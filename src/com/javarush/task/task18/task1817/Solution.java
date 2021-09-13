package com.javarush.task.task18.task1817;

import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;

/* 
Пробелы
*/

public class Solution {
    public static void main(String[] args) throws IOException{
        int countSpace = 0;
        int countWithoutSpace = 0;
        try (FileInputStream fileInputStream = new FileInputStream(args[0])) {
            byte[] mas = new byte[255];
            while (fileInputStream.available() > 0)
                mas[fileInputStream.read()]++;
            for (int i = 0; i < mas.length; i++) {
                    countWithoutSpace += mas[i];
            }
            countSpace = mas[32];
            double d = (double) countSpace/countWithoutSpace *100;

            System.out.printf("%.2f",d );

        }
    }
}
