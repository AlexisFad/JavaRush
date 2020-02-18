package com.javarush.task.task27.task2712;

import com.javarush.task.task27.task2712.ad.AdvertisementManager;
import com.javarush.task.task27.task2712.ad.NoVideoAvailableException;
import com.javarush.task.task27.task2712.kitchen.Order;
import com.javarush.task.task27.task2712.kitchen.TestOrder;

import java.io.IOException;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Tablet{

    private final int number;
    static Logger logger = Logger.getLogger(Tablet.class.getName());
    private LinkedBlockingQueue queue;

    public Tablet(int number) {
        this.number = number;
    }

    public Order createOrder(){
        try{
             Order order = new Order(this);
            ordered(order);
            return order;
        }
        catch (IOException e){
            logger.severe("Console is unavailable.");
            return null;
        }
    }

    private void ordered(Order order) {
        if (!order.isEmpty()) {
            AdvertisementManager adManager = new AdvertisementManager(order.getTotalCookingTime() * 60);
            try {
                adManager.processVideos();
            } catch (NoVideoAvailableException ex) {
                logger.log(Level.INFO, "No video is available for the order " + order);
            }

            queue.offer(order);
        }
    }

    public void createTestOrder(){
        try{
            TestOrder order = new TestOrder(this);
            ordered(order);
        }
        catch (IOException e) {
            logger.severe("Console is unavailable.");
        }
    }

    public int getNumber() {
        return number;
    }

    @Override
    public String toString() {
        return "Tablet{" +
                "number=" + number +
                '}';
    }

    public void setQueue(LinkedBlockingQueue<Order> queue) {
        this.queue = queue;
    }
}