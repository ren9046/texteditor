package command;

public class exit extends command{
    public exit(file file) {
        super(file);
    }

    @Override
    public void execute(){
        file.exit();
    }
}
