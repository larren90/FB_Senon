package com.company;

import java.io.FileReader;
import java.util.Scanner;

public class first {

    public void first() throws Exception {
//task 1
        FileReader f = new FileReader("./src/com/company/MyDoc.txt");
        Scanner scan = new Scanner(f);
        String t;

        int i = 0;

        while (scan.hasNextLine()) {
            t=scan.nextLine();
            if (t.contains("new")) {
                i++;
            }
        }
        System.out.println(i);
        f.close();
    }
    //Вывести объекты и классы, к которым они принадлежат
    public  void second() throws Exception{
        FileReader f = new FileReader("./src/com/company/MyDoc.txt");
        Scanner scan = new Scanner(f);
        String t;

        while (scan.hasNextLine()) {
            t=scan.nextLine();
            if (t.contains("class")) {
                System.out.println(t);
            }
            if (t.contains("new")) {
                System.out.println(t);
            }
        }
        System.out.println(String.valueOf(f));
        f.close();
    }
    //переменные, которые вводились с клавы
    public  void third() throws Exception{
        FileReader f = new FileReader("./src/com/company/MyDoc.txt");
        Scanner scan = new Scanner(f);
        String t;

        while (scan.hasNextLine()) {
            t=scan.nextLine();
            if (t.contains("input.")) {
                String inp[] = t.split("\\s+");
                System.out.print(inp[1] + "\n");
            }
        }
        f.close();
    }
    //подсчет констант
    public void fourth() throws Exception {
//task 1
        FileReader f = new FileReader("./src/com/company/MyDoc.txt");
        Scanner scan = new Scanner(f);
        String t;

        int i = 0;

        while (scan.hasNextLine()) {
            t=scan.nextLine();
            if (t.contains("final")) {
                i++;
            }
        }
        System.out.println(i);
        f.close();
    }
}