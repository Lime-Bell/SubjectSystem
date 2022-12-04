package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MyCourseTest {
    AddCourse add;
    MyCourse myData;

    @BeforeEach
    void setUp() {
        CourseDB.Initialized();
        UserDB.Initialized();

        add = new AddCourse();
        myData = new MyCourse();
    }

    @Test
    void myCourse() {

        assertEquals(0, myData.myCourse()); // 初始共0堂課
    }
}