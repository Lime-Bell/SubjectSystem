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
    MenuItem all, select, myCourse; // 菜單項
    Panel contentPanel; // 內容面板，其上用於添加其他待切換的面板

    public Home() {
        // 初始化組件
        menuBar = new MenuBar();
        function = new Menu("Function");
        all = new MenuItem("All Course");
        select = new MenuItem("Select Course");
        myCourse = new MenuItem("My Course");
        contentPanel = new Panel();

        // 菜單項添加事件監聽器
        all.addActionListener(this);
        select.addActionListener(this);
        myCourse.addActionListener(this);

        // 設置窗口的菜單欄，菜單和各個菜單項。
        function.add(all);
        function.add(select);
        function.add(myCourse);
        menuBar.add(function);
        setMenuBar(menuBar);

        // 設置佈局爲邊界佈局管理器。將contentPanel添加到窗口中心位置。
//        this.setContentPane(new MyPanel("Welcome to SubjectSystem"));
        this.setContentPane(new SelectPanel(this));

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
        if (source.equals(all)) {
            changeContentPane(new HomePanel(this));
        }
        else if (source.equals(select)) {
            changeContentPane(new SelectPanel(this));
        }
        else if (source.equals(myCourse)) {
            changeContentPane(new MyPanel(this));
        }
    }

    // 切換內容面板
    public void changeContentPane(Container contentPane) {

        this.setContentPane(contentPane);
        this.revalidate();
        this.repaint();
    }
}


