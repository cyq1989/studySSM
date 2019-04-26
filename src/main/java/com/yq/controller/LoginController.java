package com.yq.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/loginController")
public class LoginController {

    @RequestMapping("/login")
    public Object login() {

        return null;
    }

}
