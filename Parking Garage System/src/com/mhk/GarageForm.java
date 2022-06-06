package com.mhk;

import java.util.Scanner;
import java.util.Vector;


public class GarageForm  {
    
    public void fillForm(){
        Dimensions dimensionsOfGarage = enterDimensionsOfGarage();
        int numberOfSlots = enterMaximumNumberofSlots();
        Vector<Slot> slots = new Vector<Slot>(numberOfSlots);
        for(int i = 0 ; i < numberOfSlots ; i++){
            Dimensions dimensions = enterDimensionsOfEachSlot(i + 1);
            slots.add(new Slot());
            slots.elementAt(i).setSlotID(i);
            slots.elementAt(i).setDimensions(dimensions);
        }

        String config = enterConfiguratino();
        confirm(config, numberOfSlots, dimensionsOfGarage,  slots);

    }

    private void confirm(String configuration , int numberOfSlots , Dimensions dimensions, Vector<Slot> slots ){
        CheckGarageForm check  = new CheckGarageForm();
        try{
            check.Validate(configuration, numberOfSlots, dimensions , slots);
            Garage garage = Garage.getInstance();
            //Create object Garage 
            garage.setDimensionsOfGarage(dimensions);

            //here
            garage.setMaximumNumberofSlots(numberOfSlots);
            garage.getConfiguration().setConfig(configuration);
            if(configuration.equals("BestFit") ){
                slots.sort(SlotComparator.slotComparator);
            }
            garage.setSlots(slots);
           

        }
        catch(IllegalArgumentException e){
            LcdDisplay lcd =  LcdDisplay.getInstance();
            lcd.Display(e.getMessage());
            lcd.Display("Please Enter your data again ");
            fillForm();
        }
        
    }

    private String enterConfiguratino(){
        Scanner input = new Scanner(System.in);
        System.out.print("Please Enter the configuration of the garage : ");
        String config = input.nextLine();
        return config;
    }

    private int enterMaximumNumberofSlots(){
        Scanner input = new Scanner(System.in);
        System.out.print("Please Enter the Maximum Number Of Slots : ");
        int numberOfSlots = input.nextInt();

        return numberOfSlots;
    }

    private Dimensions enterDimensionsOfGarage(){
        Scanner input = new Scanner(System.in);
        System.out.print("Please Enter the Dimensions of the garage width & depth : ");
        double width = input.nextDouble();
        double depth = input.nextDouble();
        Dimensions dimensions = new Dimensions(depth, width);
        return dimensions;
    }

    private Dimensions enterDimensionsOfEachSlot(int id){
        Scanner input = new Scanner(System.in);
        System.out.print("Please Enter the Dimensions of the Slot " + id + " width & dipth : ");
        double width = input.nextDouble();
        double depth = input.nextDouble();
        return  new Dimensions(depth, width);
    }


}
