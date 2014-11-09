package lehuo.lsm.model;

/**
 * Created with IntelliJ IDEA.
 * User: simonliu
 * Date: 14-11-1
 * Time: 下午1:41
 * To change this template use File | Settings | File Templates.
 */
public class Images {
    Integer id;
    Integer links_id;

    String img_link;
    String path;

    public Images(Integer links_id,String img_link){
        this.links_id = links_id;
        this.img_link = img_link;
    }
}
