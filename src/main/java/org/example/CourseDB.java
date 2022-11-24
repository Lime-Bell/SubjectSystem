package org.example;



import java.util.*;

public class CourseDB {
    public static List<Course> courseList = new ArrayList<>();

    public static int maxIDLength = 7;
    public static int maxNameLength = 20;
    public static int maxClassLength = 15;
    public static int maxCreditLength = 5;
    public static int maxisRequiredLength = 6;
    public static int maxDepartmentLength = 20;
    public static int maxCurrentSeatLength = 4;
    public static int maxMaxSeatLength = 4;
    public static int maxTeacherLength = 5;


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
            course = new Course(id, name, Class, credit, isRequired, department, c_seat, m_seat, teacher);
            courseList.add(course);

        }

    }
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
    public  static List<String> ToList(){

        List<String> l = new ArrayList<>();

        for(Course course: courseList){
            l.add(course.ToCourseString());
//            System.out.println(course.ToCourseString());
        }

        return l;
    }

}
