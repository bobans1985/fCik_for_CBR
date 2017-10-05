package ru.bobans.gui;

import ru.bobans.Utils.JdbcConnection;
import ru.bobans.Utils.PrefSettings;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.SQLException;

public class LoginForm extends JFrame {
    JButton blogin = new JButton("Login");
    JButton bexit = new JButton("Exit");
    JButton bsettings = new JButton();
    JLabel llabel = new JLabel("Login: ");
    JLabel plabel = new JLabel("Password: ");
    JPanel panel = new JPanel();
    JTextField txuser = new JTextField(10);
    JPasswordField pass = new JPasswordField(10);
    JdbcConnection connection = new JdbcConnection();
    MainForm mainform = new MainForm();

    public LoginForm() {
        super("Login Form");
        setSize(300,170);
        setLocation(500,280);
        panel.setLayout (null);
        super.setResizable(false);

        txuser.setBounds(100,20,150,20);
        pass.setBounds(100,55,150,20);
        blogin.setBounds(20,100,80,20);
        bexit.setBounds(195,100,80,20);
        llabel.setBounds(20,20,150,20);
        plabel.setBounds(20,55,150,20);

        JRootPane rootPane = this.getRootPane();
        rootPane.setDefaultButton(blogin);

        try {
            bsettings.setBounds(260,19,20,20);
            bsettings.setIcon(new ImageIcon(ImageIO.read(getClass().getResource("/setting.gif"))));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        panel.add(blogin);
        panel.add(bexit);
        panel.add(bsettings);
        panel.add(llabel);
        panel.add(plabel);
        panel.add(txuser);
        panel.add(pass);

        getContentPane().add(panel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        actionExit();
        actionLogin();
        actionSettings();

        setVisible(true);
    }

    public void setConnection (JdbcConnection connect) {
        this.connection = connect;
    }

    public void setMainform (MainForm mainform) {
        this.mainform = mainform;
    }

    public  void actionExit () {
        bexit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                System.exit(0);
            }
        });
    }

    public  void actionLogin() {
        blogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent)  {
                try {
                    connection.StartConnect(txuser.getText(), pass.getText());
                    if (connection.getConnection()!=null) {
                        mainform.setVisible(true);
                        dispose();
                    } else  JOptionPane.showMessageDialog(null, "Ошибка при установке соединения");
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });
    }

    public  void actionSettings () {
        bsettings.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                    SettingsForm settingsform = new SettingsForm(LoginForm.this);
            }
        });
    }



}
