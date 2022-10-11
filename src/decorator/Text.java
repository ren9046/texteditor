package decorator;
import main.texteditor;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;

public class Text implements Content{
    static texteditor editor;
    public Text(texteditor edit){
        editor = edit;
    }
    public SimpleAttributeSet att = new SimpleAttributeSet();

    @Override
    public void getTextStyle() {
        StyleConstants.setFontSize(att,20);
        StyleConstants.setFontFamily(att,"新細明體");
        editor.textPane1.setCharacterAttributes(att,false);
    }

}
