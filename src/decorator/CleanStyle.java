package decorator;
import main.WindowListener;

import javax.swing.text.StyleConstants;
import java.awt.*;

public class CleanStyle extends TextStyle {

    public CleanStyle(Content text){
        super(text);
    }

    @Override
    public void getTextStyle() {
        super.getTextStyle();
        cleanStyle();
    }

    private void cleanStyle(){
        setselect();
        StyleConstants.setBold(BOLD,false);
        StyleConstants.setItalic(ITALIC,false);
        StyleConstants.setUnderline(TextUnderline,false);
        StyleConstants.setBackground(att, Color.white);
        editor.textPane1.getStyledDocument().setCharacterAttributes(start, length, BOLD, false);
        editor.textPane1.getStyledDocument().setCharacterAttributes(start, length, ITALIC, false);
        editor.textPane1.getStyledDocument().setCharacterAttributes(start, length, TextUnderline, false);
        editor.textPane1.setCharacterAttributes(att,false);
        new WindowListener.ForegroundColor("FG-Black",Color.BLACK).actionPerformed(null);
        System.out.println("Clean TextStyle");
    }
}
