package org.example;

public class LoginMethod {

    MyCourse myCourse;

    public Boolean login(String id, String pw) {
        myCourse = new MyCourse();

//        UserDB user = new UserDB();

        String userid = id;
        String password = pw;

        // 假設輸入的id, pwd 存在 UserDB

//        System.out.println(userid);

        if (myCourse.user.isUser(userid, password)){

            myCourse.user.setNowUser(userid);

            return true;
        }
        else {
            myCourse.user.setNowUser("");
//            System.out.println("Send the wrong UserID or the Password !");
            return false;
        }
    }
}
