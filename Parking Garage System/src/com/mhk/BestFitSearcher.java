package com.mhk;

import java.util.Vector;

public class BestFitSearcher implements ISearcher {

    @Override
    public int searchForAvailableSlot(Vehicle vehicle, Vector<Slot> slots) {
        boolean check = false;
        for(int i = 0 ; i < slots.size() ;i++){
            if(slots.elementAt(i).getDimensions().getWidth() >= vehicle.getDimensions().getWidth()
            && slots.elementAt(i).getDimensions().getDepth() >= vehicle.getDimensions().getDepth()){
                check = true;
                if(slots.elementAt(i).getOccupied() == false){
                    return slots.elementAt(i).getSlotID();
                }
            }
        }
        if(check){
            throw new IllegalArgumentException("No available slots in the garage");
        }else{
            throw new IllegalArgumentException("There is no  available slots for the dimension of this vehicle");
        }
    }
}

