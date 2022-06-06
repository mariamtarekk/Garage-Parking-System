package com.mhk;


public class Dimensions{
    private double _depth;
    private double _width;

    Dimensions(){
        this._depth = 0;
        this._width = 0;
    }

    Dimensions(double depth, double width){
        this._depth = depth;
        this._width = width;
    }

    public void setDepth(double depth){
        this._depth = depth;
    }

    public double getDepth(){
        return _depth;
    }

    public void setWidth(double width){
        this._width = width;
    }
    
    public double getWidth(){
        return _width;
    }
}
