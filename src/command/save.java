package command;

public class save extends command{
    public save(file file) {
        super(file);
    }

    @Override
    public void execute() {
        file.save();
    }
}
