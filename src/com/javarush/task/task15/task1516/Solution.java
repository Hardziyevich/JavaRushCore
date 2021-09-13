package com.javarush.task.task15.task1516;

/* 
Значения по умолчанию
*/

import java.lang.reflect.Field;

public class Solution {
    public int intVar;
    public double doubleVar ;
    public Double DoubleVar ;
    public boolean booleanVar ;
    public Object ObjectVar ;
    public Exception ExceptionVar ;
    public String StringVar ;
    public static void main(String[] args) {
        Solution solution = new Solution();
        Class<?> first = Solution.class;
        Field[] mas = first.getFields();
        for (Field a:
             mas) {
            try {
                System.out.println(a.get(solution));
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
    }
}
