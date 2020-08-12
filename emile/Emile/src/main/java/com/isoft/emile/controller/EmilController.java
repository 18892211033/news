package com.isoft.emile.controller;

import com.isoft.emile.bean.ActiveMessage;
import com.isoft.emile.bean.MailMessage;
import com.isoft.emile.util.MailUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.thymeleaf.TemplateEngine;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("/email")
public class EmilController {
    @Autowired
    MailUtil mailUtil;
    //发送激活电子邮件
    @Value("${com.email.ip}")
    String serverIP;
    @Value("${com.email.port}")
    String serverPort;
    @Autowired
    TemplateEngine templateEngine;

    @GetMapping("simple")
    public String sendSimple() {
        MailMessage mailMessage = new MailMessage();
        mailMessage.setTo("361687699@qq.com");
        mailMessage.setSubject("跟您打个招呼");

        String str = "您好，很开心认识您";
        mailMessage.setText(str);
        mailUtil.sendSimpleMail(mailMessage);
        return "ok";
    }

    @GetMapping("html")
    public String sendHtml() {
        MailMessage mailMessage = new MailMessage();
        mailMessage.setTo("361687699@qq.com");
        mailMessage.setSubject("测试HTML邮件");
        String test = "<html lang=\"zh\">" +
                "<head>" +
                "</head>" +
                "<body>" +
                "<a href='http://www.baidu.com'>百度</a>" +
                "<p>王宇回家了</p>" +
                "</body>" +
                "</html>";
        mailMessage.setText(test);
        mailUtil.sendMailHtml(mailMessage);
        return "ok";
    }

    @GetMapping("attachment")
    public String sendAttachment(HttpServletRequest request) {
        MailMessage mailMessage = new MailMessage();
        mailMessage.setTo("361687699@qq.com");
        mailMessage.setSubject("测试HTML邮件");
        String test = "<html lang=\"zh\">" +
                "<head>" +
                "</head>" +
                "<body>" +
                "<p>王宇回家了并带走了一个带<B>附件<B>的邮件</p>" +
                "</body>" +
                "</html>";
        mailMessage.setText(test);
        String fname = "test附件.rar";
        String path = request.getServletContext().getRealPath("/") + "/WEB-INF/classes/static/attachment/" + fname;
        mailMessage.setAttachmentFileName(fname);
        File file = new File(path);
        mailMessage.setAttachmentFile(file);
        mailUtil.sendMailAttachment(mailMessage, true);
        return "Attachment --- ok";
    }

    @GetMapping("sendActive")
    public String sendActive() {
        String url = "email/active";
        String activeCode = UUID.randomUUID().toString().replace("-", "");
        Integer id = 111;
        String title = "激活账号";
        String to = "361687699@qq.com";
        //获取模板页内容 ，填充页中的数据
        ActiveMessage activeMessage = new ActiveMessage();
        activeMessage.setIp(serverIP);
        activeMessage.setPort(serverPort);
        activeMessage.setUrl(url);
        activeMessage.setActiveCode(activeCode);
        activeMessage.setId(String.valueOf(id));

        Map<String, Object> map = new HashMap<>();
        map.put("params", activeMessage);
        org.thymeleaf.context.Context context = new org.thymeleaf.context.Context();
        context.setVariables(map);
        String text = templateEngine.process("ActiveTemplate.html", context);
        MailMessage mailMessage = new MailMessage();
        mailMessage.setTo(to);
        mailMessage.setSubject(title);
        mailMessage.setText(text);
        mailUtil.sendMailHtml(mailMessage);
        return "send Active Email  -- ok ";
    }

    //用户点击电子邮件后的处理
    @GetMapping("active")
    public String active(String activeCode, Integer id) {
        System.out.println(activeCode + "," + id);
        //update db
        return "active -- ok";
    }
}

