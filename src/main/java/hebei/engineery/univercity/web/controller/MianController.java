package hebei.engineery.univercity.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by Administrator on 2017/12/9.
 */
@RequestMapping("/")
@Controller
public class MianController {
    @RequestMapping("")
    public ModelAndView index(){
        ModelAndView mv = new ModelAndView("/index");
        return mv;
    }
}
