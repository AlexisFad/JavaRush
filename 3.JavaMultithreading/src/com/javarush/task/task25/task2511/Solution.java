package com.javarush.task.task25.task2511;

import java.util.TimerTask;

/* 
Вооружаемся до зубов!
Создай свой UncaughtExceptionHandler в виде локального класса внутри конструктора.
UncaughtExceptionHandler должен маскировать звездочками имя трэда и выводить в консоль описание возникшей ошибки.
"Thread-0" должно быть заменено на "********".
"Thread-4321" должно быть заменено на "***********".


Требования:
1. Определение класса Solution и его поля менять нельзя.
2. Конструктор Solution должен создавать свой UncaughtExceptionHandler, и сохранять его в поле handler.
3. Созданный UncaughtExceptionHandler должен выводить описание возникшей ошибки в консоль.
4. В описании ошибки имя трэда должно быть замаскировано символами "*".
*/

public class Solution extends TimerTask {
    protected TimerTask original;
    protected final Thread.UncaughtExceptionHandler handler;

    public Solution(TimerTask original) {
        if (original == null) {
            throw new NullPointerException();
        }
        this.original = original;
        this.handler = (t, e) -> System.out.println(e.getMessage().replaceAll(t.getName(),
                t.getName().replaceAll(".", "*")));
    }

    public void run() {
        try {
            original.run();
        } catch (Throwable cause) {
            Thread currentThread = Thread.currentThread();
            handler.uncaughtException(currentThread, new Exception("Blah " + currentThread.getName() + " blah-blah-blah", cause));
        }
    }

    public long scheduledExecutionTime() {
        return original.scheduledExecutionTime();
    }

    public boolean cancel() {
        return original.cancel();
    }

    public static void main(String[] args) {
        new Solution(new TimerTask() {
            @Override
            public void run() {
                throw new UnsupportedOperationException();
            }
        }).run();
    }
}