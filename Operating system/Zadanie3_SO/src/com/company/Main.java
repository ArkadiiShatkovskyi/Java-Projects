package com.company;

import java.util.LinkedList;

public class Main {

    public static void main(String[] args) {
        final Main main=new Main();
        final int ramek=3;
        final LinkedList list = main.generator(100);
        FIFO fifo=new FIFO(ramek,main.generMy());
        fifo.fifo();
        System.out.println(fifo.toString());
        RAND rand=new RAND(ramek,main.generMy());
        rand.rand();
        System.out.println(rand.toString());
        OPT opt= new OPT(ramek,main.generMy());
        opt.opt();
        System.out.println(opt.toString());
        LRU lru=new LRU(ramek,main.generMy());
        lru.lru();
        System.out.println(lru.toString());
        Apr apr=new Apr(ramek,main.generMy());
        apr.apr();
        System.out.println(apr.toString());
    }

    public LinkedList<Integer> generator(int n){
        LinkedList<Integer> list=new LinkedList<Integer>();
        for(int i=0;i<1000;i++){
            list.add((int)(Math.random()*n));
        }
        //System.out.println("Wynegerowana lista: "+list.toString());
        return list;
    }

    public LinkedList<Integer> generMy(){
        LinkedList<Integer> list=new LinkedList<Integer>();
        /**
        list.add(5);
        list.add(7);
        list.add(3);
        list.add(5);
        list.add(2);
        list.add(1);
        list.add(7);
        list.add(1);
        list.add(3);
        list.add(2);
        list.add(8);
        list.add(1);
        list.add(9);
        list.add(7);
        **/
        list.add(3);
        list.add(1);
        list.add(0);
        list.add(3);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(4);
        list.add(0);
        list.add(4);
        return list;
    }
}
