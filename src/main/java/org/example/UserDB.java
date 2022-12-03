package org.example;

import javax.swing.*;
import java.util.*;

public class UserDB {
    public static List<User> UserList = new ArrayList<>();

    private static String nowUser = "";

    private static int nowCredit = 0;
    private static Map<String, List<Course>> course = new HashMap<String, List<Course>>();

    private static final Map<String, List<Boolean>> schedule = new HashMap<>();

    // UserDB 初始化
    public static void Initialized(){
        User user;
        for(int i = 0; i < User.User_Num; i++){
            user = new User(User.ReturnUserIDList(i), User.ReturnPasswordList(i));
            UserList.add(user);
        }

        schedule.put("一", new ArrayList<>(Collections.nCopies(10, false)));
        schedule.put("二", new ArrayList<>(Collections.nCopies(10, false)));
        schedule.put("三", new ArrayList<>(Collections.nCopies(10, false)));
        schedule.put("四", new ArrayList<>(Collections.nCopies(10, false)));
        schedule.put("五", new ArrayList<>(Collections.nCopies(10, false)));

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

//       System.out.println(this.schedule.entrySet());
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

    public Boolean addSchedule(String weekTime) {

        StringTokenizer splitWeek = new StringTokenizer(weekTime, "()");
        StringTokenizer splitSection = new StringTokenizer(splitWeek.nextToken(), "-");

        String week = splitWeek.nextToken();
        List<Integer> time = new ArrayList();
        Boolean canBeAdded = true;

        while(splitSection.hasMoreElements()) {
            int timeIndex = Integer.parseInt(splitSection.nextToken());
            time.add(timeIndex);

            if (this.schedule.get(week).get(timeIndex) == true) {
                canBeAdded = false;
                break;
            }
        }

//        System.out.println(time.size());

        if (time.size() == 2 && canBeAdded == true) {
            for (int i = time.get(0); i <= time.get(1); i++) {

                this.schedule.get(week).set(i, true);

            }
        }
        else if (time.size() == 1 && canBeAdded == true) {
            this.schedule.get(week).set(time.get(0), true);
        }


//        if (canBeAdded == true) {
//            for (Integer timeIndex: time) {
//
//                this.schedule.get(week).set(timeIndex, true);
//            }
//        }

//        System.out.println(time);
//        System.out.println(this.schedule);

        return canBeAdded;

    }

    public void delSchedule(String weekTime) {
        StringTokenizer splitWeek = new StringTokenizer(weekTime, "()");
        StringTokenizer splitSection = new StringTokenizer(splitWeek.nextToken(), "-");

        String week = splitWeek.nextToken();

        while(splitSection.hasMoreElements()) {
            int timeIndex = Integer.parseInt(splitSection.nextToken());

            this.schedule.get(week).set(timeIndex, false);
        }
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
