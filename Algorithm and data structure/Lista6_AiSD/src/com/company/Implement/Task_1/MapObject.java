package com.company.Implement.Task_1;

public class MapObject {

    private String key;
    private int value;

    public MapObject(String key, int value){
        this.key=key;
        this.value=value;
    }

    public String getKey(){
        return key;
    }

    public int getValue(){
        return value;
    }

    public void setKey(String key){
        this.key=key;
    }

    public void setValue(int value){
        this.value=value;
    }

    @Override
    public String toString() {
        return "[ Key: '"+getKey()+"', Values: "+getValue()+" ]";
    }
}
