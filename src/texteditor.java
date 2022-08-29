import javax.swing.*;

public class texteditor {
    private JTextArea textArea1;
    private JPanel panel1;
    private JMenu filemenu;
    private JMenuItem NewFile;
    private JMenuItem OpenFile;
    private JMenu editmenu;
    private JMenuItem copy;
    private JMenuItem cut;
    private JMenuItem paste;
    private JMenu modemenu;
    private JMenuItem lang_c;
    private JMenuItem lang_Java;
    private JMenuItem lang_py;
    private JMenu fontmenu;
    private JMenuItem LFont;
    private JMenuItem RFont;
    private JMenuItem CFont;
    private JMenuItem SaveFile;
    private JMenuItem Exit;
    private JMenuItem normal;

    public static void main(String[] args) {
        JFrame frame = new JFrame("texteditor");
        frame.setContentPane(new texteditor().panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
