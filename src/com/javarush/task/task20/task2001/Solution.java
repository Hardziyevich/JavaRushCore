package com.javarush.task.task20.task2001;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* 
Читаем и пишем в файл: Human
*/

public class Solution {
    public static void main(String[] args) {
        //исправьте outputStream/inputStream в соответствии с путем к вашему реальному файлу
        try {
            //File your_file_name = File.createTempFile("C:1.txt", null);
            OutputStream outputStream = new FileOutputStream("C:10.txt");
            InputStream inputStream = new FileInputStream("C:10.txt");
            OutputStream outputStream1 = new FileOutputStream("C:1.txt");
            InputStream inputStream1 = new FileInputStream("C:1.txt");
            Human ivanov = new Human("Ivanov", new Asset("home", 999_999.99), new Asset("car", 2999.99));
            Human pavel = new Human("Pavel");
            ivanov.save(outputStream);
            outputStream.flush();
            pavel.save(outputStream1);
            outputStream1.flush();

            Human somePerson = new Human();
            Human testPasha = new Human();
            somePerson.load(inputStream);
            inputStream.close();
            testPasha.load(inputStream1);
            inputStream1.close();
            //check here that ivanov equals to somePerson - проверьте тут, что ivanov и somePerson равны
            System.out.println(ivanov.equals(somePerson));
            System.out.println(pavel.equals(testPasha));

        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Oops, something wrong with my file");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Oops, something wrong with save/load method");
        }
    }

    public static class Human {
        public String name;
        public List<Asset> assets = new ArrayList<>();

        public Human() {
        }

        public Human(String name, Asset... assets) {
            this.name = name;
            if (assets != null) {
                this.assets.addAll(Arrays.asList(assets));
            }
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Human human = (Human) o;

            if (name != null ? !name.equals(human.name) : human.name != null) return false;
            return assets != null ? assets.equals(human.assets) : human.assets == null;
        }

        @Override
        public int hashCode() {
            int result = name != null ? name.hashCode() : 0;
            result = 31 * result + (assets != null ? assets.hashCode() : 0);
            return result;
        }

        public void save(OutputStream outputStream) throws Exception {
            //implement this method - реализуйте этот метод
            DataOutputStream dataOutputStream = new DataOutputStream(outputStream);
            boolean isAsset = assets.isEmpty();
            dataOutputStream.writeBoolean(isAsset);
            dataOutputStream.writeUTF(name);
            if (!isAsset) {
                for (Asset asset :
                        assets) {
                    dataOutputStream.writeUTF(asset.getName());
                    dataOutputStream.writeDouble(asset.getPrice());
                }
            }

        }

        public void load(InputStream inputStream) throws Exception {
            //implement this method - реализуйте этот метод
            DataInputStream inputStream1 = new DataInputStream(new BufferedInputStream(inputStream));
            /*System.out.println(inputStream1.readBoolean());
            System.out.println(inputStream1.readUTF());*/
            boolean state = inputStream1.readBoolean();
            this.name = inputStream1.readUTF();
            while (inputStream1.available() > 0 && !state) {
                    assets.add(new Asset(inputStream1.readUTF(), inputStream1.readDouble()));
                /*System.out.println(inputStream1.readUTF());
                System.out.println(inputStream1.readDouble());*/
            }
        }

    }
}

