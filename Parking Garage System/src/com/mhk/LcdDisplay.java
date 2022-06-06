package com.mhk;

import java.time.LocalTime;
import java.util.Scanner;
import java.util.Vector;

// singelton
public class LcdDisplay {

   private static LcdDisplay _lcd;

   private LcdDisplay(){};

   public static LcdDisplay getInstance(){
      if(_lcd == null){
         _lcd = new LcdDisplay();
      }
	   return _lcd;
   }

   private void menu(){
      System.out.println("1.ParkIn\n2.ParkOut\n3.Display Available Slots\n4.Setup Grage\n5.Generate Report\n6.Exit ");      
   }

  private int enterRequriedMoney(){
      Scanner input = new Scanner(System.in);
      System.out.print("Enter the required Money : ");
      int enter = input.nextInt();
      return enter;

  }

   private void parkIn(){
      VehicleForm form = new VehicleForm();
      Vehicle vehicle = form.fillForm();
      GarageController controller = new GarageController("Park In");
      int availableSlot = controller.searchForAvailableSlot(vehicle);
      Display("the availableSlot is slot " + (availableSlot + 1 ) );
   }

   private void parkOut(){
      GarageController controller = new GarageController();
      System.out.print("Enter the ID of the vehicle : ");
      Scanner input = new Scanner(System.in);
      String id = input.nextLine();

      // remove vehicle from the garage and get the start time to calculate the fees
      LocalTime startTime = controller.removeVehicle(id);
      if(startTime == null){
         functionality();
         return;
      }

      // get the end time to calculate the fees
      LocalTime endTime = LocalTime.now();

      Payment payment = new Payment();

      // get the fees that the user should pay
      int fees = payment.calculateTotalFees(startTime, endTime);

      // checking the entered money is fit with required or not
      boolean process = true;
      while(process){
         try {
            //user enter the money
            Display("Required money is : " + fees );

            //take the required money
            int enteredMoney = enterRequriedMoney();

            // check the money and calculate the rest of the money
            int restOfTheMoney = payment.checkMoney(enteredMoney, fees);

            Display("The Rest Of The Money is : " + restOfTheMoney );

            //The process is Done Successfully
            process = false;

            //Add fees to the total Income of the garage 
            Income income = Income.getInstance();
            income.addToIncome(fees);

            // Generate Recipt
            Reciept reciept = new Reciept();
            reciept.displayRecipt(startTime , endTime , fees , enteredMoney , restOfTheMoney , id);
         }
         catch(IllegalArgumentException e){
            Display(e.getMessage());
         }
      }
      Display("Thank you for using our service ");

   }

   private void setUpGarage(){
      GarageForm form = new GarageForm();
      form.fillForm();
      Display("Garage Setup successfully !\n");   
   }


   private void displayAvailableSlots(){
      GarageController controller = new GarageController();
      Vector<Slot> availableSlots = controller.findAvailableSlots();
      Display("Available Slots are : ");
      for(Slot slot : availableSlots){
         Display("Slot: " + ((int)slot.getSlotID() + 1 )+ " ");
      }
      Display("\n");
   }


    public void functionality(){
      menu();
      System.out.print("What choice do you need : ");
      Scanner input = new Scanner(System.in);
      int choice =  input.nextInt();
      switch(choice){
         case 1:
            parkIn();
            functionality();
            break;
         case 2:
            parkOut();
            functionality();
            break;
         case 3:
            displayAvailableSlots();
            functionality();
            break;
         case 4:
            setUpGarage();
            functionality();
            break;
         case 5 : 
            Report report = new Report();
            report.generateReport();
            functionality();
            break;
         default:
            System.out.println("Thank you for using our service");
            System.exit(0);
            break;
      }
      return;
   }

   public void Display(String message){
      System.out.println(message);
   }

}
