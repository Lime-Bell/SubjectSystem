package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

public class User {
    private String user_id;
    private String password;

    public User(String id, String password){
       this.user_id = id;
       this.password = password;
    }

    private static String[] UserIDList ={"joe", "amy"};
    private static String[] PasswordList = {"1234", "4321"};



    public static int User_Num = UserIDList.length;
    public static String ReturnUserIDList(int index){
        if(index < UserIDList.length){
            return UserIDList[index];
        }
        else {
            return "Wrong";
        }
    }
    // 回傳所有的密碼
    public static String ReturnPasswordList(int index) {
        if(index < PasswordList.length){
            return PasswordList[index];
        }
        else {
            return "Wrong";
        }
    }


    public String GetUserID(){
        return this.user_id;
    }

    public String GetPassword(){
        return this.password;
    }

}
