package com.javarush.task.task20.task2009;

import java.io.*;

/* 
Как сериализовать static?
*/

public class Solution implements Serializable{
    public static class ClassWithStatic implements Serializable{
        public static String staticString = "This is a static test string";
        public int i;
        public int j;

        private void writeObject(ObjectOutputStream out) throws IOException {
            out.defaultWriteObject();
            out.writeObject(staticString);
        }

        private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException{
            in.defaultReadObject();
            staticString = (String) in.readObject();
        }
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        ClassWithStatic sol = new ClassWithStatic();
        sol.i = 5;
        sol.j = 6;
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("txt.txt"));
        objectOutputStream.writeObject(sol);
        objectOutputStream.close();

        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("txt.txt"));
        ClassWithStatic sol1 = (ClassWithStatic) objectInputStream.readObject();

        System.out.println(sol1.i);
    }
}
