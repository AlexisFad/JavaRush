package com.javarush.task.task27.task2712;

import com.javarush.task.task27.task2712.ad.Advertisement;
import com.javarush.task.task27.task2712.ad.StatisticAdvertisementManager;
import com.javarush.task.task27.task2712.statistic.StatisticManager;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Map;

public class DirectorTablet {

   public void printAdvertisementProfit(){
      double totalCount = 0;
      SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MMM-yyyy - ", Locale.ENGLISH);

      for (Map.Entry<Date,Long> entry :StatisticManager.getInstance().makeAdData().entrySet()) {
         double amount = (double) entry.getValue()/100;
         ConsoleHelper.writeMessage(dateFormat.format(entry.getKey()) + String.format("%.2f",amount));

         totalCount += amount;
      }
      ConsoleHelper.writeMessage(String.format("Total - %.2f", totalCount));
   }

   public void printCookWorkloading(){
      SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);
      Map<Date,Map<String,Integer>> data = StatisticManager.getInstance().makeCookData();

      for (Map.Entry<Date,Map<String,Integer>> entry: data.entrySet()) {
        ConsoleHelper.writeMessage(dateFormat.format(entry.getKey()));

         for (Map.Entry<String,Integer> entry1: entry.getValue().entrySet()) {
            ConsoleHelper.writeMessage(entry1.getKey() + " - " + entry1.getValue() + " min");
         }
         ConsoleHelper.writeMessage("");

      }
   }

   public void printActiveVideoSet(){
      for (Advertisement advertisement : StatisticAdvertisementManager.getInstance().activeVideoSet()) {
         ConsoleHelper.writeMessage(advertisement.getName() + " - " + advertisement.getHits());
      }
   }

   public void printArchivedVideoSet(){
      for (Advertisement advertisement : StatisticAdvertisementManager.getInstance().archivedVideoSet()) {
         ConsoleHelper.writeMessage(advertisement.getName());
      }
   }
}