package com.example.demo.util;

/**
 * @author 浅蓝
 * @email blue@ixsec.org
 * @since 2019/10/28 19:16
 */
import com.example.demo.controller.RegisterController;
import com.example.demo.controller.SettingController;

import java.util.Properties;
import javax.activation.DataHandler;
import javax.mail.*;
import javax.mail.internet.*;

public class SendQQMailUtil {
    public static void send(String email , String pass , String template) throws AddressException,MessagingException {
        Properties properties = new Properties();
        properties.put("mail.transport.protocol", "smtp");// 连接协议
        properties.put("mail.smtp.host", "smtp.qq.com");// 主机名
        properties.put("mail.smtp.port", 465);// 端口号
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.ssl.enable", "true");// 设置是否使用ssl安全连接 ---一般都使用
        properties.put("mail.debug", "true");// 设置是否显示debug信息 true 会在控制台显示相关信息
        // 得到回话对象
        Session session = Session.getInstance(properties);
        // 获取邮件对象
        Message message = new MimeMessage(session);
        // 设置发件人邮箱地址
        message.setFrom(new InternetAddress(SettingController.EMAIL_ACCOUNT));
        // 设置收件人邮箱地址
        message.setRecipient(Message.RecipientType.TO, new InternetAddress(email));//一个收件人
        // 设置邮件标题
        message.setSubject("欢迎注册DEMO");
        // 设置邮件内容
        // 得到邮差对象
        message.setContent(template, "text/html;charset=utf-8");
/*
        Multipart mp = new MimeMultipart("related");
        BodyPart bodyPart = new MimeBodyPart();
        bodyPart.setDataHandler(new DataHandler(template,"text/html;charset=UTF-8"));

        mp.addBodyPart(bodyPart);
        message.setContent(mp);// 设置邮件内容对象*/

        Transport transport = session.getTransport();
        // 连接自己的邮箱账户
        transport.connect(SettingController.EMAIL_ACCOUNT, SettingController.EMAIL_PASS);// 密码为QQ邮箱开通的stmp服务后得到的客户端授权码
        // 发送邮件
        transport.sendMessage(message, message.getAllRecipients());
        transport.close();
    }
}