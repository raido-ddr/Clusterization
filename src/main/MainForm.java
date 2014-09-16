/*
 * Created by JFormDesigner on Mon Sep 15 22:56:19 FET 2014
 */

package main;

import java.awt.*;
import javax.swing.*;
import com.jgoodies.forms.factories.*;
import com.jgoodies.forms.layout.*;

/**
 * @author unknown
 */
public class MainForm extends JFrame {
    public MainForm() {
        initComponents();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        panel1 = new JPanel();
        panel2 = new JPanel();
        label1 = new JLabel();
        textField1 = new JTextField();
        label2 = new JLabel();
        textField2 = new JTextField();
        button1 = new JButton();
        button2 = new JButton();

        //======== this ========
        Container contentPane = getContentPane();
        contentPane.setLayout(new FormLayout(
            "592dlu, $lcgap, 90dlu",
            "397dlu"));

        //======== panel1 ========
        {
            panel1.setLayout(new FormLayout(
                "592dlu",
                "397dlu"));
        }
        contentPane.add(panel1, CC.xy(1, 1, CC.DEFAULT, CC.FILL));

        //======== panel2 ========
        {
            panel2.setLayout(new FormLayout(
                "97dlu",
                "25dlu, 8*($lgap, default)"));

            //---- label1 ----
            label1.setText("Number of observations:");
            panel2.add(label1, CC.xy(1, 1));
            panel2.add(textField1, CC.xy(1, 3));

            //---- label2 ----
            label2.setText("Number of clusters:");
            panel2.add(label2, CC.xy(1, 7));
            panel2.add(textField2, CC.xy(1, 9));

            //---- button1 ----
            button1.setText("K-means");
            panel2.add(button1, CC.xy(1, 13));

            //---- button2 ----
            button2.setText("Maximin");
            panel2.add(button2, CC.xy(1, 17));
        }
        contentPane.add(panel2, CC.xy(3, 1, CC.CENTER, CC.FILL));
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JPanel panel1;
    private JPanel panel2;
    private JLabel label1;
    private JTextField textField1;
    private JLabel label2;
    private JTextField textField2;
    private JButton button1;
    private JButton button2;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
