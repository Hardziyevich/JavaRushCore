package com.javarush.task.task19.task1914;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

/* 
Решаем пример
*/

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) {
        PrintStream console = System.out;

        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(byteArrayOutputStream);

        System.setOut(printStream);
        testString.printSomething();

        String[] s = byteArrayOutputStream.toString().split(" ");
        int result = 0;
        switch (s[1]){
            case "+":result = Integer.parseInt(s[0]) + Integer.parseInt(s[2]);break;
            case "-":result = Integer.parseInt(s[0]) - Integer.parseInt(s[2]);break;
            case "*":result = Integer.parseInt(s[0]) * Integer.parseInt(s[2]);break;
        }
        System.setOut(console);
        StringBuilder stringBuilder = new StringBuilder();
        for (String ss:
             s) {
            stringBuilder.append(ss+" ");
        }
        stringBuilder.append(result);

        System.out.println(stringBuilder.toString());
    }

    public static class TestString {
        public void printSomething() {
            System.out.println("3 + 6 = ");
        }
    }
}

