package command;
import javax.swing.text.BadLocationException;

public class paste extends command{
    public paste(edit edit) {
        super(edit);
    }

    @Override
    public void execute() throws BadLocationException {
        edit.paste();
    }
}
