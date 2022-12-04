package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SelectCourseTest {
    SelectCourse select;
//    AddCourse add;

    @BeforeEach
    void setUp() {
        CourseDB.Initialized();
        UserDB.Initialized();
        select = new SelectCourse();
    }

    @Test
    void selectCourse() {
        ArrayList<Integer> testArray = new ArrayList<Integer>() {{
            add(select.selectCourse("", "", "資訊三丙", "", "", "五", "")); // 1
            add(select.selectCourse("", "", "企管二乙", "", "", "三", "")); // 2
            add(select.selectCourse("", "", "通識－社會(S)", "通識核心課程", "", "二", "")); // 5
            add(select.selectCourse("", "", "", "資訊工程學系", "", "二", "")); // 25
            add(select.selectCourse("", "", "", "資訊工程學系", "", "", "")); // 117
            add(select.selectCourse("", "", "通識－統合(M)", "", "", "", "7")); //
            add(select.selectCourse("", "", "", "企業管理學系", "", "", "")); //
            add(select.selectCourse("", "", "", "企業管理學系", "劉峰旗", "", "")); // 117
            add(select.selectCourse("", "會計學(二)", "", "企業管理學系", "", "", "")); // 117
            add(select.selectCourse("3892", "", "", "", "", "", "")); // 117
            add(select.selectCourse("1360", "", "", "", "", "", "8")); // 117
            add(select.selectCourse("20221204", "", "", "", "", "", "")); // 117
            add(select.selectCourse("", "", "", "", "不要亂", "", "8")); // 117
        }};

        // Assert
        // 回傳搜尋到的筆數
        assertEquals(1, testArray.get(0));
        assertEquals(2, testArray.get(1));
        assertEquals(5, testArray.get(2));
        assertEquals(25, testArray.get(3));
        assertEquals(117, testArray.get(4));
        assertEquals(16, testArray.get(5));
        assertEquals(86, testArray.get(6));
        assertEquals(1, testArray.get(7));
        assertEquals(2, testArray.get(8));
        assertEquals(1, testArray.get(9));
        assertEquals(1, testArray.get(10));
        assertEquals(0, testArray.get(11));
        assertEquals(0, testArray.get(12));
    }



}