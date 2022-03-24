package com.scl.frame.controller;

import com.scl.frame.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description:
 * @author: shanglimin888@163.com
 * @time: 2021/11/24 16:21
 */
@RestController
@RequestMapping("/test")
public class TestController {

    @Autowired
    private TestService service;

    @RequestMapping("/getUsers")
    public void getUsers(){
        System.out.println(service.getUsers());
    }
}    