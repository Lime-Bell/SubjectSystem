package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class AddCourseTest {
    AddCourse add;
    MyCourse courseNum;

    @BeforeEach
    void setUp() {
        CourseDB.Initialized();
        UserDB.Initialized();
        add = new AddCourse();
        courseNum = new MyCourse();
    }

    @Test
    void addCourse() {

        List<Course> copyList = new ArrayList<>(CourseDB.courseList);

        ArrayList<String> addTestArray = new ArrayList<String>() {{
            add(add.addCourse(copyList.get(5)));
            add(add.addCourse(copyList.get(55)));
            add(add.addCourse(copyList.get(127)));
            add(add.addCourse(copyList.get(268)));
            add(add.addCourse(copyList.get(377))); // 5
            add(add.addCourse(copyList.get(28)));
            add(add.addCourse(copyList.get(0)));
            add(add.addCourse(copyList.get(99)));
            add(add.addCourse(copyList.get(100)));
            add(add.addCourse(copyList.get(88))); // 10
            add(add.addCourse(copyList.get(258)));
            add(add.addCourse(copyList.get(301)));
            add(add.addCourse(copyList.get(400)));
            add(add.addCourse(copyList.get(5)));
            add(add.addCourse(copyList.get(317)));
        }};


//        System.out.println(copyList.get(5).ToCourseString());
//        System.out.println(copyList.get(55).ToCourseString());
//        System.out.println(copyList.get(127).ToCourseString());
//        System.out.println(copyList.get(268).ToCourseString());
//        System.out.println(copyList.get(377).ToCourseString());
//        System.out.println(copyList.get(28).ToCourseString());
//        System.out.println(copyList.get(0).ToCourseString());
//        System.out.println(copyList.get(99).ToCourseString());
//        System.out.println(copyList.get(100).ToCourseString());
//        System.out.println(copyList.get(88).ToCourseString());
//        System.out.println(copyList.get(258).ToCourseString());
//        System.out.println(copyList.get(301).ToCourseString());
//        System.out.println(copyList.get(400).ToCourseString());
//        System.out.println(copyList.get(5).ToCourseString());

//         Assert
        assertEquals("Add Success!", addTestArray.get(0));
        assertEquals("課程人數已滿, Add Failed!", addTestArray.get(1));
        assertEquals("Add Success!", addTestArray.get(2));
        assertEquals("課程人數已滿, Add Failed!", addTestArray.get(3));

        assertEquals("課程人數已滿, Add Failed!", addTestArray.get(4));
        assertEquals("Add Success!", addTestArray.get(5));
        assertEquals("Add Success!", addTestArray.get(6));
        assertEquals("課程人數已滿, Add Failed!", addTestArray.get(7));
        assertEquals("衝堂, Add Failed!", addTestArray.get(8));
        assertEquals("Add Success!", addTestArray.get(9));
        assertEquals("學分已達上限, Add Failed!", addTestArray.get(10));
        assertEquals("學分已達上限, Add Failed!", addTestArray.get(11));
        assertEquals("學分已達上限, Add Failed!", addTestArray.get(12));
        assertEquals("衝堂, Add Failed!", addTestArray.get(13));
        assertEquals("Add Success!", addTestArray.get(14));

        assertEquals(8, add.showCredit());      // 目前共8學分

        assertEquals(6, courseNum.myCourse());  // 目前共5堂課
    }



}