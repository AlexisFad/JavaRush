package com.javarush.task.task27.task2712.statistic;


import com.javarush.task.task27.task2712.statistic.event.CookedOrderEventDataRow;
import com.javarush.task.task27.task2712.statistic.event.EventDataRow;
import com.javarush.task.task27.task2712.statistic.event.EventType;
import com.javarush.task.task27.task2712.statistic.event.VideoSelectedEventDataRow;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.*;

public class StatisticManager {
    private static volatile StatisticManager instance;
    private StatisticStorage statisticStorage = new StatisticStorage();

    private StatisticManager() {
    }

    public static StatisticManager getInstance() {
        StatisticManager localInstance = instance;
        if (localInstance == null) {
            synchronized (StatisticManager.class) {
                localInstance = instance;
                if (localInstance == null) {
                    instance = localInstance = new StatisticManager();
                }
            }
        }
        return localInstance;
    }

    public void register(EventDataRow data){
       statisticStorage.put(data);
    }

    public Map<Date,Long> makeAdData(){
        Map<Date,Long> adData = new TreeMap<>(Collections.reverseOrder());
        List<EventDataRow> eventDataRows = statisticStorage.storage.get(EventType.SELECTED_VIDEOS);

        for (EventDataRow eventDataRow: eventDataRows) {
            VideoSelectedEventDataRow videoSelect = (VideoSelectedEventDataRow) eventDataRow;
            Date date = convertToDate(convertToLocalDate(videoSelect.getDate()));

            if (!adData.containsKey(date)){
                adData.put(date,videoSelect.getAmount());
            }
            else {
                adData.put(date, adData.get(date)+videoSelect.getAmount());
            }
        }
        return adData;
    }

    public Map<Date,Map<String,Integer>> makeCookData(){
        Map<Date,Map<String,Integer>> cookData = new TreeMap<>(Collections.reverseOrder());
        List<EventDataRow> list = statisticStorage.storage.get(EventType.COOKED_ORDER);

        for (EventDataRow eventDataRow: list) {
            CookedOrderEventDataRow cookOrder = (CookedOrderEventDataRow) eventDataRow;
            Date date = convertToDate(convertToLocalDate(cookOrder.getDate()));
            int cookTime = cookOrder.getTime() / 60;
            String cookName = cookOrder.getCookName();

            if (!cookData.containsKey(date)){
                Map<String, Integer> map = new HashMap<>();
                map.put(cookName,cookTime);
                cookData.put(date,map);
            }
            else{
                Map<String, Integer> map = cookData.get(date);
                if(!map.containsKey(cookName)) map.put(cookName, cookTime);
                else map.put(cookName,map.get(cookName)+cookTime);
            }
        }
        return cookData;
    }

    private class StatisticStorage{
        private Map<EventType, List<EventDataRow>> storage = new HashMap<>();

        private StatisticStorage() {
            for (EventType eventType:EventType.values()) {
                storage.put(eventType, new ArrayList<EventDataRow>());
            }
        }

      private void put(EventDataRow data){
          storage.get(data.getType()).add(data);
      }
    }

    public LocalDate convertToLocalDate(Date dateToConvert) {
        return dateToConvert.toInstant()
                .atZone(ZoneId.systemDefault())
                .toLocalDate();
    }

    public Date convertToDate(LocalDate dateToConvert) {
        return Date.from(dateToConvert.atStartOfDay()
                .atZone(ZoneId.systemDefault())
                .toInstant());
    }
}
