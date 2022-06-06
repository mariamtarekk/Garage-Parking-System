package com.mhk;

import java.time.LocalTime;
import java.util.Vector;

public class GarageController {
    private ISearcher _search;

    GarageController(){};
    
    // Dummy parameter
    GarageController(String s){
        Garage garage = Garage.getInstance();
        try{
            if(garage.getConfiguration().getConfiguration().equals("BestFit")){
                _search = new BestFitSearcher();
            }
            else{
                _search = new FirstServedSearcher();
            }
        }catch(Exception e){
            LcdDisplay lcd =  LcdDisplay.getInstance();
            lcd.Display( "You need to Setup the garage first \n");
            lcd.functionality();
            return;
        }
    }

    public int searchForAvailableSlot(Vehicle vehicle){
         Garage garage = Garage.getInstance();
         Vector<Slot> slots = garage.getListOfSlots();
         try{
            int id = _search.searchForAvailableSlot(vehicle, slots);
            garage.setSlot(id, LocalTime.now(), vehicle);
            garage.incrementTotalNumberOfVehicle();
            return id;
         }
         catch (IllegalArgumentException e) {
           LcdDisplay lcd =  LcdDisplay.getInstance();
           lcd.Display(e.getMessage() + '\n');
           lcd.functionality();
        }
        return 0;
    }

    
    private int searchForVehicleID(String vehicleId){
        Garage garage = Garage.getInstance();
        Vector<Slot> slots = garage.getListOfSlots();
        for(int i = 0 ; i < slots.size() ; i++){
            if(!(slots.elementAt(i).getVehicle()==null)&&slots.elementAt(i).getVehicle().getVehicleID().equals(vehicleId)){
                return slots.elementAt(i).getSlotID();
            }
        }
        throw new IllegalArgumentException("No vehicle with this ID in the garage");
    } 

    public LocalTime removeVehicle(String id){
        try{
            int slotId = searchForVehicleID(id);
            Garage garage = Garage.getInstance();
            Vector<Slot> slots = garage.getListOfSlots();
            slots.elementAt(slotId).setVehicle(null);
            slots.elementAt(slotId).setOccupied();
            return slots.elementAt(slotId).getStartTime();
        }
        catch(IllegalArgumentException e){
            LcdDisplay lcd =  LcdDisplay.getInstance();
            lcd.Display(e.getMessage() + '\n');
        }
        return null;
    }

    public Vector<Slot> findAvailableSlots(){
        Garage garage = Garage.getInstance();
        Vector<Slot> slots = garage.getListOfSlots();
        
        // push tha avaialble slots in the vector
        Vector<Slot> avaialble = new Vector<Slot>();
        for(Slot slot : slots){
            if(slot.getOccupied() == false){
                avaialble.add(slot);
            }
        }
        return avaialble;
    }

}