// 簡易地獲取所需的面板(使用時需自定義)
class MyPanel extends JPanel {
    public MyPanel(JFrame frame) {
//        List<User> userList = new ArrayList<>(UserDB.UserList);
        UserDB user = new UserDB();

        JPanel userData = new JPanel(new FlowLayout(FlowLayout.CENTER));


        JLabel userName = new JLabel("用戶名稱：" + user.getNowUser());
        JLabel userCredit = new JLabel(" 目前學分：" + user.getNowCredit());

        userData.add(userName);
        userData.add(userCredit);

        this.add(userData);
//        for (User user: UserDB.UserList) {
//            user.GetUserID()
//        }

//        System.out.println(User.ReturnUserIDList());

//        this.add(new Label(frame), new BorderLayout().CENTER);
    }
}
class HomePanel extends ScrollPane{
    public HomePanel(JFrame frame) {
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

//        JPanel panel = new JPanel(new BorderLayout());
//        JLabel l = new JLabel("                   ID  CourseName    Class    Credit    isRequired   Department    " +
//                "CurrentSeat   MaxSeat      Teacher  ");
//        panel.add(l, BorderLayout.NORTH);
        JPanel panel = new JPanel(new GridBagLayout());

        GridBagConstraints addButton = new GridBagConstraints();
        GridBagConstraints id = new GridBagConstraints();
        GridBagConstraints classes = new GridBagConstraints();
        GridBagConstraints credit = new GridBagConstraints();
        GridBagConstraints isRequired = new GridBagConstraints();
        GridBagConstraints department = new GridBagConstraints();
        GridBagConstraints currentSeat = new GridBagConstraints();
        GridBagConstraints maxSeat = new GridBagConstraints();
        GridBagConstraints teacher = new GridBagConstraints();

        addButton.gridx = 0;
        id.gridx = 1;
        classes.gridx = 2;
        credit.gridx = 3;
        isRequired.gridx = 4;
        department.gridx = 5;
        currentSeat.gridx = 6;
        maxSeat.gridx = 7;
        teacher.gridx = 8;

        addButton.gridwidth = id.gridwidth = classes.gridwidth = credit.gridwidth = isRequired.gridwidth = department.gridwidth =
                currentSeat.gridwidth = maxSeat.gridwidth = teacher.gridwidth = 1;

        addButton.ipadx = id.ipadx = classes.ipadx = credit.ipadx = isRequired.ipadx =
                department.ipadx = currentSeat.ipadx = maxSeat.ipadx = teacher.ipadx = 1;

        addButton.gridheight = id.gridheight = classes.gridheight = credit.gridheight = isRequired.gridheight =
                department.gridheight = currentSeat.gridheight= maxSeat.gridheight = teacher.gridheight = 1;

        addButton.weightx = id.weightx = classes.weightx = credit.weightx = isRequired.weightx =
                department.weightx = currentSeat.weightx = maxSeat.weightx = teacher.weightx = 1;

        addButton.weighty = id.weighty = classes.weighty = credit.weighty = isRequired.weighty = department.weighty =
                currentSeat.weighty = maxSeat.weighty = teacher.weighty = 1;

        addButton.fill = id.fill = classes.fill = credit.fill = isRequired.fill = department.fill =
                currentSeat.fill = maxSeat.fill = teacher.fill = GridBagConstraints.HORIZONTAL;

        addButton.anchor = id.anchor = classes.anchor = credit.anchor = isRequired.anchor = department.anchor =
                currentSeat.anchor = maxSeat.anchor = teacher.anchor = GridBagConstraints.CENTER;

        addButton.gridy = id.gridy = classes.gridy = credit.gridy = isRequired.gridy = department.gridy =
                currentSeat.gridy = maxSeat.gridy = teacher.gridy = 0;

        JLabel idHeader = new JLabel("ID");
        JLabel classesHeader = new JLabel("CourseName");
        JLabel creditHeader = new JLabel("Credit");
        JLabel isRequiredHeader = new JLabel("isRequired");
        JLabel departmentHeader = new JLabel("Department");
        JLabel currentSeatHeader = new JLabel("CurrentSeat");
        JLabel maxSeatHeader = new JLabel("MaxSeat");
        JLabel teacherHeader = new JLabel("Teacher");

        panel.add(idHeader, id);
        panel.add(classesHeader, classes);
        panel.add(creditHeader, credit);
        panel.add(isRequiredHeader, isRequired);
        panel.add(departmentHeader, department);
        panel.add(currentSeatHeader, currentSeat);
        panel.add(maxSeatHeader, maxSeat);
        panel.add(teacherHeader, teacher);

        int index = 1;


//        System.out.println(CourseDB.courseList.size());
        for(Course course: CourseDB.courseList) {

            JButton button = new JButton("加選");
//            JLabel label = new JLabel(course.ToCourseString());

            JLabel idText = new JLabel(Integer.toString(course.GetCourseID()));
            JLabel classesText = new JLabel(course.GetCourseClass());
            JLabel creditText = new JLabel(Integer.toString(course.GetCredit()));
            JLabel isRequiredText = new JLabel(Boolean.toString(course.GetIsRequired()));
            JLabel departmentText = new JLabel(course.GetDepartment());
            JLabel currentSeatText = new JLabel(Integer.toString(course.GetCurrentSeat()));
            JLabel maxSeatText = new JLabel(Integer.toString(course.GetMaxSeat()));
            JLabel teacherText = new JLabel(course.GetTeacherName());

            addButton.gridy = id.gridy = classes.gridy = credit.gridy = isRequired.gridy = department.gridy =
                    currentSeat.gridy = maxSeat.gridy = teacher.gridy = index;

            panel.add(button, addButton);
            panel.add(idText, id);
            panel.add(classesText, classes);
            panel.add(creditText, credit);
            panel.add(isRequiredText, isRequired);
            panel.add(departmentText, department);
            panel.add(currentSeatText, currentSeat);
            panel.add(maxSeatText, maxSeat);
            panel.add(teacherText, teacher);

//            addButton.gridwidth = 1;
//            classes.gridwidth = 4;
//            credit.gridwidth = 2;
//            isRequired.gridwidth = 2;
//            department.gridwidth = 6;
//            currentSeat.gridwidth = 2;
//            maxSeat.gridwidth = 2;
//            teacher.gridwidth = 3 ;

//            GridBagConstraints c0 = new GridBagConstraints();
//            GridBagConstraints c1 = new GridBagConstraints();

//            GridBagConstraints typeSettins = new GridBagConstraints();
//            c0.gridx = 0;
//            c0.gridy = index;
//            c0.gridwidth = 1;
//            c0.gridheight = 1;
//            c0.weightx = 0;
//            c0.weighty = 0;
//            c0.fill = GridBagConstraints.NONE;
//            c0.anchor = GridBagConstraints.WEST;

//            for (int i = 0; i < CourseDB.courseList.size())
//            c1.gridx = 1;
//            c1.gridy = index;
//            c1.gridwidth = 20;
//            c1.gridheight = 1;
//            c1.weightx = 0;
//            c1.weighty = 0;
//            c1.fill = GridBagConstraints.HORIZONTAL;
//            c1.anchor = GridBagConstraints.WEST;

//            panel2.add(button, c0);
//            panel2.add(label, c1);

            if (index == 40) {
                break;
            }

            index ++;

        }
//        panel.add(panel2, BorderLayout.CENTER);
        this.add(panel);





    }
}


