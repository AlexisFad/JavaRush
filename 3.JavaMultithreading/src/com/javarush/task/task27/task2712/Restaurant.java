package com.javarush.task.task27.task2712;

import com.javarush.task.task27.task2712.kitchen.Cook;
import com.javarush.task.task27.task2712.kitchen.Order;
import com.javarush.task.task27.task2712.kitchen.Waiter;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.LinkedBlockingQueue;

/*
Ресторан
 */

public class Restaurant {
    private static final int ORDER_CREATING_INTERVAL = 100;
    private static final LinkedBlockingQueue<Order> orderQueue = new LinkedBlockingQueue<>();

    public static void main(String[] args) {
        Cook cook1 = new Cook("Валера");
        cook1.setQueue(orderQueue);
        Cook cook2 = new Cook("Игорь");
        cook2.setQueue(orderQueue);
        Thread cooker1 = new Thread(cook1);
        Thread cooker2 = new Thread(cook2);
        cooker1.start();
        cooker2.start();

        Waiter waiter = new Waiter();
        cook1.addObserver(waiter);
        cook2.addObserver(waiter);

        List<Tablet> tabletList = new ArrayList<>();
        for (int i = 1; i < 6 ; i++) {
            Tablet tablet = new Tablet(i);
            tablet.setQueue(orderQueue);
            tabletList.add(tablet);
        }

        RandomOrderGeneratorTask generatorTask = new RandomOrderGeneratorTask(tabletList,ORDER_CREATING_INTERVAL);
        Thread testTask = new Thread(generatorTask);
        testTask.start();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            ConsoleHelper.writeMessage(e.getMessage());
        }
        testTask.interrupt();

        DirectorTablet directorTablet = new DirectorTablet();
        directorTablet.printAdvertisementProfit();
        directorTablet.printCookWorkloading();
        directorTablet.printActiveVideoSet();
        directorTablet.printArchivedVideoSet();

    }
}

