package observer;

import java.util.HashMap;

public class Subscriber implements Subject{
    //// use HashMap to record all subscribers' e-mail
    HashMap<String,observer> sub;
    //mail context
    String data;
    //init subscriber setting
    public Subscriber(){
        sub = new HashMap<String, observer>();
        data="";
    }
    //set mail context and notify all subscribers' e-mail
    public void SendEmail(String text)
    {
        data = text;
        Notify();
    }
    //add subscriber's e-mail
    public  void Attach(String email,observer s){
        if(sub.get(email)==null) {
            System.out.println("add:"+email);
            sub.put(email,s);
        }
    }
    //delete subscribers' e-mail
    public  void Detach(String email,observer s){
        if(sub.get(email)!=null) {
            System.out.println("remove:"+email);
            sub.remove(email);
        }
    }
    //notify all subscribers' e-mail
    public void Notify() {
        for (observer o: sub.values()){
            o.Update(data);
        }

    }
}
