package lehuo.lsm.controller;

import lehuo.lsm.model.User;
import lehuo.lsm.service.impl.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.logging.Logger;

/**
 * Created by simonliu on 2014/10/26.
 */
@Controller
@RequestMapping(value = "/user")
public class UserController {

    @Resource
    private UserService userService;

    @RequestMapping(value = "/insertUser")
    @ResponseBody
    public String insertUser(){
        User u = new User("lsm", "123", "lsm0622@163.com", 18,'F');
        userService.insert(u);
        return "aaa";
    }

    @RequestMapping(value = "/test")
    public String test(){
        User u = new User("lsmooogyl", "123", "lsm0622@163.com", 18,'F');
        userService.insert(u);
        return "aaa";
    }
}
