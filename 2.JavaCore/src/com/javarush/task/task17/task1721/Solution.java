package com.javarush.task.task17.task1721;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/*
Транзакционность
Сделать метод joinData транзакционным, т.е. если произошел сбой, то данные не должны быть изменены.
1. Считать с консоли 2 имени файла.
2. Считать построчно данные из файлов. Из первого файла - в allLines, из второго - в forRemoveLines.
В методе joinData:
3. Если список allLines содержит все строки из forRemoveLines, то удалить из списка allLines все строки, которые есть в forRemoveLines.
4. Если условие из п.3 не выполнено, то:
4.1. очистить allLines от данных
4.2. выбросить исключение CorruptedDataException
Метод joinData должен вызываться в main. Все исключения обработайте в методе main.
Не забудь закрыть потоки.


Требования:
1. Класс Solution должен содержать public static поле allLines типа List<String>.
2. Класс Solution должен содержать public static поле forRemoveLines типа List<String>.
3. Класс Solution должен содержать public void метод joinData() который может бросать исключение CorruptedDataException.
4. Программа должна считывать c консоли имена двух файлов.
5. Программа должна считывать построчно данные из первого файла в список allLines.
6. Программа должна считывать построчно данные из второго файла в список forRemoveLines.
7. Метод joinData должен удалить в списке allLines все строки из списка forRemoveLines, если в allLines содержаться все строки из списка forRemoveLines.
8. Метод joinData должен очистить список allLines и выбросить исключение CorruptedDataException, если в allLines не содержаться все строки из списка forRemoveLines.
9. Метод joinData должен вызываться в main.
*/


public class Solution {
    public static List<String> allLines = new ArrayList<String>();
    public static List<String> forRemoveLines = new ArrayList<String>();

    public static void main(String[] args) throws IOException {
        Solution z = new Solution();

        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        String name = r.readLine();
        String name2 = r.readLine();
        r.close();


        FileInputStream read = new FileInputStream(name);
        BufferedReader x = new BufferedReader(new InputStreamReader(read));
        String s = x.readLine();

        while (s != null){
            allLines.add(s);
            s = x.readLine();
        }

        read = new FileInputStream(name2);
        x = new BufferedReader(new InputStreamReader(read));
        String s2 = x.readLine();


        while (s2 != null){
                forRemoveLines.add(s2);
                s2 = x.readLine();
        }

        x.close();
        z.joinData();
    }


    public void joinData() throws CorruptedDataException {
        int count = 0;
            for (String x: forRemoveLines) {
                for (String y: allLines) {
                    if (x.equals(y)){
                        count++;
                    }
                }
            }

        if (count == forRemoveLines.size()){
            for (String x: forRemoveLines) {
                allLines.remove(x);
            }
        }
        else{
           allLines.clear();
           throw new CorruptedDataException();

        }
    }
}

