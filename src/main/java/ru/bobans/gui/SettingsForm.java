package ru.bobans.gui;

import ru.bobans.Utils.PrefSettings;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;


public class SettingsForm  extends JDialog{
    JPanel panelsettings = new JPanel();
    JTextField tjdbcstring = new JTextField();
    JLabel ljdbcstring = new JLabel("JDBC String:");
    JButton bclose = new JButton("Close");
    JButton bsave = new JButton("Save");

    public SettingsForm(JFrame parent) {
        super(parent,"Settings");
        setModal(true);
        setSize(400, 140);
        setLocation(500, 280);
        setResizable(false);
        getContentPane().add(panelsettings);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        panelsettings.setLayout(null);

        bsave.setBounds(20, 80, 70, 20);
        bclose.setBounds(300, 80, 70, 20);
        tjdbcstring.setBounds(100,20,260,20);
        ljdbcstring.setBounds(5, 20, 90, 20);

        panelsettings.add(bclose);
        panelsettings.add(bsave);
        panelsettings.add(tjdbcstring);
        panelsettings.add(ljdbcstring);
        actionClose();
        actionSave();
        try {
            tjdbcstring.setText(new PrefSettings().GetJDBCString());
        } catch (IOException | NoSuchFieldException  | IllegalAccessException ex) {
            ex.printStackTrace();
        }
        setVisible(true);

    }

        public void actionClose() {
            bclose.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent actionEvent) {
                    dispose();
                }
            });
        }

    public void actionSave() {
        bsave.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                System.out.println("saving jdbs settings:" + tjdbcstring.getText());
                try {
                    new PrefSettings().SetJDBCString(tjdbcstring.getText());
                }catch (IOException ex) {
                    ex.printStackTrace();
                }
                dispose();
            }
        });
    }


}



