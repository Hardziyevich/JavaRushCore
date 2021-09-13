package com.javarush.task.task19.task1908;

import java.io.*;
import java.util.ArrayList;
import java.util.regex.Pattern;

/* 
Выделяем числа
*/

public class Solution {
    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader readerFile = new BufferedReader(new FileReader(reader.readLine()));
        BufferedWriter writerFile = new BufferedWriter(new FileWriter(reader.readLine()));
        Pattern pattern = Pattern.compile("\\b\\d+[\\s]");
        while (readerFile.ready()){
            String[] s = readerFile.readLine().split(" ");
            for (int i = 0; i < s.length; i++) {
                if(s[i].matches("\\b[0-9]+\\b")){
                    writerFile.write(s[i]+" ");
                }

            }
            writerFile.write("\r\n");
        }
        reader.close();
        readerFile.close();
        writerFile.close();
    }
}
