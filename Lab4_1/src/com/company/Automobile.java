//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.company;

import java.util.Date;
import java.io.Serializable;

public class Automobile implements Serializable
{
    private String model;
    private Number number;
    private String color;
    private Owner owner;
    private Date date;

    Automobile(String model, Number number,  String color, Owner owner, Date date) throws InputException {
        this.model = model;
        this.number=number;
        this.color = color;
        this.date = date;
        this.owner=owner;
    }

    public String getModel() {
        return this.model;
    }

    public Number getNumber()
    {
        return  this.number;
    }

    public Owner getOwner()
    {
        return  this.owner;
    }

    public String getColor() {
        return this.color;
    }

    public Date getDate() {
        return this.date;
    }

    public void setDate(Date date)
    {
        this.date=date;
    }

    @Override
    public String toString() {
        return this.model + " " + this.number + " " +  this.color + " " + this.owner + " " + this.date + "\n";
    }

}
