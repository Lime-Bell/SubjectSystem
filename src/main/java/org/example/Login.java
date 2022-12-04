package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Login {

    private final JFrame frame;
    private final JPanel TPanel = new JPanel();
    public Login(){
        // 創建 JFrame
        frame = new JFrame("Login");
        frame.setSize(350, 200);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.add(TPanel);
        PlaceComponents();

        // 設定頁面為可見
        frame.setVisible(true);
    }
    private void PlaceComponents(){
        // UserID
        JPanel userPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JLabel userLabel = new JLabel("   UserID   ");
        JTextField userField = new JTextField(20);
        userPanel.add(userLabel);
        userPanel.add(userField);
        TPanel.add(userPanel);

        // Password
        JPanel pwdPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JLabel pwdLabel = new JLabel("Password");
        JPasswordField pwdField = new JPasswordField(20);
        pwdPanel.add(pwdLabel);
        pwdPanel.add(pwdField);
        TPanel.add(pwdPanel);

        // Send / Reset Button
        JPanel buttonPanel = new JPanel();
        JButton send = new JButton("Send");
        JButton reset = new JButton("Reset");
        buttonPanel.add(send);
        buttonPanel.add(reset);
        TPanel.add(buttonPanel);

        // 按鈕事件觸發
        send.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String userid;
                String password;
                userid = userField.getText();
                password = String.valueOf(pwdField.getPassword());

                // 假設輸入的id, pwd 存在 UserDB
                if (UserDB.isUser(userid, password)){
                    UserDB user = new UserDB();
                    user.setNowUser(userid);
                    System.out.println("Login Success");
                    // 關閉現在的 window
                    frame.dispose();
                    // 開啟主頁 window
                    AllInterface.ShowHome();

                }
                else{
                    System.out.println("Send the wrong UserID or the Password !");
                }
            }
        });

        // 觸發reset事件，清除輸入格
        reset.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                userField.setText("");
                pwdField.setText("");
            }
        });


    }


}
