package command;

public class copy extends command {
    public copy(edit edit) {
        super(edit);
    }

    @Override
    public void execute() {
        edit.copy();
    }
}
