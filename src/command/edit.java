package command;
import main.texteditor;
import javax.swing.text.BadLocationException;
import javax.swing.text.StyledDocument;

public class edit {
    private String backup;
    texteditor editor ;

    public  edit(texteditor editor){
        this.editor = editor;
    }

    final ThreadLocal<StyledDocument> doc = ThreadLocal.withInitial(() -> editor.textPane1.getStyledDocument());

    public  void  copy(){
        editor.clipboard = editor.textPane1.getSelectedText();
    }

    public  void  cut(){
        backup();
        String source = editor.textPane1.getText();
        editor.clipboard = editor.textPane1.getSelectedText();
        editor.textPane1.setText(cutString(source));
    }

    public  void  paste() throws BadLocationException {
        backup();
        doc.get().insertString(doc.get().getLength(), editor.clipboard,editor.atr.att);
    }

    void backup() {
        backup = editor.textPane1.getText();
    }

    private String cutString(String source) {
        String start = source.substring(0, editor.textPane1.getSelectionStart());
        String end = source.substring(editor.textPane1.getSelectionEnd());
        return start+end;
    }
}
