package com.company.Test;

import com.company.Implement.Task_1.KeyIterator;
import com.company.Implement.Task_1.Map_1;
import com.company.Implement.Task_1.Structure;
import com.company.Implement.Task_1.ValueIterator;
import com.company.Implement.Task_4.MultiMap;

public class Main {

    public static void main(String[] args) {
        Map_1 map_1=new Map_1();
         map_1.put("damm",3);
         map_1.put("it's key",8);
         map_1.put("d",3);
         map_1.put("i do ii",9);
         map_1.put("j",12);
         map_1.put("ko",17);
        System.out.println(map_1.toString());

        /**
        System.out.println("rozmiar: " + map_1.size() + "\n daj element o klucze 'j': " + map_1.get("j") + "\n czy jest element o klucze 'd': " + map_1.containsKey("d") +
              "\n usuwamy element o klucze 'd': " + map_1.remove("d") + "\n czy jest element o klucze 'd': " + map_1.containsKey("d") + "\n czy pusta mapa: " + map_1.isEmpty());
        **/

        KeyIterator keyIterator= (KeyIterator) map_1.keyIterator();
        System.out.println(keyIterator.toString());

        ValueIterator valueIterator =(ValueIterator) map_1.valueIterator();
        System.out.println(valueIterator.toString());

        MultiMap multiMap =new MultiMap();
        multiMap.put("key",9);
        multiMap.put("key",8);
        multiMap.put("not yet",14);
        multiMap.put("noy",6);
        multiMap.put("b",7);
        multiMap.put("era",6);
        multiMap.put("era",6);
        multiMap.put("era",6);
        System.out.println(multiMap.toString());

        /**
        System.out.println(" rozmiar: "+multiMap.size()+"\nwartosci o klucze 'b': "+multiMap.get("era").toString()+
               "\n usuwmy elementy o klucze 'key': "+multiMap.remove("key").toString()+ "\nczy pusta: "+multiMap.isEmpty()+"\n czyszcz");
        multiMap.clear();
        System.out.println(multiMap.size());
        **/

        Structure structure=new Structure();
        structure.add("I'm batman");
        structure.add("Leszek");
        structure.add("I");
        structure.add("man");
        structure.add("woman");
        structure.add("tiger");
        structure.add("we");
        System.out.println(structure.toString());
/**
        System.out.println(" czy jest wartosc o wartosci 'I': "+structure.contains("I")+"\n usuwamy element o klucze 'cow' oraz 'we'");
        structure.remove("cow");
        structure.remove("we");
        System.out.println("rozmiar: "+structure.size()+"\n czy pusta: "+structure.isEmpty());
        System.out.println(structure.toString());
 **/
    }
}
