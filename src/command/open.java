package command;

public class open extends  command{
    public open(file file) {
        super(file);
    }

    @Override
    public void execute() {
        file.open();
    }
}
