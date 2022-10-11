package Flyweight_Style;

import main.WindowListener;

import javax.swing.text.StyledEditorKit;
import java.util.HashMap;
import java.util.Map;
import java.awt.Color;
public abstract class Flyweight {
    protected static String fontColor;
    protected static int fontSize;
    protected Color color;
    protected Map<String, Color> colorList= new HashMap<String, Color>(){{
        put("FG-Red",Color.RED);
        put("FG-Blue",Color.BLUE);
        put("FG-Green",Color.GREEN);
        put("FG-Black",Color.BLACK);
        put("FG-Yellow",Color.yellow);
        put("FG-Orange",Color.orange);
        put("FG-Pink",Color.pink);
    }};
    public void execute(){
        setStyle();
        show();
    }
    public Flyweight(){}
    public abstract void setStyle();

    protected void show(){
        color = colorList.get(fontColor);
        new StyledEditorKit.FontSizeAction("font-size-"+fontSize,fontSize).actionPerformed(null);
        new WindowListener.ForegroundColor(fontColor,color).actionPerformed(null);
    }
}
