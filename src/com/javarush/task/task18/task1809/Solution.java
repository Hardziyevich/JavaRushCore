package com.javarush.task.task18.task1809;

import java.io.*;
import java.util.*;

/* 
Реверс файла
*/

public class Solution {
    public static void main(String[] args) throws IOException{
        try (FileInputStream fileInputStream = new FileInputStream(new Scanner(System.in).nextLine());
            FileOutputStream fileOutputStream = new FileOutputStream(new Scanner(System.in).nextLine())){
            byte[] input = new byte[fileInputStream.available()];
            fileInputStream.read(input);
            for (int i = input.length - 1; i >= 0 ; i--) {
                fileOutputStream.write(input[i]);
            }
        }
    }
}
