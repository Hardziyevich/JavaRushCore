package com.javarush.task.task19.task1910;

import java.io.*;
import java.util.ArrayList;

/* 
Пунктуация
*/

public class Solution {
    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader fileRead = new BufferedReader(new FileReader(reader.readLine()));
        BufferedWriter fileWrite = new BufferedWriter(new FileWriter(reader.readLine()));
        while (fileRead.ready()){
            fileWrite.write(fileRead.readLine().replaceAll("\\p{Punct}",""));
        }
        reader.close();
        fileRead.close();
        fileWrite.close();
    }
}
