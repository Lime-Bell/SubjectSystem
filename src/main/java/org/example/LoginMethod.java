package org.example;

public class LoginMethod {

    public Boolean login(String id, String pw) {
//        UserDB user = new UserDB();
        String userid = id;
        String password = pw;

        // 假設輸入的id, pwd 存在 UserDB
        if (UserDB.isUser(userid, password)){
            UserDB user = new UserDB();
            user.setNowUser(userid);

//            System.out.println("Login Success");
            // 關閉現在的 window
//            frame.dispose();
            // 開啟主頁 window
//            AllInterface.ShowHome();

            return true;
        }
        else {
//            System.out.println("Send the wrong UserID or the Password !");
            return false;
        }
    }
}
