package ru.bobans.gui;

import com.sun.javafx.tk.Toolkit;
import javafx.concurrent.Worker;
import ru.bobans.Utils.JdbcConnection;
import ru.bobans.main.ProcessingRequest;
import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;


public class ProcessingRequestForm  extends JDialog{
    JPanel panel = new JPanel();
    public JProgressBar progressBar = new JProgressBar();

    JdbcConnection connection = new JdbcConnection();
    SwingWorker<Void, Void> worker;


    public ProcessingRequestForm(JFrame parent, JdbcConnection connection) {
        super(parent,"Processing Request");
        this.connection= connection;
        //setModal(true);
        setSize(400, 100);
        setLocation(500, 280);
        setResizable(false);
        getContentPane().add(panel);
        //setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent evt) {
                worker.cancel(true);
               // System.exit(-1);
            }
        });

        this.addWindowListener(new WindowAdapter(){
            public void windowClosing(WindowEvent e){
                worker.cancel(true);
            }
        });

        progressBar.setStringPainted(true);
        progressBar.setMinimum(0);
        progressBar.setMaximum(100);
        progressBar.setBounds(10, 20, 370, 40);

        panel.setLayout(null);
        panel.add(progressBar);

        setVisible(true);

        ProcessingRequestInBackGround(connection);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent evt) {
                worker.cancel(true);
                //worker.isCancelled();
            }
        });
    }

    public  void setProgressBar(int index) {
        progressBar.setValue( index);
        if (progressBar.getValue()==100) {
            dispose();
        }
    }

    public void ProcessingRequestInBackGround(JdbcConnection connection) {
        worker = new SwingWorker<Void, Void>() {
            @Override
            protected Void doInBackground() throws Exception {
                ProcessingRequest process = new ProcessingRequest(ProcessingRequestForm.this,connection);
                return null;
            }
        };
        worker.execute();
    }



}
