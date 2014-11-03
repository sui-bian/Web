package lehuo.lsm.model;

/**
 * Created with IntelliJ IDEA.
 * User: simonliu
 * Date: 14-11-3
 * Time: 下午10:56
 * To change this template use File | Settings | File Templates.
 */
public class Comment {
    Integer id;

    Integer linkId;

    String commnet;

    String time;

    public Comment(Integer linkId, String commnet) {
        this.linkId = linkId;
        this.commnet = commnet;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getLinkId() {
        return linkId;
    }

    public void setLinkId(Integer linkId) {
        this.linkId = linkId;
    }

    public String getCommnet() {
        return commnet;
    }

    public void setCommnet(String commnet) {
        this.commnet = commnet;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
