package com.company;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Window extends JFrame {

    JTextField linetf;

    public Window(){
        setBounds(20,21,800,600);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("GUI");
        JPanel panel = new JPanel();
        getContentPane().add(panel);
        panel.setLayout(null);
        addVidgets(panel);
    }
    void addVidgets(JPanel panel){
      JLabel firstlbl = new JLabel("Моя первая надпись");
      firstlbl.setBounds(50,50,400,40);
        Font lblFont = new Font("Helvetica", 2,40);
        firstlbl.setFont(lblFont);
      panel.add(firstlbl);

      linetf = new JTextField();
      linetf.setFont(lblFont);
      linetf.setBounds(50, 150,400, 40);
      panel.add(linetf);
      JCheckBox twicechbx = new JCheckBox("повторить дважды");
      twicechbx.setBounds(200,100,150,40);
      panel.add(twicechbx);

        JButton firstbtn = new JButton("ЖМЯК!");
        firstbtn.setBounds(50,100, 100, 40);
        firstbtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String text = linetf.getText();
                linetf.setText("");
                if(twicechbx.isSelected())
                    text += text;
                firstlbl.setText(text);
            }
        });
        panel.add(firstbtn);

        JSlider slider = new JSlider(200, 400);
        slider.setBounds(50,250,200,20);
        slider.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                linetf.setBounds(50,150,slider.getValue(),40);
            }
        });
        panel.add(slider);
    }
}
