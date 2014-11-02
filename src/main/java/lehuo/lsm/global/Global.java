package lehuo.lsm.global;

/**
 * Created with IntelliJ IDEA.
 * User: simonliu
 * Date: 14-11-1
 * Time: 下午2:42
 * To change this template use File | Settings | File Templates.
 */
public class Global {
    static int LINK_MAX = 0;

    static int CURRENT_ONLINE = 0;

    public static int getLINK_MAX() {
        return LINK_MAX;
    }

    public static void setLINK_MAX(int LINK_MAX) {
        Global.LINK_MAX = LINK_MAX;
    }

    public static int getCURRENT_ONLINE() {
        return CURRENT_ONLINE;
    }

    public static void setCURRENT_ONLINE(int CURRENT_ONLINE) {
        Global.CURRENT_ONLINE = CURRENT_ONLINE;
    }
}
