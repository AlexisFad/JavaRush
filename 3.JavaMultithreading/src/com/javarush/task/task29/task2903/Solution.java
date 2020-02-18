package com.javarush.task.task29.task2903;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ThreadLocalRandom;

/* 
И еще раз рефакторинг

1. Исправить код в соответствии с Naming and Code Convention (Shift+F6 для рефакторинга)
2. Просмотри методы класса ConcurrentMap.
3. В строке "String previousEntry = null;" у concurrentMap вызови метод, который вставит пару (randomInt, text) только для ключа, которого нет в concurrentMap.
(Вызванный метод должен возвращать предыдущее значение либо null для новой пары.)


Требования:
1. Переименуй константу random в соответствии с Naming and Code Convention.
2. Объект, возвращаемый методом getRunnable(), должен быть экземпляром анонимного класса.
3. Метод run() внутри метода getRunnable() должен вызывать у concurrentMap метод, вставляющий пару (randomInt, text), если в concurrentMap еще нет пары со значением ключа randomInt.
4. Метод run() класса, возвращаемого методом getRunnable(), должен выводить текст на экран.
*/

public class Solution {
    public static final ThreadLocalRandom RANDOM = ThreadLocalRandom.current();

    public static void main(String[] args) {
        ConcurrentMap<Integer, String> concurrentMap = new ConcurrentHashMap<>();
        for (int i = 0; i < 100; i++) {
            new Thread(getRunnable(i, concurrentMap)).start();
        }
        sleepOneSecond();
    }

    private static void sleepOneSecond() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static Runnable getRunnable(final int i, final ConcurrentMap<Integer, String> concurrentMap) {
        return new Runnable() {
            @Override
            public void run() {
                final String name = "Thread #" + i;
                int randomInt = RANDOM.nextInt(20);
                String text = name + " вставил запись для " + randomInt;

                // previousEntry is null for new entries
                /* Instead of setting it to null, call concurrentMap.someMethod(randomInt, text) */
                String previousEntry = concurrentMap.putIfAbsent(randomInt, text);

                if (previousEntry != null) {
                    System.out.println(name + " хочет обновить " + randomInt + ", однако уже " + previousEntry);
                } else {
                    System.out.println(text);
                }
            }
        };
    }
}
