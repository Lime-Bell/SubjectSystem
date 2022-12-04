package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class IntegrateTest {
    AddCourse add;
    DelCourse del;
    MyCourse courseNum;

    @BeforeEach
    void setUp() {
        CourseDB.Initialized();
        UserDB.Initialized();
        add = new AddCourse();
        del = new DelCourse();
        courseNum = new MyCourse();
    }

    @Test
    void integrateTest() {

        List<Course> copyList = new ArrayList<>(CourseDB.courseList);

        assertEquals(0, courseNum.myCourse()); // 初始共0堂課

        // 嘗試加4堂課
        assertEquals("課程人數已滿, Add Failed!", add.addCourse(copyList.get(377)));
        assertEquals("Add Success!",add.addCourse(copyList.get(28)));
        assertEquals("Add Success!", add.addCourse(copyList.get(0)));
        assertEquals("課程人數已滿, Add Failed!", add.addCourse(copyList.get(99)));

        assertEquals(2, courseNum.myCourse()); // 現有共2堂課

        // 嘗試退1堂課
        assertEquals("Del Success!", del.delCourse(copyList.get(0)));

        // 嘗試退未加選的課
        assertEquals("沒有課程!", del.delCourse(copyList.get(401)));

        // 嘗試加6堂課
        assertEquals("Add Success!", add.addCourse(copyList.get(401)));
        assertEquals("衝堂, Add Failed!",add.addCourse(copyList.get(92)));
        assertEquals("課程人數已滿, Add Failed!", add.addCourse(copyList.get(133)));
        assertEquals("Add Success!", add.addCourse(copyList.get(233)));

        assertEquals(3, courseNum.myCourse()); // 現有共3堂課

//        System.out.println(copyList.get(133).ToCourseString());
//        assertEquals();

    }
}