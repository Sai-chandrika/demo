package com.example.demo.service.impl;

import com.example.demo.dto.*;
import com.example.demo.entity.AppUser;
import com.example.demo.enums.Role;
import com.example.demo.exception_handler.DuplicateDataException;
import com.example.demo.exception_handler.InvalidDataException;
import com.example.demo.exception_handler.NullPointerException;
import com.example.demo.exception_handler.PermissionDeniedException;
import com.example.demo.repo.AppUserRepo;
import com.example.demo.security.JwtTokenUtils;
import com.example.demo.service.AppUserService;
import com.nimbusds.jose.JOSEException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AppUserServiceImpl implements AppUserService {

    private static final String emailHintMessage = "Email must be in the format 'example@domain.com' and can include letters, digits, dots, underscores, percentage signs, plus signs, and hyphens.";


    @Autowired
    AppUserRepo appUserRepo;
    @Autowired
    JwtTokenUtils jwtTokenUtils;

    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;
    @Override
    public GenericResponse save(AppUserDto appUserDto) {
        AppUser appUser=new AppUser();
        appUser.setFirstName(appUserDto.getFirstName());
        appUser.setLastName(appUserDto.getLastName());
        appUser.setAddress(appUserDto.getAddress());
                if(checkRole(appUserDto.getRole())) {
                    appUser.setRole(appUserDto.getRole());
                }else{
                    throw new PermissionDeniedException("You are Not Access For Choose ADMIN Role , Please Choose USER Role :)");}
        if(Validation.isValidEmailPattern(appUserDto.getEmail())) {
            AppUser appUser1=appUserRepo.findByEmail(appUserDto.getEmail());
            if(appUser1!=null) {
                throw new DuplicateDataException("Email is already existed ...!");
            }else{
                appUser.setEmail(appUserDto.getEmail());
            }
        }else{
            throw new InvalidDataException("Email is not valid  :(" + "please check this pattern " +emailHintMessage + ":)" );
        }
        if(Validation.isValidPassword(appUserDto.getPassword())) {
            appUser.setPassword(appUserDto.getPassword());
        }else{
            throw new InvalidDataException("Password is not valid ,Please check again :(");
        }
        if(Validation.isValidMobileNumber(appUserDto.getMobileNo())) {
            AppUser optionalAppUser=appUserRepo.findByMobileNo(appUserDto.getMobileNo());
            if(optionalAppUser !=null) {
                throw new DuplicateDataException("Mobile NUmber  is already existed ...!");
            }else{
                appUser.setMobileNo(appUserDto.getMobileNo());
            }
        }else{
            throw new InvalidDataException("Mobile No  is not valid ,Please check again :(");
        }
         appUserRepo.save(appUser);
        AppUserDto dto=entityToDto(appUser);
        return new GenericResponse(HttpStatus.OK.value(), "User Save Successfully :)", dto);
    }

    @Override
    public GenericResponse signIn(SignInDto sign) throws JOSEException {
        if(sign.getPassword()!=null && sign.getEmail()!=null){
            AppUser appUser=appUserRepo.findByEmail(sign.getEmail());
            if(appUser!=null){
                if(appUser.getPassword().equals(sign.getPassword())){
                    SignInResponce signInResponce=new SignInResponce();
                signInResponce.setToken(jwtTokenUtils.getToken(appUser));
                String s=jwtTokenUtils.getToken(appUser);
                System.out.println(s);
                signInResponce.setRole(appUser.getRole());
                    return new GenericResponse(HttpStatus.OK.value(), "Sign In Successfully :)" , signInResponce);
                }else{
                    throw new InvalidDataException("Password Wrong");
                }
            }else{
                throw new NullPointerException("Email Not found");
            }
        }else {
            throw new NullPointerException("Email and Password Fields are required ...!");
        }

    }

    public Boolean checkRole(Role role){
        List<AppUser> appUserList=appUserRepo.findAll();
        for(AppUser role1: appUserList){
            if(role1.getRole().name().equals("ADMIN") && role.name().equals("ADMIN")){
                return false;
            }
        }
        return true;
    }

    public AppUserDto entityToDto(AppUser appUser){
        AppUserDto appUserDto=new AppUserDto();
        appUserDto.setId(appUser.getId());
        appUserDto.setFirstName(appUser.getFirstName());
        appUserDto.setLastName(appUser.getLastName());
        appUserDto.setAddress(appUser.getAddress());
        appUserDto.setRole(appUser.getRole());
        appUserDto.setEmail(appUser.getEmail());
        appUserDto.setPassword(bCryptPasswordEncoder.encode((appUser.getPassword())));
        appUserDto.setMobileNo(appUser.getMobileNo());
        return appUserDto;
    }
}
