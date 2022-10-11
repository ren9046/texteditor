package Memento;

//Save the internal data of Originator
public class Memento {
    private String data;

    public Memento(MementoOriginator mementoOriginator) {
        this.data = mementoOriginator.getData();
    }
    public String getData() {
        return data;
    }
    public void setData(String data) {
        this.data = data;
    }
}