package prototype;
import java.util.HashMap;
import java.util.Map;

public class Prototype {
    //record prototype name and their context
    private Map<String, modeprototype> prototypes = new HashMap<String, modeprototype>();
    public void addPrototype(String mode, modeprototype prototype){
        prototypes.put(mode,prototype);
    }

    //Return the Prototype which the button click
    public modeprototype getPrototype(String mode) throws CloneNotSupportedException {
        return (modeprototype) prototypes.get(mode).clone();
    }
}
