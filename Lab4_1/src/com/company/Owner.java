package com.company;
import java.io.Serializable;

public class Owner  implements Serializable
{
    String lastName;
    String firstName;
    String adress;

    public Owner(String lastName, String firstName, String adress)
    {
        this.lastName=lastName;
        this.firstName=firstName;
        this.adress=adress;
    }

    @Override
    public String toString() {
        return lastName+" "+firstName+" "+adress;
    }
}