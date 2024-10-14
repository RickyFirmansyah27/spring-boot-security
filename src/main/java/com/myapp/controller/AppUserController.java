package com.myapp.controller;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.myapp.dto.AppUserData;
import com.myapp.model.Entity.AppUser;
import com.myapp.response.BaseResponse;
import com.myapp.service.AppUserService;
import org.springframework.web.bind.annotation.PostMapping;


@RestController
@RequestMapping("/api/auth")
public class AppUserController {
 
    @Autowired
    private AppUserService appUserService;

    @Autowired
    private ModelMapper modelMapper;

    @PostMapping("/register")
    public BaseResponse<AppUser> register(@RequestBody AppUserData userData) {
        
        AppUser appUser = modelMapper.map(userData, AppUser.class);
        System.out.println("User full name: " + userData.getFullName());
        appUserService.registAppUser(appUser);
        return new BaseResponse<>("success", "Product registered successfully", appUser);
    }
}
