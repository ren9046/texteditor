package decorator;
import javax.swing.text.StyleConstants;

public class TextBold extends TextStyle{

    public TextBold(Content text){
        super(text);
    }

    @Override
    public void getTextStyle( ){
        super.getTextStyle();
        addBold();
    }

    private void addBold(){
        setselect();
        StyleConstants.setBold(BOLD,true);
        editor.textPane1.getStyledDocument().setCharacterAttributes(start, length, BOLD, false);
        System.out.println("text add boldStyle");
    }
}
