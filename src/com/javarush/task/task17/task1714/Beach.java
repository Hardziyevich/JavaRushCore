package com.javarush.task.task17.task1714;

/* 
Comparable
*/

public class Beach implements Comparable<Beach>{
    private String name;      //название
    private float distance;   //расстояние
    private int quality;    //качество

    public Beach(String name, float distance, int quality) {
        this.name = name;
        this.distance = distance;
        this.quality = quality;
    }

    public synchronized String getName() {
        return name;
    }

    public synchronized void setName(String name) {
        this.name = name;
    }

    public synchronized float getDistance() {
        return distance;
    }

    public synchronized void setDistance(float distance) {
        this.distance = distance;
    }

    public synchronized int getQuality() {
        return quality;
    }

    public synchronized void setQuality(int quality) {
        this.quality = quality;
    }

    public synchronized static void main(String[] args) {

    }

    @Override
    public synchronized int compareTo(Beach o) {
        int returnTemp = 0;
        int stateDistance = 0;
        int stateQuality = 0;
        if(this.getDistance() < o.getDistance())
            stateDistance = 1;
        else if(this.getDistance() > o.getDistance())
            stateDistance = -1;

        if(this.getQuality() > o.getQuality())
            stateQuality = 1;
        else if(this.getQuality() < o.getQuality())
            stateQuality = -1;

        if((stateQuality+stateDistance) < 0 )
            returnTemp = -1;
        else if((stateQuality+stateDistance) > 0)
            returnTemp = 1;
        else
            returnTemp = 0;


        return returnTemp;
    }
}
