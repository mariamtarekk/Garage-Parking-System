package com.mhk;

import java.util.Vector;

public class CheckGarageForm {
    // Validate the form
    public void Validate(String config , int maxSlots , Dimensions dimension, Vector<Slot> slots ){
       checkConfig(config);
       checkNumberOfSlots(maxSlots); 
       checkDimensions(dimension);
       checkEachSlot(slots, maxSlots);
    }

    // check the dimension is positive or not
    private void checkDimensions(Dimensions dimensions){
        if (dimensions.getWidth() <= 0){
            throw new IllegalArgumentException("Width cannot be negative");
        }
        if(dimensions.getDepth() <= 0){
            throw new IllegalArgumentException("Depth cannot be negative");
        }
    }

    // check configuration bestfit or firstserved
    private void checkConfig(String config){
        if(!config.equals("BestFit")&&!config.equals("FirstServed")){
            throw new IllegalArgumentException("Invalid configuration ('BestFit' and 'FirstServed') only accepted");
        }
    }
    // check number of slots is non negative
    private void checkNumberOfSlots(int maxVehicles){
        if(maxVehicles <= 0){
            throw new IllegalArgumentException("Number of slots cannot be negative");
        }
    }

    // check the dimension of each slot is positve or not
    private void checkEachSlot(Vector<Slot>slots, int maxSlots){
        for(int i = 0 ; i < maxSlots ; i++){
            try{
                checkDimensions(slots.elementAt(i).getDimensions());
            }
            catch(IllegalArgumentException e){
                throw e;
            }
        }
    }
}
