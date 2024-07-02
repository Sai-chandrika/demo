package com.example.demo.dto;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validation {
    private static final String emailHintMessage = "Email must be in the format 'example@domain.com' and can include letters, digits, dots, underscores, percentage signs, plus signs, and hyphens.";

    public static Boolean isValidEmailPattern(String email) {
        String ePattern = "^[a-z0-9.!#$%&'*+/=?^_`{|}~-]+@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\])|(([a-zA-Z\\-0-9]+\\.)+[a-zA-Z]{2,}))$";
        Pattern p = Pattern.compile(ePattern);
        Matcher m = p.matcher(email);
        return m.matches();
    }
    public static Boolean isValidMobileNumber(String mobileNumber){
        String ePattern=("^(0|9)?[6-9]{1}[0-9]{9}+$");
        Pattern p=Pattern.compile(ePattern);
        Matcher m=p.matcher(mobileNumber);
        return m.matches();
    }
    public static Boolean isValidPassword(String password) {
        String ePattern=("^[a-zA-Z0-9'@&#.\\s]{6,15}$");
        Pattern p = Pattern.compile(ePattern);
        Matcher m = p.matcher(password);
        return m.matches();
    }

}
