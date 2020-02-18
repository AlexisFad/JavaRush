package com.javarush.task.task25.task2504;

/*
Switch для нитей

Обработай список нитей в зависимости от состояния:
1. Если нить еще не запущена, то запусти ее.
2. Если нить в ожидании, то прерви ее.
3. Если нить работает, то проверь маркер isInterrupted.
4. Если нить прекратила работу, то выведи в консоль ее приоритет.
Используй switch.


Требования:
1. Метод processThreads принимает аргументом массив нитей.
2. Если переданная нить не запущена, нужно ее запустить.
3. Если переданная нить находится в ожидании, нужно ее прервать.
4. Если переданная нить работает, то нужно проверить маркер isInterrupted.
5. Если переданная нить завершила работу, нужно вывести в консоль ее приоритет.
6. Метод processThreads должен использовать оператор switch.

*/
public class Solution {
    public static void processThreads(Thread... threads) {
        //implement this method - реализуйте этот метод

        for (Thread t : threads) {

            switch (t.getState()) {
                case NEW: {
                    t.start();
                    break;
                }

                case TIMED_WAITING:
                case WAITING:
                case BLOCKED: {
                    t.interrupt();
                    break;
                }

                case RUNNABLE:{
                    t.isInterrupted();
                    break;
                }
                case TERMINATED:{
                    System.out.println(t.getPriority());
                    break;
                }

                }
            }

            }


    public static void main(String[] args) {

    }
}
