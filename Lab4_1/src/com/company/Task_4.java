package com.company;

import java.util.Date;

public class Task_4 {

    public Task_4()
    {
    }

    public void start_task_4()
    {
        try {
            //Create serializable file
            ListAuto list=new ListAuto();
            //Заполняем список
            ClassTextFile classTextFile=new ClassTextFile(list);
            //Сохрнаяем на диск
            ClassSerializableFile.save("list.ser",list);
        }
        catch (Exception exc)
        {
            System.out.println(exc);
        }
        try {
            //Считываем данные с диска
            ListAuto list=ClassSerializableFile.load("list.ser");
            System.out.println(list);
        }
        catch (Exception exc)
        {
            System.out.println(exc);
        }
    }

}
