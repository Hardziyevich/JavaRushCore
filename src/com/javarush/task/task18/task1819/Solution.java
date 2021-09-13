package com.javarush.task.task18.task1819;

import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

/* 
Объединение файлов
*/

public class Solution {
    public static void main(String[] args) throws IOException{
        Scanner scanner = new Scanner(System.in);
        String s1 = scanner.nextLine();
        String s2 = scanner.nextLine();
        byte[] buf = null;
        FileInputStream fileInputStream1 = new FileInputStream(s1);
            buf= new byte[fileInputStream1.available()];
            while (fileInputStream1.available() > 0)
                fileInputStream1.read(buf);
            fileInputStream1.close();

        try (FileOutputStream fileOutputStream1 = new FileOutputStream(s1);
             FileInputStream fileInputStream2 = new FileInputStream(s2)){
            int startPoint = buf.length;
            buf = Arrays.copyOf(buf,startPoint+fileInputStream2.available());
            while (fileInputStream2.available() > 0)
                fileInputStream2.read(buf,startPoint,fileInputStream2.available());
            for (int i = startPoint; i < buf.length; i++) {
                fileOutputStream1.write(buf[i]);
            }
            for (int i = 0; i < startPoint; i++) {
                fileOutputStream1.write(buf[i]);
            }

        }

    }
}
