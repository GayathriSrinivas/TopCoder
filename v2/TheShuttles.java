package com.jasper.ccbp;

import org.apache.commons.lang.ArrayUtils;

import java.util.*;

/**
 * Created by gayathsr on 4/20/17.
 */
public class TheShuttles {


    public int getLeastCost(int[] cnt, int baseCost, int seatCost) {

        int maxPassengerCount = (int) Collections.max(Arrays.asList(ArrayUtils.toObject(cnt)));

        int minCost = Integer.MAX_VALUE;

        for (int numOfSeat = 1; numOfSeat <= maxPassengerCount; numOfSeat++) {
            int numOfShuttles = getNumOfShuttelesPerPassengerCount(numOfSeat, cnt);

            int cost = (baseCost + (numOfSeat * seatCost)) * numOfShuttles;

            if(cost < minCost) {
                minCost = cost;
            }
        }

        return minCost;
    }

    private int getNumOfShuttelesPerPassengerCount(int seatPerShuttle, int[] cnt) {

        int numOfShuttles = 0;

        for (int i = 0; i < cnt.length; i++) {
            numOfShuttles += Math.ceil(cnt[i] / (float) seatPerShuttle);
        }

        return numOfShuttles;
    }

    public static void main(String args[]) {
        TheShuttles theShuttles = new TheShuttles();
        int[] cnt = {9, 4};
        int base = 10;
        int seat = 5;
        System.out.println(theShuttles.getLeastCost(cnt, base, seat));
    }
}
