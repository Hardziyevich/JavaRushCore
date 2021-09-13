package com.javarush.task.task19.task1923;

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* 
Слова с цифрами
*/

public class Solution {
    public static void main(String[] args) throws IOException{
        try (BufferedReader buff = new BufferedReader(new FileReader(args[0]));
             BufferedWriter buffWritter = new BufferedWriter(new FileWriter(args[1]))){
            while (buff.ready()){
                String[] s = buff.readLine().split(" ");
                for (String data:
                     s) {
                    if(!data.replaceAll("\\d","").equals(data))
                        buffWritter.write(data+" ");
                }
            }
        }
    }
}
