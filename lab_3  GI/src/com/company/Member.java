package com.company;
import java.io.IOException;
import java.io.NotSerializableException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

class Admin extends User
{

    public Admin(String name, String login,String password)
    {
        super(name, login, password);
    }
}

class Member extends User
{
    private  List<Request> requests;

    public Member(String name, String login,String password)
    {
        super(name, login, password);
        requests=new ArrayList<Request>();
    }

    public HashSet<String> getPlaces()
    {
        HashSet<String> list=new HashSet<String>();
        for(Request r: requests)
        {
            list.add(r.getPlace());
        }
        return  list;
    }

    public HashSet<Integer> getDays(String place)
    {
        HashSet<Integer> list=new HashSet<Integer>();
        for(Request r: requests)
        {
            if (r.getPlace().equals(place))
                list.add(r.getDay());
        }
        return  list;

    }

    public HashSet<Integer> getTimes(String place,int day)
    {
        HashSet<Integer> list=new HashSet<Integer>();
        for(Request r: requests)
        {
            if (r.getPlace().equals(place) && r.getDay()==day)
                for(int i=r.getStartHour();i<=r.getEndHour();i++)
                    list.add(i);
        }
        return  list;

    }

    public void clearRequests()
    {
        requests.clear();
    }

    public void addRequest(String place, int day, int from,int to)
    {
        this.requests.add(new Request(place,day,from,to));
    }

    public void addRequest(Request request)
    {
        this.requests.add(request);
    }

    public List<Request> getRequests()
    {
        return requests;
    }

    void print()
    {
        if (requests.size()==0) System.out.println("Requests list is empty");
        else
            for (Request request: requests)
            {
                System.out.println(request);
            }
    }

     public   String getStringRequests()
    {
        if (requests.size()==0)  return  "Requests list is empty";
        else {
            String s="";
            for (Request request : requests) {
                s=s+request+"\n";
            }
            return s;
        }
    }
}

class Request implements Serializable
{
    private String Place;
    private int dayOfWeek;
    private  int startHour;
    private int endHour;

    public Request(String place, int dayOfWeek, int startHour, int endHour)
    {
        this.Place=place;
        this.dayOfWeek=dayOfWeek;
        this.startHour=startHour;
        this.endHour=endHour;
    }



    public String getPlace()
    {
        return Place;
    }

    public int getDay()
    {
        return dayOfWeek;
    }

    public int getStartHour()
    {
        return startHour;
    }

    public int getEndHour()
    {
        return endHour;
    }

    @Override
    public String toString()
    {
        return "Place:"+Place+ ", Day:"+dayOfWeek+", startHour:"+startHour+", endHour:"+endHour;
    }

}