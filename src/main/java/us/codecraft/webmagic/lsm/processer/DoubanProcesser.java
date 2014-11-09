package us.codecraft.webmagic.lsm.processer;

import lehuo.lsm.dao.LinksDao;
import lehuo.lsm.model.Links;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import lehuo.lsm.model.spider.DoubanVo;
import us.codecraft.webmagic.lsm.proxys.Proxy;
import us.codecraft.webmagic.model.LsmSpider;
import us.codecraft.webmagic.pipeline.ConsolePipeline;
import us.codecraft.webmagic.processor.PageProcessor;
import us.codecraft.webmagic.selector.Html;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by simonliu on 2014/10/23.
 */
@Component
public class DoubanProcesser implements PageProcessor {
    protected static Logger logger = LoggerFactory.getLogger(DoubanProcesser.class);

    private Site site = Site.me().setDomain("www.douban.com")
            .addHeader("User-Agent", "Mozilla/5.0 (Windows NT 6.2; WOW64; rv:32.0) Gecko/20100101 Firefox/32.0")
            ;

    private List<Links> result = new ArrayList<Links>();

    @Resource
    private  LinksDao dao;
    @Override
    public void process(Page page) {
        System.out.print("lsm");
        logger.info("process start : {}",page.getUrl().get());

        Html html = page.getHtml();

        if(page.getUrl().regex("http://www.douban.com/group/topic/\\d+").get()!=null){
            //TODO
            logger.info("link is "+page.getUrl().get());
            String title = html.xpath("//div[@id='content']/h1/text()").get();
            String authorlink = html.xpath("//div[@class='user-face']/a/@href").get();
            String author = html.xpath("//div[@class='topic-doc']/h3/span[@class='from']/a/text()").get();
            String posttime = html.xpath("//span[@class='color-green']/text()").get();
            if(posttime==null){
                posttime="";
            }
            String content = html.xpath("//div[@class='topic-content']/p/text()").get();
            List<String> imgLinks = html.xpath("//div[@id='link-report']/div[@class='topic-content']//img/@src").all();
            DoubanVo vo = new DoubanVo(title,author,authorlink,content,posttime,imgLinks);

            logger.info("result is {}",vo);

            Links lvo = new Links(vo);
            lvo.setLink(page.getUrl().toString());
            try{
                dao.update(lvo);
            }catch(Exception e){
                lvo.setContent("");
                dao.update(lvo);
            }

            logger.info("update complete!");
        }else{

            List<String> tlinks = html.xpath("//table[@class='olt']/tbody/tr[@class=' ']/td[@class='title']/a/@href").all();
            List<String> reply = html.xpath("//table[@class='olt']/tbody/tr[@class=' ']/td[@class=' ']/text()").all();
            String next = html.xpath("//span[@class='next']/a/@href").get();
            logger.info("next is {}",next);
            String current = html.xpath("//span[@class='thispage']/text()").get();
            logger.info("target links size :{}"+tlinks.size());

            if(next!=null&&!next.equals("")){
                addUrl(next,page);
            }else{
                addUrl(page.getUrl().toString(),page);
            }

            if(tlinks!=null&&tlinks.size()>0){
                addUrl(tlinks,page);
            }

            List<Links> result = new ArrayList<Links>();
            for(int i=0;i<reply.size();i++){
                Links l = new Links();
                l.setLink(tlinks.get(i));
                try{
                    l.setReply(Integer.parseInt(reply.get(i)));
                }catch(Exception e){
                    l.setReply(0);
                }

                l.setDomains("http://www.douban.com/haixiu");
                try{
                    l.setPageno(Integer.parseInt(current));
                }catch(Exception e){
                    l.setPageno(-1);
                }

                l.setExtra("");
                dao.insert(l);
            }

        }

    }

    @Override
    public Site getSite() {
        return site;
    }

    public String testlsm(){
        return "asdasdas";
    }

    public void action(){
        final int PAGESIZE =1;

        List<String> list = new ArrayList<String>();

        list = dao.selectNeedReload();

        String[] requests = new String[20000];
        for(int i=0;i<list.size();i++){
            requests[i] = list.get(i);
        }
        Proxy.init();
        LsmSpider.create(new DoubanProcesser()).pipeline(new ConsolePipeline()).setProxys(Proxy.addProxyServers()).addUrl(requests).thread(5).runAsync();

    }



    public void addUrl(List<String> list,Page page){
        logger.info("add target links size :{}",list.size());
        page.addTargetRequests(list);
    }

    public void addUrl(String s,Page page){
        logger.info("add target {}",s);
        page.addTargetRequest(s);
    }
}
