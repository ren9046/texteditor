package command;
import java.util.Stack;

public class history {
    private Stack<command> history = new Stack<>();

    public void push(command c) {
        history.push(c);
    }

    public command pop() {
        return history.pop();
    }

    public boolean isEmpty() { return history.isEmpty(); }
}
