package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 * @author 浅蓝
 * @email blue@ixsec.org
 * @since 2019/10/28 18:58
 */
@Controller
@RequestMapping
public class SettingController {


    public static final String EMAIL_ACCOUNT = "youremail@qq.com";
    public static final String EMAIL_PASS= "123456789";
    public static final String PORTAL_URL = "portal_url";

    public static Map<String,String> settings = new HashMap(){
        {
            put(PORTAL_URL,"http://demo.com/");
            put("xxx","xxx");
        }
    };

    @ResponseBody
    @RequestMapping("/set")
    public String setOption(String key , String value){
        if (settings.containsKey(key)){
            settings.put(key,value);
            return "1";
        }
        return "0";
    }

}
