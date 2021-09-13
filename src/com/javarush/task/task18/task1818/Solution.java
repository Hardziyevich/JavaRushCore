package com.javarush.task.task18.task1818;

import java.io.*;
import java.util.Scanner;

/* 
Два в одном
*/

public class Solution {
    public static void main(String[] args) throws IOException{
        Scanner scanner = new Scanner(System.in);
        String first = scanner.nextLine();
        String second = scanner.nextLine();
        String third = scanner.nextLine();
        try(FileInputStream fileInputStream1 = new FileInputStream(second);
            FileInputStream fileInputStream2 = new FileInputStream(third);
            FileWriter writer = new FileWriter(first,true) ){
            while (fileInputStream1.available() > 0)
                writer.write(fileInputStream1.read());
            while (fileInputStream2.available() > 0)
                writer.write(fileInputStream2.read());
        }
    }
}
