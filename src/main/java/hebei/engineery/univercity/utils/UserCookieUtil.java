package hebei.engineery.univercity.utils;

import hebei.engineery.univercity.domain.User;
import hebei.engineery.univercity.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by Administrator on 2017/12/10.
 * 存储登陆用户和获取登陆用户
 */
public class UserCookieUtil {
    @Autowired
    private static UserService userService;
    /**
     * 存储登陆用户
     *
     * @param request
     * @param response
     * @param userId
     * @return
     */
    public static boolean saveUserToCookie(HttpServletRequest request, HttpServletResponse response, Long userId) {
        try {
            Cookie cookie = new Cookie("userToken", userId.toString());
            cookie.setPath("/");
            cookie.setMaxAge(60 * 60 * 24);
            response.addCookie(cookie);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * 获取登录用户
     *
     * @param request
     * @return
     */
    public static Long getUserFromCookie(HttpServletRequest request) {
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (int i = 0; i < cookies.length; i++) {
                if ("userToken".equals(cookies[i].getName())) {
                    Long userId = Long.valueOf(cookies[i].getValue());
                    return userId;
                }
            }
        }
        return null;
    }
}
