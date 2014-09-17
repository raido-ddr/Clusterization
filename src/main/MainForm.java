package main;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.util.List;
import javax.swing.*;
import com.jgoodies.forms.factories.*;
import com.jgoodies.forms.layout.*;
import entity.Cluster;
import entity.ObservationContainer;
import graphic.GraphicOutput;
import logic.strategy.ClusterizationContext;
import logic.strategy.impl.KMeansStrategy;
import logic.strategy.task.ClusterizationTask;


public class MainForm extends JFrame {

    private static MainForm instance;

    public static MainForm getInstance() {
        if(instance == null) {
            instance = new MainForm();
        }
        return instance;
    }

    private MainForm() {
        initComponents();
    }

    private void kMeansBtnActionPerformed(ActionEvent e) {

        kMeansBtn.setEnabled(false);

        int observationCount =
                Integer.parseInt(observationCountTxt.getText());

        int clusterCount =
                Integer.parseInt(clusterCountTxt.getText());



        new ClusterizationTask(clusterCount, observationCount).execute();

        kMeansBtn.setEnabled(true);

        /*new Thread(new Runnable() {
            @Override
            public void run() {
                int observationCount =
                        Integer.parseInt(observationCountTxt.getText());

                int clusterCount =
                        Integer.parseInt(clusterCountTxt.getText());

                ClusterizationContext context =
                        new ClusterizationContext(new KMeansStrategy());

                ObservationContainer container =
                        new ObservationContainer(observationCount);

                List<Cluster> clusters =
                        context.executeStrategy(null, container, clusterCount);

                for(Cluster cluster : clusters) {
                    System.out.println(cluster.toString());
                }
            }
        }).start();*/

    }

    private void initComponents() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        imageHolder = ImageHolder.getInstance();
        controlHolder = new JPanel();
        label1 = new JLabel();
        observationCountTxt = new JTextField();
        label2 = new JLabel();
        clusterCountTxt = new JTextField();
        kMeansBtn = new JButton();
        maximinBtn = new JButton();

        //======== this ========
        Container contentPane = getContentPane();
        contentPane.setLayout(new FormLayout(
            "592dlu, $lcgap, 95dlu",
            "433dlu"));
        contentPane.add(imageHolder, CC.xy(1, 1, CC.DEFAULT, CC.FILL));
        contentPane.revalidate();
        contentPane.repaint();

        //======== controlHolder ========
        {

            //---- label1 ----
            label1.setText("Number of observations:");

            //---- label2 ----
            label2.setText("Number of clusters:");

            //---- kMeansBtn ----
            kMeansBtn.setText("K-means");
            kMeansBtn.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    kMeansBtnActionPerformed(e);
                }
            });

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
                                    .addComponent(label1))
                            .addGroup(controlHolderLayout.createSequentialGroup()
                                    .addContainerGap()
                                    .addComponent(observationCountTxt, GroupLayout.PREFERRED_SIZE, 116, GroupLayout.PREFERRED_SIZE))
                            .addGroup(controlHolderLayout.createSequentialGroup()
                                    .addContainerGap()
                                    .addComponent(label2, GroupLayout.PREFERRED_SIZE, 116, GroupLayout.PREFERRED_SIZE))
                            .addGroup(controlHolderLayout.createSequentialGroup()
                                    .addContainerGap()
                                    .addComponent(clusterCountTxt, GroupLayout.PREFERRED_SIZE, 116, GroupLayout.PREFERRED_SIZE))
                            .addGroup(controlHolderLayout.createSequentialGroup()
                                    .addContainerGap()
                                    .addComponent(kMeansBtn, GroupLayout.PREFERRED_SIZE, 116, GroupLayout.PREFERRED_SIZE))
                            .addGroup(controlHolderLayout.createSequentialGroup()
                                    .addContainerGap()
                                    .addComponent(maximinBtn, GroupLayout.PREFERRED_SIZE, 116, GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            );
            controlHolderLayout.setVerticalGroup(
                controlHolderLayout.createParallelGroup()
                    .addGroup(controlHolderLayout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(label1)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(observationCountTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(label2)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(clusterCountTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(kMeansBtn)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
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
    private ImageHolder imageHolder;
    private JPanel controlHolder;
    private JLabel label1;
    private JTextField observationCountTxt;
    private JLabel label2;
    private JTextField clusterCountTxt;
    private JButton kMeansBtn;
    private JButton maximinBtn;
    // JFormDesigner - End of variables declaration  //GEN-END:variables


    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable(){

            @Override
            public void run() {
                MainForm.getInstance().setVisible(true);
            }

        });

    }

    public ImageHolder getImageHolder() {
        return imageHolder;
    }



}
