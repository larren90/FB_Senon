package com.company;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.*;

class GroupMeetSystem
{
    private List<Member> users;
    private Member currentUser;
    private String result;
    //private List<Request> places;

    public String GetResult()
    {
            return result;
    }

    public Vector<String> getUserNames()
    {
        Vector<String> temp=new Vector<>();
        for (Member user:users) {
            temp.add(user.getName());
        }
        return temp;
    }

    //Расчет возможностей для текущего пользователя
    public int processRequests()
    {
        int countVariants=0;
        if (users.size()==0) return 0;
          HashSet<String> places=users.get(0).getPlaces();
          for(Member member:users)
          {
              if (member.getPlaces().size()>0) places.retainAll(member.getPlaces());
          }
          if(places.size()==0) return 0;
          //Set 0 element
        List<String> tmpList = new ArrayList<String>(places);
        //Creates Dictanory<key, value>
        Map<String,HashSet<Integer>> days =new HashMap<String, HashSet<Integer>>();

        // sets places and days
        for(int i=0;i<tmpList.size();i++)
            days.put(tmpList.get(i),new HashSet<>(users.get(0).getDays(tmpList.get(i))));

        for(String place:places)
          {
              for(Member member:users)
              {
                  if (member.getDays(place).size()>0) days.get(place).retainAll(member.getDays(place));
              }
          }

        //if(days.size()==0) return 0;

        Member member=users.get(0);
        {

            for (String place : places) {

                if (days.get(place).size()>0) {
                    for (Integer day : days.get(place)) {
                        HashSet<Integer> times = member.getTimes(place, day);
                         for(Member member1: users)
                           if (member1.getTimes(place, day).size() > 0) times.retainAll(member1.getTimes(place, day));
                        if (times.size()>0)
                        {
                            System.out.println(place);
                            System.out.print("Day:" + day + " ");
                            for (Integer time : times) {
                                System.out.print(" " + time + ", ");
                                countVariants++;
                            }
                        }
                        System.out.print("\n");
                    }
                }
            }
        }
        System.out.println();
        return countVariants;
    }

    public int GetProcessRequests()
    {
        result="";
        int countVariants=0;
        if (users.size()==0) return 0;
        HashSet<String> places=users.get(0).getPlaces();
        for(Member member:users)
        {
            if (member.getPlaces().size()>0) places.retainAll(member.getPlaces());
        }
        if(places.size()==0) return 0;
        //Set 0 element
        List<String> tmpList = new ArrayList<String>(places);
        //Creates Dictanory<key, value>
        Map<String,HashSet<Integer>> days =new HashMap<String, HashSet<Integer>>();

        // sets places and days
        for(int i=0;i<tmpList.size();i++)
            days.put(tmpList.get(i),new HashSet<>(users.get(0).getDays(tmpList.get(i))));

        for(String place:places)
        {
            for(Member member:users)
            {
                if (member.getDays(place).size()>0) days.get(place).retainAll(member.getDays(place));
            }
        }

        //if(days.size()==0) return 0;

        Member member=users.get(0);
        {

            for (String place : places) {

                if (days.get(place).size()>0) {
                    for (Integer day : days.get(place)) {
                        HashSet<Integer> times = member.getTimes(place, day);
                        for(Member member1: users)
                            if (member1.getTimes(place, day).size() > 0) times.retainAll(member1.getTimes(place, day));
                        if (times.size()>0)
                        {
                            //System.out.println(place);
                            result=result+place+"\n";
                            //System.out.print("Day:" + day + " ");
                            result=result+"Day:" + day + " ";
                            for (Integer time : times) {
                                //System.out.print(" " + time + ", ");
                                result=result+" " + time + ", ";
                                countVariants++;
                            }
                        }

                        //System.out.print("\n");
                        result=result+"\n";
                    }
                }
            }
        }
        //System.out.println();
        result=result+"\n";
        return countVariants;
    }

    public GroupMeetSystem()
    {
        users=new ArrayList<Member>();
        //places=new ArrayList<Request>();
    }

    static Scanner sc=new Scanner(System.in);

    Member GetById(int id)
    {
        for(int i=0;i<users.size();i++)
            if (users.get(i).getId()==id) return users.get(i);
            return null;
    }

    Member GetByUserName(String userName)
    {
        for(int i=0;i<users.size();i++)
            if (users.get(i).getName().equals(userName)) return users.get(i);
        return null;
    }


    void AddUser()
    {
        System.out.println("Input name");
        String name=sc.nextLine();
        System.out.println("Input login");
        String login=sc.nextLine();
        System.out.println("Input password");
        String password=sc.nextLine();
        Member user=new Member(name,login, password);
        if (users.indexOf(user)==-1) users.add(user);
        else System.out.println("This user is exists");
        if (users.size()==1) currentUser=users.get(0);
    }

