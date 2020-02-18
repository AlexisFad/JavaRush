package com.javarush.task.task27.task2708;

import java.util.Set;

/* 
Убираем deadLock используя открытые вызовы
Синхронизированные методы, которые вызывают внутри себя синхронизированные методы других классов, приводят к dead-lock-у.
1. Перенесите синхронизацию с метода в синхронизированный блок, куда поместите лишь необходимые части кода.
2. Уберите избыточную синхронизацию методов.
3. В стеке вызова методов не должно быть перекрестной синхронизации, т.е. такого synchronizedMethodAClass().synchronizedMethodBClass().synchronizedMethodAClass()

Этот способ избавления от дэдлока называется "открытые вызовы", о нем читайте в дополнительном материале к лекции.
Метод main не участвует в тестировании.


Требования:
1. Должна быть обеспечена возможность корректного взаимодействия объектов типа Apartment и RealEstate без возникновения взаимных блокировок.
2. Метод up класса RealEstate должен быть объявлен без модификатора synchronized.
3. Метод revalidate класса RealEstate должен быть объявлен без модификатора synchronized.
4. Метод revalidate класса Apartment должен быть объявлен без модификатора synchronized.
5. Метод revalidate класса RealEstate должен содержать один synchronized блок.
6. В synchronized блоке метода revalidate класса RealEstate должен содержаться вызов метода revalidate на объекте apartment с параметром randomValue.
*/

public class Solution {
    public static void main(String[] args) {
        final long deadline = System.currentTimeMillis() + 5000; //waiting for 5 sec

        final RealEstate realEstate = new RealEstate();
        Set<Apartment> allApartments = realEstate.getAllApartments();

        final Apartment[] apartments = allApartments.toArray(new Apartment[allApartments.size()]);

        for (int i = 0; i < 20; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int i = 0; i < 10; i++) {
                        realEstate.revalidate();
                    }
                }
            }, "RealEstateThread" + i).start();

            new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int i = 0; i < apartments.length; i++) {
                        apartments[i].revalidate(true);
                    }
                }
            }, "ApartmentThread" + i).start();
        }

        Thread deamonThread = new Thread(new Runnable() {
            @Override
            public void run() {
                while (System.currentTimeMillis() < deadline)
                    try {
                        Thread.sleep(2);
                    } catch (InterruptedException ignored) {
                    }
                System.out.println("Deadlock occurred");
            }
        });
        deamonThread.setDaemon(true);
        deamonThread.start();
    }
}