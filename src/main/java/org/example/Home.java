package org.example;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import java.util.List;

import javax.swing.*;


class Home extends JFrame implements ActionListener {
//    private static final long serialVersionUID = 1L;
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
        this.setContentPane(new MyPanel("Welcome to SubjectSystem"));

        // 窗口的其他參數
        setTitle("Home");
        setBounds(300, 50, 700, 500);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    // 事件觸發，更新觸發頁面版面（Panel）
    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        if (source == all) {
            changeContentPane(new HomePanel(this));
        } else if (source == select) {
            changeContentPane(new SelectPanel(this));
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
        this.add(new Label(msg), new BorderLayout().CENTER);
    }
}
class HomePanel extends ScrollPane{
    public HomePanel(JFrame frame){
//        JLabel id = new JLabel("ID");
//        JLabel name = new JLabel("      Name      ");
//        JLabel classes = new JLabel("         Class     ");
//        JLabel credit = new JLabel(" Credit ");
//        JLabel isRequires = new JLabel(" isRequired ");
//        JLabel department = new JLabel("   Department   ");
//        JLabel currentSeat = new JLabel("CurrentSeat ");
//        JLabel maxSeat = new JLabel("MaxSeat ");
//        JLabel teacher = new JLabel(" Teacher");

//        JPanel p1 = new JPanel();
//        p1.add(id);
//        p1.add(name);
//        p1.add(classes);
//        p1.add(credit);
//        p1.add(isRequires);
//        p1.add(department);
//        p1.add(currentSeat);
//        p1.add(maxSeat);
//        p1.add(teacher);
//        this.add(p1, BorderLayout.NORTH);

        JPanel panel = new JPanel(new BorderLayout());
        JLabel l = new JLabel("                   ID  CourseName    Class    Credit    isRequired   Department    " +
                "CurrentSeat   MaxSeat      Teacher  ");
        panel.add(l, BorderLayout.NORTH);
        JPanel panel2 = new JPanel(new GridBagLayout());
        int index = 0;
        for(Course course: CourseDB.courseList){
            JButton button = new JButton("加選");
            JLabel label = new JLabel(course.ToCourseString());
            GridBagConstraints c0 = new GridBagConstraints();
            GridBagConstraints c1 = new GridBagConstraints();
            c0.gridx = 0;
            c0.gridy = index;
            c0.gridwidth = 1;
            c0.gridheight = 1;
            c0.weightx = 0;
            c0.weighty = 0;
            c0.fill = GridBagConstraints.NONE;
            c0.anchor = GridBagConstraints.WEST;

            c1.gridx = 1;
            c1.gridy = index;
            c1.gridwidth = 20;
            c1.gridheight = 1;
            c1.weightx = 0;
            c1.weighty = 0;
            c1.fill = GridBagConstraints.HORIZONTAL;
            c1.anchor = GridBagConstraints.WEST;
            panel2.add(button, c0);
            panel2.add(label, c1);
            index ++;

        }
        panel.add(panel2, BorderLayout.CENTER);
        this.add(panel);





    }
}


// 篩選面板
class SelectPanel extends JPanel{
    public SelectPanel(JFrame frame){
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
        // 下拉選單
        JComboBox classCombox = new JComboBox();
        List<String> classList = CourseDB.ReturnAllClass();
        classCombox.addItem("NULL");
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
        departmentCombox.addItem("NULL");
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
        p1.add(courseIDLabel);
        p1.add(courseIDField);
        p1.add(courseNameLabel);
        p1.add(courseNameField);
        p1.add(classLabel);
        p1.add(classCombox);
        this.add(p1);

        p2.add(departmentLabel);
        p2.add(departmentCombox);
        p2.add(teacherLabel);
        p2.add(teacherField);

        buttonPanel.add(search);
        buttonPanel.add(reset);


        this.add(p2);
        this.add(buttonPanel);

        // 觸發搜尋事件
        search.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // 取得所有輸入條件
                String strID = courseIDField.getText();
                String strName = courseNameField.getText();
                String strClass = classCombox.getItemAt(classCombox.getSelectedIndex()).toString();
                String strDepartment = departmentCombox.getItemAt(departmentCombox.getSelectedIndex()).toString();
                String strTeacher = teacherField.getText();

                List<Course> copyList = new ArrayList<>(CourseDB.courseList);
                List<Course> aCourseList;

                // 每個條件篩選，假設不為空值的話
                if(!strID.contentEquals("")){
                    copyList = CourseDB.SearchID(strID, copyList);
                }
                if(!strName.contentEquals("")){
                    copyList = CourseDB.SearchName(strName, copyList);
                }
                if(!strClass.contentEquals("NULL")){
                    copyList = CourseDB.SearchClass(strClass, copyList);
                }
                if(!strDepartment.contentEquals("NULL")){
                    copyList = CourseDB.SearchDepartment(strDepartment, copyList);
                }
                if(!strTeacher.contentEquals("")){
                    copyList = CourseDB.SearchTeacher(strTeacher, copyList);
                }

                // 假設選擇有結果的話
                if(!copyList.equals(CourseDB.courseList) && !copyList.isEmpty()){
                    frame.setContentPane(new AfterSelectPanel(frame, copyList));
                    frame.revalidate();
                }
                else{
                    System.out.println("Has Error\nPlease select again!");
                }
            }
        });

        // 清除輸入格
        reset.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                classCombox.setSelectedItem("NULL");
                courseIDField.setText("");
                courseNameField.setText("");
                departmentCombox.setSelectedItem("NULL");
                teacherField.setText("");
            }
        });
    }

}

// 篩選後列表面板
class AfterSelectPanel extends Panel{
    public AfterSelectPanel(JFrame frame, List<Course> courseList){
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

        // 列出篩選後的課程
        String s = "";
        for(String course: CourseDB.ToList(courseList)){
            s += course + "\n";
        }
        TextArea ta = new TextArea(s);
//        System.out.println(s);
        JScrollPane scrollPane = new JScrollPane(ta);
        this.add(scrollPane, BorderLayout.CENTER);

        //AddButton
        JButton reset = new JButton("Reset");

        this.add(reset,BorderLayout.SOUTH);

        // 回到篩選面板
        reset.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setContentPane(new SelectPanel(frame));
                frame.revalidate();
            }
        });
    }
}

