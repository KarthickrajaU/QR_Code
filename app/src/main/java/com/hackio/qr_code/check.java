package com.hackio.qr_code;

import android.util.Log;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class check {
    private String data="";
    public static final Pattern VALID_EMAIL_ADDRESS_REGEX =
            Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);
    public static final Pattern VALID_PHONE_NUMBER=
            Pattern.compile("^{6,14}[0-9]$");
    public check(String data){
        this.data=data;
    }

    public boolean isEmail(){
        Matcher matcher = VALID_EMAIL_ADDRESS_REGEX.matcher(data);
        return matcher.find();
    }

    public boolean isURL(){
        return data.startsWith("http");
    }

    public boolean isPHONE_NUMBER(){
       Matcher matcher=VALID_PHONE_NUMBER.matcher(data);
        return matcher.find();
    }




}
