package lehuo.lsm.controller.interceptor;



import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
public class UserAuthInterceptor extends HandlerInterceptorAdapter {

    private static Logger logger = LoggerFactory.getLogger(UserAuthInterceptor.class);

    private static final String INTERCEPTOR_URL = "/admin/";

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        logger.info("admin interceptor {},{}",request.getRequestedSessionId(),request.getRequestURI());
        return true;

    }

}
