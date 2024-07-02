package com.example.demo.service;

import com.example.demo.dto.AppUserDto;
import com.example.demo.dto.GenericResponse;
import com.example.demo.dto.SignInDto;
import com.nimbusds.jose.JOSEException;

public interface AppUserService {

    GenericResponse save(AppUserDto appUserDto);

   GenericResponse signIn(SignInDto sign) throws JOSEException;
}
