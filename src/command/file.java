package command;
import main.texteditor;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class file {
    texteditor editor ;
    public  file(texteditor editor){
        this.editor = editor;
    }

    public void newfile(){
        new texteditor();
    }

    public  void open(){
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setCurrentDirectory(new File("."));
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Text files", "txt");
        fileChooser.setFileFilter(filter);

        int response = fileChooser.showOpenDialog(null);

        if(response == JFileChooser.APPROVE_OPTION) {

            File file = new File(fileChooser.getSelectedFile().getAbsolutePath());
            Scanner fileIn = null;
            try {
                fileIn = new Scanner(file);
                if(file.isFile()) {
                    while(fileIn.hasNextLine()) {
                        String line = fileIn.nextLine()+"\n";
                        editor.textPane1.setText(line);
                    }
                }
            }catch (FileNotFoundException e1) {
                e1.printStackTrace();
            }finally {
                fileIn.close();
            }
        }
    }

    public void  save(){
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setCurrentDirectory(new File("."));

        int response = fileChooser.showSaveDialog(null);

        if(response == JFileChooser.APPROVE_OPTION) {
            File file;
            PrintWriter fileOut = null;

            file = new File(fileChooser.getSelectedFile().getAbsolutePath());
            try {
                fileOut = new PrintWriter(file);
                fileOut.println(editor.textPane1.getText());
            }
            catch (FileNotFoundException e1) {
                e1.printStackTrace();
            }
            finally {
                fileOut.close();
            }
        }
    }

    public  void exit(){
        System.exit(0);
    }
}
