package com.leon.utils;

import com.leon.pojo.Chats;
import com.leon.pojo.FriendList;
import com.leon.pojo.StarSpace;
import com.leon.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.UnsupportedEncodingException;

@Component
public class EmailUtil {
    @Value("${spring.mail.from}") // 从application.yml配置文件中获取
    private String from; // 发送发邮箱地址
    @Autowired
    private JavaMailSender mailSender;
    @Autowired
    TemplateEngine templateEngine;

    /**
     * 发送验证码模板
     *
     * @param to      接收方
     * @param subject 邮件主题
     * @param verification 验证码内容
     */
    public void sendCode(String to, String subject, int verification) throws MessagingException, UnsupportedEncodingException {
        // 创建一个邮件对象
        MimeMessage mimeMessage = mailSender.createMimeMessage();
        MimeMessageHelper msg = new MimeMessageHelper(mimeMessage, true);
        msg.setFrom("1686201564@qq.com","polyhedron.com"); // 设置发送方
        msg.setTo(to); // 设置接收方
        msg.setSubject(subject); // 设置邮件主题
        Context context = new Context();
        context.setVariable("code",verification);
        String process = templateEngine.process("SendCodeTemplate.html",context);
        msg.setText(process,true); // 设置邮件内容
        // 发送邮件
        mailSender.send(mimeMessage);
    }

    /**
     * 发送注册成功模板
     *
     * @param to      接收方
     * @param subject 邮件主题
     * @param user  刚刚注册的用户
     */
    public void sendRegisterSuccess(String to, String subject, User user) throws MessagingException, UnsupportedEncodingException {
        // 创建一个邮件对象
        MimeMessage mimeMessage = mailSender.createMimeMessage();
        MimeMessageHelper msg = new MimeMessageHelper(mimeMessage, true);
        msg.setFrom("1686201564@qq.com","polyhedron.com"); // 设置发送方
        msg.setTo(to); // 设置接收方
        msg.setSubject(subject); // 设置邮件主题
        Context context = new Context();
        context.setVariable("userName",user.getUserQQ());
        context.setVariable("userPassword",user.getUserPassword());
        context.setVariable("userEmail",user.getUserEmail());
        String process = templateEngine.process("RegistSuccessTemplate.html",context);
        msg.setText(process,true); // 设置邮件内容
        // 发送邮件
        mailSender.send(mimeMessage);
    }

    /**
     * 忘记密码
     *
     * @param to      接收方
     * @param subject 邮件主题
     * @param user  用户
     */
    public void userForgetPassword(String to, String subject, User user) throws MessagingException, UnsupportedEncodingException {
        // 创建一个邮件对象
        MimeMessage mimeMessage = mailSender.createMimeMessage();
        MimeMessageHelper msg = new MimeMessageHelper(mimeMessage, true);
        msg.setFrom("1686201564@qq.com","polyhedron.com"); // 设置发送方
        msg.setTo(to); // 设置接收方
        msg.setSubject(subject); // 设置邮件主题
        Context context = new Context();
        context.setVariable("userName",user.getUserName());
        context.setVariable("userPassword",user.getUserPassword());
        String process = templateEngine.process("ForgetPasswordTemplate.html",context);
        msg.setText(process,true); // 设置邮件内容
        // 发送邮件
        mailSender.send(mimeMessage);
    }

    /**
     * 发送消息
     *
     * @param to      接收方
     * @param subject 邮件主题
     * @param starSpace  内容
     */
    public void sendMessages(String to, String subject, StarSpace starSpace) throws MessagingException, UnsupportedEncodingException{
        // 创建一个邮件对象
        MimeMessage mimeMessage = mailSender.createMimeMessage();
        MimeMessageHelper msg = new MimeMessageHelper(mimeMessage, true);
        msg.setFrom("1686201564@qq.com","polyhedron.com"); // 设置发送方
        msg.setTo(to); // 设置接收方
        msg.setSubject(subject); // 设置邮件主题
        Context context = new Context();
        context.setVariable("userName",starSpace.getPublishQQ());
        context.setVariable("noticeTime",starSpace.getPublishTime());
        context.setVariable("messageType",starSpace.getCollector());
        context.setVariable("sendUserName",starSpace.getSharer());
        context.setVariable("messageContent",starSpace.getGooder());
        String process = templateEngine.process("sendMessages.html",context);
        msg.setText(process,true); // 设置邮件内容
        // 发送邮件
        mailSender.send(mimeMessage);
    }


    /**
     * 登录通知
     *
     * @param to      接收方
     * @param subject 邮件主题
     * @param user  内容
     */
    public void loginNotice(String to, String subject, User user) throws MessagingException, UnsupportedEncodingException{
        // 创建一个邮件对象
        MimeMessage mimeMessage = mailSender.createMimeMessage();
        MimeMessageHelper msg = new MimeMessageHelper(mimeMessage, true);
        msg.setFrom("1686201564@qq.com","polyhedron.com"); // 设置发送方
        msg.setTo(to); // 设置接收方
        msg.setSubject(subject); // 设置邮件主题
        Context context = new Context();
        context.setVariable("userName",user.getUserQQ());
        context.setVariable("noticeTime",user.getUserSign());
        String process = templateEngine.process("loginNotice.html",context);
        msg.setText(process,true); // 设置邮件内容
        // 发送邮件
        mailSender.send(mimeMessage);
    }
}

