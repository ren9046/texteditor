package command;

public class newfile extends command{

    public newfile(file file) {
        super(file);
    }

    @Override
    public void execute() {
        file.newfile();
    }
}
