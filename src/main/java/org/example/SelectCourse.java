package org.example;

import java.util.ArrayList;
import java.util.List;

public class SelectCourse {
    public int selectCourse(String id, String name, String Class, String department,
                             String teacher, String week, String time) {

        // 取得所有輸入條件
        String strID = id;
        String strName = name;
        String strClass = Class;
        String strDepartment = department;
        String strTeacher = teacher;
        String strWeek = week;
        String strTime = time;

        List<Course> copyList = new ArrayList<>(CourseDB.courseList);

        // 每個條件篩選，假設不為空值的話
        if (!strID.contentEquals("")){
            copyList = CourseDB.SearchID(strID, copyList);
        }
        if (!strName.contentEquals("")){
            copyList = CourseDB.SearchName(strName, copyList);
        }
        if (!strClass.contentEquals("")){
            copyList = CourseDB.SearchClass(strClass, copyList);
        }
        if (!strDepartment.contentEquals("")){
            copyList = CourseDB.SearchDepartment(strDepartment, copyList);
        }
        if (!strTeacher.contentEquals("")){
            copyList = CourseDB.SearchTeacher(strTeacher, copyList);
        }
        if (!strWeek.contentEquals("")){
            copyList = CourseDB.SearchWeek(strWeek, copyList);
        }
        if (!strTime.contentEquals("")){
            copyList = CourseDB.SearchTime(strTime, copyList);
        }

        // 假設選擇有結果的話
//        if (!copyList.equals(CourseDB.courseList) && !copyList.isEmpty()){
////            System.out.println(copyList.size());
//            return copyList.size();
//        }
//        else {
////            System.out.println("Has Error, Please select again!");
//            return 0;
//        }

        if (copyList.equals(CourseDB.courseList) && copyList.isEmpty()){
            return 0;
//            return copyList.size();
        }
        else {
            return copyList.size();
        }
    }
}
