package com.javarush.task.task18.task1801;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/* 
Максимальный байт
*/

public class Solution {
    public static void main(String[] args) throws FileNotFoundException {
        byte[] mas = new byte[10000];
        byte[] res = null;
        int count = 0;
        try (FileInputStream fileInputStream = new FileInputStream(new Scanner(System.in).nextLine())) {
            while (fileInputStream.available() > 0){
                count = fileInputStream.read(mas);
            }

            res = Arrays.copyOf(mas,count-1);
            Arrays.sort(res);
            System.out.println(res[res.length - 1]);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
