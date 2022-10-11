package decorator;

import javax.swing.text.StyleConstants;
import java.awt.*;

public class TextLight extends  TextStyle{
    public TextLight(Content text) {
        super(text);
    }
    @Override
    public void getTextStyle(){
        super.getTextStyle();
        addLight();
    };
    private void addLight(){
        System.out.println("text add LightStyle");
        StyleConstants.setBackground(att, Color.yellow);
        editor.textPane1.setCharacterAttributes(att,false);
    }

}
