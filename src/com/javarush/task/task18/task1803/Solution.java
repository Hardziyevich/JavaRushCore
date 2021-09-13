package com.javarush.task.task18.task1803;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.*;

/* 
Самые частые байты
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        int[] mas = new int[257];
        int max = 0;
        try(FileInputStream fileInputStream = new FileInputStream(new Scanner(System.in).nextLine())){
            while (fileInputStream.available() > 0){
                int i = fileInputStream.read();
                int temp = mas[i];
                mas[i] = ++temp;
            }
            /*for (int i = 0; i < mas.length; i++) {
                System.out.println(i+" = "+mas[i]);
            }*/
            for (int i = 0; i < mas.length; i++) {
                if(max < mas[i])
                    max = mas[i];
            }
            for (int i = 0; i < mas.length; i++) {
                if(mas[i] == max)
                    System.out.print(i+" ");
            }
        }
    }
}
