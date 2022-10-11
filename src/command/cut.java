package command;

public class cut extends command{
    public cut(edit edit) {
        super(edit);
    }

    @Override
    public void execute() {
        edit.cut();
    }

}
