package observer;

import javax.mail.*;
import javax.mail.internet.*;
import javax.mail.internet.MimeMessage.RecipientType;
import java.util.Properties;


public class JavaMail {
    private String acc = ""; /* sender mail address,Only can use the mail server provided by google,
                                otherwise you must change the mail server settings below*/
    private String pwd = ""; // 寄件者密碼
    private String receiver = ""; // 收件者郵箱
    private String subject = "texteditor's context"; // 標題
    private String txt = ""; // context

    //set mail receiver
    public void setReceiver(String address){
        this.receiver =address;
    }
    //set mail context
    public void  setText(String data){
        txt="Program texteditor has new file save. The following file content:\n"+data;
    }
    //set email send server
    private  Properties setserver(){
        /* link setting The following is set to gmail.
        gmail:https://support.google.com/mail/answer/7126229?hl=zh-Hant#zippy=%2C%E6%AD%A5%E9%A9%9F-%E6%AA%A2%E6%9F%A5-imap-%E6%98%AF%E5%90%A6%E5%B7%B2%E5%95%9F%E7%94%A8%2C%E6%AD%A5%E9%A9%9F-%E8%AE%8A%E6%9B%B4%E9%9B%BB%E5%AD%90%E9%83%B5%E4%BB%B6%E7%94%A8%E6%88%B6%E7%AB%AF%E7%9A%84-smtp-%E5%92%8C%E5%85%B6%E4%BB%96%E8%A8%AD%E5%AE%9A
        yahoo mail:https://help.yahoo.com/kb/SLN4075.html
         */
        Properties prop = new Properties();

        // setting link is smtp
        prop.setProperty("mail.transport.protocol", "smtp");

        // host server:smtp.gmail.com
        prop.setProperty("mail.host", "smtp.gmail.com");

        // host port:465
        prop.put("mail.smtp.port", "465");

        // sender account need Auth：Yes
        prop.put("mail.smtp.auth", "true");

        // need useSSL：Yes
        prop.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");

        // SSL port：465
        prop.put("mail.smtp.socketFactory.port", "465");

        // show link info for debug
        //prop.put("mail.debug", "true");
        return  prop;
    }
    //use above info to send email
    public void SendMail() {

        Properties prop = setserver();
        // Auth sender login info
        Auth auth = new Auth(acc, pwd);
        Session session = Session.getDefaultInstance(prop, auth);

        // setting mail send info
        MimeMessage msg = new MimeMessage(session);

        try {

            // new sender class
            InternetAddress sender = new InternetAddress(acc);
            msg.setSender(sender);

            // new receiver class
            msg.setRecipient(RecipientType.TO, new InternetAddress(receiver));

            // set title
            msg.setSubject(subject);

            // set content and its encoding
            msg.setContent(txt, "text/html;charset = UTF-8");


            // ---------------------------------------------------------Transport傳送Message
            Transport mailserver = session.getTransport();

            // mailserver將message送出
            mailserver.send(msg);

            // stop mailserver
            mailserver.close();

        } catch (MessagingException e) {
            // deal with send exception
            e.printStackTrace();
        }


    }

}
//Authenticate sender account
class Auth extends Authenticator {

    private String acc;
    private String pwd;
    //input sender's info to construct
    public Auth(String userName, String password) {
        this.acc = userName;
        this.pwd = password;
    }
    //return Auth's result
    @Override
    protected PasswordAuthentication getPasswordAuthentication() {
        PasswordAuthentication pa = new PasswordAuthentication(acc, pwd);
        return pa;
    }

}
