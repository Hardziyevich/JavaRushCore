package com.javarush.task.task20.task2002;

import java.io.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/* 
Читаем и пишем в файл: JavaRush
*/

public class Solution {
    public static void main(String[] args) {
        //you can find your_file_name.tmp in your TMP directory or adjust outputStream/inputStream according to your file's actual location
        //вы можете найти your_file_name.tmp в папке TMP или исправьте outputStream/inputStream в соответствии с путем к вашему реальному файлу
        try {
            //File yourFile = File.createTempFile("your_file_name", null);
            OutputStream outputStream = new FileOutputStream("C:1.txt");
            InputStream inputStream = new FileInputStream("C:1.txt");

            JavaRush javaRush = new JavaRush();
            //initialize users field for the javaRush object here - инициализируйте поле users для объекта javaRush тут
            User pasha = new User();
            pasha.setBirthDate(new Date());
            pasha.setCountry(User.Country.OTHER);
            pasha.setFirstName("Pasha");
            pasha.setLastName("Hard");
            pasha.setMale(true);
            System.out.println(pasha.getCountry().ordinal());
            System.out.println(User.Country.values()[pasha.getCountry().ordinal()]);
            javaRush.users.add(pasha);
            javaRush.save(outputStream);
            outputStream.flush();

            JavaRush loadedObject = new JavaRush();
            loadedObject.load(inputStream);
            User newpasha = loadedObject.users.get(0);
            System.out.println(pasha.equals(newpasha));
            //here check that the javaRush object is equal to the loadedObject object - проверьте тут, что javaRush и loadedObject равны

            outputStream.close();
            inputStream.close();

        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Oops, something is wrong with my file");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Oops, something is wrong with the save/load method");
        }
    }

    public static class JavaRush {
        public List<User> users = new ArrayList<>();

        public void save(OutputStream outputStream) throws Exception {
            //implement this method - реализуйте этот метод
            DataOutputStream dataOutputStream = new DataOutputStream(outputStream);
            for (User user :
                    users) {
                dataOutputStream.writeUTF(user.getFirstName());
                dataOutputStream.writeUTF(user.getLastName());
                dataOutputStream.writeBoolean(user.isMale());
                dataOutputStream.writeLong(user.getBirthDate().getTime());
                dataOutputStream.writeInt(user.getCountry().ordinal());
            }

        }

        public void load(InputStream inputStream) throws Exception {
            //implement this method - реализуйте этот метод
            DataInputStream dataInputStream = new DataInputStream(inputStream);
            while (dataInputStream.available() > 0) {
                User temp = new User();
                temp.setFirstName(dataInputStream.readUTF());
                temp.setLastName(dataInputStream.readUTF());
                temp.setMale(dataInputStream.readBoolean());
                temp.setBirthDate(new Date(dataInputStream.readLong()));
                temp.setCountry((User.Country.values()[dataInputStream.readInt()]));
                users.add(temp);
            }

        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            JavaRush javaRush = (JavaRush) o;

            return users != null ? users.equals(javaRush.users) : javaRush.users == null;

        }

        @Override
        public int hashCode() {
            return users != null ? users.hashCode() : 0;
        }
    }
}
