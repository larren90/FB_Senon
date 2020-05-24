package com.company;
import java.io.File;

import java.io.FileNotFoundException;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Task_1 {

    public void start_task_1() {

        System.out.println("Упражнение 1");

/*Упражнение 1:

*Исследовать возможности класса File по созданию файлов (пустых) и папок программой. Применение конструктора и метода.

• Создать файл в папке приложения с именем MyFile1.txt.

• Проверить появление файла в папке приложения.

• Создать файл с именем MyFile2.txt в корне определенного диска.

• Проверить появление файла в папке.

• Создать файл с именем MyFile3.txt в папке Имя диска\\Имя папки\\Имя файла.

• Проверить появление файла в папке.

• Создать папку третьего уровня, например, Первая\\Вторая\\Третья.

• Проверить появление папки.

• Все операции заключить в блок try, с обработчиками исключений IOException, Exception, FileNotFoundException.

*/

        try {
//1.1-1.2
//создаем файл
            String filename="MyFile1.txt";
            File F1 = new File(filename);
            if (F1.exists()) {
                System.out.println("Файл в папке проекта существует");
            } else {
                System.out.println("Файл в папке проекта НЕ существует");
                if (F1.createNewFile())
                {
                    System.out.println("Файл "+filename+" был создан");
                }
            }

            F1.deleteOnExit();
        }
        catch (FileNotFoundException ex)
        {
            System.out.println("File not found Exception in Task 1.1 " + ex);
        }
        catch (IOException ex)
        {
            System.out.println("IO Error in Task 1.1 " + ex);
        }
        catch (Exception ex){

            System.out.println("Exception in Task 1.1 " + ex);
            //io.printStackTrace();

        }

        try {

//создаем файл в корне диска С

//будет отказано в доступе, если это системный диск
//1.3-1.4
            File F2 = new File("D:\\MyFile2.txt");

            if(F2.createNewFile())

                System.out.println("Файл в корне диска существует");

            else

                System.out.println("Файл в корне диска НЕ существует");

            F2.deleteOnExit();

        }catch (Exception io){

            System.out.println("Error 2 " + io);

        }

        try {

//создаем файл с именем MyFile3.txt в папке Имя диска\\Имя папки\\Имя файла
//1.5-1.6
            File F3 = new File("D:\\ProgramData\\MyFile3.txt");

            if(F3.createNewFile())

                System.out.println("Файл в папке существует");

            else

                System.out.println("Файл в папке проекта НЕ существует");

            F3.deleteOnExit();

        }catch (Exception io){

            System.out.println("Error 3 " + io);

        }

        try {

//создаеим каталог папок первая\вторая\третья на диске С
//1.7-1.9
            File F4 = new File("D:\\Первая\\Вторая\\Третья");

            if(F4.mkdirs())

                System.out.println("Удалось создать каталог ");

            else

                System.out.println("НЕ удалось создать каталог ");

            if (F4.exists()) F4.deleteOnExit();

        }

        catch (Exception io){

            System.out.println("Error 4 " + io);

        }

        System.out.println("\n\nУпражнение 2");

/*Упражнение 2. Получить параметры файлов методами класса File.

В пунктах задания использовать объекты, созданные в задании 1.

• Проверить, что вызывающий объект содержит имя файла, а не папки и

отобразить имя файла, вызывающего объекта и его родительскую папку.

• Проверить, что вызывающий объект содержит имя папки, а не файла и

отобразить имя файла, вызывающего объекта.

• Проверить, что в папке приложения существует файл с именем MyFile1.txt.

• Отобразить полный путь к файлу или папке объекта.

• Отобразить размер файла или папки объекта, указать единицу измерения. Прокомментировать вид файла – папка или файл.

*/

        /*Довольно странная формулировка задания в первых двух пунктах. Буду это понимать так:

         * Берем из предыдущего упражнения пути к 4 файлам. Сначала проверяем указывают ли они на объект и отображаем

         * имя объектра и родительскую папку. Затем еще раз проверяем эти файлы, если они они содержат только путь к папке

         * и веведем имя этой папки*/

//проверим по-очереди F1 F2 F3
        try {

//2.1-2.2

            File F1 = new File("MyFile1.txt");
            System.out.println(F1.toPath());
            if(Files.isRegularFile(F1.toPath())){

                System.out.println(F1.getCanonicalPath());

            }

            else

                System.out.println("Вывзывающий объект не содержит имя файла");

        }catch (Exception io){

            System.out.println("Error 1" + io);

        }

        try {

//2.3-2.4

            File F2 = new File("D:\\");
            //System.out.println(F2.toPath());
            if(Files.isDirectory(F2.toPath())){

                System.out.println(F2.getCanonicalPath());

            }

            else

                System.out.println("Вывзывающий объект не является папкой");

        }catch (Exception io){

            System.out.println("Error 2" + io);

        }

        try {

//2.5-2.7
            if (Files.exists(Paths.get("MyFile1.txt"))) {
                System.out.println("MyFile1.txt существует");
                File F3 = new File("MyFile1.txt");
                System.out.println(F3.getCanonicalPath());
                System.out.println("File size:"+F3.length()+" байт");
            } else {
                System.out.println("MyFile1.txt не существует");
            }
        }
        catch (Exception io){

            System.out.println("Error 3" + io);

        }


/*Упражнение 3. Модификация файловой структуры приложения средствами класса File.

1. Добавить в папку приложения еще одну папку.

2. Сформировать массив файлов, находящихся в папке приложения, используя метод list(). Отобразить содержимое массива.

3. Сформировать массив файлов, находящихся в папке приложения, используя метод listFiles( ).

Отобразить содержимое массива. Определить количество папок, содержащихся в файле приложения.

4. Удалить папки и файлы созданные во всех трех упражнениях

*/

// добавим новую папку в приложении
//3.1
        try{


            File F5 = new File("New");

            F5.mkdir();

            System.out.println("Папка добавлена");

            F5.deleteOnExit();

        }

        catch (Exception io){

            System.out.println("Error 5" + io);

        }
// сформируем массив файлов в папке приложения с помощью list
//3.2-3.3
        try {

            //Получаем имя пользовательской папки (где запускается программа)
            File F6 = new File(System.getProperty("user.dir"));
            System.out.println(F6);
            String[] paths = F6.list();//Получаем список файлов в этой папке

            System.out.print("Файлы папки приложения: ");

// и выведем на экран

            for(String path : paths){

                System.out.print(path+" , ");

            }

            System.out.println();

            //F6.deleteOnExit();

        }catch (Exception io){

            System.out.println("Error 6 " + io);

        }

        try {

// сформируем массив файлов с помощью ListFiles и посчитаем сколкьо папок с помощью isDirectory()
//3.3-3.4
            File F7 = new File(System.getProperty("user.dir"));

            File[] paths = F7.listFiles();

            System.out.print("Файлы папки приложения: ");

            int count_directory = 0;

            for(File path : paths){

                System.out.print(path.getName() + " , ");

                if(path.isDirectory())

                    count_directory++;

            }

            System.out.println(" Из них папок " + count_directory );

            F7.deleteOnExit();

        }catch (Exception io){

            System.out.println("Error 7 " + io);

        }

// все созданные файлы удаляются в конце с помощью метода deleteOnExit()

        System.out.println("Все созданные файлы будут удалены после закрытия приложения с помощью команды '0' " + "\n\n\n");

    }

}