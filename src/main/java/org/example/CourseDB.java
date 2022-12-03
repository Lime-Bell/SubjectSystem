package org.example;



import java.util.*;

public class CourseDB {
    // Total 課程列表
    public static List<Course> courseList = new ArrayList<>();

    // 供回傳字串長度設定
    public static int maxIDLength = 7;
    public static int maxNameLength = 20;
    public static int maxClassLength = 15;
    public static int maxCreditLength = 5;
    public static int maxisRequiredLength = 6;
    public static int maxDepartmentLength = 20;
    public static int maxCurrentSeatLength = 4;
    public static int maxMaxSeatLength = 4;
    public static int maxTeacherLength = 5;


    // 初始化 CourseDB
    public static void Initialized() {
        Course course;
        int id;
        String name;
        String Class;
        int credit;
        Boolean isRequired;
        String department;
        int c_seat;
        int m_seat;
        String teacher;
        String time;
        // 存入所有課程
        for (int i = 0; i < Course.courseNum; i++) {
            id = Course.returnCourseID(i);
            name = Course.returnCourseName(i);
            Class = Course.returnCourseClass(i);
            credit = Course.returnCredit(i);
            isRequired = Course.returnIsRequired(i);
            department = Course.returnDepartment(i);
            c_seat = Course.returnCurrentSeat(i);
            m_seat = Course.returnMaxSeat(i);
            teacher = Course.returnTeacherName(i);
            time = Course.returnWeekName(i);
            course = new Course(id, name, Class, credit, isRequired, department, c_seat, m_seat, teacher, time);
            courseList.add(course);

        }

    }
    // 回傳所有Class
    public static List<String> ReturnAllClass(){
        List<String> classList = new ArrayList<>();
        for(int i = 0; i < Course.courseNum; i++){
            String d = Course.returnCourseClass(i);
            if(classList.contains(d)){
                continue;
            }
            classList.add(d);
        }
        return classList;
    }

    //回傳所有Department
    public static List<String> ReturnAllDepartment(){
        List<String> departmentList = new ArrayList<>();
        for(int i = 0; i < Course.courseNum; i++){
            String d = Course.returnDepartment(i);
            if(departmentList.contains(d)){
                continue;
            }
            departmentList.add(d);
        }
        return departmentList;
    }
    // 將List<Course> 變成 List<String>
    public  static List<String> ToList(List<Course> courseList){

        List<String> l = new ArrayList<>();

        for(Course course: courseList){
            l.add(course.ToCourseString());
        }

        return l;
    }

    // 搜尋符合的courseID 在 courseList裡
    public static List<Course> SearchID(String id, List<Course> courseList){
        List<Course> newList = new ArrayList<>();
        for(Course course: courseList){
            if(id.contentEquals(String.valueOf(course.GetCourseID()))){
                newList.add(course);
            }
        }
        return newList;
    }
    // 搜尋符合的courseName 在 courseList裡
    public static List<Course> SearchName(String name, List<Course> courseList){
        List<Course> newList = new ArrayList<>();
        for(Course course: courseList){
            if(name.contentEquals(course.GetCourseName())){
                newList.add(course);
            }
        }
        return newList;
    }
    // 搜尋符合的courseClass 在 courseList裡
    public static List<Course> SearchClass(String aclass, List<Course> courseList){
        List<Course> newList = new ArrayList<>();
        for(Course course: courseList){
            if(aclass.contentEquals(course.GetCourseClass())){
                newList.add(course);
            }
        }
        return newList;
    }
    // 搜尋符合的Department 在 courseList裡
    public static List<Course> SearchDepartment(String department, List<Course> courseList){
        List<Course> newList = new ArrayList<>();
        for(Course course: courseList){
            if(department.contentEquals(course.GetDepartment())){
                newList.add(course);
            }
        }
        return newList;
    }
    // 搜尋符合的Teacher 在 courseList裡
    public static List<Course> SearchTeacher(String teacher, List<Course> courseList){
        List<Course> newList = new ArrayList<>();
        for(Course course: courseList){
            if(teacher.contentEquals(course.GetTeacherName())){
                newList.add(course);
            }
        }
        return newList;
    }

    public static List<Course> SearchWeek(String week, List<Course> courseList) {
        List<Course> newList = new ArrayList<>();
        for (Course course: courseList) {
            StringTokenizer token = new StringTokenizer(course.GetTime(), "()");
            String weekToken = new String();
//            weekToken = token.nextToken();

            while (token.hasMoreElements()) {
                weekToken = token.nextToken();
            }

            if (week.contentEquals(weekToken)) {
                newList.add(course);
            }
        }

        return newList;
    }

    public static List<Course> SearchTime(String time, List<Course> courseList) {
        List<Course> newList = new ArrayList<>();
        for (Course course: courseList) {
            StringTokenizer token = new StringTokenizer(course.GetTime(), "()");
            StringTokenizer timeToken = new StringTokenizer(token.nextToken(), "-");

            List<Integer> timeScope = new ArrayList();

            int timeSearch = Integer.parseInt(time);

            while (timeToken.hasMoreElements()) {
//                System.out.println(timeToken.nextToken());
                timeScope.add(Integer.parseInt(timeToken.nextToken()));
            }

            if (timeScope.size() == 2 && timeSearch >= (timeScope.get(0)) && timeSearch <= (timeScope.get(1))) {
                newList.add(course);
            }
            else if (timeScope.size() == 1 && timeSearch == timeScope.get(0)) {
                newList.add(course);
            }
        }

        return newList;
    }

}
