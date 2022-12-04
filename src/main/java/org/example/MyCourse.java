package org.example;

import java.util.List;

public class MyCourse {
    public UserDB user = new UserDB();


//    public List<Course> courseList;     // 不能為static


    public int myCourse() {
//        courseList = user.getCourse();

        if (user.getCourse().isEmpty()) {
            return 0;
        }
        else {
            return user.getCourse().size();
        }
//        System.out.println(courseList.size());

//        return courseList.size();

    }

//    public static List<Course> returnMyCourse() {
//        return courseList;
//    }
}
