package com.javarush.task.task19.task1907;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Считаем слово
*/

public class Solution {
    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileReader fileReader = new FileReader(reader.readLine());
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        int count = 0;
        while (bufferedReader.ready()){
            for (String ss:
                    bufferedReader.readLine().split("\\W")) {
                if (ss.equals("word"))
                    count++;
            }
        }

        System.out.println(count);
        reader.close();
        fileReader.close();
        bufferedReader.close();
    }
}
