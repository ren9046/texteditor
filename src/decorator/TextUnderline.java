package decorator;
import javax.swing.text.StyleConstants;

public class TextUnderline extends TextStyle{

    public TextUnderline(Content text){
        super(text);
    }

    @Override
    public void getTextStyle( ){
        super.getTextStyle();
        addUnderLine();
    }

    private void addUnderLine(){
        setselect();
        StyleConstants.setUnderline(TextUnderline,true);
        editor.textPane1.getStyledDocument().setCharacterAttributes(start, length, TextUnderline, false);
        System.out.println("text add UnderlineStyle");
    }
}
