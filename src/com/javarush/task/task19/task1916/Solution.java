package com.javarush.task.task19.task1916;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* 
Отслеживаем изменения
*/

public class Solution {
    public static List<LineItem> lines = new ArrayList<LineItem>();
    public static List<String> firstFile = new ArrayList<>();
    public static List<String> secondFile = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        Type state = Type.SAME;
        String s1 = "", s2 = "";
        BufferedReader line = new BufferedReader(new InputStreamReader(System.in));
        FileReader fileReader1 = new FileReader(line.readLine());
        BufferedReader bufferedReader1 = new BufferedReader(fileReader1);
        FileReader fileReader2 = new FileReader(line.readLine());
        BufferedReader bufferedReader2 = new BufferedReader(fileReader2);

        line.close();

        while (bufferedReader1.ready())
            firstFile.add(bufferedReader1.readLine());
        while (bufferedReader2.ready())
            secondFile.add(bufferedReader2.readLine());
        bufferedReader1.close();
        bufferedReader2.close();
        fileReader1.close();
        fileReader2.close();

        while (firstFile.size() > 0) {
            s1 = firstFile.get(0);
            while (secondFile.size() > 0) {
                s2 = secondFile.get(0);
                if (s1.equals(s2)) {
                    state = Type.SAME;
                    lines.add(new LineItem(state, s1));
                    firstFile.remove(0);
                    secondFile.remove(0);
                    break;
                } else {
                    if (secondFile.size() > 1) {
                        s2 = secondFile.get(1);
                        if (s1.equals(s2)) {
                            s2 = secondFile.get(0);
                            state = Type.ADDED;
                            lines.add(new LineItem(state, s2));
                            secondFile.remove(0);
                        }
                        else {
                                state = Type.REMOVED;
                             lines.add(new LineItem(state, s1));
                             firstFile.remove(0);
                        }
                    } else {
                        state = Type.REMOVED;
                        lines.add(new LineItem(state, s1));
                        firstFile.remove(0);
                    }
                    break;
                }
            }
        }
        for (LineItem l : lines) {
            System.out.println(l.type + " " + l.line);
        }
    }


    public static enum Type {
        ADDED,        //добавлена новая строка
        REMOVED,      //удалена строка
        SAME          //без изменений
    }

    public static class LineItem {
        public Type type;
        public String line;

        public LineItem(Type type, String line) {
            this.type = type;
            this.line = line;
        }
    }
}

