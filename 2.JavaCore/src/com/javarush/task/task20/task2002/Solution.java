package com.javarush.task.task20.task2002;


import java.io.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/* 
Читаем и пишем в файл: JavaRush

Реализуйте логику записи в файл и чтения из файла для класса JavaRush.
Метод main реализован только для вас и не участвует в тестировании.


Требования:
1. Логика чтения/записи реализованная в методах save/load должна работать корректно в случае, если список users пустой.
2. Логика чтения/записи реализованная в методах save/load должна работать корректно в случае, если список users не пустой.
3. Класс Solution.JavaRush не должен поддерживать интерфейс Serializable.
4. Класс Solution.JavaRush должен быть публичным.
5. Класс Solution.JavaRush не должен поддерживать интерфейс Externalizable.
*/
public class Solution {
    public static void main(String[] args) {
        try {
            File yourFile = File.createTempFile("your_file_name", null);
            OutputStream outputStream = new FileOutputStream("/Users/Alex/Алексей/JavaRush/test/test.txt");
            InputStream inputStream = new FileInputStream("/Users/Alex/Алексей/JavaRush/test/test.txt");

            JavaRush javaRush = new JavaRush();

           javaRush.users.add(new User());
           javaRush.users.get(0).setMale(true);
           javaRush.users.get(0).setBirthDate(new Date(2323223232L));
           javaRush.users.get(0).setCountry(User.Country.RUSSIA);
           javaRush.users.get(0).setFirstName("Alexey Al");
           javaRush.users.get(0).setLastName("Fadeev");

           javaRush.users.add(0,new User());

            javaRush.users.get(0).setMale(true);
            javaRush.users.get(0).setBirthDate(new Date(2323223232L));
            javaRush.users.get(0).setCountry(User.Country.RUSSIA);
            javaRush.users.get(0).setFirstName("Alexeyo");
            javaRush.users.get(0).setLastName("Fadeev");

            javaRush.save(outputStream);

            outputStream.flush();

            JavaRush loadedObject = new JavaRush();
            loadedObject.load(inputStream);
            System.out.println(loadedObject.equals(javaRush));

            outputStream.close();
            inputStream.close();

        } catch (IOException e) {
            System.out.println("Oops, something is wrong with my file");
        } catch (Exception e) {
            System.out.println("Oops, something is wrong with the save/load method");
        }
    }

    public static class JavaRush {
        public List<User> users = new ArrayList<>();

        public void save(OutputStream outputStream) throws Exception {
           BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(outputStream));
           if (users.size() > 0){
            for (User x: users) {
                String s = String.format("%s:last_name:%s:isMale:%s:getCountry:%s:getTime:%d\n",x.getFirstName(),x.getLastName(),x.isMale(),x.getCountry().getDisplayName(),x.getBirthDate().getTime());
                bw.write(s);
            }
           }
            bw.close();
        }

        public void load(InputStream inputStream) throws Exception {
            BufferedReader r = new BufferedReader(new InputStreamReader(inputStream));
            String s = r.readLine();

            while (s != null){
                users.add(new User());
                users.get(users.size()-1).setFirstName(s.substring(0,s.indexOf(":last_name:")));
                users.get(users.size()-1).setLastName(s.substring(s.indexOf(":last_name:")+11,s.indexOf(":isMale")));
                users.get(users.size()-1).setMale(s.substring(s.indexOf(":isMale")+8,s.indexOf(":getCountry:")).equals("true"));
                if (s.substring(s.indexOf(":getCountry:")+12,s.indexOf(":getTime:")).equals("Russia")) users.get(users.size()-1).setCountry(User.Country.RUSSIA);
                else if (s.substring(s.indexOf(":getCountry:")+12,s.indexOf(":getTime:")).equals("Ukraine")) users.get(users.size()-1).setCountry(User.Country.UKRAINE);
                else users.get(users.size()-1).setCountry(User.Country.OTHER);
                users.get(users.size()-1).setBirthDate(new Date(Long.parseLong(s.substring(s.indexOf(":getTime:")+9))));

                s = r.readLine();
            }
            r.close();

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
