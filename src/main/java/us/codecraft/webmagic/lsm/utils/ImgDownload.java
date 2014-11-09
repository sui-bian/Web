package us.codecraft.webmagic.lsm.utils;

import lehuo.lsm.dao.LinksDao;
import lehuo.lsm.model.Links;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.Resource;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

/**
 * Created by simonliu on 2014/10/24.
 */
public class ImgDownload {

    protected static final String path="E:\\SpiderTiebaImg\\";

    protected static Logger logger = LoggerFactory.getLogger(ImgDownload.class);

    @Resource
    private static LinksDao dao;
    public static void main(String[] args) {

        List<Links> list = null;
        for(int i=1;i<=30000;i=i+1000){
            list  = dao.selectbyoffset(i);
            for(Links vo:list){
                String url = vo.getImg();
                try{
                    url = url.substring(1,url.length()-1);
                }catch (Exception e){
                    logger.error("url substring error",e);
                }

                if(StringUtils.isBlank(url)){
                    continue;
                }else{
                    String[] surl = url.split("\\, ");
                    Integer k=0;
                    for(String s:surl){

                        byte[] btImg = getImageFromNetByUrl(s);
                        if(null != btImg && btImg.length > 0){
                            logger.info("从{}读取到：" + btImg.length + " 字节",s);
                            String fileName = vo.getId()+"_"+k+".jpg";
                            writeImageToDisk(btImg, fileName);
                            ++k;
                        }else{
                            logger.info("没有从该连接获得内容,{}",s);
                        }
                    }

                }
            }
        }

    }
    /**
     * 将图片写入到磁盘
     * @param img 图片数据流
     * @param fileName 文件保存时的名称
     */
    public static void writeImageToDisk(byte[] img, String fileName){
        try {
            File file = new File(path+fileName);
            if(!file.exists()){
                file.createNewFile();
            }else{
                logger.info("file exist {}",file.getAbsolutePath());
            }
            FileOutputStream fops = new FileOutputStream(file);
            fops.write(img);
            fops.flush();
            fops.close();
            System.out.println("图片已经写入到C盘");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    /**
     * 根据地址获得数据的字节流
     * @param strUrl 网络连接地址
     * @return
     */
    public static byte[] getImageFromNetByUrl(String strUrl){
        try {
            URL url = new URL(strUrl);
            HttpURLConnection conn = (HttpURLConnection)url.openConnection();
            conn.setRequestMethod("GET");
            conn.setConnectTimeout(10 * 1000);
            InputStream inStream = conn.getInputStream();//通过输入流获取图片数据
            byte[] btImg = readInputStream(inStream);//得到图片的二进制数据
            return btImg;
        } catch (Exception e) {
            e.printStackTrace();
            logger.error(strUrl,e);
        }
        return null;
    }
    /**
     * 从输入流中获取数据
     * @param inStream 输入流
     * @return
     * @throws Exception
     */
    public static byte[] readInputStream(InputStream inStream) throws Exception{
        ByteArrayOutputStream outStream = new ByteArrayOutputStream();
        byte[] buffer = new byte[1024];
        int len = 0;
        while( (len=inStream.read(buffer)) != -1 ){
            outStream.write(buffer, 0, len);
        }
        inStream.close();
        return outStream.toByteArray();
    }
}
