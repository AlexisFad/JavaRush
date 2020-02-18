package com.javarush.task.task27.task2712.ad;

import com.javarush.task.task27.task2712.ConsoleHelper;
import com.javarush.task.task27.task2712.statistic.StatisticManager;
import com.javarush.task.task27.task2712.statistic.event.VideoSelectedEventDataRow;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class AdvertisementManager {
    private final AdvertisementStorage storage = AdvertisementStorage.getInstance();
    private int timeSeconds;

    public AdvertisementManager(int timeSeconds) {
        this.timeSeconds = timeSeconds;
    }

    public void processVideos() throws NoVideoAvailableException {
        if (storage.list().isEmpty()) throw new NoVideoAvailableException();

        VideoSelect videoSelect = new VideoSelect(timeSeconds);
        videoSelect.makeAllSets(getVideoList());
        List<Advertisement> advertisementsList = videoSelect.getBestAds();

        if(advertisementsList != null ) {
            List<Advertisement> advertisements = sortingVideoList(advertisementsList);

            StatisticManager.getInstance().register(new VideoSelectedEventDataRow(advertisements,
                    videoSelect.calcMaxAmount(advertisements), videoSelect.calcMaxTime(advertisements)));

            for (Advertisement advertisement : advertisements) {
                advertisement.revalidate();
                ConsoleHelper.writeMessage(advertisement.toString());
            }
        }
    }

    public List<Advertisement> getVideoList(){
       List<Advertisement> advertisementsList = new ArrayList<>();
        for (Advertisement ad:storage.list()) {
            if (ad.getHits() > 0) advertisementsList.add(ad);
        }
        return advertisementsList;
    }

    public List<Advertisement> sortingVideoList(List<Advertisement> advertisements){
        advertisements
                .sort(((Comparator<Advertisement>) (o1, o2) -> Double.compare(o2.getAmountPerOneDisplaying(), o1.getAmountPerOneDisplaying()))
                .thenComparingDouble(Advertisement::getAmountPerOneSec));

        return advertisements;
    }

     class VideoSelect{
        private List<Advertisement> bestAds = null;
        private int maxTime;
        private long bestAmount;

        public VideoSelect(int maxTime){
            this.maxTime = maxTime;
        }

        private int calcMaxTime(List<Advertisement> advertisements){
            int calcTime = 0;
            for (Advertisement ad: advertisements) {
               calcTime += ad.getDuration();
            }
            return calcTime;
        }

        private long calcMaxAmount(List<Advertisement> advertisements){
            long calcAmount = 0;
            for (Advertisement ad: advertisements) {
                calcAmount += ad.getAmountPerOneDisplaying();
            }
            return calcAmount;
        }

        private void checkVideo(List<Advertisement> advertisements){
            if(bestAds == null && calcMaxTime(advertisements) <= maxTime){
                    bestAds = advertisements;
                    bestAmount = calcMaxAmount(advertisements);
            }
            else {
                if (calcMaxTime(advertisements) <= maxTime && calcMaxAmount(advertisements) > bestAmount){
                    bestAds = advertisements;
                    bestAmount = calcMaxAmount(advertisements);
                }
                else if (calcMaxTime(advertisements) <= maxTime && calcMaxAmount(advertisements) == bestAmount){

                    if(calcMaxTime(advertisements) > calcMaxTime(bestAds)){
                        bestAds = advertisements;
                    }
                    else if(calcMaxTime(advertisements) == calcMaxTime(bestAds)){
                        if (advertisements.size() < bestAds.size()){
                            bestAds = advertisements;
                        }
                    }
                }
            }
        }

        public void makeAllSets(List<Advertisement> advertisements) {
            if (advertisements.size() > 0)
                checkVideo(advertisements);

            for (int i = 0; i < advertisements.size(); i++) {
                List<Advertisement> newSet = new ArrayList<>(advertisements);
                newSet.remove(i);
                makeAllSets(newSet);
            }
        }

        public List<Advertisement> getBestAds() {
            return bestAds;
        }
    }
}