package com.mhk;

import java.time.LocalTime;

public class Slot {
    private Dimensions _dimensions;
    private int _slotID;
    private Vehicle _vehicle;
    private boolean _occupied;
    private LocalTime _startTime;

    Slot(){
        _dimensions = new Dimensions(0,0);
        _slotID = 0;
        _vehicle = new Vehicle();
        _occupied = false;
        _startTime = LocalTime.of(0,0);
    }

    public void setDimensions(Dimensions dimensions) {
        this._dimensions= dimensions;
    }

    public Dimensions getDimensions() {
        return _dimensions;
    }

    public void setSlotID(int slotID) {
        this._slotID = slotID;
    }

    public int getSlotID() {
        return _slotID;
    }

    public void setStartTime(LocalTime startTime) {
        this._startTime = startTime;
    }

    public LocalTime getStartTime() {
        return this._startTime;
    }

    public void setOccupied() {
        if (_occupied) {
            _occupied = false;
        }else{
            _occupied = true;
        }
    }
    public boolean getOccupied() {
        return _occupied;
    }

    public void setVehicle(Vehicle vehicle) {
        this._vehicle= vehicle;
    }
    
    public Vehicle getVehicle() {
        return _vehicle;
    }
}
