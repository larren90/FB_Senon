package com.company;

import java.util.Date;

public class ClassTextFile
{

    public ClassTextFile(ListAuto list)
    {
        try {
            Automobile a1 = new Automobile("BMW", new Number("Mow", 10, "A"), "Black", new Owner("Ivanov", "Ivan", "Moscow"), new Date());
            Automobile a2 = new Automobile("BMW", new Number("Mow", 10, "A"), "Black", new Owner("Ivanov", "Ivan", "Moscow"), new Date());
            Automobile a3 = new Automobile("BMW", new Number("Mow", 10, "A"), "Black", new Owner("Ivanov", "Ivan", "Moscow"), new Date());
            Automobile a4 = new Automobile("BMW", new Number("Mow", 10, "A"), "Black", new Owner("Ivanov", "Ivan", "Moscow"), new Date());
            list.Add(a1);
            list.Add(a2);
            list.Add(a3);
            list.Add(a4);
        }
        catch (Exception exc)
        {
            System.out.println(exc);
        }
    }
}
