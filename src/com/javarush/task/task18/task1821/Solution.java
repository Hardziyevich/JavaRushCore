package com.javarush.task.task18.task1821;

import java.io.*;
import java.util.Scanner;

/* 
Встречаемость символов
*/

public class Solution {
    public static void main(String[] args) throws IOException{
        String s = args[0];
        try(FileInputStream inputStreamReader = new FileInputStream(s)) {
            int[] mas = new int[255];
            while (inputStreamReader.available() > 0)
                mas[inputStreamReader.read()]++;
            for (int i = 0; i < mas.length; i++) {
                if (mas[i] != 0)
                    System.out.println((char) i + " " + mas[i]);
            }
        }
    }
}
