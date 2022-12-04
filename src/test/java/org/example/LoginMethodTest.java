package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LoginMethodTest {

    LoginMethod login;

    @BeforeEach
    void setUp() {
        login = new LoginMethod();
    }

    @Test
    void login() {

        assertTrue(login.login("joe", "1234"));         // 登入成功
        assertFalse(login.login(">_<", "1234"));        // 登入失敗
        assertTrue(login.login("amy", "4321"));         // 登入成功
        assertFalse(login.login("amy", "20221204"));    // 登入失敗
        assertFalse(login.login("", ""));               // 登入失敗
        assertFalse(login.login("にゃこ", "喵"));         // 登入失敗
    }
}