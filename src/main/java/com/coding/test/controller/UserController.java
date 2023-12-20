package com.coding.test.controller;

import com.coding.test.Response;
import com.coding.test.service.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
@RequestMapping("/v1/user")

public class UserController {
    @Autowired
    private UserServices userServices;

    @PostMapping("/create")
    public Response setDataUser(@RequestBody HashMap<String, Object> data){
        return userServices.setDataUser(data);
    }
    @GetMapping("/get/")
    public Response getDataUser(@RequestParam("userId") String userId){
        return userServices.getDataUser(userId);
    }
    @DeleteMapping("/delete/")
    public Response delDataUser(@RequestParam("userId") String userId){
        return userServices.delDataUser(userId);
    }
}
