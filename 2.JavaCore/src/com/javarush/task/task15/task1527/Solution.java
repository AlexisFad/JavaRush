package com.javarush.task.task15.task1527;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Парсер реквестов

Считать с консоли URL-ссылку.
Вывести на экран через пробел список всех параметров (Параметры идут после ? и разделяются &, например, lvl=15).
URL содержит минимум 1 параметр.
Выводить параметры нужно в той же последовательности, в которой они представлены в URL.
Если присутствует параметр obj, то передать его значение в нужный метод alert.
alert(double value) - для чисел (дробные числа разделяются точкой)
alert(String value) - для строк
Обрати внимание на то, что метод alert необходимо вызывать ПОСЛЕ вывода списка всех параметров на экран.

Пример 1

Ввод:
http://javarush.ru/alpha/index.html?lvl=15&view&name=Amigo

Вывод:
lvl view name

Пример 2

Ввод:
http://javarush.ru/alpha/index.html?obj=3.14&name=Amigo

Вывод:
obj name
double: 3.14


Требования:
1. Программа должна считывать с клавиатуры только одну строку.
2. Класс Solution не должен содержать статические поля.
3. Программа должна выводить данные на экран в соответствии с условием.
4. Программа должна вызывать метод alert с параметром double в случае, если значение параметра obj может быть корректно преобразовано в число типа double.
5. Программа должна вызывать метод alert с параметром String в случае, если значение параметра obj НЕ может быть корректно преобразовано в число типа double.
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        String s = r.readLine();
        ArrayList<String> list = new ArrayList<>();
        ArrayList<String> list2 = new ArrayList<>();


        for (String x: s.split("\\?")) {
            list.add(x);

        }
        list.remove(0);

        for(String x: list){
            for (String y: x.split("&")) {
                list2.add(y);
            }
        }

        for (int i = 0; i < list2.size(); i++) {
            if(list2.get(i).contains("obj")){
                System.out.print(("obj"));
                if(i< list2.size()-1){
                    System.out.print(" ");
                }
            }
            else if (list2.get(i).contains("=")){
                System.out.print((list2.get(i).substring(0,list2.get(i).indexOf("="))));
                if (i < list2.size()-1)
                System.out.print(" ");

            }
            else{
                System.out.print(list2.get(i));
                if (i < list2.size()-1)
                System.out.print(" ");}

        }

        for (int i = 0; i < list2.size(); i++) {
            if(list2.get(i).contains("obj")) {
                System.out.println("");
                try {
                    alert(Double.parseDouble(list2.get(i).substring(list2.get(i).indexOf("=") + 1)));
                } catch (Exception e) {
                    alert(list2.get(i).substring(list2.get(i).indexOf("=") + 1));
                }
            }

        }

    }

    public static void alert(double value) {
        System.out.println("double: " + value);
    }

    public static void alert(String value) {
        System.out.println("String: " + value);
    }
}




