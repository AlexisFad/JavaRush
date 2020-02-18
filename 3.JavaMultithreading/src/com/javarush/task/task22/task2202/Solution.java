package com.javarush.task.task22.task2202;

/* 
Найти подстроку

Метод getPartOfString должен возвращать подстроку начиная с символа после 1-го пробела и до конца слова,
которое следует после 4-го пробела.

Пример:
"JavaRush - лучший сервис обучения Java."

Результат:
"- лучший сервис обучения"

Пример:
"Амиго и Диего лучшие друзья!"

Результат:
"и Диего лучшие друзья!"

На некорректные данные бросить исключение TooShortStringException (сделать исключением).


Требования:
1. Класс TooShortStringException должен быть потомком класса RuntimeException.
2. Метод getPartOfString должен принимать строку в качестве параметра.
3. В случае, если в метод getPartOfString были переданы некорректные данные, должно возникнуть исключение TooShortStringException.
4. Метод getPartOfString должен возвращать подстроку начиная с символа после 1-го пробела и до конца слова, которое следует после 4-го пробела.
*/

public class Solution {
    public static void main(String[] args) {
        System.out.println(getPartOfString("Амиго и Диего лучшие друзья!"));
        System.out.println(getPartOfString("JavaRush - лучший сервис обучения Java."));
        System.out.println(getPartOfString("Моя задача не работает, как требует условие"));
        System.out.println(getPartOfString("Тесты для слабаков"));
        System.out.println(getPartOfString("День числа пи — неофициальный праздник, который отмечается любителями математики 14 марта в 1:59:26 в честь математической константы — числа пи."));
        System.out.println(getPartOfString("День был отмечен в 1988 году в научно-популярном музее Эксплораториум"));

    }

    public static String getPartOfString(String string) {
        if (string == null) throw new TooShortStringException();
            int firstIndex = string.indexOf(" ");
            int lastIndex =  firstIndex;

            for (int i = 0; i < 3; i++) {
                lastIndex = string.indexOf(" ", lastIndex + 1);
                if (lastIndex == -1) throw new TooShortStringException();
            }

            lastIndex = string.indexOf(" ", lastIndex + 1);

            if (lastIndex > 0) return string.substring(firstIndex + 1, lastIndex);
            else return string.substring(firstIndex+1);

    }

    public static class TooShortStringException extends RuntimeException{
    }
}
