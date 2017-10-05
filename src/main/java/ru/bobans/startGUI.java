package ru.bobans;

import ru.bobans.Utils.JdbcConnection;
import ru.bobans.gui.*;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class startGUI{
    public static void main(String[] args) {

        JdbcConnection connectinon = new JdbcConnection();

        MainForm mainform = new MainForm();
        mainform.setConnection(connectinon);
        LoginForm loginform = new LoginForm();
        loginform.setConnection(connectinon);
        loginform.setMainform(mainform);

        loginform.setIconImage(Toolkit.getDefaultToolkit().getImage(startGUI.class.getClass().getResource("/favicon.ico")));
        mainform.setIconImage(Toolkit.getDefaultToolkit().getImage(startGUI.class.getClass().getResource("/favicon.ico")));

    }


}
