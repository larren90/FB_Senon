package com.company;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.util.Vector;

public class Main {

    static GroupMeetSystem gms=new GroupMeetSystem();

    public static void main(String[] args)
    {

        //gms.load("users.dat");
        gms.AddUser("petrov","petrov","petrov");
        gms.AddUser("sidorov","sidorov","sidorov");
        gms.AddUser("ivanov","ivanov","ivanov");
        gms.GetByUserName("petrov").addRequest("London",1,10,12);
        gms.GetByUserName("petrov").addRequest("London",2,11,13);
        gms.GetByUserName("petrov").addRequest("Paris",3,15,17);

        gms.GetByUserName("sidorov").addRequest("Moscow",2,11,13);
        gms.GetByUserName("sidorov").addRequest("London",1,10,13);
        gms.GetByUserName("sidorov").addRequest("New York",3,15,17);

        gms.GetByUserName("ivanov").addRequest("London",1,9,12);
        gms.GetByUserName("ivanov").addRequest("Moscow",2,12,13);
        gms.GetByUserName("ivanov").addRequest("Banjin",3,15,17);


        JFrame jFrame=new JFrame("Аутентификация");
        jFrame.setDefaultCloseOperation(jFrame.EXIT_ON_CLOSE);
        jFrame.setLayout(new FlowLayout(FlowLayout.LEFT));
        JLabel lblLogin=new JLabel("Логин   ");
        JLabel lblPassword=new JLabel("Пароль");
        JTextField tfLogin=new JTextField(15);
        //tfLogin.setSize(100,40);
        tfLogin.setFont(new Font("Dialog",Font.PLAIN,14));
        JPasswordField pfPassword=new JPasswordField(15);
        pfPassword.setEchoChar('*');
        //pfPassword.setSize(100,40);
        JButton btnOK=new JButton("OK");
        btnOK.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jFrame.setVisible(false);
                main2();
                /*
                if (gms.findUser(tfLogin.getText(),pfPassword.getText())!=null)
                {
                    jFrame.setVisible(false);
                    main2();
                }
                    else
                       JOptionPane.showMessageDialog(jFrame,"Не правильный логин или пароль");
                  */
            }
        });


        JPanel content=new JPanel(new FlowLayout(FlowLayout.LEFT));

        content.add(lblLogin);
        content.add(tfLogin);
        content.add(lblPassword);
        content.add(pfPassword);
        content.add(btnOK);
        content.setVisible(true);
        jFrame.setContentPane(content);
        jFrame.setSize(250,250);
        jFrame.setVisible(true);
    }

    public static void main2()//Основая форма
    {
        JFrame jFrame=new JFrame("Lab3 GI");
        jFrame.setSize(500,300);
        jFrame.setDefaultCloseOperation(jFrame.EXIT_ON_CLOSE);
        jFrame.setLayout(new FlowLayout());
        //jFrame.setLocation(500,400);
        //String s1[] = { "Jalpaiguri", "Mumbai", "Noida", "Kolkata", "New Delhi" };
        JComboBox<String> jComboBox=new JComboBox<String>(gms.getUserNames());
        JButton jbtnAddUser = new JButton("Add user");
        JButton jbtnSaveList = new JButton("Save list members");
        JButton jbtnLoadList = new JButton("Load list members");
        //JButton jbtnSelectCurrent = new JButton(" Select current member");
        JButton jbtnAddRequest = new JButton("Add request");
        JButton jbtnShowAllRequest = new JButton("Show all requests");
        JButton jbtnClearList = new JButton("Clear list");
        JButton jbtnClearCurrentUserRequestList = new JButton("Clear current user requests list ");
        JButton jbtnShowVariants = new JButton("Show variants");
        JButton jbtnExit = new JButton("Exit");

        JTextArea jtaRequests = new JTextArea("", 8, 25);
        JScrollPane jScroll = new JScrollPane(jtaRequests,
                JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
                JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        //jtaRequests.setText();
        // Шрифт и табуляция
        jtaRequests.setFont(new Font("Dialog", Font.PLAIN, 14));
        jtaRequests.setTabSize(10);
        //jtaRequests.scrollRectToVisible();
        //ДОБАВЛЕНИЕ ПОЛЬЗОВАТЕЛЯ
        jbtnAddUser.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JFrame jFrame=new JFrame("Добавление пользователя");
                jFrame.setDefaultCloseOperation(jFrame.HIDE_ON_CLOSE);
                jFrame.setLayout(new FlowLayout(FlowLayout.LEFT));
                JLabel lblUserName=new JLabel("Имя пользователя");
                JLabel lblLogin=new JLabel("Логин   ");
                JLabel lblPassword=new JLabel("Пароль");
                JTextField tfLogin=new JTextField(15);
                JTextField tfUserName=new JTextField(15);
                //tfLogin.setSize(100,40);
                //tfLogin.setFont(new Font("Dialog",Font.PLAIN,14));
                JTextField tfPassword=new JTextField(15);
                JButton btnOK=new JButton("OK");
                JButton btnCancel=new JButton("Cancel");
                btnOK.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if (tfUserName.getText().equals("")==true)
                        {
                            JOptionPane.showMessageDialog( jFrame,"User name isn't defined");
                            return;
                        }
                        //ДОБАВИТЬ ПРОВЕРКУ ДАННЫХ
                        if (tfLogin.getText().equals("")==true) return;
                        if (tfPassword.getText().equals("")==true) return;
                        gms.AddUser(tfUserName.getText(),tfLogin.getText(),tfPassword.getText());
                        jFrame.setVisible(false);
                        jComboBox.removeAllItems();
                        for(String name:gms.getUserNames() )
                            jComboBox.addItem(name);
                    }
                });
                btnCancel.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        jFrame.setVisible(false);
                    }
                });

                JPanel content=new JPanel(new FlowLayout(FlowLayout.LEFT));
                content.add(lblUserName);
                content.add(tfUserName);
                content.add(lblLogin);
                content.add(tfLogin);
                content.add(lblPassword);
                content.add(tfPassword);
                content.add(btnOK);
                content.add(btnCancel);
                content.setVisible(true);
                jFrame.setContentPane(content);
                jFrame.setSize(200,220);
                jFrame.setVisible(true);

            }
        });
        //ДОБАВЛЕНИЕ ЗАПРОСА
        jbtnAddRequest.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JFrame jFrame=new JFrame("Добавление запроса");
                jFrame.setDefaultCloseOperation(jFrame.HIDE_ON_CLOSE);
                jFrame.setLayout(new FlowLayout(FlowLayout.LEFT));
                JLabel lblCityName=new JLabel("Название города");
                JLabel lblDay=new JLabel("День  ");
                JLabel lblStartTime=new JLabel("Начало");
                JLabel lblFinishTime=new JLabel("Окончание");
                JTextField tfCityName=new JTextField(15);
                JTextField tfDay=new JTextField(15);
                JTextField tfStartTime=new JTextField(15);
                JTextField tfFinishTime=new JTextField(15);
                JButton btnOK=new JButton("OK");
                JButton btnCancel=new JButton("Cancel");
                btnOK.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if (tfCityName.getText().equals("")==true)
                        {
                            JOptionPane.showMessageDialog( jFrame,"City name isn't defined");
                            return;
                        }
                        //ДОБАВИТЬ ПРОВЕРКУ ДАННЫХ
                        if (tfDay.getText().equals("")==true) return;
                        if (tfStartTime.getText().equals("")==true) return;
                        if (tfFinishTime.getText().equals("")==true) return;
                        gms.GetByUserName((String)jComboBox.getSelectedItem()).addRequest(tfCityName.getText(),
                                         Integer.parseInt(tfDay.getText()),
                                    Integer.parseInt(tfStartTime.getText()),
                                Integer.parseInt(tfFinishTime.getText()));
                        //gms.AddUser(tfUserName.getText(),tfLogin.getText(),tfPassword.getText());
                        jFrame.setVisible(false);
                        jtaRequests.setText(gms.GetByUserName((String)jComboBox.getSelectedItem()).getStringRequests());
                    }
                });
                btnCancel.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        jFrame.setVisible(false);
                    }
                });

                JPanel content=new JPanel(new FlowLayout(FlowLayout.LEFT));
                content.add(tfCityName);
                content.add(tfDay);
                content.add(tfFinishTime);
                content.add(tfStartTime);
                //content.add(lblPassword);
                //content.add(tfPassword);
                content.add(btnOK);
                content.add(btnCancel);
                content.setVisible(true);
                jFrame.setContentPane(content);
                jFrame.setSize(200,220);
                jFrame.setVisible(true);

            }
        });

        //ОБРАБОТЧИК СОБЫТИЯ ВЫБОРА ЭЛЕМЕНТА В ComboBox
        jComboBox.addActionListener(new ActionListener() {
                                        public void actionPerformed(ActionEvent ae) {
                                            //jtaRequests.setText((String)jComboBox.getSelectedItem());
                                            if (gms.GetByUserName((String)jComboBox.getSelectedItem())!=null)
                                                jtaRequests.setText(gms.GetByUserName((String)jComboBox.getSelectedItem()).getStringRequests());
                                            else jtaRequests.setText("");
                                        }
                                    }
        );
        jtaRequests.setText(gms.GetById(0).getStringRequests());//получаем данные первого пользователя (надо понять как сами вызвать событие)
        jbtnExit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jFrame.dispatchEvent(new WindowEvent(jFrame, WindowEvent.WINDOW_CLOSING));
                //jFrame.setVisible(false); //you can't see me!
                //jFrame.dispose(); //Destroy the JFrame object
            }
        });
        jbtnSaveList.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FileDialog fd=new FileDialog(jFrame,"Save file as...",FileDialog.SAVE);
                fd.setVisible(true);
                if (fd.getFile()!="")
                {
                    String filename=fd.getDirectory()+fd.getFile();
                    gms.save(filename);
                }
            }
        });
        jbtnLoadList.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FileDialog fd=new FileDialog(jFrame,"Load file as...",FileDialog.LOAD);
                fd.setVisible(true);
                if (fd.getFile()!="")
                {
                    String filename=fd.getDirectory()+fd.getFile();
                    gms.load(filename);
                    jComboBox.removeAllItems();
                    for (String el:gms.getUserNames())
                    {
                        jComboBox.addItem(el);
                    }

                }
            }
        });
        jbtnClearList.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jComboBox.removeAllItems();
                jtaRequests.setText("");
            }
        });

        jbtnClearCurrentUserRequestList.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (gms.GetByUserName((String)jComboBox.getSelectedItem())!=null)
                gms.GetByUserName((String)jComboBox.getSelectedItem()).clearRequests();
                jtaRequests.setText("Requests list is empty");
            }
        });
        jbtnShowAllRequest.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //gms.showAllRequests();
                jtaRequests.setText(gms.GetAllRequests());
            }
        });
        jbtnShowVariants.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gms.processRequests();
                gms.GetProcessRequests();
                jtaRequests.setText(gms.GetResult());
            }
        });
        JPanel panel=new JPanel();
        panel.setLayout(new FlowLayout());
        panel.add(jScroll);
        jFrame.add(panel);
        jFrame.setLocationRelativeTo(null);

        jFrame.add(jbtnAddRequest);
        jFrame.add(jbtnAddUser);
        jFrame.add(jbtnClearCurrentUserRequestList);
        jFrame.add(jbtnClearList);
        jFrame.add(jbtnExit);
        jFrame.add(jbtnLoadList);
        jFrame.add(jbtnSaveList);
        //jFrame.add(jbtnSelectCurrent);
        jFrame.add(jbtnShowAllRequest);
        jFrame.add(jbtnShowVariants);
        jFrame.add(jComboBox);
        //jFrame.add(jtaRequests);
        jFrame.add(jScroll);

        jFrame.setVisible(true);
    }
}
