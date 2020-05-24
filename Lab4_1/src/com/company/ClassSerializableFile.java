package com.company;

import java.io.*;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Member;

public class ClassSerializableFile {
    //Сериализация в файл
   static public void save(String filename,ListAuto listAuto)
    {
        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename)))
        {
            oos.writeObject(listAuto);
            System.out.println("File has been written");
        }
        catch(Exception ex)
        {
            System.out.println("***** Has been error! *****");
            System.out.println(ex.getMessage());
        }
    }

    //Десериализация из файла
    static public ListAuto load(String filename)
    {
        ListAuto listAuto=new ListAuto();
        try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename)))
        {

            listAuto=((ListAuto)ois.readObject());
            return listAuto;
        }
        catch(Exception ex){
            System.out.println("***** Has been error! *****");
            System.out.println(ex.getMessage());
        }
        return null;
    }
}
