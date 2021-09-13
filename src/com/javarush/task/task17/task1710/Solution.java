package com.javarush.task.task17.task1710;

import javax.xml.crypto.Data;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/* 
CRUD
*/

public class Solution {
    public static List<Person> allPeople = new ArrayList<Person>();

    static {
        allPeople.add(Person.createMale("Иванов Иванов", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public static void main(String[] args) {
        //напишите тут ваш код
        getCommand(args);
        /*String[] s = "-c Миронов м 15/04/1990".split(" ");
        getCommand(s);
        String[] ss = "-r 2".split(" ");
        getCommand(ss);

        String[] sss = "-d 2".split(" ");
        getCommand(sss);

        String[] sss = "-u 0".split(" ");
        getCommand(sss);*/


    }

    public static void getCommand(String[] command){
        switch (command[0]){
            case "-c":{
                addPeople(command);
            }break;
            case "-r":{printPeople(command);}break;
            case "-u":{updatePeople(command);}break;
            case "-d":{removePeople(command);}break;
        }
    }

    public static void addPeople(String[] command){
        String[] Data = command[3].split("/");
        int day = Integer.parseInt(Data[0]);
        int month = Integer.parseInt(Data[1]);
        int year = Integer.parseInt(Data[2]);
        Date data = new Date();
        data.setDate(day);
        data.setMonth(month-1);
        data.setYear(year-1900);
        Person person = null;
        if(command[2].equals("м")) {
            person = Person.createMale(command[1], data);
            allPeople.add(person);
        }
        else {
            person = Person.createFemale(command[1], data);
            allPeople.add(person);
        }

        System.out.println(allPeople.indexOf(person));
    }

    public static void printPeople(String[] command){
        Person person = allPeople.get(Integer.parseInt(command[1]));
        DateFormat df = new SimpleDateFormat("dd-MMM-yyyy",Locale.ENGLISH);
        String gender = null;
        if(person.getSex() == Sex.FEMALE)
            gender = "ж";
        else
            gender = "м";
        System.out.println(person.getName() + " "+ gender+ " " + df.format(person.getBirthDate()));
    }

    public static void removePeople(String[] command){
        Person person = allPeople.get(Integer.parseInt(command[1]));
        person.setName(null);
        person.setSex(null);
        person.setBirthDate(null);
        allPeople.set(Integer.parseInt(command[1]),person);
        System.out.println(person.getName()+ " " + person.getSex() + " "+ person.getBirthDate());
    }

    public static void updatePeople(String[] command){
        Person person = allPeople.get(Integer.parseInt(command[1]));
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy",Locale.ENGLISH);
        Date date = null;
        try {
            date = simpleDateFormat.parse(command[4]);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        if (person == null) {
            throw new IllegalArgumentException();
        }
        String gender = command[3];
        if(gender.equals("ж"))
            person.setSex(Sex.FEMALE);
        else
            person.setSex(Sex.MALE);
        person.setName(command[2]);
        person.setBirthDate(date);
        allPeople.set(Integer.parseInt(command[1]),person);

    }

}
