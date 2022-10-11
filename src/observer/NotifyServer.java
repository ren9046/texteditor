package observer;

public class NotifyServer implements observer{
    //subscriber's e-mail
    String email;

    public NotifyServer(String amail){
        email =amail;
    }
    //run JavaMail to send texteditor's context for subscriber
    @Override
    public void Update(String data) {
        JavaMail mail = new JavaMail();
        mail.setReceiver(this.email);
        mail.setText(data);
        mail.SendMail();
    }
}
