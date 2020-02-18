package com.javarush.task.task26.task2612;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/* 
Весь мир играет комедию
Почитать про java.util.concurrent.locks.Lock на http://docs.oracle.com/ (там все есть в джавадоках!)
Написать реализацию метода someMethod():
1. попытаться захватить лок
1.1. если лок занят, то вызвать метод actionIfLockIsBusy()
1.2. если лок свободен, то:
1.2.1 вызвать метод actionIfLockIsFree()
1.2.2 отпустить лок при любых условиях, даже если actionIfLockIsFree() будет кидать исключение


Требования:
1. Класс Solution должен содержать приватное поле Lock lock.
2. Класс Solution должен содержать публичный метод actionIfLockIsFree().
3. Класс Solution должен содержать публичный метод actionIfLockIsBusy().
4. Метод someMethod() должен пытаться захватить лок.
5. Метод someMethod() должен вызвать метод actionIfLockIsBusy(), если лок занят.
6. Метод someMethod() должен вызвать метод actionIfLockIsFree(), если лок свободен.
7. Метод someMethod() должен отпускать лок при любых условиях, даже если actionIfLockIsFree() будет кидать исключение.
*/

public class Solution {
    private Lock lock = new ReentrantLock();

    public void someMethod() {
        // Implement the logic here. Use the lock field
        if (lock.tryLock()){
            try{
            actionIfLockIsFree();
            } finally {
                lock.unlock();
            }
        }
        else
                actionIfLockIsBusy();

    }

    public void actionIfLockIsFree() {
    }

    public void actionIfLockIsBusy() {
    }

}
