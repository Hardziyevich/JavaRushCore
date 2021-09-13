package com.javarush.task.task18.task1804;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

/* 
Самые редкие байты
*/

public class Solution {
    public static void main(String[] args) throws Exception {

        try(FileInputStream a = new FileInputStream(new Scanner(System.in).nextLine())){
            int min = Integer.MAX_VALUE;
            int[] mas = new int[255];
            while (a.available()>0){
                mas[a.read()]++;
            }
            for (int i = 0; i < mas.length; i++) {
                if(mas[i] != 0){
                    if(mas[i] < min)
                        min = mas[i];
                }
            }
            for (int i = 0; i < mas.length; i++) {
                if(mas[i] == min)
                    System.out.print(i+" ");
            }
        }
    }
}
