//package org.example;
//
//import java.awt.event.ActionListener;
//import java.awt.event.ActionEvent;
//import javax.swing.*;
//
//public class GUI extends JFrame{
//    private final JLabel label1, label2, label3;
//    private final JTextField textField, textField2;
//    private final JButton btn;
//
//    public GUI(){
//        super("計算 BMI");
//        super.setLayout(null);
//
//        label1 = new JLabel("請輸入體重（公斤）：");
//        label1.setBounds(70, 50, 150, 20);
//        add(label1);
//
//        textField = new JTextField("0");
//        textField.setBounds(230, 50, 100, 20);
//        add(textField);
//
//        label2 = new JLabel("請輸入身高（公尺）：");
//        label2.setBounds(70, 100, 150, 20);
//        add(label2);
//
//        textField2 = new JTextField("0");
//        textField2.setBounds(230, 100, 100, 20);
//        add(textField2);
//
//        btn = new JButton("計算");
//        btn.setBounds(70, 150, 260, 20);
//        add(btn);
//
//        ButtonHandler handler = new ButtonHandler();
//        btn.addActionListener(handler);
//
//        label3 = new JLabel("BMI：");
//        label3.setBounds(150, 200, 100, 20);
//        add(label3);
//    }
//
//    private class ButtonHandler implements ActionListener{
//
//        @Override
//        public void actionPerformed(ActionEvent event){
//            double weight = 0, height = 0, bmi = 0;
//            try{
//                weight = Double.parseDouble(textField.getText());   //取得文字框文字
//                height = Double.parseDouble(textField2.getText());
//                bmi = weight / (height * height);
//                label3.setText("BMI：" + bmi);
//            }catch(Exception e){
//                JOptionPane.showMessageDialog(null, "請輸入數字", "輸入錯誤", JOptionPane.ERROR_MESSAGE);
//            }
//        }
//    }
//}
