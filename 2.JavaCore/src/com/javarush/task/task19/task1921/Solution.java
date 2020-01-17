package com.javarush.task.task19.task1921;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/* 
Хуан Хуанович

В метод main первым параметром приходит имя файла.
В этом файле каждая строка имеет следующий вид:
имя день месяц год
где [имя] - может состоять из нескольких слов, разделенных пробелами, и имеет тип String.
[день] - int, [месяц] - int, [год] - int
данные разделены пробелами.

Заполнить список PEOPLE используя данные из файла.
Закрыть потоки.

Пример входного файла:
Иванов Иван Иванович 31 12 1987
Вася 15 5 2013


Требования:
1. Класс Solution должен содержать публичную константу PEOPLE типа List<Person>, которая должна быть сразу проинициализирована.
2. Программа НЕ должна считывать данные с консоли.
3. Программа должна считывать содержимое файла (используй FileReader).
4. Поток чтения из файла (FileReader) должен быть закрыт.
5. Программа должна заполнить список PEOPLE данными из файла.
6. Программа должна правильно работать с двойными именами, например Анна-Надежда.
*/

public class Solution {
    public static final List<Person> PEOPLE = new ArrayList<Person>();

    public static void main(String[] args) throws IOException, ParseException {
        FileReader reader = new FileReader(args[0]);
        BufferedReader reader1 = new BufferedReader(reader);

        String s = reader1.readLine();
        while (s !=null){
            String name = "";
            String date = "";

            for (String string: s.split(" ")) {
                if (string.matches("[0-9]*$")) date += string+" ";
                else name += string +" ";
            }
            SimpleDateFormat dataformat= new SimpleDateFormat("d M yyyy");
            Date dateBirthday = dataformat.parse(date);
            s = reader1.readLine();

            PEOPLE.add(new Person(name.substring(0,name.length()-1),dateBirthday));
        }
        reader.close();
        reader1.close();
        System.out.println(PEOPLE.get(0).getBirthDate() + PEOPLE.get(0).getName());

    }
}
