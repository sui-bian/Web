package lehuo.lsm.controller.interceptor;



import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;


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

    private String noAuthView = "/WEB-INF/jsp/noAuth.jsp";

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        logger.info("admin interceptor {},{}",request.getRequestedSessionId(),request.getRequestURI());
        failAccess(request, response);
        return true;

    }

    private void failAccess(HttpServletRequest request, HttpServletResponse response) throws IOException,
            ServletException {
        logger.info("权限未通过验证，跳转至无权限页面:{}", noAuthView);
        request.getRequestDispatcher(noAuthView).forward(request, response);
    }

}
