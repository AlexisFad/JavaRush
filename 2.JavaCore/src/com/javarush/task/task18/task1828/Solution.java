package com.javarush.task.task18.task1828;

/*
Прайсы 2

CrUD для таблицы внутри файла
Считать с консоли имя файла для операций CrUD

Программа запускается с одним из следующих наборов параметров:
-u id productName price quantity
-d id

Значения параметров:
где id - 8 символов
productName - название товара, 30 символов
price - цена, 8 символов
quantity - количество, 4 символа
-u - обновляет данные товара с заданным id
-d - производит физическое удаление товара с заданным id (все данные, которые относятся к переданному id)

В файле данные хранятся в следующей последовательности (без разделяющих пробелов):
id productName price quantity
Данные дополнены пробелами до их длины

Пример:
19847   Шорты пляжные синие           159.00  12
198479  Шорты пляжные черные с рисунко173.00  17
19847983Куртка для сноубордистов, разм10173.991234


Требования:
1. Программа должна считать имя файла для операций CrUD с консоли.
2. При запуске программы без параметров список товаров должен остаться неизменным.
3. При запуске программы с параметрами "-u id productName price quantity" должна обновится информация о товаре в файле.
4. При запуске программы с параметрами "-d id" строка товара с заданным id должна быть удалена из файла.
5. Созданные для файлов потоки должны быть закрыты.
*/

import java.io.*;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        String nameFile = r.readLine();
        r.close();

        if(args[0].length() > 0 && args[0].equals("-u")){
            int id = Integer.parseInt(args[1]);
            String upProduct = String.format("%-8.8s%-30.30s%-8.8s%-4.4s", Integer.toString(id), args[2], args[3], args[4]);
            UpdateString(nameFile,id,upProduct);
        }
        else if (args[0].length() > 0 && args[0].equals("-d")){
            int id = Integer.parseInt(args[1]);
            DeleteString(nameFile,id);
        }
    }
    public static void DeleteString(String file, int id) throws IOException {
        ArrayList<String> str = new ArrayList<>();
        FileInputStream inputStream = new FileInputStream(file);
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream,"UTF-8"));

        String priceString = reader.readLine();
        while (priceString != null) {
            if (!(Integer.parseInt((priceString.substring(0, 8)).replaceAll("\\D+", "")) == id)){
                str.add(priceString);
            }
            priceString = reader.readLine();
        }
        inputStream.close();
        reader.close();

        FileOutputStream  outputStream = new FileOutputStream(file);
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream,"UTF-8"));

        for (String s: str) {
            bufferedWriter.write(s +"\n");
        }

        bufferedWriter.close();
        outputStream.close();
    }

    public static void UpdateString(String file, int id, String upProduct) throws IOException {

        ArrayList<String> str = new ArrayList<>();
        FileInputStream inputStream = new FileInputStream(file);
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream,"UTF-8"));

        String priceString = reader.readLine();
        while (priceString != null) {
            if (!(Integer.parseInt((priceString.substring(0, 8)).replaceAll("\\D+", "")) == id)){
                str.add(priceString);
            }
            else{
                str.add(upProduct);
            }

            priceString = reader.readLine();
        }
        inputStream.close();
        reader.close();

        FileOutputStream  outputStream = new FileOutputStream(file);
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream,"UTF-8"));

        for (String s: str) {
            bufferedWriter.write(s +"\n");
        }

        bufferedWriter.close();
        outputStream.close();
    }
}
