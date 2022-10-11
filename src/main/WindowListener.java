package main;

import Flyweight_Style.FlyweightFactory;

import javax.swing.*;
import javax.swing.text.MutableAttributeSet;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledEditorKit;
import java.awt.*;
import java.awt.event.ActionEvent;
import Flyweight_Style.Flyweight;
public class WindowListener {
    texteditor texteditor;
    FlyweightFactory flyweightFactory;
    public WindowListener(main.texteditor mainWindow){
        this.texteditor = mainWindow;
    }
    public void Color(int c){
        Flyweight style = flyweightFactory.getStyle(c);
        style.execute();
    }
    public static class ForegroundColor extends StyledEditorKit.StyledTextAction{
        private Color fg;

        public ForegroundColor(String nm, Color fg) {
            super(nm);
            this.fg = fg;
        }

        @Override
        public void actionPerformed(ActionEvent ae) {
            JEditorPane editor = getEditor(ae);
            if (editor == null) return ;
            // 設定空的attribute
            MutableAttributeSet attr = new SimpleAttributeSet();
            // 傳送變換背景色的指令給editor
            if (this.fg != null) {
                StyleConstants.setForeground(attr, this.fg);
            }
            setCharacterAttributes(editor, attr, false);
        }

    }
}
