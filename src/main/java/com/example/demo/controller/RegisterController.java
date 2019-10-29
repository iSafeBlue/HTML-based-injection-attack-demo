package com.example.demo.controller;

import com.example.demo.util.SendQQMailUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.mail.MessagingException;
import java.util.Date;
import java.util.Random;

/**
 * @author 浅蓝
 * @email blue@ixsec.org
 * @since 2019/10/28 18:52
 */
@RequestMapping
@Controller
public class RegisterController {
    @RequestMapping("/")
    public String index(){
        return "register";
    }

    @ResponseBody
    @RequestMapping("register")
    public String doRegister(String email){
        String str = "<!DOCTYPE html>\n" +
                "<html lang=\"en\">\n" +
                "<head>\n" +
                "    <meta charset=\"UTF-8\">\n" +
                "    <title>欢迎注册</title>\n" +
                "</head>\n" +
                "<body>\n" +
                "\n" +
                "<div x=\"xxx\">\n" +
                "    <p x=\"xxx\">您的账号是 {1} 密码是 {2} </p>\n" +
                "    <p x=\"xxx\">登录地址：</p>\n" +
                "    <a href=\"{3}\">{3}</a>\n" +
                "</div>\n" +
                "\n" +
                "<div x=\"xxx\">\n" +
                "    <p x=\"xxx\">your account is {1} password is {2} </p>\n" +
                "    <p x=\"xxx\">login address：</p>\n" +
                "    <a href=\"{3}\">{3}</a>\n" +
                "</div>\n" +
                "\n" +
                "</body>\n" +
                "</html>";
        String password = randomPassword();
        str = str.replace("{1}",email);
        str = str.replace("{2}",password);
        str = str.replace("{3}",SettingController.settings.get(SettingController.PORTAL_URL));
        try {
            SendQQMailUtil.send(email, password , str);
        } catch (MessagingException e) {
            e.printStackTrace();
            return "register error";
        }

        return "register success";
    }


    public final static String[] word={
            "a","b","c","d","e","f",
            "g","h","j","k","m","n",
            "p","q","r","s","t","u",
            "v","w","x","y","z",
            "A","B","C","D","E","F",
            "G","H","J","K","M","N",
            "P","Q","R","S","T","U",
            "V","W","X","Y","Z",
    };

    public static String[] num={
            "2","3","4","5","6","7","8","9"
    };
    public static String randomPassword(){

        StringBuffer stringBuffer=new StringBuffer();
        //以当前时间生成random
        Random random=new Random(new Date().getTime());
        boolean flag=false;
        //设置默认密码的长度为1+6位
        int length=random.nextInt(1)+6;
        for (int i = 0; i < length; i++) {
            if(flag){
                stringBuffer.append(num[random.nextInt(num.length)]);
            }else{
                stringBuffer.append(word[random.nextInt(word.length)]);
            }
            flag=!flag;
        }
        return stringBuffer.toString();
    }

}
