package Iterator;

import java.util.ArrayList;

public class WordContainer implements Container{
    public ArrayList<String> wList;

    public WordContainer(ArrayList<String> list) {
        this.wList = list;
    }


    @Override
    public Iterator getIterator() {
        return new WordIterator();
    }

    private class WordIterator implements Iterator {
        int index;

        @Override
        public boolean hasNext() {
            if(index < wList.size()) {
                return true;
            }
            return false;
        }

        @Override
        public Object next() {
            if(this.hasNext()) {
                return wList.get(index++);//.getWord()
            }
            return null;
        }
    }
}
