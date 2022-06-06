package com.mhk;

public class Report {
    private int _totalIncome = 0;
    private int _totalVehicles = 0;

    Report(){
        Garage garage = Garage.getInstance();
        _totalVehicles = garage.getTotalNumberOfVehicles();

        Income income = Income.getInstance();
        _totalIncome = income.getTotalIncome();
    }
    
    public void generateReport(){
        System.out.println("The Report Of the Garage : " );
        System.out.println("Total Number of Vehicles parked in the garage : " + _totalVehicles);
        System.out.println("Total Income of the garage : " + _totalIncome );
        System.out.print('\n');
    }
}
