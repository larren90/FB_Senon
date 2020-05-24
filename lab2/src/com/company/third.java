package com.company;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class third {
    public void Task1() {
        String userInput=null;
        Scanner sc;
        sc=new Scanner(System.in);
            System.out.println("Enter a string");
            userInput=sc.nextLine();
            boolean found=Pattern.matches("([+-]?[\\d]+)|([+-]?[\\d]+[.]{1}[\\d]+)",userInput);
            if (found)
                System.out.println("It's a number");
            else
                System.out.println("It is not a number");
            sc.close();
    }
    public void Task2() {
        String userInput=null;
        Scanner sc;
        sc=new Scanner(System.in);
            System.out.println("Enter a string");
            userInput=sc.nextLine();
            //System.out.println("you entered "+userInput);
            //System.out.println("its base 10 equivalent is "+binToDec(userInput));
            Pattern pattern=Pattern.compile("(\\b[+-]?[\\d]+[.]{1}[\\d]+\\b)|(\\b[+-]?[\\d]+)\\b");
            Matcher matcher=pattern.matcher(userInput);
            String str="";
            int pos1=0;
            String substr2="";
            int start=0,end=0;
            while(matcher.find())
            {

                start=matcher.start();
                end=matcher.end();
                String substring=userInput.substring(start,end);
                if (start!=0) substr2=userInput.substring(pos1,start);
                pos1=end;
                if (Pattern.matches("[+-]?[\\d]+",substring))
                {
                    int q=Integer.parseInt(substring);
                    str=str+substr2+ (q*q);
                }
                else
                {
                    str=str+substr2+ ((int)Double.parseDouble(substring));
                }
            }
            if (end<userInput.length()) str=str+userInput.substring(end,userInput.length());
            System.out.println(str);
            sc.close();
    }

    }
