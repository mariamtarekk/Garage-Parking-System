package com.mhk;

public class Vehicle {
    private String _Id;
    private String _modelName;
    private String _modelYear;
    private Dimensions _dimensions;

    Vehicle(){
        this._Id = "";
        this._modelName = "";
        this._modelYear = "";
        this._dimensions = new Dimensions(0,0);
    };

    Vehicle(String Id, String modelName, String modelYear, Dimensions dimensions){
        this._Id = Id;
        this._modelName = modelName;
        this._modelYear = modelYear;
        this._dimensions = new Dimensions(dimensions.getDepth(), dimensions.getWidth());
    }
    
    public void setModelName(String modelName){
        this._modelName = modelName;
    }
    
    public String getModelName(){
        return _modelName;
    }

    public void setModelYear(String modelYear){
        this._modelYear = modelYear;
    }

    public String getModelYear(){
        return _modelYear;
    }

    public void setVehicleID(String Id){
        this._Id = Id;
    }

    public String getVehicleID(){
        return _Id;
    }

    public void setDimensions(Dimensions dimensions){
        this._dimensions = dimensions;
    }
    
    public Dimensions getDimensions(){
        return _dimensions;
    }
}
