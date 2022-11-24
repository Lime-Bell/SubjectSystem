//package org.example;
//
//import javax.swing.*;
//import javax.swing.plaf.ComboBoxUI;
//import java.awt.*;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//import java.util.*;
//import java.util.List;
//
//public class Home {
//
//    private JFrame frame;
//    private JPanel TPanel = new JPanel();
//
////    private GridLayout gridLayout = new GridLayout();
////    private FlowLayout flowLayout = new FlowLayout(FlowLayout.LEFT);
//    public Home(){
//        frame = new JFrame("Home");
////        Dimension screenSize =Toolkit.getDefaultToolkit().getScreenSize();
//        frame.setSize(700, 300);
//        frame.setLocationRelativeTo(null);
//        // Setting the width and height of frame
////        frame.setSize(350, 200);
//        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//
//        PlaceComponents();
//
//        // 设置界面可见
//        frame.setVisible(true);
//    }
//
//    private void PlaceComponents(){
//        JMenuBar menuBar = new JMenuBar();
//        frame.setJMenuBar(menuBar);
//
//
//        JMenu mnMenu = new JMenu("Function");
//        menuBar.add(mnMenu);
//        JMenuItem mnItem1 = new JMenuItem("All Course");
//        JMenuItem mnItem2 = new JMenuItem("Select");
//        mnMenu.add(mnItem1);
//        mnMenu.add(mnItem2);
//
//        mnItem1.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                TPanel.removeAll();
//                JPanel aPanel = new JPanel();
//                TPanel.add();
//                TPanel.validate();
//                TPanel.repaint();
//                ShowAllCourse();
//            }
//        });
//
//        mnItem2.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                TPanel.removeAll();
//                TPanel.add(new JPanel());
//                TPanel.validate();
//                TPanel.repaint();
//                ShowSelect();
//            }
//        });
//        ShowSelect();
//
//
//    }
//    private void ShowAllCourse(){
//        frame.add(TPanel);
//        for(String s: CourseDB.ToString()){
//            System.out.println(s);
//        }
//    }
//    private void ShowSelect(){
//        frame.add(TPanel);
////        TPanel.getContentPane().setLayout(flowLayout);
//        System.out.println(2);
//        //courseID
//        JPanel p1 = new JPanel();
//        JPanel p2 = new JPanel();
//        JPanel courseIDPanel = new JPanel();
//        JLabel courseIDLabel = new JLabel("courseID");
//        JTextField courseIDField = new JTextField(5);
//        courseIDPanel.add(courseIDLabel);
//        courseIDPanel.add(courseIDField);
//
//        //courseName
//        JPanel courseNamePanel = new JPanel();
//        JLabel courseNameLabel = new JLabel("courseName");
//        JTextField courseNameField = new JTextField(15);
//        courseNamePanel.add(courseNameLabel);
//        courseNamePanel.add(courseNameField);
//
//        //Class
//        JPanel classPanel = new JPanel();
//        JLabel classLabel = new JLabel("Class");
//        JTextField classField = new JTextField(15);
//        classPanel.add(classLabel);
//        classPanel.add(classField);
//
//        //Department
//        JPanel departmentPanel = new JPanel();
//        JLabel departmentLabel = new JLabel("Department");
//        JComboBox combox = new JComboBox();
//        List<String> departmentList = CourseDB.ReturnAllDepartment();
//        for (String department: departmentList) {
//            combox.addItem(department);
//        }
//        departmentPanel.add(departmentLabel);
//        departmentPanel.add(combox);
//
//
//        //Teacher
//        JPanel teacherPanel = new JPanel();
//        JLabel teacherLabel = new JLabel("Teacher");
//        JTextField teacherField = new JTextField(15);
//        teacherPanel.add(teacherLabel);
//        teacherPanel.add(teacherField);
//
//        p1.add(courseIDPanel);
//        p1.add(courseNamePanel);
//        p1.add(classPanel);
//        TPanel.add(p1);
//        p2.add(departmentPanel);
//        p2.add(teacherPanel);
//        TPanel.add(p2);
//    }
//
//}
