package lehuo.lsm.model.spider;

import java.util.List;

/**
 * Created by simonliu on 2014/10/23.
 */
public class DoubanVo extends BaseVo{


    public DoubanVo(String title, String author, String authorlink, String content, String posttime, List<String> imgLinks) {
        super(title,author,authorlink,content,posttime,imgLinks);
    }



    @Override
    public String toString() {
        return "Douban{" +
                "title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", content='" + content + '\'' +
                ", imgLinks='"  + imgLinks+'\'' +
                ", authorlink='"  + authorlink+'\'' +
                ", posttime='"  + posttime+'\'' +
                '}';
    }
}
