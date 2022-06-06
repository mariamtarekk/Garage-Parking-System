package com.mhk;

import java.time.LocalTime;

public class Reciept {
    public void displayRecipt(LocalTime startTime , LocalTime endTime , int fees , int enteredMoney , int restOfMoney , String id){
        System.out.println("\nThe Recipt of the vehicle Id " + id);
        System.out.println("Start Time of Parking : " + startTime );
        System.out.println("End Time of Parking : " + endTime);
        System.out.println("Total Fees of the parking : " + fees );
        System.out.println("Entered Money is : " + enteredMoney);
        System.out.println("The Rest Of The Money : " + restOfMoney);
        System.out.print('\n');
    }
}
