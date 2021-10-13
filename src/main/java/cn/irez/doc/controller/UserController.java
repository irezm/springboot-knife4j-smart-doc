package cn.irez.doc.controller;

import cn.hutool.core.lang.Assert;
import cn.hutool.core.util.NumberUtil;
import cn.irez.doc.api.Result;
import cn.irez.doc.model.User;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * User 用户接口
 */
@RequestMapping("/")
@RestController
public class UserController {

    /**
     * 获得用户对象
     * @return 用户对象
     */
    @RequestMapping(value = "/userInfo",method = RequestMethod.GET)
    public Result<List<User>> userInfo(){
        List<User> userList = new ArrayList<>();
        User user = new User();
        user.setId(1L);
        user.setUsername("兰泽民");
        user.setCompany("长沙产力云科技有限公司");
        user.setMail("irez@qq.com");
        userList.add(user);
        return Result.ok(userList);
    }

    /**
     * 根据Id获得用户信息
     * @param id 用户Id
     * @return 用户对象
     */
    @RequestMapping(value = "/userInfoById",method = RequestMethod.GET)
    public Result<User> userInfoById(Long id){
        Assert.isTrue(NumberUtil.equals(id,1L),"用户不存在!");
        User user = new User();
        user.setId(1L);
        user.setUsername("Leon·Lan");
        user.setCompany("长沙产力云科技有限公司");
        user.setMail("irez@qq.com");
        return Result.ok(user);
    }
}
