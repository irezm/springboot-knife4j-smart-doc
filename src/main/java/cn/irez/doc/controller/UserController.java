package cn.irez.doc.controller;

import cn.hutool.core.lang.Assert;
import cn.hutool.core.util.NumberUtil;
import cn.irez.doc.api.Result;
import cn.irez.doc.model.User;
import cn.irez.doc.model.dto.UserDto;
import cn.irez.doc.model.vo.UserVo;
import org.springframework.web.bind.annotation.RequestBody;
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
     * @return Result<List<User>>
     */
    @RequestMapping(value = "/userInfo",method = RequestMethod.GET)
    public Result<List<User>> userInfo(){
        List<User> userList = new ArrayList<>();
        User user = new User();
        user.setId(1);
        user.setUsername("兰泽民");
        user.setCompany("长沙产力云科技有限公司");
        user.setMail("irez@qq.com");
        userList.add(user);
        return Result.ok(userList);
    }

    /**
     * 根据Id获得用户信息
     * @param id 用户Id
     * @return Result<User>
     */
    @RequestMapping(value = "/userInfoById",method = RequestMethod.GET)
    public Result<User> userInfoById(Long id){
        Assert.isTrue(NumberUtil.equals(id,1L),"用户不存在!");
        User user = new User();
        user.setId(1);
        user.setUsername("Leon·Lan");
        user.setCompany("长沙产力云科技有限公司");
        user.setMail("irez@qq.com");
        return Result.ok(user);
    }

    /**
     * 根据班级Id,与学生名称获得数据
     * @param dto 筛选条件
     * @return Result<UserVo>
     */
    @RequestMapping(value = "/classByIdUsername",method = RequestMethod.POST)
    public Result<UserVo> classByIdUsername(@RequestBody UserDto dto){
        UserVo vo = new UserVo()
                .setClassId(1)
                .setClassName("一年级倒数第一班")
                .setUserList(new ArrayList<>());
        for (int i = 1; i <= 10; i++){
            User user = new User()
            .setId(i)
            .setUsername(String.format("Leon for %s",i))
            .setCompany("长沙产力云科技有限公司")
            .setMail(String.format("irez-%s@qq.com",i));
            vo.getUserList().add(user);
        }
        return Result.ok(vo);
    }
}
