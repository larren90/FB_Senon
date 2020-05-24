package com.company;
import java.io.Serializable;

public class User implements Serializable
{
    private String name;
    private String login;
    private String password;
    private int id;

    static int Count=-1;

    public static  void SetCount(int count)
    {
        Count=count;
    }

    public User(String name, String login,String password)
    {
        this.name=name;
        this.login=login;
        this.password=password;
        Count++;
        id=Count;
    }

    public boolean enter(String login,String password)
    {
        return this.login==login && this.password==password;
    }

    public String getName()
    {
        return name;
    }
    public String getLogin(){return  login;}
    public String getPassword(){return password;}
    public int getId(){return  id;}

    @Override
    public String toString()
    {
        return "ID:"+id+ ", Name:"+name+", login:"+login+", password:"+password;
    }


}
