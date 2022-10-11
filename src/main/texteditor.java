package main;

import Flyweight_Style.Custom_Color;
import Iterator.Iterator;
import Iterator.WordContainer;
import Memento.MementoOriginator;
import command.*;
import decorator.*;
import observer.NotifyServer;
import observer.Subscriber;
import prototype.Prototype;
import prototype.modeprototype;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.plaf.FontUIResource;
import javax.swing.text.BadLocationException;
import javax.swing.text.StyleContext;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class texteditor extends JFrame implements ActionListener, DocumentListener {
    private JPanel panel1;
    private JMenu filemenu;
    private JMenuItem NewFile;
    private JMenuItem OpenFile;
    private JMenu editmenu;
    private JMenuItem copy;
    private JMenuItem cut;
    private JMenuItem paste;

    private JMenuItem undo;
    private JMenuItem redo;
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


    private JTextField countWord;
    private MementoOriginator originator = new MementoOriginator();
    private WordContainer word;

    private JMenu styleMenu;

    private JMenuItem Style_one;

    private JMenuItem Style_two;

    private JMenuItem Style_three;
    private JMenuItem Custom_Style;
    private JMenuItem Customize;

    public JTextPane textPane1;
    private JTextField emailinput;
    private JButton NotifyButton;
    private JButton unsubscribe;
    private modeprototype java;
    private modeprototype c;
    private modeprototype python;
    private modeprototype clear;
    private Prototype modes;
    // oberserver's variable
    private Subscriber cs = new Subscriber();
    private NotifyServer obs;
    private final WindowListener eventListener = new WindowListener(this);

    private JMenu textmenu;
    private JMenuItem bold;
    private JMenuItem italic;
    private JMenuItem underline;
    private JMenuItem light;
    private JMenuItem clean;
    public String clipboard;
    private final history history = new history();
    texteditor editor = this;
    public Text atr = new Text(editor);
    edit editcm = new edit(this);
    file filecm = new file(this);
    TextStyle bold_text = new TextBold(new Text(this));//額外加的外型--粗體-------------Decorater
    TextStyle italic_text = new TextItalic(new Text(this));//額外加的外型--斜體-------------Decorater
    TextStyle underline_text = new TextUnderline(new Text(this));//額外加的外型--斜體-------------Decorater
    TextStyle light_text = new TextLight(new Text(this));
    TextStyle clean_text = new CleanStyle(new Text(this));//額外加的外型--清除樣式-------------Decorater

    public texteditor() {
        JFrame frame = new JFrame("texteditor");
        frame.setContentPane(this.panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        init();
        atr.getTextStyle();
        setUpEventListener();
        //Bind Edit Menu
        undo.setAccelerator(KeyStroke.getKeyStroke("ctrl Z"));
        redo.setAccelerator(KeyStroke.getKeyStroke("ctrl Y"));
        undo.setMnemonic('U');
        redo.setMnemonic('R');
        undo.addActionListener(this);
        redo.addActionListener(this);
        textPane1.getDocument().addDocumentListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == undo) {
            originator.undo(textPane1);
        }

        if (e.getSource() == redo) {
            originator.redo(textPane1);
        }
    }

    public static void main(String[] args) {
        new texteditor();
    }

    //set protype's context
    public void init() {
        java = new modeprototype();
        java.setMode("public class Main\n" +
                "{\n" +
                "\tpublic static void main(String[] args) {\n" +
                "\t\tSystem.out.println(\"Hello World\");\n" +
                "\t}\n" +
                "}");
        c = new modeprototype();
        c.setMode("#include <stdio.h>\n" +
                "\n" +
                "int main()\n" +
                "{\n" +
                "    printf(\"Hello World\");\n" +
                "\n" +
                "    return 0;\n" +
                "}");
        python = new modeprototype();
        python.setMode("print ('Hello World')");
        clear = new modeprototype();
        clear.setMode("");
        modes = new Prototype();
        modes.addPrototype("c", c);
        modes.addPrototype("java", java);
        modes.addPrototype("python", python);
        modes.addPrototype("clear", clear);


    }

    @Override
    public void insertUpdate(DocumentEvent e) {
        originator.setAndStoreData(textPane1.getText());
        setCountWord(textPane1.getText());
    }

    @Override
    public void removeUpdate(DocumentEvent e) {
        originator.setAndStoreData(textPane1.getText());
        setCountWord(textPane1.getText());
    }

    @Override
    public void changedUpdate(DocumentEvent e) {
        System.out.println("Change Happened");
    }

    //Set up and use the Iterator to count the words
    public void setCountWord(String w) {
        ArrayList<String> wList = new ArrayList<>();
        int count = 0;
        List<String> text = new ArrayList<>();

        for (int i = 0; i < w.length(); i += 1) {
            wList.add(w.substring(i, Math.min(w.length(), i + 1)));
        }
        word = new WordContainer(wList);

        for (Iterator iter = word.getIterator(); iter.hasNext(); ) {
            count++;
            iter.next();
        }
        countWord.setText("word : " + count);
        wList.clear();
    }

    //set mode "C" context
    public void PrintC(ActionEvent actionEvent) throws CloneNotSupportedException {
        modeprototype cpro = modes.getPrototype("c");
        textPane1.setText(cpro.getMode());
    }

    //set mode "Java" context
    public void PrintJava(ActionEvent actionEvent) throws CloneNotSupportedException {
        modeprototype javapro = modes.getPrototype("java");
        textPane1.setText(javapro.getMode());
    }

    //set mode "Python" context
    public void PrintPython(ActionEvent actionEvent) throws CloneNotSupportedException {
        modeprototype pypro = modes.getPrototype("python");
        textPane1.setText(pypro.getMode());
    }

    //set mode "normal" context
    public void PrintClear(ActionEvent actionEvent) throws CloneNotSupportedException {
        modeprototype clearpro = modes.getPrototype("clear");
        textPane1.setText(clearpro.getMode());
    }

    private void setUpEventListener() {
        //set lang_c function
        lang_c.addActionListener(
                new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        try {
                            PrintC(e);
                        } catch (CloneNotSupportedException ex) {
                            ex.printStackTrace();
                        }
                    }
                }
        );
        //set lang_Java function
        lang_Java.addActionListener(
                new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        try {
                            PrintJava(e);
                        } catch (CloneNotSupportedException ex) {
                            ex.printStackTrace();
                        }
                    }
                }
        );
        //set lang_py function
        lang_py.addActionListener(
                new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        try {
                            PrintPython(e);
                        } catch (CloneNotSupportedException ex) {
                            ex.printStackTrace();
                            System.out.println("error");
                        }
                    }
                }
        );
        //set normal function
        normal.addActionListener(
                new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        try {
                            PrintClear(e);
                        } catch (CloneNotSupportedException ex) {
                            ex.printStackTrace();
                            System.out.println("error");
                        }
                    }
                }
        );
        //set subscribe function
        NotifyButton.addActionListener(
                new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        obs = new NotifyServer(emailinput.getText());
                        cs.Attach(emailinput.getText(), obs);
                    }
                }
        );
        //set unsubscribe function
        unsubscribe.addActionListener(
                new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        obs = new NotifyServer(emailinput.getText());
                        cs.Detach(emailinput.getText(), obs);
                    }
                }
        );
        //set save&notify function
        SaveFile.addActionListener(
                new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        cs.SendEmail(textPane1.getText());
                    }
                }
        );
        //set style function
        Style_one.addActionListener(
                new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        eventListener.Color(1);
                    }
                }
        );
        Style_two.addActionListener(
                new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        eventListener.Color(2);
                    }
                }
        );
        Style_three.addActionListener(
                new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        eventListener.Color(3);
                    }
                }
        );
        Custom_Style.addActionListener(
                new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        eventListener.Color(4);
                    }
                }
        );
        Customize.addActionListener(
                new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        Custom_Color.Customize();
                    }
                }
        );
        //set Text function

        copy.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new copy(editcm).execute();
                System.out.println("copy");
            }
        });

        cut.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new cut(editcm).execute();
                System.out.println("cut");
            }
        });

        paste.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    new paste(editcm).execute();
                } catch (BadLocationException ex) {
                    throw new RuntimeException(ex);
                }
                System.out.println("paste");
            }
        });

        NewFile.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new newfile(filecm).execute();
            }
        });

        OpenFile.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new open(filecm).execute();
            }
        });

        SaveFile.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new save(filecm).execute();
            }
        });

        Exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new exit(filecm).execute();
            }
        });

        bold.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                bold_text.getTextStyle();
            }
        });

        italic.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                italic_text.getTextStyle();
            }
        });

        underline.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                underline_text.getTextStyle();
            }
        });

        light.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                light_text.getTextStyle();
            }
        });

        clean.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                clean_text.getTextStyle();
            }
        });
    }


}
