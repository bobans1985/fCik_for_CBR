package ru.bobans.gui;

import ru.bobans.Utils.JdbcConnection;
import ru.bobans.main.ProcessingReceipt;
import ru.bobans.main.ProcessingRequest;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MainForm extends JFrame  implements ActionListener {
    JPanel panel = new JPanel();
    //Создаем основное меню
    JMenuBar menuBar = new JMenuBar();

    JMenu menuWork = new JMenu("Обработка");
    JMenu menuExit = new JMenu("Выход");
    JMenuItem item1 = new JMenuItem("Обработать Файл запрос ");
    JMenuItem item2 = new JMenuItem("Создать файл-квитанцию");

    JLabel lmaintext1 = new JLabel("Программа для обработки запросов ЦИК");
    JLabel lmaintext2 = new JLabel("bobans@");
    JdbcConnection connection = new JdbcConnection();


    public MainForm() {
        super("Main Form");
        setSize(300,100);
        setLocation(500,280);
        panel.setLayout (null);
        super.setResizable(false);
        getContentPane().add(panel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(false);
        lmaintext1.setBounds(10,10,300,20);
        lmaintext2.setBounds(10,20,300,20);
        panel.add(lmaintext1);
        panel.add(lmaintext2);

        menuExit.addMouseListener(new MouseListener() {
                                      @Override
                                      public void mouseReleased(MouseEvent e) {
                                      }

                                      @Override
                                      public void mousePressed(MouseEvent e) {
                                      }

                                      @Override
                                      public void mouseExited(MouseEvent e) {
                                      }

                                      @Override
                                      public void mouseEntered(MouseEvent e) {
                                      }

                                      @Override
                                      public void mouseClicked(MouseEvent e) {
                                        System.exit(0);
                                      }
                                  }
        );

    item1.addActionListener(new ActionListener() {
    public void actionPerformed(ActionEvent e) {
        ProcessingRequestForm startwork = new ProcessingRequestForm(MainForm.this, connection);
    }
});
        item2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ReceiptForm receiptform = new ReceiptForm(MainForm.this, connection);
            }

        });

        menuWork.add(item1);
        menuWork.add(item2);
        menuBar.add(menuWork);
        menuBar.add(menuExit);
        this.setJMenuBar(menuBar);
    }

    @Override
    public void actionPerformed(ActionEvent arg0) {
        System.out.println(arg0.getActionCommand());

    }

    public void setConnection (JdbcConnection connect) {
        this.connection = connect;
    }
}
