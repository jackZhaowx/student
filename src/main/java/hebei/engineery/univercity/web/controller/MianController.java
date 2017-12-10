package hebei.engineery.univercity.web.controller;

import hebei.engineery.univercity.domain.User;
import hebei.engineery.univercity.service.UserService;
import hebei.engineery.univercity.utils.UserCookieUtil;
import hebei.engineery.univercity.web.request.UserFormBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;

/**
 * Created by Administrator on 2017/12/9.
 */
@RequestMapping("/")
@Controller
public class MianController {
    @Autowired
    UserService userService;

    /**
     * 首页
     *
     * @return
     */
    @RequestMapping("/index")
    public ModelAndView index() {
        ModelAndView mv = new ModelAndView("/index");
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

    @RequestMapping(value = "/login/dolocation", method = RequestMethod.POST)
    @ResponseBody
    public String loginDoAction(@Valid @RequestBody UserFormBean userFormBean, HttpServletRequest request, HttpServletResponse response) throws Exception {
        User user = userService.findOneByUserNameAndPassword(userFormBean);
        if (user != null) {
            UserCookieUtil.saveUserToCookie(request,response,user.getId());
            return "OK";
        } else {
            return "NO";
        }
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
    public String registerDoAction(@Valid @RequestBody UserFormBean userFormBean) throws Exception{
        String result = userService.save(userFormBean);
        return result;
    }
}
