package com.example.demo.controller;

import com.example.demo.dto.AppUserDto;
import com.example.demo.dto.GenericResponse;
import com.example.demo.dto.SignInDto;
import com.example.demo.service.AppUserService;
import com.nimbusds.jose.JOSEException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/user")
public class AppUserController {
    @Autowired
    AppUserService appUserService;

    @PostMapping("/save")
    public GenericResponse signUp(@RequestBody AppUserDto appUserDto){
        return new GenericResponse(appUserService.save(appUserDto));
    }
    @PostMapping("/sign-in")
    public GenericResponse signIn(@RequestBody SignInDto sign) throws JOSEException {
        return new GenericResponse(appUserService.signIn(sign));
    }


}
