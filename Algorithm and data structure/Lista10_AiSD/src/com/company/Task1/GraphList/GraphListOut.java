package com.company.Task1.GraphList;

import java.util.ArrayList;

public class GraphListOut {

    private ArrayList<Element> graphList=new ArrayList<Element>();
    private Comp comp=new Comp();  //Comparator
    private String s;
    private ArrayList<Character> views=new ArrayList<Character>();

    public ArrayList<Element> getGraphList(){
        return graphList;
    }

    public void add(char element){
        if(!onList(element)){
            graphList.add(new Element(element));
        }
    }

    public void addWay(String st){
        char[] ch=st.toCharArray();
        char value=ch[0];
        char way=ch[1];
        for(Element el:graphList){
            if(comp.compare(el.getValue(), value)==0){
                el.addWay(way);
            }
        }
    }

    private boolean onList(char value){
        boolean result=false;
        for(Element el:graphList){
            if (comp.compare(el.getValue(),value)==0){
                result=true;
            }
        }
        return result;
    }

    public int indexOnList(char value){
        int result=-1;
        for(int i=0;i<graphList.size();i++){
            if(comp.compare(graphList.get(i).getValue(),value)==0){
                result=i;
            }
        }
        return result;
    }

    public void deleteWay(char value,char way){
        for(Element el:graphList){
            if(comp.compare(el.getValue(),value)==0){
                el.deleteWay(way);
            }
        }
    }

    private boolean views(char el,ArrayList<Character> view){
        boolean result=false;
        for(Character ch:view){
            if(comp.compare(ch,el)==0){
                result=true;
            }
        }
        return result;
    }

    public String bfs(char od){
        s="Przeszukiwanie BFS: [ ";
        if(!graphList.isEmpty()){
            bfs(graphList.get(indexOnList(od)),views);
            for(Element elem:graphList){
                if(!elem.getViews()){
                   // System.out.println(elem.getValue()+", "+elem.getViews()+" 2");
                    bfs(elem,views);
                }
            }
        }
        for(Element el:graphList){
            el.setViews(false);
        }
        views.clear();
        return s.substring(0,s.length()-2)+" ]";
    }

    private void bfs(Element el,ArrayList<Character> views){
        if(!el.getViews() && !views(el.getValue(),views)){
            el.setViews(true);
            views.add(el.getValue());
            s+=el.getValue()+el.getWays().toString()+"; ";
        }
        for(Character ch:el.getWays()){
            if(!graphList.get(indexOnList(ch)).getViews() && !views(graphList.get(indexOnList(ch)).getValue(),views)){
                //System.out.println(graphList.get(indexOnList(ch)).getValue()+", "+graphList.get(indexOnList(ch)).getViews()+" 1");
               s += ch + graphList.get(indexOnList(ch)).getWays().toString()+"; ";
                views.add(graphList.get(indexOnList(ch)).getValue());
               //graphList.get(indexOnList(ch)).setViews(true);
            }
        }
        for(Character ch:el.getWays()){
            for(Element elem:graphList){
                if(comp.compare(elem.getValue(),ch)==0 && !elem.getViews()){
                    elem.setViews(true);
                    //System.out.println(elem.getValue()+", "+elem.getViews()+" 2");
                    bfs(elem,views);
                }
            }
        }
    }

    public String dfs(char od){
        s="Przeszukiwanie DFS: [ ";
        if(!graphList.isEmpty()){
            dfs(graphList.get(indexOnList(od)));
            //jezeli mamy taki wypadek ze sa sziezki do jakich nie maja dostepu
            for(Element elem:graphList){
                if(!elem.getViews()){
                    dfs(elem);
                }
            }
        }
        for(Element el:graphList){
            el.setViews(false);
        }
        return s.substring(0,s.length()-2)+" ]";
    }

    private void dfs(Element el){
        el.setViews(true);
        s+=el.getValue()+el.getWays().toString()+"; ";
        for(Character ch:el.getWays()){
            for(Element elem:graphList){
                if(comp.compare(elem.getValue(),ch)==0 && !elem.getViews()){
                    dfs(elem);
                }
            }
        }
    }

    @Override
    public String toString() {
        String s="Graf listy sasiedstwa: [ ";
        for(Element el:graphList){
            s+=el.getValue()+el.getWays().toString()+"; ";
        }
        return s.substring(0,s.length()-2)+" ]";
    }
}
