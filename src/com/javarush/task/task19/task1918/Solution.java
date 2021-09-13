package com.javarush.task.task19.task1918;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* 
Знакомство с тегами
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        List<String> stringList = new ArrayList<>();
        List<Integer> listIn = new ArrayList<>();
        List<Integer> listOut = new ArrayList<>();
        String tag = args[0];
        String tagIn = "<" + tag;
        String tagOut = "</" + tag + ">";
        int tempIn = 0;
        int tempOUt = 0;
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
             FileReader fileReader = new FileReader(bufferedReader.readLine());
             BufferedReader fileR = new BufferedReader(fileReader)) {
            while (fileR.ready()) {
                stringList.add(fileR.readLine());
            }
            StringBuilder stringBuilder = new StringBuilder();
            for (String ss : stringList) stringBuilder.append(ss);
            while (tempIn < stringBuilder.length()){
                tempIn = stringBuilder.toString().indexOf(tagIn,tempIn);
                if(tempIn == -1)
                    break;
                listIn.add(tempIn);
                tempIn++;
            }
            while (tempOUt < stringBuilder.length()){
                tempOUt = stringBuilder.toString().indexOf(tagOut,tempOUt);
                if(tempOUt == -1)
                    break;
                listOut.add(tempOUt);
                tempOUt++;
            }
            //System.out.println(stringBuilder);
            for (Integer s :listIn) System.out.print(s+" ");
            for (Integer s :listOut) System.out.print(s+" ");
            System.out.println();
            while (!listOut.isEmpty()) {
                if(listIn.size() > 1) {
                    if (listOut.get(0) < listIn.get(1)) {
                        System.out.println(stringBuilder.substring(listIn.get(0), listOut.get(0)+tagOut.length()));
                        listIn.remove(0);
                        listOut.remove(0);
                    }
                    else{
                        int temp = rec(listIn,listOut,1);
                        System.out.println(stringBuilder.substring(listIn.get(0),temp+tagOut.length()));
                        int index = listOut.indexOf(temp);
                        for (int i = 1; i <= index; i++) {
                            System.out.println(stringBuilder.substring(listIn.get(i),listOut.get(index-1)+tagOut.length()));
                        }
                        for (int i = index; i >= 0; i--) {
                            listIn.remove(i);
                            listOut.remove(i);
                        }
                    }

                }
                else {
                    System.out.println(stringBuilder.substring(listIn.get(0), listOut.get(0)+tagOut.length()));
                    listIn.remove(0);
                    listOut.remove(0);
                }

            }
        }
    }

    public static int rec(List<Integer> listIn, List<Integer> listOut,int index){
        int out = 0;
        if(listIn.size() > index+1) {
            if (listOut.get(index) < listIn.get(index + 1)) {
                out = listOut.get(index);
            } else {
                out = rec(listIn, listOut,index+1);
            }
        }
        else{
            out = listOut.get(index);
        }
        return out;
    }

}
