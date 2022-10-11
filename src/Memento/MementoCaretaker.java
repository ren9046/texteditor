package Memento;

import java.util.ArrayList;
import java.util.List;

//Responsible for managing, maintaining and reading Memento
public class MementoCaretaker {
    private List<Memento> undoList;
    private final List<Memento> redoList;
    private static MementoCaretaker caretaker;

    private MementoCaretaker() {
        undoList = new ArrayList<>();
        redoList = new ArrayList<>();
    }

    public static MementoCaretaker getInstance() {
        if(caretaker == null) {
            caretaker = new MementoCaretaker();
        }
        return caretaker;
    }
    public void addMemento(Memento memento) {
        for (int i = redoList.size() - 1; i >= 0; i--) {
            redoList.remove(i);
        }
        undoList.add(memento);
    }
    public Memento undo() {
        Memento result = null;
        if(undoList.size() >= 1) {
            result=undoList.get(undoList.size() - 2);
            redoList.add(undoList.get(undoList.size() - 1));
            undoList.remove(undoList.size() - 1);
        } else {
            System.out.println("fail");
        }
        return result;
    }
    public Memento redo() {
        Memento result = null;
        if(redoList.size() > 0) {
            result=redoList.get(redoList.size() - 1);
            undoList.add(result);
            redoList.remove(redoList.size() - 1);
        } else {
            System.out.println("fail");
        }
        return result;
    }
}
