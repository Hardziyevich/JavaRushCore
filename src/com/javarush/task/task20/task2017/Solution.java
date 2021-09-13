package com.javarush.task.task20.task2017;

import java.io.*;

/* 
Десериализация
*/

public class Solution {
    public A getOriginalObject(ObjectInputStream objectStream){
        A temp = null;
        Object ob = null;
        try {
            ob = objectStream.readObject();
            if(ob instanceof A)
                temp = (A) ob;
        }catch (ClassNotFoundException e) {
            temp = null;
        } catch (IOException e) {
            temp = null;
        }
        return temp;
    }

    public class A implements Serializable{
    }

    public class B extends A {
        public B() {
            System.out.println("inside B");
        }
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {



    }
}
