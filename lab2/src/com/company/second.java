package com.company;
import java.io.FileReader;
import java.util.Scanner;

public class second {

    public void Task_1 () {
//task 1 удаление слов
        StringBuffer sb = new StringBuffer("Папа купил сыну игрушку. Зебры не едят мясо. За окном виднеется луна. Друзья идут в кино. Сегодня дождливый холодный день.");
        int[] myArray = new int[20];
        myArray[0] = sb.indexOf(" ");
        for (int m = 1, i=1; m< myArray.length; i++) {
            myArray[m] = sb.indexOf(" ", i);
            if (myArray[m] != myArray[m - 1])
                m++;
        }
        int k = myArray[3]-1-myArray[2];
        sb.delete(myArray[2],myArray[3]-1);
        sb.delete(myArray[10]-k,myArray[11]-1-k);
        System.out.println(sb);
    }
    public void Task_2 () {
//task 2 добавить предложение
        StringBuffer sb = new StringBuffer("Папа купил сыну игрушку. Зебры не едят мясо. За окном виднеется луна. Друзья идут в кино. Сегодня дождливый холодный день. ");
        System.out.println("Введите предложение, которое хотите добавить:");
        Scanner scan1 = new Scanner(System.in);
        String t = scan1.nextLine();
        System.out.println("Введите после какого предложения добавить новое предложение(цифру):");
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int first = sb.indexOf(".");
        int second = sb.indexOf(".", first+1);
        int third = sb.indexOf(".", second+1);
        int fourth = sb.indexOf(".", third+1);
        int fifth = sb.indexOf(".", fourth+1);
        if (n == 1)
            sb.insert(first+2, t+" ");
        if (n == 2)
            sb.insert(second+2, t+" ");
        if (n == 3)
            sb.insert(third+2, t+" ");
        if (n == 4)
            sb.insert(fourth+2, t+" ");
        if (n == 5)
            sb.insert(fifth+2, t+" ");
        System.out.println(sb);
    }
    public void Task_3 () {
//task 3 добавить слово после 1 слова 1 предложения
        StringBuffer sb = new StringBuffer("Папа купил сыну игрушку. Зебры не едят мясо. За окном виднеется луна. Друзья идут в кино. Сегодня дождливый холодный день. ");
        System.out.println("Введите слово, которое хотите добавить:");
        Scanner scan1 = new Scanner(System.in);
        String t = scan1.nextLine();
        int first = sb.indexOf(".");
        int second = sb.indexOf(" ", first+2);
        sb.insert(second, " " + t);
        System.out.println(sb);
    }
}
