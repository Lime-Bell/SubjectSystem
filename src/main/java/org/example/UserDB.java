package org.example;

import java.util.*;

public class UserDB {
    public static List<User> UserList = new ArrayList<>();

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
}
