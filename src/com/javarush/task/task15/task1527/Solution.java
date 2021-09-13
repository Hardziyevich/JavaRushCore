package com.javarush.task.task15.task1527;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

/* 
Парсер реквестов
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String url = reader.readLine();
        getString(url);
        //напишите тут ваш код
    }

    public static void alert(double value) {
        System.out.println("double: " + value);
    }

    public static void alert(String value) {
        System.out.println("String: " + value);
    }

    public static void getString(String s){
        String s1 = s.substring(s.indexOf("?")+1);
        StringTokenizer stringTokenizer = new StringTokenizer(s1,"&");
        ArrayList<String> out = new ArrayList<>();
        ArrayList<Double> doubles = new ArrayList<>();
        while (stringTokenizer.hasMoreTokens()){
           String test  = stringTokenizer.nextToken();
            if(test.indexOf("obj")!= -1) {
                String[] splitTest = test.split("=");
                out.add(splitTest[0]);
                doubles.add(Double.parseDouble(splitTest[1]));
            }
            else if(test.indexOf("=") != -1){
                out.add(test.substring(0,test.indexOf("=")));
            }
            else {
                out.add(test);
            }
        }

        for (String d:
                out) {
            System.out.print(d+" ");
        }
        System.out.println();
        for (Double d:
             doubles) {
            try {
                alert(d);
            } catch (Exception e) {
                alert(d);
            }
        }
    }
}
