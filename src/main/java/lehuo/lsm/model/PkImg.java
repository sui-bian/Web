package lehuo.lsm.model;

/**
 * Created with IntelliJ IDEA.
 * User: shumeng.liu
 * Date: 14-10-30
 * Time: 下午9:12
 * To change this template use File | Settings | File Templates.
 */
public class PkImg {
    Integer id;
    Integer win;
    Integer lose;
    Integer accessId;

    public PkImg(){}

    public PkImg(Integer w, Integer l){
        win = w;
        lose = l;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getWin() {
        return win;
    }

    public void setWin(Integer win) {
        this.win = win;
    }

    public Integer getLose() {
        return lose;
    }

    public void setLose(Integer lose) {
        this.lose = lose;
    }

    public Integer getAccessId() {
        return accessId;
    }

    public void setAccessId(Integer accessId) {
        this.accessId = accessId;
    }
}
