package prototype;

public class modeprototype implements Cloneable{

        private String mode;

        public String getMode(){
            return mode;
        }

        public void setMode(String mode) {this.mode = mode;}

        //Clone the Prototype and return clone;
        public Object clone() throws CloneNotSupportedException{

            modeprototype clone = (modeprototype) super.clone();

            return clone;
        }
    }
