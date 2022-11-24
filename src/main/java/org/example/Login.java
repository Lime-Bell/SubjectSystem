package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Login {

    private JFrame frame;
    private JPanel TPanel = new JPanel();
    public Login(){
        // 创建 JFrame 实例
        frame = new JFrame("Login Example");
//        Dimension screenSize =Toolkit.getDefaultToolkit().getScreenSize();
        frame.setSize(350, 200);
        frame.setLocationRelativeTo(null);
        // Setting the width and height of frame
//        frame.setSize(350, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        frame.getContentPane().setLayout(new GridLayout(3,1));
        frame.add(TPanel);
        PlaceComponents();

        // 设置界面可见
        frame.setVisible(true);
    }
    private void PlaceComponents(){
//        TPanel.setLayout(null);
        // UserID
        JPanel userPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
//        Dimension screenSize =Toolkit.getDefaultToolkit().getScreenSize();
//        Dimension frameSize = frame.getSize();
        JLabel userLabel = new JLabel("UserID");
        JTextField userField = new JTextField(20);
        userPanel.add(userLabel);
        userPanel.add(userField);
        TPanel.add(userPanel);

        // Password
        JPanel pwdPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
//        pwdPanel.setSize(100,50);
        Label pwdLabel = new Label("Password");
        JPasswordField pwdField = new JPasswordField(20);
        pwdPanel.add(pwdLabel);
        pwdPanel.add(pwdField);
        TPanel.add(pwdPanel);
//
        // Send / Reset Button
        JPanel buttonPanel = new JPanel();
        JButton send = new JButton("Send");
        JButton reset = new JButton("Reset");
        buttonPanel.add(send);
        buttonPanel.add(reset);
        TPanel.add(buttonPanel, FlowLayout.CENTER);

        send.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String userid;
                String password;
                userid = userField.getText();
                password = String.valueOf(pwdField.getPassword());

                if(UserDB.isUser(userid, password)){
                    System.out.println("Login Success");
                    frame.dispose();
                    AllInterface.ShowHome();
                }
                else{
                    System.out.println("Send the wrong UserID or the Password !");
                }
            }
        });

        reset.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                userField.setText("");
                pwdField.setText("");
            }
        });


    }


}
