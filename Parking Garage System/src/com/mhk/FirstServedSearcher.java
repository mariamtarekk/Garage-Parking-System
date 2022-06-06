package com.mhk;

import java.util.Vector;

public class FirstServedSearcher implements ISearcher {

    @Override
    public int searchForAvailableSlot(Vehicle v, Vector<Slot> slots) {
        boolean check = false;
        for (Slot slot : slots) {
            if(slot.getDimensions().getDepth() >= v.getDimensions().getDepth() && slot.getDimensions().getWidth() >= v.getDimensions().getWidth()){
                check = true;
                if(!slot.getOccupied()){
                    return slot.getSlotID();
                }
            }
        }
        if(check){
            throw new IllegalArgumentException("No available slots in the garage ");
        }else{
            throw new IllegalArgumentException("No available slots for the dimension of this vehicle");
        }
    }

}
