package ru.bobans.gui;

import ru.bobans.Utils.JdbcConnection;
import ru.bobans.Utils.PrefSettings;
import ru.bobans.main.ProcessingReceipt;
import ru.bobans.main.ProcessingRequest;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class ReceiptForm extends JDialog{
    JPanel panel = new JPanel();

    JTextField tresulttext = new JTextField("Не может быть пустым");
    JLabel lresulttext = new JLabel("Set ResultText:");
    JButton bclose = new JButton("Close");
    JButton bstart = new JButton("Generate");

    String[]  array_acknowledgementtype = {"8","9","10"};
    JLabel lacknowledgementtype = new JLabel("Set AcknowledgementType:");
    JComboBox acknowledgementtype = new JComboBox(array_acknowledgementtype);

    String[]  array_ResultCode = {"1001","2001","1002","2002","1003","2003","1004","2004"};
    JLabel lResultCode = new JLabel("Set ResultCode:");
    JComboBox cResultCode = new JComboBox(array_ResultCode);


    public ReceiptForm(JFrame parent,JdbcConnection connection) {
        super(parent, "Receipt Form");
        setModal(true);
        setSize(410, 220);
        setLocation(500, 280);
        setResizable(false);
        getContentPane().add(panel);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        panel.setLayout(null);

        bstart.setBounds(20, 160, 90, 20);
        bclose.setBounds(300, 160,90, 20);
        lresulttext.setBounds(5, 50, 90, 20);
        tresulttext.setBounds(100, 50, 280, 20);

        lacknowledgementtype.setBounds(5, 20, 170, 20);
        acknowledgementtype.setBounds(180, 20, 200, 20);
        lResultCode.setBounds(5, 80, 170, 20);
        cResultCode.setBounds(180, 80, 200, 20);

        panel.add(bclose);
        panel.add(bstart);
        panel.add(lresulttext);
        panel.add(tresulttext);
        panel.add(lacknowledgementtype);
        panel.add(acknowledgementtype);
        panel.add(lResultCode);
        panel.add(cResultCode);

        bclose.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });

        bstart.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ProcessingReceipt startwork = new ProcessingReceipt(connection,(String)cResultCode.getSelectedItem(),
                                                                               (String)acknowledgementtype.getSelectedItem(),
                                                                                tresulttext.getText());
                dispose();
            }
        });

        setVisible(true);


    }
}
