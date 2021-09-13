package com.javarush.task.task18.task1808;

import java.io.*;
import java.util.Scanner;

/* 
Разделение файла
*/

public class Solution {
    public static void main(String[] args) throws IOException{
        try(FileInputStream fileInputStream = new FileInputStream(new Scanner(System.in).nextLine());
        FileOutputStream fileOutputStream1 = new FileOutputStream(new Scanner(System.in).nextLine());
        FileOutputStream fileOutputStream2 = new FileOutputStream(new Scanner(System.in).nextLine())){
            byte[] buff = new byte[fileInputStream.available()];
            byte[] buff1 = buff;
            fileInputStream.read(buff);
            if(buff.length%2 == 1){
                fileOutputStream1.write(buff,0, (buff.length/2) +1);
                fileOutputStream2.write(buff1,(buff.length/2) +1, buff.length/2);
            }
            else{
                fileOutputStream1.write(buff,0, buff.length/2);
                fileOutputStream2.write(buff,buff.length/2, buff.length/2);
            }

        }
    }
}
