package com.mhk;

import java.util.Scanner;

public class VehicleForm {

    public Vehicle fillForm() {

        String modelName = enterModelName();

        String modelYear = enterModelYear();

        String ID = enterIdOfVehicle();

        Dimensions dimensions = enterDimensionsOfVehicle();

        confirm(modelName , modelYear , ID , dimensions);
        return(new Vehicle(ID, modelName , modelYear , dimensions));
    }

    private void confirm(String modelName , String modelYear , String ID , Dimensions dimensions){
        CheckVehicleForm check = new CheckVehicleForm();
        try{
           check.checkDimensions(dimensions);

        }
        catch(IllegalArgumentException e){
            LcdDisplay lcd =  LcdDisplay.getInstance();
            lcd.Display(e.getMessage());
            lcd.Display("Please Enter your data again ");
            fillForm();
        }
    }

    private Dimensions enterDimensionsOfVehicle(){
        Scanner input = new Scanner(System.in);

        System.out.print("Enter the width of the vehicle : ");
        double width = input.nextDouble();

        System.out.print("Enter the depth  of the vehicle : ");
        double depth = input.nextDouble();
        return new Dimensions(depth, width);
    }

    private String enterModelYear(){
        Scanner input = new Scanner(System.in);

        System.out.print("Enter the model year of the vehicle : ");
        String modelYear = input.nextLine();

        return modelYear;
    }

     private String enterModelName(){
        Scanner input = new Scanner(System.in);

        System.out.print("Enter the model name of the vehicle : ");
        String modelYear = input.nextLine();

        return modelYear;
    }

    private String enterIdOfVehicle(){
        Scanner input = new Scanner(System.in);

        System.out.print("Enter the ID of the vehicle : ");
        String ID = input.nextLine();

        return ID;
    }
    
}   
