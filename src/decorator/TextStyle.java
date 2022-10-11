package decorator;
import main.texteditor;
import javax.swing.*;
import javax.swing.text.MutableAttributeSet;
import javax.swing.text.SimpleAttributeSet;

public class TextStyle implements  Content{

    public MutableAttributeSet BOLD = new SimpleAttributeSet();
    public  MutableAttributeSet ITALIC = new SimpleAttributeSet();
    public  MutableAttributeSet TextUnderline = new SimpleAttributeSet();
    SimpleAttributeSet att = new SimpleAttributeSet();

    int start,length;
    Content content;
    texteditor editor = Text.editor;
    public TextStyle(Content text) {
        this.content = text;
    }

    @Override
    public void getTextStyle() {
        content.getTextStyle();
    }

    public void setselect() {
        JTextPane jtp = editor.textPane1;
        this.start=jtp.getSelectionStart();
        this.length=jtp.getSelectionEnd()-start;
        System.out.println(this.start & this.length);
    }
}
