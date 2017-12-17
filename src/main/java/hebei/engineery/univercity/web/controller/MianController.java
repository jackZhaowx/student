package hebei.engineery.univercity.web.controller;

import hebei.engineery.univercity.domain.LoginRecord;
import hebei.engineery.univercity.domain.User;
import hebei.engineery.univercity.service.LoginRecordService;
import hebei.engineery.univercity.service.UserService;
import hebei.engineery.univercity.utils.DateUtil;
import hebei.engineery.univercity.utils.IpUtil;
import hebei.engineery.univercity.utils.UserCookieUtil;
import hebei.engineery.univercity.web.request.UserFormBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.Date;

/**
 * Created by Administrator on 2017/12/9.
 */
@RequestMapping("/")
@Controller
public class MianController {
    @Autowired
    UserService userService;
    @Autowired
    LoginRecordService loginRecordService;

    /**
     * 首页
     *
     * @return
     */
    @RequestMapping("")
    public ModelAndView index(HttpServletRequest request) {
        ModelAndView mv = new ModelAndView("/index");
        Long userId = UserCookieUtil.getUserFromCookie(request);
        User user = userService.findOne(userId);
        LoginRecord record = loginRecordService.findOneByUserId(userId);
        String time = DateUtil.getDatePoor(record.getLoginTime());
        mv.addObject("user", user);
        mv.addObject("ip", record.getLoginIP());
        mv.addObject("time", time);
        return mv;
    }

    /**
     * 登陆页
     *
     * @return
     */
    @RequestMapping("/login")
    public ModelAndView login() {
        ModelAndView mv = new ModelAndView("/login");
        return mv;
    }

    /**
     * 登陆操作
     *
     * @param userFormBean
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/login/dolocation", method = RequestMethod.POST)
    @ResponseBody
    public String loginDoAction(@Valid @RequestBody UserFormBean userFormBean, HttpServletRequest request, HttpServletResponse response) throws Exception {
        User user = userService.findOneByUserNameAndPassword(userFormBean);
        if (user != null) {
            String ip = IpUtil.getRealIP(request);
            UserCookieUtil.saveUserToCookie(request, response, user.getId());
            LoginRecord loginRecord = loginRecordService.findOneByUserId(user.getId());
            if (null != loginRecord) {
                loginRecord.setLoginIP(ip);
                loginRecord.setLoginTime(new Date());
            } else {
                loginRecord = new LoginRecord();
                loginRecord.setUserId(user.getId());
                loginRecord.setLoginIP(ip);
                loginRecord.setLoginTime(new Date());
            }
            loginRecordService.save(loginRecord);
            return "OK";
        } else {
            return "NO";
        }
    }

    /**
     * 注销
     *
     * @param request
     * @param response
     * @return
     */
    @RequestMapping("/logout")
    @ResponseBody
    public String logout(HttpServletRequest request, HttpServletResponse response) {
        UserCookieUtil.deleteUserFromCookie(request, response);
        return "OK";
    }

    /**
     * 注册页面
     *
     * @return
     */
    @RequestMapping("/register")
    public ModelAndView register() {
        ModelAndView mv = new ModelAndView("/register");
        return mv;
    }

    /**
     * 注册操作
     *
     * @param userFormBean
     * @return
     * @throws UnsupportedEncodingException
     * @throws NoSuchAlgorithmException
     */
    @RequestMapping(value = "/register/doaction", method = RequestMethod.POST)
    @ResponseBody
    public String registerDoAction(@Valid @RequestBody UserFormBean userFormBean) throws Exception {
        String result = userService.save(userFormBean);
        return result;
    }
}