// 篩選面板
class SelectPanel extends JPanel{
    public SelectPanel(JFrame frame){

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));

        JPanel p1 = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JPanel p2 = new JPanel(new FlowLayout(FlowLayout.LEFT));

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
class AfterSelectPanel extends ScrollPane{
    public AfterSelectPanel(JFrame frame, List<Course> courseList) {
//        this.setLayout(new GridBagLayout());
        UserDB user = new UserDB();

        JPanel panel = new JPanel(new GridBagLayout());

        GridBagConstraints addButton = new GridBagConstraints();
        GridBagConstraints id = new GridBagConstraints();
        GridBagConstraints classes = new GridBagConstraints();
        GridBagConstraints credit = new GridBagConstraints();
        GridBagConstraints isRequired = new GridBagConstraints();
        GridBagConstraints department = new GridBagConstraints();
        GridBagConstraints currentSeat = new GridBagConstraints();
        GridBagConstraints maxSeat = new GridBagConstraints();
        GridBagConstraints teacher = new GridBagConstraints();
        GridBagConstraints resetButton = new GridBagConstraints();

        addButton.gridx = 0;
        id.gridx = 2;
        classes.gridx = 4;
        credit.gridx = 6;
        isRequired.gridx = 8;
        department.gridx = 10;
        currentSeat.gridx = 12;
        maxSeat.gridx = 14;
        teacher.gridx = 16;

        addButton.gridwidth = id.gridwidth = classes.gridwidth = credit.gridwidth = isRequired.gridwidth = department.gridwidth =
                currentSeat.gridwidth = maxSeat.gridwidth = teacher.gridwidth = 1;

        addButton.ipadx = id.ipadx = classes.ipadx = credit.ipadx = isRequired.ipadx =
                department.ipadx = currentSeat.ipadx = maxSeat.ipadx = teacher.ipadx = 1;

        addButton.gridheight = id.gridheight = classes.gridheight = credit.gridheight = isRequired.gridheight =
                department.gridheight = currentSeat.gridheight = maxSeat.gridheight = teacher.gridheight = 1;

        addButton.weightx = id.weightx = classes.weightx = credit.weightx = isRequired.weightx =
                department.weightx = currentSeat.weightx = maxSeat.weightx = teacher.weightx = 1;

        addButton.weighty = id.weighty = classes.weighty = credit.weighty = isRequired.weighty = department.weighty =
                currentSeat.weighty = maxSeat.weighty = teacher.weighty = 1;

        addButton.fill = id.fill = classes.fill = credit.fill = isRequired.fill = department.fill =
                currentSeat.fill = maxSeat.fill = teacher.fill = GridBagConstraints.CENTER;

        addButton.anchor = id.anchor = classes.anchor = credit.anchor = isRequired.anchor = department.anchor =
                currentSeat.anchor = maxSeat.anchor = teacher.anchor = GridBagConstraints.CENTER;

        addButton.gridy = id.gridy = classes.gridy = credit.gridy = isRequired.gridy = department.gridy =
                currentSeat.gridy = maxSeat.gridy = teacher.gridy = 0;

        JLabel idHeader = new JLabel("ID");
        JLabel classesHeader = new JLabel("CourseName");
        JLabel creditHeader = new JLabel("Credit");
        JLabel isRequiredHeader = new JLabel("isRequired");
        JLabel departmentHeader = new JLabel("Department");
        JLabel currentSeatHeader = new JLabel("CurrentSeat");
        JLabel maxSeatHeader = new JLabel("MaxSeat");
        JLabel teacherHeader = new JLabel("Teacher");

        panel.add(idHeader, id);
        panel.add(classesHeader, classes);
        panel.add(creditHeader, credit);
        panel.add(isRequiredHeader, isRequired);
        panel.add(departmentHeader, department);
        panel.add(currentSeatHeader, currentSeat);
        panel.add(maxSeatHeader, maxSeat);
        panel.add(teacherHeader, teacher);

        int index = 0;

//        System.out.println(CourseDB.courseList.size());

        JButton button[] = new JButton[courseList.size()];

        for (Course course : courseList) {
            if (user.getCourse() == null || !user.getCourse().contains(course.GetCourseID())) {
                button[index]= new JButton("加選");
                button[index].setForeground(Color.BLACK);
            } else if (user.getCourse().contains(course.GetCourseID())) {
                button[index]= new JButton("退選");
                button[index].setForeground(Color.RED);
            }

            final int number = index;
            button[index].addActionListener(new ActionListener() {
                @Override
                public void actionPerformed (ActionEvent e){
//                    List<Course> copyList = new ArrayList<>(courseList);

                    if (button[number].getText().equals("加選")) {
                        button[number].setText("退選");
                        button[number].setForeground(Color.RED);
                        user.addCourse(course.GetCourseID(), course.GetCredit());
                        System.out.println("加選成功!");
                    }
                    else if (button[number].getText().equals("退選")) {
                        button[number].setText("加選");
                        button[number].setForeground(Color.BLACK);
                        user.delCourse(course.GetCourseID(), course.GetCredit());
                        System.out.println("退選成功!");
                    }
                }
            });

            JLabel idText = new JLabel(Integer.toString(course.GetCourseID()));
            JLabel classesText = new JLabel(course.GetCourseClass());
            JLabel creditText = new JLabel(Integer.toString(course.GetCredit()));
            JLabel isRequiredText = new JLabel(Boolean.toString(course.GetIsRequired()));
            JLabel departmentText = new JLabel(course.GetDepartment());
            JLabel currentSeatText = new JLabel(Integer.toString(course.GetCurrentSeat()));
            JLabel maxSeatText = new JLabel(Integer.toString(course.GetMaxSeat()));
            JLabel teacherText = new JLabel(course.GetTeacherName());

            addButton.gridy = id.gridy = classes.gridy = credit.gridy = isRequired.gridy = department.gridy =
                    currentSeat.gridy = maxSeat.gridy = teacher.gridy = index + 1;

            panel.add(button[index], addButton);
            panel.add(idText, id);
            panel.add(classesText, classes);
            panel.add(creditText, credit);
            panel.add(isRequiredText, isRequired);
            panel.add(departmentText, department);
            panel.add(currentSeatText, currentSeat);
            panel.add(maxSeatText, maxSeat);
            panel.add(teacherText, teacher);

            if (index == 30) {
                break;
            }

            index++;



        }

//        this.setLayout(new BorderLayout());
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

        // 列出篩選後的課程
//        String s = "";
//        for(String course: CourseDB.ToList(courseList)){
//            s += course + "\n";
//        }
//        TextArea ta = new TextArea(s);
//
//        JScrollPane scrollPane = new JScrollPane(ta);
//        this.add(scrollPane, BorderLayout.CENTER);
//

        //回上頁按鈕
        JButton reset = new JButton("Reset");

        resetButton.gridx = 8;
        resetButton.gridy = index + 2;
        resetButton.gridwidth = 2;
        resetButton.gridheight = 1;
        resetButton.ipadx = 2;
        resetButton.weightx = resetButton.weighty = 1;
        resetButton.fill = GridBagConstraints.CENTER;
        resetButton.anchor = GridBagConstraints.CENTER;

//        reset.setLayout(new FlowLayout(FlowLayout.CENTER));

        panel.add(reset, resetButton);

        this.add(panel);

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

