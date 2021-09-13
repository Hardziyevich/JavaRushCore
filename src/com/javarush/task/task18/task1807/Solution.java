package com.javarush.task.task18.task1807;

import java.io.*;
import java.util.Scanner;

/* 
Подсчет запятых
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        try (FileInputStream fileInputStream = new FileInputStream(new Scanner(System.in).nextLine())){
            int[] asciCounter = new int[255];
            while (fileInputStream.available() > 0){
                asciCounter[fileInputStream.read()]++;
            }
            System.out.println(asciCounter[44]);
        }
    }
}
