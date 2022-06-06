package com.mhk;

// singelton Entity
public class Income {
    private int _totalIncomce;
    private static Income _income;

    private Income(){
        _totalIncomce = 0;
    }

    public static Income getInstance(){
        if(_income == null){
            _income = new Income();
        }
        return _income;
    }

    public void addToIncome(int num){
        _totalIncomce +=num;
    }

    public int getTotalIncome(){
        return _totalIncomce;
    }
}
