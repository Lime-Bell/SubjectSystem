package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class DelCourseTest {

    DelCourse del;
    MyCourse courseNum;

    AddCourse add;

    @BeforeEach
    void setUp() {
        CourseDB.Initialized();
        UserDB.Initialized();

        del = new DelCourse();
        add = new AddCourse();
        courseNum = new MyCourse();
    }

    @Test
    void delCourse() {

        List<Course> copyList = new ArrayList<>(CourseDB.courseList);


        assertEquals("沒有課程!", del.delCourse(copyList.get(333)));
        assertEquals("課程人數已滿, Add Failed!", add.addCourse(copyList.get(8)));
        assertEquals("Add Success!", add.addCourse(copyList.get(80)));
        assertEquals("沒有課程!", del.delCourse(copyList.get(5)));
        assertEquals("Del Success!", del.delCourse(copyList.get(80)));

    }
}