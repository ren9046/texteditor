package observer;

import java.util.ArrayList;

public interface Subject {
    public void Notify() ;
    public void Attach(String email,observer s);
    public void Detach(String email,observer s);
}
