package com.javarush.task.task27.task2712.ad;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class StatisticAdvertisementManager {
    private static volatile StatisticAdvertisementManager instance;
    private AdvertisementStorage advertisementStorage =  AdvertisementStorage.getInstance();

    private StatisticAdvertisementManager(){
    }

    public static StatisticAdvertisementManager getInstance() {
        StatisticAdvertisementManager localInstance = instance;
        if (localInstance == null) {
            synchronized (StatisticAdvertisementManager.class) {
                localInstance = instance;
                if (localInstance == null) {
                    instance = localInstance = new StatisticAdvertisementManager();
                }
            }
        }
        return localInstance;
    }

    public List<Advertisement> activeVideoSet(){
        List<Advertisement> activeVideoSet = new ArrayList<>();
        for (Advertisement advertisement : advertisementStorage.list()) {
            if(advertisement.getHits() > 0) activeVideoSet.add(advertisement);
        }
        sortVideos(activeVideoSet);
        return activeVideoSet;
    }

    public List<Advertisement> archivedVideoSet(){
        List<Advertisement> archivedVideoSet = new ArrayList<>();
        for (Advertisement advertisement : advertisementStorage.list()) {
            if(advertisement.getHits() < 1) archivedVideoSet.add(advertisement);
        }
        sortVideos(archivedVideoSet);
        return archivedVideoSet;
    }

    public List<Advertisement> sortVideos(List<Advertisement> advertisements){
        advertisements.sort(new Comparator<Advertisement>() {
            @Override
            public int compare(Advertisement o1, Advertisement o2) {
                return  o1.getName().compareToIgnoreCase(o2.getName());
            }
        });

        return advertisements;
    }
}
