package com.mhk;

import java.time.LocalTime;
import java.util.Vector;

// singelton
public class Garage {
    private static Garage _garage ;
    private Vector<Slot> _slots;
    private Dimensions _dimensions;
    private Configuration _configuration;
    private Income _income;
    private int _totalNumberOfSlots;
    private int _totalNumberOfVehicles;

    private Garage(){
        _dimensions = new Dimensions();
        _configuration = Configuration.getInstance();
        _totalNumberOfSlots = 0;
        _income = Income.getInstance();
        _totalNumberOfVehicles = 0;
        _slots = new Vector<Slot>(_totalNumberOfSlots);
    }

    public static Garage getInstance(){
        if(_garage == null){
            _garage = new Garage();
        }
        return _garage ;
    }

    public Vector<Slot> getListOfSlots() {
        return _slots;
    }

    public Configuration getConfiguration(){
        return _configuration;
    }
    
    public LocalTime getStartTimeOfSlot(int SlotID){
        return _slots.elementAt(SlotID).getStartTime();
    }

    public Dimensions getDimensions() {
        return _dimensions;
    }

    public Income getIncome() {
        return _income;
    }

    public int getTotalNumberOfVehicles() {
        return _totalNumberOfVehicles;
    }

    public void setSlots(Vector<Slot> slots) {
        for(Slot slot : slots){
            _slots.add(slot);
        }
	}

    public void setSlot(int slotId ,LocalTime localTime , Vehicle vehicle) {
        for (Slot slot : _slots) {
            if (slot.getSlotID() == slotId) {
                slot.setVehicle(vehicle);
                slot.setStartTime(localTime);
                slot.setOccupied();
                return;
            }
        }
    }

    public void setDimensionsOfGarage(Dimensions dimensions){
        this._dimensions = dimensions; 
    }

    public void setDimensionsOfSlot(int slotId,Dimensions dimensions){
        _slots.elementAt(slotId).setDimensions(dimensions);
    }

    public void setMaximumNumberofSlots(int num){
        _totalNumberOfSlots = num;
    }

    public void incrementTotalNumberOfVehicle(){
        _totalNumberOfVehicles++;
    }

	
    
}
