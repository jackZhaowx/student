package hebei.engineery.univercity.web.controller;

import hebei.engineery.univercity.config.DataConfig;
import hebei.engineery.univercity.domain.PartInfo;
import hebei.engineery.univercity.domain.User;
import hebei.engineery.univercity.enums.PartResultCode;
import hebei.engineery.univercity.service.PartInfoService;
import hebei.engineery.univercity.service.UserService;
import hebei.engineery.univercity.utils.UserCookieUtil;
import hebei.engineery.univercity.web.response.PartResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/part")
public class PartController {
    @Autowired
    UserService userService;
    @Autowired
    PartInfoService partInfoService;
    @Autowired
    DataConfig dataConfig;

    /**
     * 社区总览页面
     *
     * @param request
     * @return
     */
    @RequestMapping("")
    public ModelAndView part_list(HttpServletRequest request) {
        ModelAndView mv = new ModelAndView("/part/part_list");
        Long userId = UserCookieUtil.getUserFromCookie(request);
        User user = userService.findOne(userId);
        PartResult<PartInfo> result = new PartResult<>();
        try {
            List<PartInfo> data = partInfoService.findAllByPage(1, dataConfig.getPartPageSize());
            result.createData(PartResultCode.SUCCESS, data, null);
        } catch (Exception e) {
            result.createData(PartResultCode.ERROR, null, e);
        }
        Integer last = 0;
        Map<String, Object> map = new HashMap<>();
        if (result.getCode() == PartResultCode.SUCCESS) {
            Integer count = partInfoService.findAllCount();
            if (count % dataConfig.getPartPageSize() == 0) {
                last = count / 10;
            } else {
                last = count / 10 + 1;
            }
        }
        map.put("user", user);
        map.put("result", result);
        map.put("last", last);
        mv.addAllObjects(map);
        return mv;
    }

    /**
     * 获取更多社区信息
     * @param num
     * @return
     */
    @RequestMapping(value = "/part_list_more", method = RequestMethod.POST)
    @ResponseBody
    public PartResult<PartInfo> partListMore(@RequestParam Integer num) {
        PartResult<PartInfo> result = new PartResult<>();
        try {
            List<PartInfo> data = partInfoService.findAllByPage(num, dataConfig.getPartPageSize());
            result.createData(PartResultCode.SUCCESS, data, null);
        } catch (Exception e) {
            result.createData(PartResultCode.ERROR, null, e);
        }
        return result;
    }
}
