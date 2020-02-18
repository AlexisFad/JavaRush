package com.javarush.task.task30.task3012;

/* 
Получи заданное число

Реализуй метод createExpression(int number).
Метод createExpression вызывается с одним параметром number. Этот параметр - число от 1 до 3000 включительно.
Нужно вывести арифметическое выражение, результатом которого является число number.
Можно использовать числа: 1, 3, 9, 27, 81, 243, 729, 2187 не более, чем по одному разу.
Можно использовать знаки: "+" и "-" любое количество раз.
Обрати внимание, что перед каждым числом в искомой строке обязательно должен быть знак плюс или минус.
Перед выражением выведи [переданное число] =. (Смотри примеры вывода ниже).

Пример1:
Переданное число:
74
Ожидаемый вывод:
74 = - 1 + 3 - 9 + 81

Пример2:
Переданное число:
1234
Ожидаемый вывод:
1234 = + 1 - 9 + 27 - 243 - 729 + 2187

При выводе выражения используй числа ТОЛЬКО В ВОЗРАСТАЮЩЕМ порядке!
Переданное число:
2
Ожидаемый вывод:
2 = - 1 + 3 //правильно
Ожидаемый вывод:
2 = + 3 - 1 //НЕ правильно
Метод main не участвует в тестировании.

Подсказка:
Почитай в интернете про троичную симметричную систему счисления.


Требования:
1. В начале строчки вывода должно быть расположено число, которое передано в метод createExpression в качестве параметра и знак "=".
2. В выражении можно использовать только числа: 1, 3, 9, 27, 81, 243, 729, 2187 не более, чем по одному разу.
3. В выражении можно использовать только знаки "+" и "-" любое количество раз.
4. Метод createExpression должен быть реализован согласно условию.
*/

import java.util.LinkedList;
import java.util.Queue;

public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.createExpression(74);
    }

    public void createExpression(int number) {
        System.out.printf("%d =%s", number, createPow(convertTernary(number)));
    }

    public Queue<Integer> convertTernary(int number) {
        Queue<Integer> queue = new LinkedList<>();
        while (number > 0) {
            if (number % 3 > 1) {
                queue.add(-1);
                number++;
            } else {
                queue.add(number % 3);
            }
            number /= 3;
        }
        return queue;
    }

    public String createPow(Queue<Integer> queue) {
        StringBuilder stringBuilder = new StringBuilder();
        int pow = 0;

        while (queue.size() > 0) {
            int i = queue.poll();
            if (i != 0) {
                if (i > 0) stringBuilder.append(" + ").append((int) (i * Math.pow(3, pow)));
                if (i < 0) stringBuilder.append(" - ").append((int) (i * Math.pow(3, pow)) * -1);
            }
            pow++;
        }
        return stringBuilder.toString();
    }
}