package com.javarush.task.task20.task2001;


import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
Читаем и пишем в файл: Human

Реализуй логику записи в файл и чтения из файла для класса Human.
Поле name в классе Human не может быть пустым.
Метод main реализован только для вас и не участвует в тестировании.


Требования:
1. Логика чтения/записи реализованная в методах save/load должна работать корректно в случае, если список assets пустой.
2. Логика чтения/записи реализованная в методах save/load должна работать корректно в случае, если поле name и список assets не пустые.
3. Класс Solution.Human не должен поддерживать интерфейс Serializable.
4. Класс Solution.Human должен быть публичным.
5. Класс Solution.Human не должен поддерживать интерфейс Externalizable.

*/
public class Solution {
    public static void main(String[] args) {

        try {
            File your_file_name = File.createTempFile("your_file_name", null);
            OutputStream outputStream = new FileOutputStream("/Users/Alex/Алексей/JavaRush/test/test.txt");
            InputStream inputStream = new FileInputStream("/Users/Alex/Алексей/JavaRush/test/test.txt");

            Human ivanov = new Human("Ivanov");
            ivanov.save(outputStream);
            outputStream.flush();


            Human somePerson = new Human();
            somePerson.load(inputStream);
            inputStream.close();
            System.out.println(ivanov.equals(somePerson));

        } catch (IOException e) {
            System.out.println("Oops, something wrong with my file");

        } catch (Exception e) {
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
            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream));
            String isAssets = assets.size()>0 ? "yes" : "no";
            bufferedWriter.write(isAssets +"\n");
            bufferedWriter.write(name +"\n");
            if (assets != null) {
                String s = "";
                for (Asset x : assets) {
                    s += x.getName() + " " + x.getPrice()+"::";
                }
                bufferedWriter.write(s +"\n");
            }
            bufferedWriter.close();
        }

        public void load(InputStream inputStream) throws Exception {
            BufferedReader x = new BufferedReader(new InputStreamReader(inputStream));
            String isAssets = x.readLine();
            name = x.readLine();
            if (isAssets.equals("yes")){

                for (String s: x.readLine().split("::")) {
           assets.add(new Asset(s.substring(0,s.indexOf(" ")),Double.parseDouble(s.substring(s.indexOf(" ")+1))));
                }
            }
            x.close();
        }
    }
}
