//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.company;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.RandomAccessFile;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

public class Task_2 {

    //LinkedList<automobile> list_auto = new LinkedList();
   ListAuto listAuto=new ListAuto();

    public Task_2() {
    }

    public void show_menu_2()
    {
        String main_menu_text = "\n1. Создать новые объекты и файл\n2. Считать и создать список\n3. Найти все модели\n4.  0. Выход\n";
        int job_task_2 = -1;

        while(job_task_2 != 0) {
            System.out.println(main_menu_text);
            Scanner m_sc = new Scanner(System.in);
            job_task_2 = m_sc.nextInt();
            switch(job_task_2) {
                case 0:
                    break;
                case 1:
                    this.append_file_and_object();
                    break;
                case 2:
                    this.input_file_objects();
                    break;
                case 3:
                    this.randomAccessFile_task();
                    break;
                default:
                    System.out.println("Введена неверная команда, повторите ввод");
            }
        }

    }

    private void append_file_and_object() {
        try {
            Scanner inp = new Scanner(System.in);
            System.out.println("Сколько новыйх объектов вы хотите создать?");
            int count_object = inp.nextInt();
            System.out.println("\nВведите название будущего файла: ");
            String file_name = inp.next();
            file_name = file_name + ".bin";
            DataOutputStream doc = new DataOutputStream(new FileOutputStream(file_name));

            for(int i = 0; i < count_object; ++i) {
                System.out.println("\nВведите модель автомобиля");
                String model = inp.next();
                System.out.println("\nВведите код региона");
                String region = inp.next();
                System.out.println("\nВведите цифровой код");
                //exception?
                Integer number = Integer.parseInt(inp.next());

                System.out.println("\nВведите буквенный код");
                String word_code =  inp.next();
                System.out.println("\nВведите цвет");
                String color = inp.next();
                System.out.println("\nВведите фамилию владельца");
                String surname = inp.next();
                System.out.println("\nВведите имя владельца");
                String name = inp.next();
                System.out.println("\nВведите адрес владельца");
                String adress = inp.next();
                System.out.println("\nВведите дату последнего техосмотра(\"dd.MM.yyyy\")");
                //String string = "January 2, 2010";
                //String string = "20.02.2020";
                DateFormat format = new SimpleDateFormat("dd.MM.yyyy", Locale.ENGLISH);
                Date date = format.parse(inp.next());
                Automobile auto = new Automobile(model,new Number(region,number,word_code),color,new Owner(surname,name,adress),date);
                doc.writeUTF(auto.getModel()+"\n");
                doc.writeUTF(auto.getNumber().toString()+"\n");
                doc.writeUTF(auto.getColor()+"\n");
                doc.writeUTF(auto.getOwner().toString()+"\n");
                doc.writeUTF(auto.getDate().toString()+"\n");
            }
            doc.close();
            File f = new File(file_name);
            if (f.exists()) {
                System.out.println("\nФайл был найден в директории!");
            } else {
                System.out.println("\nФайл НЕ был найден в директории((...");
            }
        } catch (InputException var16) {
            System.out.println("\nОшибка ввода объекта");
        } catch (Exception var17) {
            System.out.println("\nОшибка записи в файл");
        }

    }

    private void input_file_objects() {
       /* try {
            Scanner inp = new Scanner(System.in);
            System.out.println("\nВведите имя файла, из которого необходимо считать информацию: ");
            String file_name = inp.next();
            file_name = file_name + ".bin";
            File f = new File(file_name);
            if (!f.exists()) {
                System.out.println("\nФайл НЕ был найден в директории!");
                return;
            }

            LinkedList<Automobile> list_autoo = new LinkedList();
            DataInputStream doc = new DataInputStream(new FileInputStream(file_name));
            String[] mod = new String[10];

            //doc.readUTF(), doc.readUTF(), doc.readUTF(), doc.readUTF(), doc.readUTF(), doc.readUTF(), doc.readUTF(), doc.readUTF(), doc.readUTF())

            for(int i = 0; doc.available() > 0; ++i) {
                Automobile auto = new Automobile();

                for(int j = 0; j < 10; ++j) {
                    if (mod[j].equals(auto.getModel())) {
                        list_autoo.add(auto);
                    }
                }

                mod[i] = auto.getModel();
            }

            System.out.println("\nВаш список:");
            Iterator var20 = list_autoo.iterator();

            while(var20.hasNext()) {
                Automobile auto = (Automobile)var20.next();
                System.out.print(auto.getAutomobile());
            }

            this.list_auto = list_autoo;
        } catch (Exception var19) {
            System.out.println(var19.toString());
        }
*/
    }

    private void randomAccessFile_task() {
        try {
            RandomAccessFile file = new RandomAccessFile("seek.txt", "rw");
/*            Iterator var2 = this.list_auto.iterator();

            while(var2.hasNext()) {
                automobile auto = (automobile)var2.next();
                file.writeUTF(auto.getModel());
                file.writeUTF(auto.getRegion());
                file.writeUTF(auto.getNumber());
                file.writeUTF(auto.getWords_code());
                file.writeUTF(auto.getColor());
                file.writeUTF(auto.getSurname());
                file.writeUTF(auto.getName());
                file.writeUTF(auto.getAdress());
                file.writeUTF(auto.getDate());
            }
*/
            file.close();
            file = new RandomAccessFile("seek.txt", "rw");

            for(int i = 0; (long)i < file.length(); ++i) {
                System.out.println(file.readUTF());
            }
        } catch (Exception var4) {
        }

    }
}
