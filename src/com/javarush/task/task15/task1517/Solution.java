package com.javarush.task.task15.task1517;

/* 
Статики и исключения
*/

public class Solution {
    public static int A = 0;
    public static Solution solution;
    static {
        //throw an exception here - выбросьте эксепшн тут
        if(true)
            throw new ExceptionInInitializerError("Exception in thread \"main\" java.lang.ExceptionInInitializerError\n" +
                    "at java.lang.Class.forName0(Native Method)\n" +
                    "at java.lang.Class.forName(Class.java:186)\n" +
                    "at com.intellij.rt.execution.application.AppMain.main(AppMain.java:113)\n" +
                    "Caused by: java.lang.RuntimeException:\n" +
                    "at com.javarush.task.task15.task1517.Solution.<clinit>(Solution.java:22)");
    }

    public static int B = 5;

    public static void main(String[] args) {
        System.out.println(B);
    }
}
