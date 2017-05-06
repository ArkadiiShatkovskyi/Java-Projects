package com.company.Task2;

import java.util.LinkedList;

public class TrieTree {

    private Node root;
    private CharacterComparator comp=new CharacterComparator();
    private StringComparator compr=new StringComparator();
    private boolean result;//for contains
    private LinkedList<String> listOnRemove=new LinkedList<String>();
    private LinkedList<String> list=new LinkedList<String>();
    private String str="";// for toString

    public TrieTree(){
        root=new Node(' ');
    }

    private boolean searchRemElem(String element){
        boolean res=false;
        for(String s: listOnRemove){
            if(compr.compare(s,element)==0){
                res=true;
            }
        }
        return res;
    }

    private void remFromRemList(String value){
        for(int i=0;i<listOnRemove.size();i++){
            if(compr.compare(listOnRemove.get(i),value)==0){
                listOnRemove.remove(i);
            }
        }
    }

    public void add(String word){
        if(searchRemElem(word)){
            remFromRemList(word);
        }
        char[] ch=word.toCharArray();
        insert(ch,root,0);
    }

    private void insert(char[] object,Node p,int i){
      if(i<object.length){
        if(p.isOnNextElements(object[i])==-1){
            p.addChildren(object[i]);
            p=p.getChildren(object[i]);
            insert(object,p,++i);
        }
        else{
            p=p.getChildren(object[i]);
            insert(object,p,++i);
        }
      }
    }

    public boolean contains(String word){
        if(searchRemElem(word)){
            return false;
        }
        result=false;
        char[] chars=word.toCharArray();
        find(chars,root,0);
        return result;
    }

    public String findByPrefix(String prefix){
        char[] chars=prefix.toCharArray();
        findByPrefix(chars,root,0);
        return list.toString();
    }

    private void findByPrefix(char[] pref,Node p,int i){
        if(i<pref.length){
            if(p.isOnNextElements(pref[i])!=-1) {
                p = p.getChildren(pref[i]);
                findByPrefix(pref,p,++i);
            }
            else{
                String s="";
                words(charToString(pref),s,p);
            }
        }
    }


    private void words(String prefix,String s,Node n){
        for(int i=0;i<n.getChildren().size();i++){
            if (!n.getChildren().get(i).isHasAChild()) {
                list.add(prefix + s + n.getChildren().get(i).getValue());
                s = "";
            }
             else {
                s += n.getChildren().get(i).getValue();
                words(prefix,s,n.getChildren().get(i));
            }
        }
    }

    private boolean find(char[] elements,Node p,int i){
        if(i<elements.length){
            if(p.isOnNextElements(elements[i])!=-1){
                p=p.getChildren(elements[i]);
                if(i==elements.length-1){
                    result=true;
                }
                else{
                    find(elements,p,++i);
                }
            }
        }
        return result;
    }

    public void delete(String word){
        char[] chars=word.toCharArray();
        find(chars,root,0);
        if(result==true){
         remove(chars,root,0);
        }
        else {
            System.out.println("Nie ma takiego elementu w drzewie!");
        }
    }

    private String charToString(char[] table){
        String s="";
        for(int i=0;i<table.length;i++){
            s+=table[i];
        }
        return s;
    }

    private void remove(char[] elements,Node p,int i){
        if(i<elements.length){
            if(p.isOnNextElements(elements[i])!=-1){
               if(!p.getChildren(elements[i]).isHasAChild()){
                   p.removeChild(p.isOnNextElements(elements[i]));
               }
               else if(i==elements.length-1){
                   if(p.getChildren(elements[i]).isHasAChild()){
                       listOnRemove.add(charToString(elements));
                   }
               }
               else{
                   p=p.getChildren(elements[i]);
                   remove(elements,p,++i);
               }
            }
        }
    }

    private void print(Node p){
        for(int z=0;z<p.getChildren().size();z++){
            str+=p.getChildren().get(z).toString();
        }
        for(int z=0;z<p.getChildren().size();z++){
            print(p.getChildren().get(z));
        }
    }

    @Override
    public String toString() {
        print(root);
        String s=root.toString()+str;
        str="";
        return s;
    }
}
