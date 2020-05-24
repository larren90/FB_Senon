package com.company;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws Exception{
        int n = 0;
        Scanner in = new Scanner(System.in);
        first arr = new first();
        second arr1 = new second();
        third arr2 = new third();
        while (true) {
            System.out.println("Введите номер желаемой операции => ");
            System.out.println("(0) - Задание 1.1");
            System.out.println("(1) - Задание 1.2");
            System.out.println("(2) - Задание 1.3");
            System.out.println("(3) - Задание 1.4");
            System.out.println("(4) - Задание 2.1");
            System.out.println("(5) - Задание 2.2");
            System.out.println("(6) - Задание 2.3");
            System.out.println("(7) - Задание 3.1");
            System.out.println("(8) - Задание 3.2");
            System.out.println("(9) - Конец");
            n = in.nextInt();
            switch (n) {
                case 0:
                    arr.first();
                    break;
                case 1:
                    arr.second();
                    break;
                case 2:
                    arr.third();
                    break;
                case 3:
                    arr.fourth();
                    break;
                case 4:
                    arr1.Task_1();
                    break;
                case 5:
                    arr1.Task_2();
                    break;
                case 6:
                    arr1.Task_3();
                    break;
                case 7:
                    arr2.Task1();
                    break;
                case 8:
                    arr2.Task2();
                    break;
                case 9:
                    return;
                default:
                    System.out.println("Введен неверный номер операции");
            }
        }
    }
}