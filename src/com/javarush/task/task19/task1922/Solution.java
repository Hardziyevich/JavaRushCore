package com.javarush.task.task19.task1922;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* 
Ищем нужные строки
*/

public class Solution {
    public static List<String> words = new ArrayList<String>();

    static {
        words.add("файл");
        words.add("вид");
        words.add("В");
    }

    public static void main(String[] args) throws IOException{
        List<String> add = new ArrayList<>();
        try(BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
                BufferedReader buff = new BufferedReader(new FileReader(input.readLine()))){
            StringBuilder reg = new StringBuilder();
            for (int i = 0; i < words.size(); i++) {
                reg.append(words.get(i));
                reg.append(")");
                if(i != words.size() - 1) {
                    reg.append("|");
                    reg.append("(");
                }
            }
            reg.insert(0,"(");

            while (buff.ready()) {
                String s = buff.readLine();
                Matcher matcher = Pattern.compile("\\b"+reg.toString()+"\\b").matcher(s);
                int counter = 0;
                while (matcher.find()) {
                    counter++;
                }
                if(counter == 2)
                    System.out.println(s);
            }

        }
    }
}
