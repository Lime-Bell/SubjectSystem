//package org.example;
//import java.awt.*;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//import java.util.*;
//import java.util.List;
//
//import javax.swing.*;
//
//
//class Home extends JFrame implements ActionListener {
////    private static final long serialVersionUID = 1L;
//    MenuBar menuBar;    // 菜單欄
//    Menu function;       // 菜單
//    MenuItem all, select, myCourse; // 菜單項
//    Panel contentPanel; // 內容面板，其上用於添加其他待切換的面板
//
//    public Home() {
//        // 初始化組件
//        menuBar = new MenuBar();
//        function = new Menu("Function");
////        all = new MenuItem("All Course");
//        select = new MenuItem("Select Course");
//        myCourse = new MenuItem("My Course");
//        contentPanel = new Panel();
//
//        // 菜單項添加事件監聽器
////        all.addActionListener(this);
//        select.addActionListener(this);
//        myCourse.addActionListener(this);
//
//        // 設置窗口的菜單欄，菜單和各個菜單項。
////        function.add(all);
//        function.add(select);
//        function.add(myCourse);
//        menuBar.add(function);
//        setMenuBar(menuBar);
//
//        // 設置佈局爲邊界佈局管理器。將contentPanel添加到窗口中心位置。
////        this.setContentPane(new MyPanel("Welcome to SubjectSystem"));
//        this.setContentPane(new SelectPanel(this));
//
//        // 窗口的其他參數
//        setTitle("Home");
//        setSize(900, 450);
////        setBounds(300, 50, 700, 500);
//        setVisible(true);
//        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//    }
//
//    // 事件觸發，更新觸發頁面版面（Panel）
//    @Override
//    public void actionPerformed(ActionEvent e) {
//        Object source = e.getSource();
////        if (source.equals(all)) {
////            changeContentPane(new HomePanel(this));
////        }
//        if (source.equals(select)) {
//            changeContentPane(new SelectPanel(this));
//        }
//        else if (source.equals(myCourse)) {
//            changeContentPane(new MyPanel(this));
//        }
//    }
//
//    // 切換內容面板
//    public void changeContentPane(Container contentPane) {
//        this.setContentPane(contentPane);
//        this.revalidate();
//        this.repaint();
//    }
//}
//
//
//// 簡易地獲取所需的面板(使用時需自定義)
//class MyPanel extends JPanel {
//    public MyPanel(JFrame frame) {
////        List<User> userList = new ArrayList<>(UserDB.UserList);
//        UserDB user = new UserDB();
//
//        CoursePanel panel = new CoursePanel();
//
//        // 設定功課表參數
//        panel.setPanelElements();
//
//        // 顯示課程標題
//        panel.addHeader();
//
//        // 獲取用戶功課表
//        List<Course> courseList = user.getCourse();
//
////        System.out.println(courseList);
//
//        int index = 0;
//
//        if (courseList != null) {
//            // 根據用戶課程數建立退選按鈕
//
//            JButton button[] = new JButton[courseList.size()];
//
//            for (Course course : courseList) {
//                button[index] = new JButton("退選");
//                button[index].setForeground(Color.RED);
//
//                final int number = index;
//                button[index].addActionListener(new ActionListener() {
//                    @Override
//                    public void actionPerformed(ActionEvent e) {
//                        if (button[number].getText().equals("加選")) {
//                            button[number].setText("退選");
//                            button[number].setForeground(Color.RED);
//                            user.addCourse(course, course.GetCredit());
//                            System.out.println("加選成功！");
//                        } else if (button[number].getText().equals("退選")) {
//                            button[number].setText("加選");
//                            button[number].setForeground(Color.BLACK);
//                            user.delCourse(course, course.GetCredit());
//                            System.out.println("退選成功！");
//                        }
//                    }
//                });
//
//                panel.addCourseIntoTable(course, index, button[index]);
//
//                index++;
//            }
//        }
//
//        panel.addResetButton(frame, index);
//
//        this.add(panel.getCoursePanel());
//    }
//}
//
//
//// 篩選面板
//class SelectPanel extends JPanel{
//    public SelectPanel(JFrame frame){
//        UserDB user = new UserDB();
//
//        // 顯示用戶名稱及學分
//        JPanel userData = new JPanel(new FlowLayout(FlowLayout.CENTER));
//
//        JLabel userName = new JLabel("                              用戶名稱：" + user.getNowUser());
//        JLabel userCredit = new JLabel("          目前學分：" + user.getNowCredit()+ "                              ");
//
//        userData.add(userName);
//        userData.add(userCredit);
//
//        this.add(userData);
//
//        //
//        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
//
//        JPanel p1 = new JPanel(new FlowLayout(FlowLayout.TRAILING));
//        JPanel p2 = new JPanel(new FlowLayout(FlowLayout.LEFT));
//
//        //courseID: courseIDPanel
//        JPanel courseIDPanel = new JPanel();
//        JLabel courseIDLabel = new JLabel(" courseID ");
//        JTextField courseIDField = new JTextField(5);
//        courseIDPanel.add(courseIDLabel);
//        courseIDPanel.add(courseIDField);
//
//        //courseName: courseNamePanel
//        JPanel courseNamePanel = new JPanel();
//        JLabel courseNameLabel = new JLabel(" courseName ");
//        JTextField courseNameField = new JTextField(15);
//        courseNamePanel.add(courseNameLabel);
//        courseNamePanel.add(courseNameField);
//
//        //Class: classPanel
//        JPanel classPanel = new JPanel();
//        JLabel classLabel = new JLabel(" Class ");
//        // 下拉選單
//        JComboBox classCombox = new JComboBox();
//        List<String> classList = CourseDB.ReturnAllClass();
//        classCombox.addItem("NULL");
//        for (String className: classList) {
//            classCombox.addItem(className);
//        }
//        classPanel.add(classLabel);
//        classPanel.add(classCombox);
//
//        //Department: departmentPanel
//        JPanel departmentPanel = new JPanel();
//        JLabel departmentLabel = new JLabel(" Department ");
//        JComboBox departmentCombox = new JComboBox();
//        List<String> departmentList = CourseDB.ReturnAllDepartment();
//        departmentCombox.addItem("NULL");
//        for (String department: departmentList) {
//            departmentCombox.addItem(department);
//        }
//        departmentPanel.add(departmentLabel);
//        departmentPanel.add(departmentCombox);
//
//        //Teacher: teacherPanel
//        JPanel teacherPanel = new JPanel();
//        JLabel teacherLabel = new JLabel(" Teacher ");
//        JTextField teacherField = new JTextField(8);
//        teacherPanel.add(teacherLabel);
//        teacherPanel.add(teacherField);
//
//        //Week: weekPanel
//        JPanel weekPanel = new JPanel();
//        JLabel weekLabel = new JLabel(" Week ");
//        JComboBox weekCombox = new JComboBox();
//        weekCombox.addItem("NULL");
//        weekCombox.addItem("一");
//        weekCombox.addItem("二");
//        weekCombox.addItem("三");
//        weekCombox.addItem("四");
//        weekCombox.addItem("五");
////        weekPanel.add(weekLabel);
////        weekPanel.add(weekCombox);
//
//        //Time: timePanel
//        JPanel timePanel = new JPanel();
//        JLabel timeLabel = new JLabel(" Time ");
//        JComboBox timeCombox = new JComboBox();
//        timeCombox.addItem("NULL");
//        timeCombox.addItem("1");
//        timeCombox.addItem("2");
//        timeCombox.addItem("3");
//        timeCombox.addItem("4");
//        timeCombox.addItem("6");
//        timeCombox.addItem("7");
//        timeCombox.addItem("8");
//        timeCombox.addItem("9");
//
//        // Button
//        JButton search = new JButton("Search");
//        JButton reset = new JButton("Reset");
//
//
//
//
//        // Add
//        p1.add(courseIDLabel);
//        p1.add(courseIDField);
//        p1.add(courseNameLabel);
//        p1.add(courseNameField);
//        p1.add(classLabel);
//        p1.add(classCombox);
//        this.add(p1);
//
//        p2.add(departmentLabel);
//        p2.add(departmentCombox);
//        p2.add(teacherLabel);
//        p2.add(teacherField);
//        p2.add(weekLabel);
//        p2.add(weekCombox);
//        p2.add(timeLabel);
//        p2.add(timeCombox);
//
//        buttonPanel.add(search);
//        buttonPanel.add(reset);
//
//
//        this.add(p2);
//        this.add(buttonPanel);
//
//
//        // 觸發搜尋事件
//        search.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                // 取得所有輸入條件
//                String strID = courseIDField.getText();
//                String strName = courseNameField.getText();
//                String strClass = classCombox.getItemAt(classCombox.getSelectedIndex()).toString();
//                String strDepartment = departmentCombox.getItemAt(departmentCombox.getSelectedIndex()).toString();
//                String strTeacher = teacherField.getText();
//                String strWeek = weekCombox.getItemAt(weekCombox.getSelectedIndex()).toString();
//                String strTime = timeCombox.getItemAt(timeCombox.getSelectedIndex()).toString();
//
//                List<Course> copyList = new ArrayList<>(CourseDB.courseList);
//
//                // 每個條件篩選，假設不為空值的話
//                if(!strID.contentEquals("")){
//                    copyList = CourseDB.SearchID(strID, copyList);
//                }
//                if(!strName.contentEquals("")){
//                    copyList = CourseDB.SearchName(strName, copyList);
//                }
//                if(!strClass.contentEquals("NULL")){
//                    copyList = CourseDB.SearchClass(strClass, copyList);
//                }
//                if(!strDepartment.contentEquals("NULL")){
//                    copyList = CourseDB.SearchDepartment(strDepartment, copyList);
//                }
//                if(!strTeacher.contentEquals("")){
//                    copyList = CourseDB.SearchTeacher(strTeacher, copyList);
//                }
//                if(!strWeek.contentEquals("NULL")){
//                    copyList = CourseDB.SearchWeek(strWeek, copyList);
//                }
//                if(!strTime.contentEquals("NULL")){
//                    copyList = CourseDB.SearchTime(strTime, copyList);
//                }
//
//                // 假設選擇有結果的話
//                if(!copyList.equals(CourseDB.courseList) && !copyList.isEmpty()){
//                    frame.setContentPane(new AfterSelectPanel(frame, copyList));
//                    frame.revalidate();
//                }
//                else{
//                    System.out.println("Has Error, Please select again!");
//                }
//            }
//        });
//
//        // 清除輸入格
//        reset.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                classCombox.setSelectedItem("NULL");
//                courseIDField.setText("");
//                courseNameField.setText("");
//                departmentCombox.setSelectedItem("NULL");
//                teacherField.setText("");
//                weekCombox.setSelectedItem("NULL");
//                timeCombox.setSelectedItem("NULL");
//            }
//        });
//    }
//
//}
//
//// 篩選後列表面板
//class AfterSelectPanel extends ScrollPane{
//    public AfterSelectPanel(JFrame frame, List<Course> courseList) {
////        this.setLayout(new GridBagLayout());
//
//        UserDB user = new UserDB();
//
//        CoursePanel panel = new CoursePanel();
//
//        panel.setPanelElements();
//
//        panel.addHeader();
//
//        panel.setTotalPage(courseList.size() / 10 + 1);
//
//        panel.setCourse(courseList);
//
//        int index = 0;
////        System.out.println(CourseDB.courseList.size());
//
//        JButton button[] = new JButton[courseList.size()];
//
//        for (Course course : courseList) {
////            user.getCourse().contains()
//            if (user.getCourse() == null || !user.getCourse().contains(course)) {
//                button[index]= new JButton("加選");
//                button[index].setForeground(Color.BLACK);
//            }
//            else if (user.getCourse().contains(course)) {
//                button[index]= new JButton("退選");
//                button[index].setForeground(Color.RED);
//            }
//
//            final int number = index;
//            button[index].addActionListener(new ActionListener() {
//                @Override
//                public void actionPerformed (ActionEvent e){
//
//                    if (button[number].getText().equals("加選") && (course.GetCurrentSeat() >= course.GetMaxSeat())) {
//                        System.out.println("無法加選！課程人數已達上限！");
//                    }
//                    else if (button[number].getText().equals("加選") && (course.GetCredit() + user.getNowCredit() > user.maxCredit)) {
//                        System.out.println("無法加選！修習學分已達上限！");
//                    }
//                    else if (button[number].getText().equals("加選") && user.addSchedule(course.GetTime()) == true) {
////                        if (button[number].getText().equals("加選") && (course.GetCredit() + user.getNowCredit() <= 25)) {
//                        button[number].setText("退選");
//                        button[number].setForeground(Color.RED);
//                        user.addCourse(course, course.GetCredit());
//                        System.out.println("加選成功！");
//                    }
//                    else if (button[number].getText().equals("退選")) {
//                        button[number].setText("加選");
//                        button[number].setForeground(Color.BLACK);
//                        user.delCourse(course, course.GetCredit());
//                        user.delSchedule(course.GetTime());
//                        System.out.println("退選成功！");
//                    }
//                    else {
//                        System.out.println("衝堂！無法加選！");
//                    }
//                }
//            });
//
//            panel.addCourseIntoTable(course, index, button[index]);
//
////            if (index == 30) {
////                break;
////            }
//
//            index++;
//
//            // 強制只能顯示 20筆
//            if ((index % 20 == 0) && index != 0) {
////                panel.panelLayout(frame);
////                index -= 10;
//
//                break;
//            }
//        }
//
//        panel.addResetButton(frame, index);
//
////        JPanel p1 = new JPanel();
////        p1.add(id);
////        p1.add(name);
////        p1.add(classes);
////        p1.add(credit);
////        p1.add(isRequires);
////        p1.add(department);
////        p1.add(currentSeat);
////        p1.add(maxSeat);
////        p1.add(teacher);
////        this.add(p1, BorderLayout.NORTH);
//
//        // 列出篩選後的課程
////        String s = "";
////        for(String course: CourseDB.ToList(courseList)){
////            s += course + "\n";
////        }
////        TextArea ta = new TextArea(s);
////
////        JScrollPane scrollPane = new JScrollPane(ta);
////        this.add(scrollPane, BorderLayout.CENTER);
////
//
//        //回上頁按鈕
////        JButton reset = new JButton("Reset");
////
////        resetButton.gridx = 8;
////        resetButton.gridy = index + 2;
////        resetButton.gridwidth = 2;
////        resetButton.gridheight = 1;
////        resetButton.ipadx = 2;
////        resetButton.weightx = resetButton.weighty = 1;
////        resetButton.fill = GridBagConstraints.CENTER;
////        resetButton.anchor = GridBagConstraints.CENTER;
//
//
////        panel.add(reset, resetButton);
//
//        this.add(panel.getCoursePanel());
//
//
//        // 回到篩選面板
////        reset.addActionListener(new ActionListener() {
////            @Override
////            public void actionPerformed(ActionEvent e) {
////                frame.setContentPane(new SelectPanel(frame));
////                frame.revalidate();
////            }
////        });
//
//    }
//
//}
//
//class CoursePanel extends ScrollPane {
//    List<Course> course;
//    int pageNumber = 1;
//
//    int totalPage;
//    JPanel panel;
//
//    GridBagConstraints addButton;
//    GridBagConstraints id;
//    GridBagConstraints courseName;
//    GridBagConstraints classes;
//    GridBagConstraints credit;
//    GridBagConstraints isRequired;
//    GridBagConstraints department;
//    GridBagConstraints currentSeat;
//    GridBagConstraints maxSeat;
//    GridBagConstraints teacher;
//    GridBagConstraints time;
//    GridBagConstraints resetButton;
//
//    public CoursePanel() {
//        this.panel = new JPanel(new GridBagLayout());
//
//        this.addButton = new GridBagConstraints();
//        this.courseName = new GridBagConstraints();
//        this.id = new GridBagConstraints();
//        this.classes = new GridBagConstraints();
//        this.credit = new GridBagConstraints();
//        this.isRequired = new GridBagConstraints();
//        this.department = new GridBagConstraints();
//        this.currentSeat = new GridBagConstraints();
//        this.maxSeat = new GridBagConstraints();
//        this.teacher = new GridBagConstraints();
//        this.time = new GridBagConstraints();
//        this.resetButton = new GridBagConstraints();
//    }
//
//    public void setPanelElements() {
//        this.addButton.gridx = 0;
//        this.courseName.gridx = 5;
//        this.id.gridx = 20;
//        this.classes.gridx = 28;
//        this.credit.gridx = 42;
//        this.isRequired.gridx = 50;
//        this.department.gridx = 65;
//        this.currentSeat.gridx = 80;
//        this.maxSeat.gridx = 90;
//        this.teacher.gridx = 100;
//        this.time.gridx = 110;
//
//        this.addButton.gridwidth = 1;
//        this.courseName.gridwidth = 15;
//        this.id.gridwidth = 4;
//        this.classes.gridwidth = 10;
//        this.credit.gridwidth = 4;
//        this.isRequired.gridwidth = 10;
//        this.department.gridwidth = 10;
//        this.currentSeat.gridwidth = 5;
//        this.maxSeat.gridwidth = 5;
//        this.teacher.gridwidth = 10;
//        this.time.gridwidth = 6;
//
//        addButton.ipadx = courseName.ipadx = id.ipadx = classes.ipadx = credit.ipadx = isRequired.ipadx =
//                department.ipadx = currentSeat.ipadx = maxSeat.ipadx = teacher.ipadx = time.ipadx = 15;
//
//        addButton.gridheight = courseName.gridheight = id.gridheight = classes.gridheight = credit.gridheight = isRequired.gridheight =
//                department.gridheight = currentSeat.gridheight = maxSeat.gridheight = teacher.gridheight = time.gridheight = 1;
//
//        addButton.weightx = courseName.weightx = id.weightx = classes.weightx = credit.weightx = isRequired.weightx =
//                department.weightx = currentSeat.weightx = maxSeat.weightx = teacher.weightx = time.weightx = 0;
//
//        addButton.weighty = courseName.weighty = id.weighty = classes.weighty = credit.weighty = isRequired.weighty = department.weighty =
//                currentSeat.weighty = maxSeat.weighty = teacher.weighty = time.weighty = 0;
//
//        addButton.anchor = courseName.anchor = id.anchor = classes.anchor = credit.anchor = isRequired.anchor = department.anchor =
//                currentSeat.anchor = maxSeat.anchor = teacher.anchor = time.anchor = GridBagConstraints.CENTER;
//
//        addButton.gridy = courseName.gridy = id.gridy = classes.gridy = credit.gridy = isRequired.gridy = department.gridy =
//                currentSeat.gridy = maxSeat.gridy = teacher.gridy = time.gridy = 0;
//    }
//
//    public void addHeader() {
//        JLabel idHeader = new JLabel("ID");
//        JLabel courseNameHeader = new JLabel("CourseName");
//        JLabel classesHeader = new JLabel("Class");
//        JLabel creditHeader = new JLabel("Credit");
//        JLabel isRequiredHeader = new JLabel("isRequired");
//        JLabel departmentHeader = new JLabel("Department");
//        JLabel currentSeatHeader = new JLabel("CurrentSeat");
//        JLabel maxSeatHeader = new JLabel("MaxSeat");
//        JLabel teacherHeader = new JLabel("Teacher");
//        JLabel timeHeader = new JLabel("Time(Week)");
//
//        this.panel.add(idHeader, id);
//        this.panel.add(courseNameHeader, courseName);
//        this.panel.add(classesHeader, classes);
//        this.panel.add(creditHeader, credit);
//        this.panel.add(isRequiredHeader, isRequired);
//        this.panel.add(departmentHeader, department);
//        this.panel.add(currentSeatHeader, currentSeat);
//        this.panel.add(maxSeatHeader, maxSeat);
//        this.panel.add(teacherHeader, teacher);
//        this.panel.add(timeHeader, time);
//    }
//
//    public void addCourseIntoTable(Course course, int index, JButton button) {
//
//        JLabel idText = new JLabel(Integer.toString(course.GetCourseID()));
//        JLabel courseNameText = new JLabel(course.GetCourseName());
//        JLabel classesText = new JLabel(course.GetCourseClass());
//        JLabel creditText = new JLabel(Integer.toString(course.GetCredit()));
//        JLabel isRequiredText = new JLabel(Boolean.toString(course.GetIsRequired()));
//        JLabel departmentText = new JLabel(course.GetDepartment());
//        JLabel currentSeatText = new JLabel(Integer.toString(course.GetCurrentSeat()));
//        JLabel maxSeatText = new JLabel(Integer.toString(course.GetMaxSeat()));
//        JLabel teacherText = new JLabel(course.GetTeacherName());
//        JLabel timeText = new JLabel(course.GetTime());
//
//        this.addButton.gridy = this.courseName.gridy = this.id.gridy = this.classes.gridy = this.credit.gridy = this.isRequired.gridy = this.department.gridy =
//                this.currentSeat.gridy = this.maxSeat.gridy = this.teacher.gridy = this.time.gridy = index + 1;
//
//        this.panel.add(button, addButton);
//        this.panel.add(courseNameText, courseName);
//        this.panel.add(idText, id);
//        this.panel.add(classesText, classes);
//        this.panel.add(creditText, credit);
//        this.panel.add(isRequiredText, isRequired);
//        this.panel.add(departmentText, department);
//        this.panel.add(currentSeatText, currentSeat);
//        this.panel.add(maxSeatText, maxSeat);
//        this.panel.add(teacherText, teacher);
//        this.panel.add(timeText, time);
//    }
//
////    public void panelLayout(JFrame frame) {
////        if (this.totalPage > 1) {
////            GridBagConstraints previousPageButton = new GridBagConstraints();
////            GridBagConstraints nextPageButton = new GridBagConstraints();
////            GridBagConstraints pages = new GridBagConstraints();
////
////            JButton previousPage = new JButton("上一頁");
////            JButton nextPage = new JButton("下一頁");
////            JLabel pagesText = new JLabel(Integer.toString(pageNumber) + " / " + Integer.toString(totalPage) + " 頁");
////
////            previousPageButton.gridx = 42;
////            pages.gridx = 46;
////            nextPageButton.gridx = 50;
////
////            previousPageButton.gridy = pages.gridy = nextPageButton.gridy = 11;
////
////            previousPageButton.ipadx = nextPageButton.ipadx = 15;
////
////            this.panel.add(previousPage, previousPageButton);
////            this.panel.add(pagesText, pages);
////            this.panel.add(nextPage, nextPageButton);
////
////            if (pageNumber > 1) {
////                previousPage.addActionListener(new ActionListener() {
////                    @Override
////                    public void actionPerformed(ActionEvent e) {
////                        pageNumber -= 1;
////
////                        for (int i = pageNumber * 10 - 10; i < pageNumber * 10 - 1; i++) {
////
////                        }
////                        panel.revalidate();
////
////
////                    }
////                });
////            }
////            nextPage.addActionListener(new ActionListener() {
////                 @Override
////                 public void actionPerformed(ActionEvent e) {
////                     pageNumber += 1;
////                     System.out.println(pageNumber);
////
////                     panel.revalidate();
////
////                 }
////            });
////
////        }
////        else if (page == 1) {
////
////        }
//
////    }
//
//    public void addResetButton(JFrame frame, int index) {
//        JButton reset = new JButton("Reset");
//
//        this.resetButton.gridx = 42;
//        this.resetButton.gridy = index + 2;
//        this.resetButton.ipadx = 15;
//
//        this.resetButton.gridwidth = 1;
//        this.resetButton.gridheight = 1;
//        this.resetButton.weightx = resetButton.weighty = 0;
////        this.resetButton.fill = GridBagConstraints.BOTH;
//        this.resetButton.anchor = GridBagConstraints.CENTER;
//
//        this.panel.add(reset, resetButton);
//        //        回到篩選面板
//
//        reset.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                frame.setContentPane(new SelectPanel(frame));
//                frame.revalidate();
//            }
//        });
//    }
//
//    public void addNoCourseMessage() {
//        GridBagConstraints noCourse = new GridBagConstraints();
//
//        JLabel noCourseText= new JLabel("目前沒有課程！");
//
//        this.panel.add(noCourseText, noCourse);
//    }
//
//    public void setTotalPage(int totalPage) {
//        this.totalPage = totalPage;
//    }
//
//
//    public JPanel getCoursePanel() {
//        return this.panel;
//    }
//
//    public void setCourse(List<Course> courseList) {
//        this.course = courseList;
//    }
//
//}
//
//
