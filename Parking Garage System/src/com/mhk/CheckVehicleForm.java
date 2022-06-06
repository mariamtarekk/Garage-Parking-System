package com.mhk;

public class CheckVehicleForm {
    // check the dimension of the vehicle
    public void checkDimensions(Dimensions dimensions) {
        if (dimensions.getWidth() <= 0) {
            throw new IllegalArgumentException("Width of the Vehicle cannot be negative");
        }
        if (dimensions.getDepth() <= 0) {
            throw new IllegalArgumentException("Depth of the Vehicle cannot be negative");
        }
    }
}
