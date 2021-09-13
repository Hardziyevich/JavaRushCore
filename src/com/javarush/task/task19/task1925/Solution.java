package com.javarush.task.task19.task1925;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* 
Длинные слова
*/

public class Solution {
    public static void main(String[] args)throws IOException{
        List<String> stringList = new ArrayList<>();
        try (BufferedReader buff = new BufferedReader(new FileReader(args[0]));
             BufferedWriter buffWritter = new BufferedWriter(new FileWriter(args[1]))){
            while (buff.ready()){
                stringList.add(buff.readLine());
            }
                StringBuilder stringBuilder = new StringBuilder();
                String[] strings = buff.readLine().split(" ");
                for (String s:
                     strings) {
                    if(s.toCharArray().length > 6) {
                        stringBuilder.append(s);
                        stringBuilder.append(",");
                    }
                }
                buffWritter.write(stringBuilder.toString());

        }
    }
}
