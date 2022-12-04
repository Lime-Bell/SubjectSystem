package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LoginMethodTest {

    LoginMethod login;
    MyCourse myData;

    @BeforeEach
    void setUp() {
        CourseDB.Initialized();
        UserDB.Initialized();
        login = new LoginMethod();
        myData = new MyCourse();
    }

    @Test
    void login() {

//        System.out.println(login.myCourse.user.getNowUser());
        assertEquals("", myData.user.getNowUser());

        assertTrue(login.login("joe", "1234"));         // 登入成功
        assertEquals("joe", myData.user.getNowUser());

        assertFalse(login.login(">_<", "1234"));        // 登入失敗
        assertTrue(login.login("amy", "4321"));         // 登入成功
        assertFalse(login.login("amy", "20221204"));    // 登入失敗
        assertFalse(login.login("", ""));               // 登入失敗
        assertFalse(login.login("にゃこ", "喵"));         // 登入失敗

        assertEquals("", myData.user.getNowUser());
    }
}