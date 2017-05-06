package com.company.Test;

import com.company.Task1.GraphList.GraphListIn;
import com.company.Task1.GraphList.GraphListOut;
import com.company.Task1.GraphMatrix.GraphM;
public class Main {

    public static void main(String[] args) {
        GraphListOut graph=new GraphListOut();
        GraphM graphM=new GraphM();
        GraphListIn gli=new GraphListIn();

        char[] elements="ABCDEF".toCharArray();
        for(char ch:elements){
            graph.add(ch);
            graphM.add(ch);
            gli.add(ch);
        }

        graph.addWay("AB");
        graph.addWay("DB");
        graph.addWay("ED");
        graph.addWay("EF");
        graph.addWay("FE");
        graph.addWay("AE");
        graph.addWay("CD");
        graph.addWay("CF");
        graph.addWay("BC");

        graphM.addWay("AB");
        graphM.addWay("BD");
        graphM.addWay("ED");
        graphM.addWay("EF");
        graphM.addWay("FE");
        graphM.addWay("AE");
        graphM.addWay("CD");
        graphM.addWay("CF");
        graphM.addWay("BC");

        gli.addWay("AB");
        gli.addWay("BD");
        gli.addWay("ED");
        gli.addWay("EF");
        gli.addWay("FE");
        gli.addWay("AE");
        gli.addWay("CD");
        gli.addWay("CF");
        gli.addWay("BC");

        System.out.println(graph.bfs('E'));
        System.out.println(graph.dfs('E'));
        System.out.println(gli.toString());
        //System.out.println(graph.toString());
        System.out.println(graphM.toString());
    }
/**
        GraphWeighted gw=new GraphWeighted();

        char[] elements2="ABCDF".toCharArray();
        for(char ch:elements2){
            gw.add(ch);
            gw.add(ch);
        }
        gw.addWay("AB",1);
        gw.addWay("BC",1);
        gw.addWay("CD",2);
        gw.addWay("AF",3);
        gw.addWay("FD",5);
        gw.algDijkstry('A','D');
    }
 **/

}
