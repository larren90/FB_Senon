package com.company;

import java.util.LinkedList;
import java.io.Serializable;

public class ListAuto implements Serializable
{
    LinkedList<Automobile> list = new LinkedList();

    public ListAuto()
    {

    }

    public void Add(Automobile auto)
    {
        list.add(auto);
    }

    public void Remove(Automobile auto)
    {
        list.remove(auto);
    }

    public void Remove(Integer index)
    {
        list.remove(index);
    }

    @Override
    public String toString() {
        String s="";
        for (Automobile a:list)
        {
            s=s+a+"\n";
        }
        return s;
    }

    public ListAuto getByModel(String model)
    {
        ListAuto tempList=new ListAuto();
        for(Automobile a:list)
            if (a.getModel().equals(model)==true) tempList.Add(a);

        return tempList;
    }

    public Owner getByNumber(Number number)
    {
        for(Automobile a:list)
            if (a.getNumber().equals(number)) return a.getOwner();
        return null;
    }
    public boolean compareModels(String model1, String model2)
    {
        for(Automobile a:list)
            for(Automobile b:list)
                if (a!=b &&  a.getModel().equals(b.getModel())) return true;
        return false;
    }
}
