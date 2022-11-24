package org.example;

import java.util.*;
import javax.swing.JFrame;


public class Main {
    public static void main(String[] args){
        // Initialized
        UserDB.Initialized();
        CourseDB.Initialized();

        //Login GUI
        AllInterface.ShowLoginInterface();
    }
}