    void AddUser(String name, String login,String password)
    {
        Member user=new Member(name,login, password);
        if (users.indexOf(user)==-1) users.add(user);
        //else  return "This user is exists";
        if (users.size()==1) currentUser=users.get(0);

    }

    void save(String filename)
    {
        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename)))
        {
            oos.writeObject(users);
            System.out.println("File has been written");
        }
        catch(Exception ex)
        {
            System.out.println("***** Has been error! *****");
            System.out.println(ex.getMessage());
        }
    }

    void load(String filename)
    {
        try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename)))
        {

            users=((ArrayList<Member>)ois.readObject());
            currentUser=users.get(0);
            User.SetCount(users.get(users.size()-1).getId());//Установить ID для вновь добалыенный пользователей
        }
        catch(Exception ex){
            System.out.println("***** Has been error! *****");
            System.out.println(ex.getMessage());
        }
    }

    void print()
    {
        if (users.size()==0) System.out.println("Users list is empty");
        else
            for (User user: users)
            {
                if (user==currentUser) System.out.print('*');
                System.out.println(user);
            }
    }
    

    static int Menu()
    {
        int menu=-1;
        do
        {
            System.out.println("1. Add user");
            System.out.println("2. Save list members");
            System.out.println("3. Load list members");
            System.out.println("4. Select current member");
            System.out.println("5. Add request");
            System.out.println("6. Show members");
            System.out.println("7. Show current member's requests ");
            System.out.println("8. Show all requests");
            System.out.println("9. Clear list");
            System.out.println("10. Clear current user requests list ");
            System.out.println("11. Show variants");
            System.out.println("0. Exit");
            String str;
            do {
                str = sc.nextLine();
            }
            while (str=="\r" || str=="");//Enter processing
            menu = Integer.parseInt(str);
        }
        while(menu<0 || menu>11);
        return  menu;
    }

    static Request InputRequest()
    {
        System.out.println("Input place:");
        String place=sc.nextLine();
        System.out.println("Input day:");
        String temp;
        int day,from,to;
        temp=sc.nextLine();
        day=Integer.parseInt(temp);
        System.out.println("Input from:");
        temp=sc.nextLine();
        from=Integer.parseInt(temp);
        System.out.println("Input to:");
        temp=sc.nextLine();
        to=Integer.parseInt(temp);
        return new Request(place,day,from,to);
    }

    void SelectCurrentUser(GroupMeetSystem gms)
    {
        Member currentUser;
        do {
            gms.print();
            System.out.println("Input user ID:");
            String strId = sc.nextLine();
            int id=Integer.parseInt(strId);
            currentUser=gms.GetById(id);
        }
        while (currentUser==null);
        this.currentUser=currentUser;
        System.out.println("Current user:"+this.currentUser);
    }

    public  void showAllRequests() {
        for (Member user : users) {
            if (user == currentUser) System.out.print('*');
            System.out.println(user);
            user.print();
        }

    }

    public  String GetAllRequests() {
        String s = "";
        for (Member user : users) {
            //if (user==currentUser) System.out.print('*');
            System.out.println(user);
            s = s + user + "\n";
            s = s + user.getStringRequests() + "\n";
        }
        return s;
    }

    public static void main(String[] args)
    {
        // write your code here
        GroupMeetSystem gms=new GroupMeetSystem();
        gms.load("users.dat");
        gms.print();
        do
        {
            switch (Menu())
            {
                case 1:
                    gms.AddUser();
                    break;
                case 2:
                    gms.save("users.dat");
                    break;
                case 3:
                    gms.load("users.dat");
                    gms.print();
                    gms.currentUser=gms.GetById(0);
                    //System.out.println(gms.currentUser);
                    //gms.SelectCurrentUser(gms);
                    break;
                case 4:
                    gms.SelectCurrentUser(gms);
                    break;
                case 5:
                    gms.currentUser.addRequest(InputRequest());
                    break;
                case 6:
                    gms.print();
                    break;
                case 7:
                      System.out.println(gms.currentUser);
                    for (Request request: gms.currentUser.getRequests())
                    {
                        System.out.println(request.toString());
                    }
                    break;
                case 8:
                    gms.showAllRequests();
                    break;
                case 9:
                        gms.users.clear();
                        gms.currentUser=null;
                        gms.print();
                    break;
                case 10:
                        gms.currentUser.clearRequests();
                        gms.currentUser.print();
                    break;
                case 11:
                    System.out.println("Variants:"+gms.processRequests());
                    break;
                case 0:
                    System.out.println("Bye-bye");
                    return;
            }
        }
        while(1==1);
    }
/*
    public void addUser(String name, String Login, String Password, String repeatin, int type)
    {

    }
*/
    public User findUser(String login, String password)
    {
        for(int i=0;i<users.size();i++)
            if (users.get(i).getLogin().equals(login) && users.get(i).getPassword().equals(password)) return users.get(i);
            return null;

    }

    public List<Member> Requests()
    {
        return users;
    }

}

