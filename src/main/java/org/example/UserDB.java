package org.example;

import javax.swing.*;
import java.util.*;

public class UserDB {
    public static List<User> UserList = new ArrayList<>();

    private static String nowUser = "";

    private static int nowCredit = 0;
    private static Map<String, List<Course>> course = new HashMap<String, List<Course>>();

    // UserDB 初始化
    public static void Initialized(){
        User user;
        for(int i = 0; i < User.User_Num; i++){
            user = new User(User.ReturnUserIDList(i), User.ReturnPasswordList(i));
            UserList.add(user);
        }
    }
    // 確認使用者是否存在
    public static Boolean isUser(String uid, String pwd){
        for (User user: UserList) {
            if(user.GetUserID().contentEquals(uid) && user.GetPassword().contentEquals(pwd)){
                return true;
            }
        }
        return false;
    }

    public void addCourse(Course course, int credit) {
        if (!this.course.containsKey(this.nowUser)) {
            this.course.put(this.nowUser, new ArrayList<Course>());
        }
        this.course.get(this.nowUser).add(course);
        this.nowCredit += credit;
    }

    public void delCourse(Course course, int credit) {
        if (this.course.containsKey(this.nowUser)) {
            this.course.get(this.nowUser).remove(course);
        }
        this.nowCredit -= credit;

    }

    public List<Course> getCourse() {

//        System.out.println(this.course.get(getNowUser()));

        return this.course.get(this.nowUser);
    }

    public void setNowUser(String user) {
        nowUser = user;
    }

    public String getNowUser() {
        return nowUser;
    }

    public int getNowCredit() {
        return nowCredit;
    }



}
