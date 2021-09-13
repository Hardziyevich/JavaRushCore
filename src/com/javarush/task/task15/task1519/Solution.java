package com.javarush.task.task15.task1519;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

/* 
Разные методы для разных типов
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        //напиште тут ваш код
        ArrayList<String> arrayList = new ArrayList();
        Scanner scanner = new Scanner(System.in);
        String s;
        while (!(s = scanner.nextLine()).equals("exit")) {
            try {
                if (s.contains("."))
                    print(Double.parseDouble(s));
                else{
                    int i = Integer.parseInt(s);
                    if(i > 0 && i < 128)
                        print((short) i);
                    else
                        print(i);
                }
            } catch (Exception e) {
                print(s);
            }
        }

    }

    public static void print(Double value) {
        System.out.println("Это тип Double, значение " + value);
    }

    public static void print(String value) {
        System.out.println("Это тип String, значение " + value);
    }

    public static void print(short value) {
        System.out.println("Это тип short, значение " + value);
    }

    public static void print(Integer value) {
        System.out.println("Это тип Integer, значение " + value);
    }
}
