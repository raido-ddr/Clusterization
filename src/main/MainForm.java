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
        imageHolder = new JPanel();
        controlHolder = new JPanel();
        label1 = new JLabel();
        textField1 = new JTextField();
        label2 = new JLabel();
        textField2 = new JTextField();
        kMeansBtn = new JButton();
        maximinBtn = new JButton();

        //======== this ========
        Container contentPane = getContentPane();
        contentPane.setLayout(new FormLayout(
            "592dlu, $lcgap, 90dlu",
            "397dlu"));

        //======== imageHolder ========
        {
            imageHolder.setLayout(new FormLayout(
                "592dlu",
                "397dlu"));
        }
        contentPane.add(imageHolder, CC.xy(1, 1, CC.DEFAULT, CC.FILL));

        //======== controlHolder ========
        {

            //---- label1 ----
            label1.setText("Number of observations:");

            //---- label2 ----
            label2.setText("Number of clusters:");

            //---- kMeansBtn ----
            kMeansBtn.setText("K-means");

            //---- maximinBtn ----
            maximinBtn.setText("Maximin");

            GroupLayout controlHolderLayout = new GroupLayout(controlHolder);
            controlHolder.setLayout(controlHolderLayout);
            controlHolderLayout.setHorizontalGroup(
                controlHolderLayout.createParallelGroup()
                    .addGroup(controlHolderLayout.createSequentialGroup()
                        .addGroup(controlHolderLayout.createParallelGroup()
                            .addGroup(controlHolderLayout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addGroup(controlHolderLayout.createParallelGroup()
                                    .addComponent(kMeansBtn, GroupLayout.PREFERRED_SIZE, 116, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(label1)))
                            .addGroup(controlHolderLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(textField1, GroupLayout.PREFERRED_SIZE, 116, GroupLayout.PREFERRED_SIZE))
                            .addGroup(controlHolderLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(label2, GroupLayout.PREFERRED_SIZE, 116, GroupLayout.PREFERRED_SIZE))
                            .addGroup(controlHolderLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(textField2, GroupLayout.PREFERRED_SIZE, 116, GroupLayout.PREFERRED_SIZE))
                            .addGroup(controlHolderLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(maximinBtn, GroupLayout.PREFERRED_SIZE, 116, GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(5, Short.MAX_VALUE))
            );
            controlHolderLayout.setVerticalGroup(
                controlHolderLayout.createParallelGroup()
                    .addGroup(controlHolderLayout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(label1)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(textField1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(label2)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(textField2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addGap(46, 46, 46)
                        .addComponent(kMeansBtn)
                        .addGap(18, 18, 18)
                        .addComponent(maximinBtn)
                        .addContainerGap())
            );
        }
        contentPane.add(controlHolder, CC.xy(3, 1, CC.CENTER, CC.FILL));
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JPanel imageHolder;
    private JPanel controlHolder;
    private JLabel label1;
    private JTextField textField1;
    private JLabel label2;
    private JTextField textField2;
    private JButton kMeansBtn;
    private JButton maximinBtn;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
