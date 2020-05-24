//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.company;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.nio.charset.Charset;

public class Task_3 {
    public Task_3() {
    }

    public void start_task_3() {
        this.work_1();
        this.work_2();
        this.work_3();
    }

    private void work_1() {
        try {
            System.out.println("\nУпражнение 1:");
            //Создаем файлы
            File T1 = new File("T1.txt");
            File T2 = new File("T2.txt");
            //Создаем выходной поток для записи
            FileWriter file_1 = new FileWriter("T1.txt");
            for(char c='A';c<='Z';c++)  file_1.append(c);
            for(char c='А';c<='Я';c++)  file_1.append(c);
            file_1.close();
            FileReader t1 = new FileReader("T1.txt");
            FileWriter t2 = new FileWriter("T2.txt");
            int ch;
            for(ch = t1.read(); ch != -1; ch = t1.read()) {
                t2.write((char)ch);
            }

            t1.close();
            t2.close();
            System.out.print("Во втором файле: ");
            FileReader file_2 = new FileReader("T2.txt");

            for(ch = file_2.read(); ch != -1; ch = file_2.read()) {
                System.out.print((char)ch);
            }

            System.out.println("\n");
            file_2.close();
            //управляем их удалением
            //T1.deleteOnExit();
            //T2.deleteOnExit();
        } catch (Exception exc) {
            System.out.println(exc.toString());
        }

    }

    private void work_2() {
        try {
            System.out.println("\nУпражнение 2:");
            new File("A.txt");
            FileWriter file_a = new FileWriter("A.txt");

            for(int i = 0; i < 512; ++i) {
                file_a.append('q');
            }

            file_a.close();
            FileReader in = new FileReader("A.txt");
            BufferedReader inb = new BufferedReader(in, 128);
            new File("B.txt");
            FileWriter out = new FileWriter("B.txt");
            BufferedWriter outb = new BufferedWriter(out, 128);

            char[] arr = new char[128];

            for(int i = 0; i < 4; ++i) {
                inb.read(arr);
                outb.write(arr);
                outb.newLine();
            }

            inb.close();
            in.close();
            outb.close();
            out.close();
            System.out.println("Успешно выполнено!");
        } catch (Exception var10) {
            System.out.println(var10.toString());
        }

    }

    private void work_3() {
        try {
            System.out.println("\n\nУпражнение 3:");
            BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream(".\\src\\A3.txt"), "Cp1251"));
            System.out.println("Название кодировки, действующей в системе:");
            System.out.println(Charset.defaultCharset().name());

            int ch;
            for(ch = in.read(); ch != -1; ch = in.read()) {
                System.out.print((char)ch);
            }

            System.out.println();
            in.close();
            BufferedReader in2 = new BufferedReader(new InputStreamReader(new FileInputStream(".\\src\\A3.txt"), "UTF8"));
            System.out.println("Название кодировки, действующей в системе:");
            System.out.println(Charset.defaultCharset().name());

            for(ch = in2.read(); ch != -1; ch = in2.read()) {
                System.out.print((char)ch);
            }

            System.out.println();
            in2.close();
        } catch (Exception exc) {
            System.out.println(exc.toString());
        }

    }
}
