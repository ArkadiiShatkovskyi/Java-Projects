package com.company.tests;

public class Car {

    private String firm;
    private int silnik;
    private String model;

    public Car(String firm,int silnik,String model){
        this.firm=firm;
        this.silnik=silnik;
        this.model=model;
    }

    public String getFirm(){
        return firm;
    }

    public int getSilnik(){
        return silnik;
    }

    public String getModel(){
        return model;
    }

    @Override
    public boolean equals(Object obj) {
        return (Integer)obj==getSilnik();
    }
}
