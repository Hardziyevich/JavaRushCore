package com.javarush.task.task18.task1802;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

/* 
Минимальный байт
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        byte[] mas = new byte[10000];
        byte[] res = null;
        int count = 0;
        try (FileInputStream fileInputStream = new FileInputStream(new Scanner(System.in).nextLine())) {
            while (fileInputStream.available() > 0){
                count = fileInputStream.read(mas);
            }

            res = Arrays.copyOf(mas,count-1);
            Arrays.sort(res);
            System.out.println(res[0]);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
