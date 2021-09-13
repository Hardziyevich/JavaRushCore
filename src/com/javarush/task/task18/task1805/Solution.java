package com.javarush.task.task18.task1805;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

/* 
Сортировка байт
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        int[] mas = new int[255];
        int size = 0;
        int count = 0;
        try (FileInputStream fileInputStream = new FileInputStream(new Scanner(System.in).nextLine())){
            while (fileInputStream.available() > 0)
                mas[fileInputStream.read()]++;
        }
        for (int i = 0; i < mas.length; i++) {
            if(mas[i] != 0)
                size++;
        }

        int[] buff = new int[size];

        for (int i = 0; i < mas.length; i++) {
            if(mas[i] != 0){
                    buff[count++] = i;
            }
        }
        Arrays.sort(buff);
        for (int i = 0; i < size; i++) {
            System.out.print(buff[i]+ " ");
        }


    }
}
