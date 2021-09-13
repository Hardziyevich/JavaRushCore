package com.javarush.task.task18.task1816;

import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/* 
Английские буквы
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        int count = 0;
        try (FileInputStream fileInputStream = new FileInputStream(args[0])) {
            byte[] mas = new byte[255];
            while (fileInputStream.available() > 0)
                mas[fileInputStream.read()]++;
            for (int i = 65; i <= 95; i++)
                count += mas[i];
            for (int i = 97; i <= 122; i++)
                count += mas[i];
            System.out.println(count);

        }
    }
}
