package lehuo.lsm.model;

/**
 * Created with IntelliJ IDEA.
 * User: simonliu
 * Date: 14-11-1
 * Time: 上午12:07
 * To change this template use File | Settings | File Templates.
 */
public class PkSubmit {
    Integer id;
    String sessionId;
    Integer age;
    Integer birth;
    String ip;

    public PkSubmit(){}

    public PkSubmit(String sessionId, Integer age, Integer birth, String ip) {
        if(sessionId==null){
            sessionId = "";
        }else{
            this.sessionId = sessionId;
        }

        this.age = age;
        this.birth = birth;

        if(ip==null){
            ip = "";
        }else{
            this.ip = ip;
        }

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getBirth() {
        return birth;
    }

    public void setBirth(Integer birth) {
        this.birth = birth;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }
}
