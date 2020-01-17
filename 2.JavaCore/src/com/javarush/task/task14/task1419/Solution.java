package com.javarush.task.task14.task1419;

import javax.activity.ActivityCompletedException;
import javax.crypto.AEADBadTagException;
import javax.security.auth.login.AccountException;
import java.nio.channels.AcceptPendingException;
import java.rmi.AlreadyBoundException;
import java.rmi.activation.ActivationException;
import java.security.acl.AclNotFoundException;
import java.util.ArrayList;
import java.util.List;

/* 
Нашествие исключений

Заполни список exceptions десятью(10) различными исключениями.
Первое исключение уже реализовано в методе initExceptions.


Требования:
1. Список exceptions должен содержать 10 элементов.
2. Все элементы списка exceptions должны быть исключениями(потомками класса Throwable).
3. Все элементы списка exceptions должны быть уникальны.
4. Метод initExceptions должен быть статическим.
*/

public class Solution {
    public static List<Exception> exceptions = new ArrayList<Exception>();

    public static void main(String[] args) {
        initExceptions();

        for (Exception exception : exceptions) {
            System.out.println(exception);
        }
    }

    private static void initExceptions() {   //the first exception
        try {
            float i = 1 / 0;

        } catch (Exception e) {
            exceptions.add(e);
            exceptions.add(new AEADBadTagException());
            exceptions.add(new ArrayIndexOutOfBoundsException());
            exceptions.add(new ArrayStoreException());
            exceptions.add(new AclNotFoundException());
            exceptions.add(new ActivationException());
            exceptions.add(new AlreadyBoundException());
            exceptions.add(new AcceptPendingException());
            exceptions.add(new AccountException());
            exceptions.add(new ActivityCompletedException());

        }

    }
}
