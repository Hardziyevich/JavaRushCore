package com.javarush.task.task19.task1919;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

/* 
Считаем зарплаты
*/

public class Solution {
    public static void main(String[] args) throws IOException{
        List<Double> list = new ArrayList<>();
        Map<String,Double> map = new HashMap<>();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(args[0]))){
            while (bufferedReader.ready()){
                String[] strings = bufferedReader.readLine().split(" ");
                if(map.containsKey((String)strings[0])){
                    Double d = map.get(strings[0]) + Double.parseDouble(strings[1]);
                    map.put(strings[0],d);
                }
                else{
                    map.put(strings[0],Double.parseDouble(strings[1]));
                }
            }
        }
        Double[] doubles = new Double[map.size()];
        int count = 0;
        for (Map.Entry<String,Double> aa:
                map.entrySet()) {
            doubles[count++] = aa.getValue();
        }
        Arrays.sort(doubles);

        for (int i = 0; i < doubles.length; i++) {
            for (Map.Entry<String,Double> aa:
                    map.entrySet()) {
                if(aa.getValue().equals(doubles[i]))
                    System.out.println(aa.getKey()+" "+aa.getValue());
            }
        }
    }
}
