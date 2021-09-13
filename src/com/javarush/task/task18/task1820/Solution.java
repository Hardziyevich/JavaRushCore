package com.javarush.task.task18.task1820;

import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

/* 
Округление чисел
*/

public class Solution {
    public static void main(String[] args) throws IOException{
        try (FileInputStream fileInputStream = new FileInputStream(new Scanner(System.in).nextLine());
        FileOutputStream fileOutputStream = new FileOutputStream(new Scanner(System.in).nextLine())){
            byte[] mas = new byte[fileInputStream.available()];
            fileInputStream.read(mas);
            StringBuilder stringBuilder = new StringBuilder();
            for (int i = 0; i < mas.length; i++) {
                stringBuilder.append((char) mas[i]);
            }
            String[] s = stringBuilder.toString().split(" ");
            StringBuilder stringBuilder1 = new StringBuilder();
            for (int i = 0; i < s.length; i++) {
                stringBuilder1.append(Math.round(Double.parseDouble(s[i])) + " ");
            }
            char[] chars = stringBuilder1.toString().toCharArray();
            byte[] bytes = new byte[chars.length];
            for (int i = 0; i < chars.length; i++) {
                bytes[i] = (byte) chars[i];
            }
            fileOutputStream.write(bytes);
        }
    }
}
