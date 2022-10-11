package Flyweight_Style;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
public class Custom_Color extends Flyweight {
    public static int Control = 0;
    public static String CustomFGColor;
    public static int CustomFontSize;
    public Custom_Color(){}

    @Override
    public void setStyle() {
        if (Control == 0){
            fontColor = "Black";
            fontSize =12;
        }else{
            fontColor = CustomFGColor;
            fontSize = CustomFontSize;
        }
    }
    public static void Customize(){
        Control = 1;

        final JDialog window = new JDialog();
        window.setVisible(true);
        window.setLayout(new GridLayout(10,1));
        window.setBounds(500,300,250,500);
        window.setTitle("Custom Style");

        //Button
        JButton CheckButton = new JButton("OK");
        //Labels
        JLabel FontColorLabel = new JLabel("Select Font Color");
        JLabel FontSizeLabel = new JLabel("Select Font Size");

        String[] FontSizeList = {"12","16","20","24","28","32"};
        JComboBox FontSizeComboBox = new JComboBox(FontSizeList);

        String[] FontColorList = {"Black","Red", "Blue", "Green","Yellow","Orange","Pink"};
        JComboBox FontColorComboBox = new JComboBox(FontColorList);


        ActionListener FontSizeActionListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int SelectedFontSize = FontSizeComboBox.getSelectedIndex();
                switch (SelectedFontSize){
                    case 0:
                        CustomFontSize = 12;
                        break;
                    case 1:
                        CustomFontSize = 16;
                        break;
                    case 2:
                        CustomFontSize = 20;
                        break;
                    case 3:
                        CustomFontSize = 24;
                        break;
                    case 4:
                        CustomFontSize = 28;
                        break;
                    case 5:
                        CustomFontSize = 32;
                        break;

                }
            }
        };

        ActionListener FontColorActionListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int SelectedFontColorOption = FontColorComboBox.getSelectedIndex();
                switch(SelectedFontColorOption){
                    case 0:
                        CustomFGColor = "FG-Black";
                        break;
                    case 1:
                        CustomFGColor = "FG-Red";
                        break;
                    case 2:
                        CustomFGColor = "FG-Blue";
                        break;
                    case 3:
                        CustomFGColor = "FG-Green";
                        break;
                    case 4:
                        CustomFGColor = "FG-Yellow";
                        break;
                    case 5:
                        CustomFGColor = "FG-Orange";
                        break;
                    case 6:
                        CustomFGColor = "FG-Pink";
                        break;
                }
            }
        };

        ActionListener CheckButtonActionListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                window.dispatchEvent(new WindowEvent(window, WindowEvent.WINDOW_CLOSING));
            }
        };

        FontSizeComboBox.addActionListener(FontSizeActionListener);
        FontColorComboBox.addActionListener(FontColorActionListener);
        CheckButton.addActionListener(CheckButtonActionListener);

        window.add(FontSizeLabel);
        window.add(FontSizeComboBox);
        window.add(FontColorLabel);
        window.add(FontColorComboBox);
        window.add(CheckButton);
    }
}
