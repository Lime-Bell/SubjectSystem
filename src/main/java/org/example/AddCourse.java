package org.example;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AddCourse {

    MyCourse myCourse;
//    UserDB user;

    public String addCourse(Course course) {
        myCourse = new MyCourse();

        if (course.GetCurrentSeat() >= course.GetMaxSeat()) {
//            System.out.println("課程人數已滿, Add Failed!");
            return "課程人數已滿, Add Failed!";
        }

        else if (course.GetCredit() + myCourse.user.getNowCredit() > myCourse.user.maxCredit) {
//            System.out.println("學分已達上限, Add Failed!");
            return "學分已達上限, Add Failed!";
        }

        else if (myCourse.user.addSchedule(course.GetTime()) == true) {
//            System.out.println("Add Success!");
            myCourse.user.addCourse(course, course.GetCredit());

            return "Add Success!";
        }
        else if (myCourse.user.addSchedule(course.GetTime()) == false) {
//            System.out.println("衝堂, Add Failed!");
            return "衝堂, Add Failed!";
        }
        else {
            return "沒有該課程, Add Failed!";
        }

    }
}
