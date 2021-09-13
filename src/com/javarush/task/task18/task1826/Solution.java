package com.javarush.task.task18.task1826;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/* 
Шифровка
*/

public class Solution {
    public static void main(String[] args) throws IOException{
        String s = args[0];
        if(!s.equals("-e") && !s.equals("-d"))return;
        try(FileInputStream fileInputStream = new FileInputStream(args[1]);
        FileOutputStream fileOutputStream = new FileOutputStream(args[2])){
            if(s.equals("-e")){
                while (fileInputStream.available() > 0)
                fileOutputStream.write(fileInputStream.read()-1);
            }
            else if(s.equals("-d")){
                while (fileInputStream.available() > 0)
                    fileOutputStream.write(fileInputStream.read()+1);
            }
        }
    }

}
