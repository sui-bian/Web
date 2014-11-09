package us.codecraft.webmagic.lsm.utils;

import lehuo.lsm.dao.ImagesDao;
import lehuo.lsm.dao.LinksDao;
import lehuo.lsm.model.Images;
import lehuo.lsm.model.Links;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: simonliu
 * Date: 14-11-1
 * Time: 下午10:55
 * To change this template use File | Settings | File Templates.
 */
public class ImgUtils {
    protected static Logger logger = LoggerFactory.getLogger(ImgUtils.class);

    @Resource
    private static LinksDao linksDao;
    @Resource
    private static ImagesDao imagesDao;
    public static void main(String[] args){
        List<Links> list = null;


        for(int i=1;i<90000;i+=1000){
            list = linksDao.selectbyoffset(i);
            logger.info("start {}",list.size());
            for(Links vo:list){
                String url = vo.getImg();
                try{
                    url = url.substring(1,url.length()-1);
                }catch (Exception e){

                }

                if(StringUtils.isBlank(url)){
                    continue;
                }else{
                    logger.info("url is {}",url);
                    String[] surl = url.split("\\, ");
                    Integer k=0;
                    for(String s:surl){
                        imagesDao.insert(new Images(vo.getId(),s));
                    }
                }
            }
        }
    }
}
