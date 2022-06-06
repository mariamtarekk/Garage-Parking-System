package com.mhk;

import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

public class Payment {
    public int checkMoney(int enteredMoney, int requiredMoney)  {
        int rest = 0;
        if (enteredMoney < requiredMoney) {
            throw new IllegalArgumentException("You need to enter more money");
        } else {
            rest = calculateRestOfTheMoney(enteredMoney, requiredMoney);

        }
        return rest;
    }

    private int calculateRestOfTheMoney(int enteredMoney, int requiredMoney){
        return enteredMoney - requiredMoney;
    }

    public int calculateTotalFees(LocalTime startTime , LocalTime endTime){
        long hours = startTime.until(endTime, ChronoUnit.HOURS);
        if(startTime.until(endTime, ChronoUnit.MINUTES)%60 >0){
            hours++;
        }
        int amountOfMoney = (int)(hours * 5);
        return amountOfMoney;
    }
}
