package com.javarush.task.task27.task2712.ad;

public class Advertisement {
    private Object content;
    private String name;
    private long initialAmount;
    private int hits;
    private int duration;
    private long amountPerOneDisplaying;

    public Advertisement(Object content, String name, long initialAmount, int hits, int duration) {
        this.content = content;
        this.name = name;
        this.initialAmount = initialAmount;
        this.hits = hits;
        this.duration = duration;
        amountPerOneDisplaying = hits > 0 ? initialAmount / hits : 0;
    }

    public String getName() {
        return name;
    }

    public int getDuration() {
        return duration;
    }

    public long getAmountPerOneDisplaying() {
        return amountPerOneDisplaying;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public void setAmountPerOneDisplaying(long amountPerOneDisplaying) {
        this.amountPerOneDisplaying = amountPerOneDisplaying;
    }

    public void revalidate(){
        if (hits < 1) throw new NoVideoAvailableException();
        else hits--;
    }

    public int getHits() {
        return hits;
    }

    public long getAmountPerOneSec(){
        return  getAmountPerOneDisplaying()*1000 / getDuration();
    }

    @Override
    public String toString() {
        return String.format("%s is displaying... %d, %d",getName(),getAmountPerOneDisplaying(),getAmountPerOneSec());
    }
}

