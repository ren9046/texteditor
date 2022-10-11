package decorator;
import javax.swing.text.StyleConstants;

public class TextItalic extends TextStyle{

    public TextItalic(Content text){
        super(text);
    }

    @Override
    public void getTextStyle( ){
        super.getTextStyle();
        addItalic();
    }

    private void addItalic(){
        setselect();
        StyleConstants.setItalic(ITALIC,true);
        editor.textPane1.getStyledDocument().setCharacterAttributes(start, length, ITALIC, false);
        System.out.println("text add italicStyle");
    }
}
