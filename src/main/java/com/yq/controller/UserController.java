package com.yq.controller;

import com.yq.domain.User;
import com.yq.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Controller
public class UserController {

    @Autowired
    private UserService service;

    @RequestMapping(value = "/getUser", method = RequestMethod.GET)
    @ResponseBody
    public Object getUser() {
        return service.getUser(1);
    }

//    @RequestMapping(value = "/selectUserTwo", method = RequestMethod.GET)
//    @ResponseBody
//    public Object selectUserTwo() {
//        return service.selectUser(1, "陈有权");
//    }

    @RequestMapping(value = "/droptable", method = RequestMethod.GET, produces = "text/html;charset=UTF-8")
    @ResponseBody
    public Object dropTable() {
        service.dropTable("droptable");
        return "删除表成功！";
    }


    @RequestMapping(value = "/selectUser", method = RequestMethod.GET)
    @ResponseBody
    public Object selectUser() {
        return service.selectUser(1);
    }

    @RequestMapping(value = "insertValue", method = RequestMethod.GET, produces = "text/html;charset=UTF-8")
    @ResponseBody
    public Object insertValue() {

        String userName = SecurityContextHolder.getContext().getAuthentication().getName();

        User user = new User();
        user.setName("成龙");
        user.setAge(58);
        service.insertValue(user);
        return "插入成功！";
    }

    @RequestMapping(value = "/testhash")
    public void testHashMap() {
        HashMap<String, String> map = new HashMap<>();
        map.put("xxx", "cyq");

        ConcurrentHashMap map1 = new ConcurrentHashMap();

    }



}
