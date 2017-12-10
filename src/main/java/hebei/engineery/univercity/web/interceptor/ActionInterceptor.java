package hebei.engineery.univercity.web.interceptor;
import hebei.engineery.univercity.domain.User;
import hebei.engineery.univercity.service.UserService;
import hebei.engineery.univercity.utils.UserCookieUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by Administrator on 2017/12/10.
 * 设置拦截与跳转
 */
public class ActionInterceptor extends HandlerInterceptorAdapter {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object o) throws Exception {
        Long userId = UserCookieUtil.getUserFromCookie(request);
        if(userId!=null){
            return true;
        }else {
            String url = request.getRequestURI();
            if ("/login".equals(url)) {
                return true;
            } else {
                response.sendRedirect("/login");
                return false;
            }
        }
    }
}
