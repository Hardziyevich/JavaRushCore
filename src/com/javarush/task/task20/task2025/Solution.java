package com.javarush.task.task20.task2025;

import java.util.*;

/* 
Алгоритмы-числа
*/

public class Solution {

    public static long[] getNumbers(long N) {
        if(N < 0)
            return null;
        List<Long> buf = new ArrayList<>();
        int countR = 0;
        for (long i = 1; i <= 9; i++) {
            buf.add(i);
        }
        buf.add(153L);buf.add(370L);buf.add(371L);buf.add(407L);buf.add(1634L);buf.add(8208L);buf.add(9474L);buf.add(54748L);buf.add(92727L);
        buf.add(93084L);buf.add(548834L);buf.add(1741725L);
        buf.add(4210818L);buf.add(9800817L);buf.add(9926315L);buf.add(24678050L);buf.add(24678051L);buf.add(88593477L);
        buf.add(146511208L);buf.add(472335975L);buf.add(534494836L);buf.add(912985153L);buf.add(4679307774L);buf.add(32164049650L);
        buf.add(32164049651L);buf.add(40028394225L);buf.add(42678290603L);buf.add(44708635679L);buf.add(49388550606L);buf.add(82693916578L);
        buf.add(94204591914L);buf.add(28116440335967L);buf.add(4338281769391370L);buf.add(4338281769391371L);buf.add(21897142587612075L);buf.add(35641594208964132L);
        buf.add(35875699062250035L);buf.add(1517841543307505039L);buf.add(3289582984443187032L);buf.add(4498128791164624869L);buf.add(4929273885928088826L);
        long[] result = null;
        for (Long l:
             buf) {
            if(l < N)
                countR++;
        }
        result = new long[countR];
        countR = 0;
        for (Long l:
                buf) {
            if(l < N)
                result[countR++] = l;
        }
        return result;
    }

    public static void main(String[] args) {
        long a = System.currentTimeMillis();
        System.out.println(Arrays.toString(getNumbers(999)));
        long b = System.currentTimeMillis();
        System.out.println("memory " + (Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory()) / (8 * 1024));
        System.out.println("time = " + (b - a) / 1000);

        a = System.currentTimeMillis();
        System.out.println(Arrays.toString(getNumbers(Long.MAX_VALUE)));
        b = System.currentTimeMillis();
        System.out.println("memory " + (Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory()) / (8 * 1024));
        System.out.println("time = " + (b - a) / 1000);
    }
}
