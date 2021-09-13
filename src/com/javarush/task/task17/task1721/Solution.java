package com.javarush.task.task17.task1721;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/* 
Транзакционность
*/

public class Solution {
    public static List<String> allLines = new ArrayList<String>();
    public static List<String> forRemoveLines = new ArrayList<String>();

    public static void main(String[] args) {
        Solution solution = new Solution();
        try (
                FileReader fileReader1 = new FileReader(new Scanner(System.in).nextLine());
                FileReader fileReader2 = new FileReader(new Scanner(System.in).nextLine());
                BufferedReader bufferedReader1= new BufferedReader(fileReader1);
                BufferedReader bufferedReader2= new BufferedReader(fileReader2)){
            while (bufferedReader1.ready())
                allLines.add(bufferedReader1.readLine());
            while (bufferedReader2.ready())
                forRemoveLines.add(bufferedReader2.readLine());
            solution.joinData();

        }catch (CorruptedDataException e){
            System.out.println("CorruptedDataException");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void joinData() throws CorruptedDataException {
        if(allLines.containsAll(forRemoveLines)){
            for (String s:
                 forRemoveLines) {
                allLines.remove(s);
            }
        }
        else {
            allLines.clear();
            throw new CorruptedDataException();
        }
    }
}
