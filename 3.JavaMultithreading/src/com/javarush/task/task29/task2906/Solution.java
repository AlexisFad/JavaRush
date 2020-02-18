package com.javarush.task.task29.task2906;

/* 
Особенности автобоксинга - 2
Исправь ошибку реализации, приводящую к NullPointerException, в методе getValue().
Читай доп. статью про особенности автобоксинга.


Требования:
1. Реализация метод getValue() должна использовать тернарный оператор.
2. Метод getValue() не должен кидать исключений при любых значениях параметров first и second.
3. Метод getValue() должен вернуть 100, если в него передать Boolean.TRUE и Boolean.TRUE.
4. Метод getValue() должен вернуть 200, если в него передать Boolean.FALSE и Boolean.TRUE.
5. Метод getValue() должен вернуть null, если в него передать Boolean.FALSE и Boolean.FALSE.
*/

public class Solution {
    public static void main(String[] args) {
        Integer a = getValue(Boolean.TRUE, Boolean.TRUE);   //100 expected
        Integer b = getValue(Boolean.FALSE, Boolean.TRUE);  //200 expected
        Integer c = getValue(Boolean.FALSE, Boolean.FALSE); //null expected

        System.out.println(a);
        System.out.println(b);
        System.out.println(c);
    }

    public static Integer getValue(boolean first, boolean second) {
        return first ? (Integer) 100 : second ? 200 : null;
    }
}
