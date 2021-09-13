package com.javarush.task.task16.task1603;

import java.util.ArrayList;
import java.util.List;

/* 
Список и нити
*/

public class Solution {
    public static volatile List<Thread> list = new ArrayList<Thread>(5);

    public static void main(String[] args) {
        //напишите тут ваш код
        SpecialThread[] specialThreads = new SpecialThread[5];
        Thread[] threads = new Thread[5];
        for (int i = 0; i < 5; i++) {
            specialThreads[i] = new SpecialThread();
            threads[i]= new Thread(specialThreads[i]);
            list.add(threads[i]);
        }

    }

    public static class SpecialThread implements Runnable {
        public void run() {
            System.out.println("it's a run method inside SpecialThread");
        }
    }
}
