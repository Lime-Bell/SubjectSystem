package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MyCourseTest {
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
    void myCourse() {

        assertEquals(0, courseNum.myCourse()); // 初始共0堂課
    }
}