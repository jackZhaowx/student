package hebei.engineery.univercity.web.controller;

import hebei.engineery.univercity.config.DataConfig;
import hebei.engineery.univercity.domain.Community;
import hebei.engineery.univercity.domain.Dormitory;
import hebei.engineery.univercity.domain.DormitoryBuilding;
import hebei.engineery.univercity.domain.User;
import hebei.engineery.univercity.enums.CommunityResultCode;
import hebei.engineery.univercity.service.CommunityService;
import hebei.engineery.univercity.service.DormitoryBuildingService;
import hebei.engineery.univercity.service.DormitoryService;
import hebei.engineery.univercity.service.UserService;
import hebei.engineery.univercity.utils.UserCookieUtil;
import hebei.engineery.univercity.web.response.UnivercityResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/community")
public class CommunityController {
    @Autowired
    UserService userService;
    @Autowired
    CommunityService communityService;
    @Autowired
    DormitoryBuildingService dormitoryBuildingService;
    @Autowired
    DormitoryService dormitoryService;
    @Autowired
    DataConfig dataConfig;

    /**
     * 社区总览页面
     *
     * @param request
     * @return
     */
    @RequestMapping("")
    public ModelAndView community(HttpServletRequest request) {
        ModelAndView mv = new ModelAndView("/community/community_list");
        Long userId = UserCookieUtil.getUserFromCookie(request);
        User user = userService.findOne(userId);
        UnivercityResult<Community> result = new UnivercityResult<>();
        try {
            List<Community> data = communityService.findAllByPage(1, dataConfig.getPartPageSize());
            result.createData(CommunityResultCode.SUCCESS, data, null);
        } catch (Exception e) {
            result.createData(CommunityResultCode.ERROR, null, e);
        }
        Integer last = 0;
        Map<String, Object> map = new HashMap<>();
        if (result.getCode() == CommunityResultCode.SUCCESS) {
            Integer count = communityService.findAllCount();
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
     *
     * @param num
     * @return
     */
    @RequestMapping(value = "/community_list_more", method = RequestMethod.POST)
    @ResponseBody
    public UnivercityResult<Community> communityMore(@RequestParam Integer num) {
        UnivercityResult<Community> result = new UnivercityResult<>();
        try {
            List<Community> data = communityService.findAllByPage(num, dataConfig.getPartPageSize());
            result.createData(CommunityResultCode.SUCCESS, data, null);
        } catch (Exception e) {
            result.createData(CommunityResultCode.ERROR, null, e);
        }
        return result;
    }

    /**
     * 添加社区
     *
     * @param request
     * @return
     */
    @RequestMapping("/community_add")
    public ModelAndView communityAdd(HttpServletRequest request) {
        ModelAndView mv = new ModelAndView("/community/community_add");
        Long userId = UserCookieUtil.getUserFromCookie(request);
        User user = userService.findOne(userId);
        Map<String, Object> map = new HashMap<>();
        map.put("user", user);
        mv.addAllObjects(map);
        return mv;
    }

    /**
     * 添加社区操作
     *
     * @param communame
     * @param demo
     * @return
     */
    @RequestMapping(value ="/community_add/submit",method = RequestMethod.POST)
    @ResponseBody
    public String communityAddSubmit(@RequestParam String communame, @RequestParam String demo) {
        Community community = new Community();
        community.setComName(communame);
        community.setDemo(demo);
        Community comm = communityService.save(community);
        if (comm != null) {
            return "OK";
        } else {
            return "NO";
        }
    }

    /**
     * 社区详情
     *
     * @param id
     * @return
     */
    @RequestMapping("/community_detail/{id}")
    public ModelAndView partDetail(@PathVariable Long id, HttpServletRequest request) {
        ModelAndView mv = new ModelAndView("/community/community_detail");
        Long userId = UserCookieUtil.getUserFromCookie(request);
        User user = userService.findOne(userId);
        UnivercityResult<DormitoryBuilding> result = new UnivercityResult<>();
        try {
            List<DormitoryBuilding> data = dormitoryBuildingService.findAllByPageAndId(1, id, dataConfig.getPartPageSize());
            result.setData(data);
            result.setCode(CommunityResultCode.SUCCESS);
            result.setException(null);
        } catch (Exception e) {
            result.createData(CommunityResultCode.ERROR, null, e);
        }
        Integer last = 0;
        Map<String, Object> map = new HashMap<>();
        if (result.getCode() == CommunityResultCode.SUCCESS) {
            Integer count = dormitoryBuildingService.findAllCountByParentId(id);
            if (count % dataConfig.getPartPageSize() == 0) {
                last = count / 10;
            } else {
                last = count / 10 + 1;
            }
        }
        Community community = communityService.findOne(id);
        map.put("user", user);
        map.put("result", result);
        map.put("last", last);
        map.put("commu", community);
        mv.addAllObjects(map);
        return mv;
    }

    /**
     * 宿舍楼信息
     *
     * @param request
     * @return
     */
    @RequestMapping("/dormitory_building")
    public ModelAndView dormitoryBuilding(HttpServletRequest request) {
        ModelAndView mv = new ModelAndView("/community/dormitory_building");
        Long userId = UserCookieUtil.getUserFromCookie(request);
        User user = userService.findOne(userId);
        UnivercityResult<DormitoryBuilding> result = new UnivercityResult<>();
        try {
            List<DormitoryBuilding> data = dormitoryBuildingService.findAllByPage(1, dataConfig.getPartPageSize());
            result.createData(CommunityResultCode.SUCCESS, data, null);
        } catch (Exception e) {
            result.createData(CommunityResultCode.ERROR, null, e);
        }
        Integer last = 0;
        Map<String, Object> map = new HashMap<>();
        if (result.getCode() == CommunityResultCode.SUCCESS) {
            Integer count = dormitoryBuildingService.findAllCount();
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
     * 添加宿舍楼
     *
     * @param request
     * @return
     */
    @RequestMapping("/dormitory_building_add")
    public ModelAndView dormitoryBuildingAdd(HttpServletRequest request) {
        ModelAndView mv = new ModelAndView("/community/dormitory_building_add");
        Long userId = UserCookieUtil.getUserFromCookie(request);
        User user = userService.findOne(userId);
        List<Community> comms = communityService.findAll();
        Map<String, Object> map = new HashMap<>();
        map.put("user", user);
        map.put("comms", comms);
        mv.addAllObjects(map);
        return mv;
    }
    @RequestMapping(value = "/dormitory_building_add/submit",method = RequestMethod.POST)
    @ResponseBody
    public String dormitoryBuildingAddSubmit(@RequestParam String ofComm,@RequestParam String name,@RequestParam Integer number,@RequestParam Integer level,@RequestParam String wheel,@RequestParam String phone){
        String[] split = ofComm.split("==");
        DormitoryBuilding building = new DormitoryBuilding();
        building.setName(name);
        building.setNumber(number);
        building.setLevel(level);
        building.setWheel(wheel);
        building.setPhone(phone);
        building.setParentId(Long.valueOf(split[0]));
        building.setParentName(split[1]);
        DormitoryBuilding dor=dormitoryBuildingService.save(building);
        if(dor!=null){
            return "OK";
        }else{
            return "NO";
        }
    }
}
