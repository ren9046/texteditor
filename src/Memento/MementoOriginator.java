package Memento;

import javax.swing.*;

//Provide the function of creating a Memento and restoring the data of the Memento
public class MementoOriginator {
    private String data;
    private MementoCaretaker mementoCaretaker;

    public MementoOriginator() {
        mementoCaretaker = MementoCaretaker.getInstance();
    }
    public Memento createMemento() {
        return new Memento(this);
    }
    public String getData() {
        return data;
    }
    public void setData(String data) {
        this.data = data;
    }
    public void setAndStoreData(String data) {
        this.setData(data);
        mementoCaretaker.addMemento(this.createMemento());
    }
    public void undo(JTextPane text) {
        Memento memento = mementoCaretaker.undo();
        if(memento!=null) {
            text.setText(memento.getData());
        }
    }
    public void redo(JTextPane text) {
        Memento memento = mementoCaretaker.redo();
        if(memento != null) {
            text.setText(memento.getData());
        }
    }
}
