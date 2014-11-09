package us.codecraft.webmagic.lsm.processer;

import lehuo.lsm.dao.LinksDao;
import lehuo.lsm.model.Links;
import org.jsoup.helper.StringUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Request;
import us.codecraft.webmagic.Site;
import lehuo.lsm.model.spider.TiebaVo;
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
public class MeituibaProcesser implements PageProcessor {
    protected Logger logger = LoggerFactory.getLogger(MeituibaProcesser.class);

    private Site site = Site.me().setDomain("http://tieba.baidu.com")
            .addHeader("User-Agent", "Mozilla/5.0 (Windows NT 6.2; WOW64; rv:32.0) Gecko/20100101 Firefox/32.0")
            .setSleepTime(5000)
            .addHeader("Cookie","BAIDUID=B71947B9AC88B9CDD5581C14493C13A9:FG=1; BAIDUPSID=535C5EB8B1F0067B1EBC9D08380F5BE0; locale=zh; H_PS_PSSID=8770_9363_1468_9182_7802_9144_9499_6506_9510_6017_8593_7825_7799_9454_7963_9192_8974_9023_9189; BDRCVFR[QxSlZxphXX_]=mk3SLVN4HKm; BDSFRCVID=d4PsJeCCxG3UtGcxsRY2BjD0MP82Dt_om0jT3J; H_BDCLCKID_SF=tRk8oIIMJCvbfP0k-4QEM-QH-UnLq-0JLT7Z0lOnMp05Stbj-n750lcXLx6RJUrTfnrRLU7OaCJ8SKO_e4bK-TrLeHQP; dasense_show_10172=1; TIEBA_USERTYPE=251e382d6bc0cc298e036c30; bdshare_firstime=1414163089072; TIEBAUID=1f2164d180666e6120d8d16b; dasense_show_10740=1; wise_device=0; GET_TOPIC=70685000; dasense_show_10726=1; dasense_show_10741=1; dasense_show_10893=1; baidu_broswer_setup_lsmsilence=0; BDUSS=dSczlUZ1hkcTRXUEp4RDVGODBSRGhQM2hqMi1MNmNaTXJhb0VvLW5yZVEtSEZVQVFBQUFBJCQAAAAAAAAAAAEAAABIkTYEbHNtc2lsZW5jZQAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAJBrSlSQa0pUYl; dasense_show_10522=1; BDRCVFR[feWj1Vr5u3D]=I67x6TjHwwYf0; dasense_show_10496=1; dasense_show_10182=1; dasense_show_10907=1; dasense_show_10739=1; dasense_show_10495=1; dasense_show_10906=1");

    private List<Links> result = new ArrayList<Links>();

    @Resource
    private LinksDao dao;
    @Override
    public void process(Page page) {
        logger.info("process start : {}",page.getUrl().get());

        Html html = page.getHtml();

        if(page.getUrl().regex("http://tieba.baidu.com/p/\\d+").get()!=null){

            logger.info("link is "+page.getUrl().get());
            String title = html.xpath("//div[@class='core_title core_title_theme_bright']/h1/text()").get();
            String authorlink = html.xpath("//li[@class='d_name']/a/@href").get();
            String author = html.xpath("//li[@class='d_name']/a/text()").get();
            String posttime = html.xpath("//ul[@class='p_tail']/li[2]/span/text()").get();

            String content = "";
            List<String> imgLinks = html.xpath("//div[@class='p_content p_content_nameplate']/cc/div//img/@src").all();

            if(StringUtil.isBlank(title)||StringUtil.isBlank(author)){
                addUrl(page.getUrl().toString(),page);
            }else{
                TiebaVo vo = new TiebaVo(title,author,authorlink,content,posttime,imgLinks);
                logger.info("result is {}",vo);

                Links lvo = new Links(vo);
                lvo.setLink(page.getUrl().toString());

                dao.update(lvo);
                logger.info("update complete!");
            }


        }else{

            List<String> tlinks = html.xpath("//a[@class='j_th_tit']/@href").all();
            List<String> reply = html.xpath("//div[@class='threadlist_li_left j_threadlist_li_left']/div[@class='threadlist_rep_num']/text()").all();
            String next = html.xpath("//div[@id='frs_list_pager']/a[@class='next']/@href").get();
            String current = html.xpath("//div[@id='frs_list_pager']/span[@class='cur']/text()").get();

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

                l.setDomains("http://tieba.baidu.com/f?kw=美女");
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

    public static void main(String[] args) {

        final int PAGESIZE =1;

        Request[] requests = new Request[PAGESIZE];

        requests[0] = new Request("http://tieba.baidu.com/f?kw=美女&pn=0");

        Proxy.init();
        LsmSpider.create(new MeituibaProcesser()).pipeline(new ConsolePipeline()).setProxys(Proxy.addProxyServers()).addRequest(requests).thread(5).runAsync();


    }

    public void addUrl(List<String> list,Page page){
        logger.info("add target links size :{},targets are {}",list.size(),list.toString());
        page.addTargetRequests(list);
    }

    public void addUrl(String s,Page page){
        logger.info("add target {}",s);
        page.addTargetRequest(s);
    }
}
