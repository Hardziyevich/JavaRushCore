package com.javarush.task.task19.task1915;

import java.io.*;

/* 
Дублируем текст
*/

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) throws IOException{
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String s = bufferedReader.readLine();
        bufferedReader.close();
        PrintStream console = System.out;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(byteArrayOutputStream);

        System.setOut(printStream);
        testString.printSomething();

        String line = byteArrayOutputStream.toString();
        System.setOut(console);
        char[] chars = line.toCharArray();
        byte[] bytes = new byte[chars.length];
        for (int i = 0; i < bytes.length; i++) {
            bytes[i] = (byte) chars[i];
        }
        FileOutputStream fileOutputStream = new FileOutputStream(s);

        fileOutputStream.write(bytes);

        System.out.println(line);

        fileOutputStream.close();

    }

    public static class TestString {
        public void printSomething() {
            System.out.println("it's a text for testing");
        }
    }
}

