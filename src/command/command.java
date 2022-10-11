package command;
import javax.swing.text.BadLocationException;

public abstract class command {
    edit edit;
    file file;

    command(edit edit) {
        this.edit = edit;
    }

    command(file file){
        this.file = file;
    }

    public abstract void execute() throws BadLocationException;
}
