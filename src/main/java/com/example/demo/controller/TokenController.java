package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author 浅蓝
 * @email blue@ixsec.org
 * @since 2019/10/28 22:48
 */
@RequestMapping
@Controller
public class TokenController {

    @RequestMapping("token")
    @ResponseBody
    public String token(@RequestParam(required = false,defaultValue = "") String point1,
                        @RequestParam(required = false,defaultValue = "")String point2){

        String template = "<!DOCTYPE html>\n" +
                "<html lang=\"en\">\n" +
                "<head>\n" +
                "    <meta charset=\"UTF-8\">\n" +
                "    <title>Test</title>\n" +
                "</head>\n" +
                "<body>\n" +
                "\n" +
                point1 +
                "\n" +
                "<div>\n" +
                "  <input type=\"hidden\" name=\"CSRF_TOKEN\" value=\"bbbc91aa69902418cad12b17e4df1d0d\">\n" +
                "</div>" +
                        point2 +
                "\n" +
                "</body>\n" +
                "</html>";
        return template;
    }

}
