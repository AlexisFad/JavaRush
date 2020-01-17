package com.javarush.task.task20.task2003;


import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/* 
Знакомство с properties

В методе fillInPropertiesMap считайте имя файла с консоли и заполни карту properties данными из файла.
Про .properties почитать тут - http://ru.wikipedia.org/wiki/.properties
Реализуй логику записи в файл и чтения из файла для карты properties.


Требования:
1. Метод fillInPropertiesMap должен считывать данные с консоли.
2. Метод fillInPropertiesMap должен создавать FileInputStream, передавая считанную строку в качестве параметра.
3. Метод fillInPropertiesMap должен вызывать метод load передавая только что созданный FileInputStream в качестве параметра.
4. Метод save должен сохранять карту properties в полученный в качестве параметра объект типа OutputStream.
5. Метод load должен восстанавливать состояние карты properties из полученного в качестве параметра объекта типа InputStream.
*/
public class Solution {
    public static Map<String, String> properties = new HashMap<>();

    public void fillInPropertiesMap() throws Exception {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream inputStream = new FileInputStream(r.readLine());
        load(inputStream);
        r.close();
    }

    public void save(OutputStream outputStream) throws Exception {
        if (properties.size() > 0){
            Properties properties1 = new Properties();
            for (Map.Entry<String, String> entry:properties.entrySet()) {
                properties1.setProperty(entry.getKey(),entry.getValue());
            }
            properties1.store(outputStream,""); {

            }
        }
        outputStream.close();
    }

    public void load(InputStream inputStream) throws Exception {
        Properties properties1 = new Properties();
        properties1.load(inputStream);
        Map<Object, Object> map = new HashMap<>(properties1);
        for (Map.Entry<Object, Object> entry:map.entrySet()) {
            properties.put((String) entry.getKey(),(String) entry.getValue());
        }
    }

    public static void main(String[] args) throws Exception {
        properties.put("dddd","dddd");
        properties.put("aaaa","aaaa");
        Solution x = new Solution();
        x.save(new FileOutputStream("/Users/Alex/Алексей/JavaRush/test/test.txt"));

        x.load(new FileInputStream("/Users/Alex/Алексей/JavaRush/test/test.txt"));
        System.out.println(properties);
    }
}