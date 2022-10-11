package Flyweight_Style;
import java.util.Map;
import java.util.HashMap;

public class FlyweightFactory {
    private static Map<Integer, Flyweight> styles = new HashMap<Integer,Flyweight>();
    public static Flyweight getStyle(int style_no){
        if (styles.get(style_no)==null){
            Flyweight s = null;
            switch (style_no){
                case 1: s =  new Style_one();break;
                case 2: s =  new Style_two();break;
                case 3: s =  new Style_three();break;
                case 4: s =  new Custom_Color();break;
            }
            styles.put(style_no,s);
        }
        return styles.get(style_no);

    }
}
