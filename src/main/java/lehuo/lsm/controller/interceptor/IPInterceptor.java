package lehuo.lsm.controller.interceptor;



import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


/**
 * Created with IntelliJ IDEA.
 * User: shumeng.liu
 * Date: 14-10-30
 * Time: 下午8:06
 * To change this template use File | Settings | File Templates.
 */
public class IPInterceptor extends HandlerInterceptorAdapter {
    //private static final Logger logger = LoggerFactory
    private final static String REQUEST_IP_HEADER = "X-Real-IP";
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String requestURL = request.getRequestURI();
        String ip = getIpAddr(request);
        //logger.info("请求的url为: {}, ip为: {}", requestURL, ip);

        request.setAttribute("ip",ip);
        return true;
    }

        private String getIpAddr(HttpServletRequest request) {
        String ip = request.getHeader("x-forwarded-for");
        if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
        }
        return ip;
    }
}
