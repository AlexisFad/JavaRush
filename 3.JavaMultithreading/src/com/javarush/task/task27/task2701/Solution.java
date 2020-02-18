package com.javarush.task.task27.task2701;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Избавляемся от меток
Избавьтесь от меток в методе isSubstringPresent сохранив логику.
Метод возвращает true, в случае если строка substring является подстрокой строки string, иначе false.
В коде должны отсутствовать операторы break и continue.


Требования:
1. Метод isSubstringPresent должен возвращать true, если строка substring является подстрокой строки string.
2. Метод isSubstringPresent должен возвращать false, если строка substring НЕ является подстрокой строки string.
3. В методе isSubstringPresent должны отсутствовать операторы break.
4. В методе isSubstringPresent должны отсутствовать операторы continue.
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String string = reader.readLine();
        String substring = reader.readLine();

        if (isSubstringPresent(substring, string)) {
            System.out.println("String: \n" + substring + "\nis present in the string: \n" + string);
        } else {
            System.out.println("String: \n" + substring + "\nis not present in the string: \n" + string);
        }
    }

    static boolean isSubstringPresent(String substring, String string) {
      return string.contains(substring);
    }
}

