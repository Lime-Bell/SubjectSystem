package org.example;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import java.util.List;

import javax.swing.*;


class Home extends JFrame implements ActionListener {
    private static final long serialVersionUID = 1L;
    MenuBar menuBar;    // 菜單欄
    Menu function;       // 菜單
    MenuItem all, select; // 菜單項
    Panel contentPanel; // 內容面板，其上用於添加其他待切換的面板

    public Home() {
        // 初始化組件
        menuBar = new MenuBar();
        function = new Menu("Function");
        all = new MenuItem("All Course");
        select = new MenuItem("SelectCourse");
        contentPanel = new Panel();

        // 菜單項添加事件監聽器
        all.addActionListener(this);
        select.addActionListener(this);

        // 設置窗口的菜單欄，菜單和各個菜單項。
        function.add(all);
        function.add(select);
        menuBar.add(function);
        setMenuBar(menuBar);

        // 設置佈局爲邊界佈局管理器。將contentPanel添加到窗口中心位置。
        this.setContentPane(new MyPanel("這是歡迎頁 - setContentPane()"));

        // 窗口的其他參數
        setTitle("Home");
        setBounds(300, 50, 700, 500);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        if (source == all) {
            changeContentPane(new HomePanel());
        } else if (source == select) {
            changeContentPane(new SelectPanel());
        }
    }

    // 切換內容面板
    public void changeContentPane(Container contentPane) {
        this.setContentPane(contentPane);
        this.revalidate();
    }

}

// 簡易地獲取所需的面板(使用時需自定義)
class MyPanel extends Panel {
    public MyPanel(String msg) {
        this.add(new Label(msg));
    }
}

class HomePanel extends Panel{
    public HomePanel(){
        this.setLayout(new BorderLayout());
        JLabel id = new JLabel("ID");
        JLabel name = new JLabel("      Name      ");
        JLabel classes = new JLabel("         Class     ");
        JLabel credit = new JLabel(" Credit ");
        JLabel isRequires = new JLabel(" isRequired ");
        JLabel department = new JLabel("   Department   ");
        JLabel currentSeat = new JLabel("CurrentSeat ");
        JLabel maxSeat = new JLabel("MaxSeat ");
        JLabel teacher = new JLabel(" Teacher");

        JPanel p1 = new JPanel();
        p1.add(id);
        p1.add(name);
        p1.add(classes);
        p1.add(credit);
        p1.add(isRequires);
        p1.add(department);
        p1.add(currentSeat);
        p1.add(maxSeat);
        p1.add(teacher);
        this.add(p1, BorderLayout.NORTH);

        String s = "";
//        System.out.println(CourseDB.courseList.toArray().length);
//        System.out.println("test " + CourseDB.ToList().toArray().length + " "+ s);
        for(String course: CourseDB.ToList()){
            s += course + "\n";
//            System.out.println(course);
        }
        TextArea ta = new TextArea(s);
//        System.out.println(s);
        JScrollPane scrollPane = new JScrollPane(ta);
        this.add(scrollPane, BorderLayout.CENTER);
    }
}

class SelectPanel extends JPanel{
    public SelectPanel(){
        JPanel p1 = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JPanel p2 = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        //courseID: courseIDPanel
        JPanel courseIDPanel = new JPanel();
        JLabel courseIDLabel = new JLabel("courseID");
        JTextField courseIDField = new JTextField(5);
        courseIDPanel.add(courseIDLabel);
        courseIDPanel.add(courseIDField);

        //courseName: courseNamePanel
        JPanel courseNamePanel = new JPanel();
        JLabel courseNameLabel = new JLabel("courseName");
        JTextField courseNameField = new JTextField(15);
        courseNamePanel.add(courseNameLabel);
        courseNamePanel.add(courseNameField);

        //Class: classPanel
        JPanel classPanel = new JPanel();
        JLabel classLabel = new JLabel("Class");
        JComboBox classCombox = new JComboBox();
        List<String> classList = CourseDB.ReturnAllClass();
        for (String className: classList) {
            classCombox.addItem(className);
        }
        classPanel.add(classLabel);
        classPanel.add(classCombox);

        //Department: departmentPanel
        JPanel departmentPanel = new JPanel();
        JLabel departmentLabel = new JLabel("Department");
        JComboBox departmentCombox = new JComboBox();
        List<String> departmentList = CourseDB.ReturnAllDepartment();
        for (String department: departmentList) {
            departmentCombox.addItem(department);
        }
        departmentPanel.add(departmentLabel);
        departmentPanel.add(departmentCombox);

        //Teacher: teacherPanel
        JPanel teacherPanel = new JPanel();
        JLabel teacherLabel = new JLabel("Teacher");
        JTextField teacherField = new JTextField(15);
        teacherPanel.add(teacherLabel);
        teacherPanel.add(teacherField);

        // Button
        JButton search = new JButton("Search");
        JButton reset = new JButton("Reset");




        // Add
//        p1.add(courseIDPanel);
//        p1.add(courseNamePanel);
//        p1.add(classPanel);
        p1.add(courseIDLabel);
        p1.add(courseIDField);
        p1.add(courseNameLabel);
        p1.add(courseNameField);
        p1.add(classLabel);
        p1.add(classCombox);
        this.add(p1,FlowLayout.LEFT);
//        p2.add(departmentPanel);
//        p2.add(teacherPanel);
//        buttonPanel.add(search);
//        buttonPanel.add(reset);
        p2.add(departmentLabel);
        p2.add(departmentCombox);
        p2.add(teacherLabel);
        p2.add(teacherField);

        buttonPanel.add(search);
        buttonPanel.add(reset);


//        this.add(buttonPanel, FlowLayout.CENTER);

        this.add(p2, FlowLayout.LEFT);
        this.add(buttonPanel, FlowLayout.LEFT);


    }
}

//
//
