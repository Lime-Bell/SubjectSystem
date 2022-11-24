package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
class AdapterDemo extends WindowAdapter {
    public void windowClosing(WindowEvent e) {
        System.exit(0);
    }
}
public class AllInterface {

//    private static int login_width = 350;
//    private static int login_high = 200;
    public static void ShowLoginInterface(){
        Login window = new Login();
//        window.OnShow();
    }



    public static void ShowHome(){
        Home window = new Home();
    }

    public static void CourseList(){

    }

    public static void Table(){

    }


}
