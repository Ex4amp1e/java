package javalaba4;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import static java.awt.Component.CENTER_ALIGNMENT;
import javax.swing.table.DefaultTableModel;

public class Form extends JFrame {
    
    private static Group people = new Group();

    private JButton AdBut = new JButton("Добавить запись");
    private JButton DelBut = new JButton("Удалить запись");
    private JButton FindBut = new JButton("Найти запись");
    private JButton ExBut = new JButton("Выйти из базы данных");

    private JTable Tab;

    private JScrollPane Scroll;

    private String[] Cols = {"№", "Фамилия", "Должность", "Стаж", "Знание англ","Зарплата"};

    private JLabel LabelAdd, LabelSall,LabelSell, LabelDel;

    private Component VerticalStrut = Box.createVerticalStrut(5);

    private Box BoxMain, BoxAdd, BoxDel, BoxExit;

    private JPanel RType,RType1,RType2, Bts, ExPanel, BtAd;

    private JRadioButton RRab, RInj, RAdmin, RYes, RNo,R1,R2,R3,R4;

    private JTextField AddFam, AddAge, AddKof, DelField;

    public Form() {

        super("База данных 'Завод' ");

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setMinimumSize(new Dimension(800, 600));
        setMaximumSize(new Dimension(800, 600));

        Tab = new JTable(people.showTabData(), Cols);
        Tab.getColumnModel().getColumn(0).setMaxWidth(30);
        Scroll = new JScrollPane(Tab);
        getContentPane().add(Scroll, BorderLayout.CENTER);

        BoxAdd = Box.createVerticalBox();
        Dimension AddSize = new Dimension(350, 500);
        BoxAdd.setMinimumSize(AddSize);
        BoxAdd.setPreferredSize(AddSize);
        BoxAdd.setMaximumSize(AddSize);
        BoxAdd.setBorder(new TitledBorder("Запись"));

        LabelAdd = new JLabel("Введите фамилию");
        LabelAdd.setAlignmentX(CENTER_ALIGNMENT);

        AddFam = new JTextField("", 40);
        AddFam.setMinimumSize(AddSize);
        AddFam.setMaximumSize(AddSize);
        AddFam.setHorizontalAlignment(JTextField.LEFT);

        LabelSall = new JLabel("Введите стаж");
        LabelSall.setAlignmentX(CENTER_ALIGNMENT);
        LabelSell = new JLabel("Введите коэффтцент");
        LabelSell.setAlignmentX(CENTER_ALIGNMENT);
       

        AddAge = new JTextField("", 40);
        AddAge.setMinimumSize(AddSize);
        AddAge.setMaximumSize(AddSize);
        AddAge.setHorizontalAlignment(JTextField.LEFT);
        
        AddKof = new JTextField("", 40);
        AddKof.setMinimumSize(AddSize);
        AddKof.setMaximumSize(AddSize);
        AddKof.setHorizontalAlignment(JTextField.LEFT);

        BtAd = new JPanel();
        BtAd.setLayout(new GridLayout(1, 1));
        BtAd.add(AdBut);
        BtAd.add(FindBut);

        RType = new JPanel();
        RType.setBorder(new TitledBorder("Выберите должность"));
        RType.setLayout(new GridLayout(3, 1));
        RRab = new JRadioButton("Рабочий");
        RInj = new JRadioButton("Инженер");
        RAdmin = new JRadioButton("Администратор");
        RType.add(RRab);
        RType.add(RInj);
        RType.add(RAdmin);
        
        RType1 = new JPanel();
        RType1.setBorder(new TitledBorder("Знает ли работник Eng"));
        RType1.setLayout(new GridLayout(2, 1));
        RYes = new JRadioButton("Да");
        //RYes.setEnabled(true);
        RNo = new JRadioButton("Нет");
        //RYes.setSelected(true);
        RType1.add(RYes);
        RType1.add(RNo);
        
        RType2 = new JPanel();
        RType2.setBorder(new TitledBorder("Поиск"));
        RType2.setLayout(new GridLayout(4, 1));
        R1 = new JRadioButton("По фамилии");
        R2 = new JRadioButton("По должности");
        R3 = new JRadioButton("По знанию Eng");
        R4 = new JRadioButton("По стажу");
        RType2.add(R1);
        RType2.add(R2);
        RType2.add(R3);
        RType2.add(R4);
        
        BoxAdd.add(LabelAdd);
        BoxAdd.add(AddFam);
        BoxAdd.add(LabelSall);
        BoxAdd.add(AddAge);
        BoxAdd.add(LabelSell);
        BoxAdd.add(AddKof);
        BoxAdd.add(Box.createVerticalStrut(5));
        BoxAdd.add(RType);
        BoxAdd.add(Box.createVerticalStrut(5));
        BoxAdd.add(RType1);
        BoxAdd.add(Box.createVerticalStrut(5));
        BoxAdd.add(RType2);
        BoxAdd.add(Box.createVerticalStrut(5));
        BoxAdd.add(BtAd);
        
        BoxDel = Box.createVerticalBox();
        Dimension DelSize = new Dimension(350, 90);
        BoxDel.setMinimumSize(DelSize);
        BoxDel.setPreferredSize(DelSize);
        BoxDel.setMaximumSize(DelSize);
        BoxDel.setBorder(new TitledBorder("Удаление записи"));

        LabelDel = new JLabel("Введите номер записи");
        LabelDel.setAlignmentX(CENTER_ALIGNMENT);

        Bts = new JPanel();
        Bts.setLayout(new GridLayout(1, 1, 5, 10));
        Bts.add(DelBut);

        DelField = new JTextField("", 40);
        DelField.setHorizontalAlignment(JTextField.LEFT);
        DelField.setMinimumSize(DelSize);
        DelField.setMaximumSize(DelSize);

        BoxDel.add(LabelDel);
        BoxDel.add(DelField);
        BoxDel.add(Bts);

        BoxExit = Box.createVerticalBox();
        Dimension ExSize = new Dimension(350, 50);
        BoxExit.setMinimumSize(ExSize);          
        BoxExit.setMaximumSize(ExSize);   

        ExPanel = new JPanel();
        ExPanel.setLayout(new GridLayout(1, 1));
        ExPanel.add(ExBut);
        BoxExit.setBorder(new TitledBorder(" "));
        BoxExit.add(ExPanel);

        BoxMain = Box.createVerticalBox();   
        BoxMain.add(BoxAdd);
        BoxMain.add(Box.createVerticalGlue());
        BoxMain.add(BoxDel);
        BoxMain.add(Box.createVerticalGlue());
        BoxMain.add(BoxExit);
        getContentPane().add(BoxMain, BorderLayout.EAST);

        FindBut.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                if (R1.isSelected()){String Name = AddFam.getText();
                int[] a=people.findFam(Name);
                
                if (a.length>0) {JOptionPane.showMessageDialog(FindBut, "Найдены записи по вашему запросу", "Внимание!", JOptionPane.INFORMATION_MESSAGE);
                    ReShowFind(a);}
                else{JOptionPane.showMessageDialog(FindBut, "Не найдено ни одно записи по этому запросу", "Внимание!", JOptionPane.INFORMATION_MESSAGE);}
                }
                
                if (R2.isSelected()){
                   String Name=null; 
                    if (RRab.isSelected()){Name ="Рабочий";}
                    if (RInj.isSelected()){Name ="Инженер";}
                    if (RAdmin.isSelected()){Name ="Администратор";}
                    int[] a=people.findPro(Name);
                
                if (a.length>0) {JOptionPane.showMessageDialog(FindBut, "Найдены записи по вашему запросу", "Внимание!", JOptionPane.INFORMATION_MESSAGE);
                    ReShowFind(a);}
                else{JOptionPane.showMessageDialog(FindBut, "Не найдено ни одно записи по этому запросу", "Внимание!", JOptionPane.INFORMATION_MESSAGE);}
                }
                
                
                if (R3.isSelected()){String Name = null;
                if (RYes.isSelected()){Name="ДА";}
                if (RNo.isSelected()){Name="НЕТ";}    
                
                int[] a=people.findEng(Name);
                
                if (a.length>0) {JOptionPane.showMessageDialog(FindBut, "Найдены записи по вашему запросу", "Внимание!", JOptionPane.INFORMATION_MESSAGE);
                    ReShowFind(a);}
                else{JOptionPane.showMessageDialog(FindBut, "Не найдено ни одно записи по этому запросу", "Внимание!", JOptionPane.INFORMATION_MESSAGE);}
                }
                
                
                
                
                if (R4.isSelected()){String Name = AddAge.getText(); int Age = 0;

                try{Age=Integer.parseInt(Name);}
                catch (NumberFormatException e) {  
                JOptionPane.showMessageDialog(FindBut, "Не найдено ни одно записи по этому запросу", "Внимание!", JOptionPane.INFORMATION_MESSAGE); }           
                if (Age>0){
                int[] a=people.findAge(Age);
                
                if (a.length>0) {JOptionPane.showMessageDialog(FindBut, "Найдены записи по вашему запросу", "Внимание!", JOptionPane.INFORMATION_MESSAGE);
                    ReShowFind(a);}
                else{JOptionPane.showMessageDialog(FindBut, "Не найдено ни одно записи по этому запросу", "Внимание!", JOptionPane.INFORMATION_MESSAGE);}
                }
            }
            }});

        ExBut.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                System.exit(0);
            }
        });

        DelBut.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                String Name = DelField.getText();
                if (people.delete(Name)) {
                    ReShow();
                    JOptionPane.showMessageDialog(DelBut, "Запись успешно удалена из базы данных", "Внимание!", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(DelBut, "Запись с таким номером не найдена", "Внимание!", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        });

        AdBut.addActionListener(new ActionListener() {                           
            @Override
            public void actionPerformed(ActionEvent event) {
                String Fam, Age, Kof = null;
                boolean Eng;
                if (RYes.isSelected()){Eng=true;}
                else{Eng=false;}
            
                Fam = AddFam.getText();
                try {Age = AddAge.getText(); 
                     Kof = AddKof.getText(); 
                        if ((Integer.parseInt(Kof)>0)&&(Integer.parseInt(Age)>0)) {
                                if(RRab.isSelected()){
                                people.addRab(Fam, Integer.parseInt(Age), Eng, Integer.parseInt(Kof));
                                ReShow();
                                JOptionPane.showMessageDialog(AdBut, "Рабочий успешно добавлен", "Внимание!", JOptionPane.INFORMATION_MESSAGE);}
                                if(RInj.isSelected()){
                                people.addInj(Fam, Integer.parseInt(Age), Eng, Integer.parseInt(Kof));
                                ReShow();
                                JOptionPane.showMessageDialog(AdBut, "Инженер успешно добавлен", "Внимание!", JOptionPane.INFORMATION_MESSAGE);}
                                if(RAdmin.isSelected()){
                                people.addAdmin(Fam, Integer.parseInt(Age), Eng, Integer.parseInt(Kof));
                                ReShow();
                                JOptionPane.showMessageDialog(AdBut, "Администртор успешно добавлен", "Внимание!", JOptionPane.INFORMATION_MESSAGE);}
                            } else {
                                JOptionPane.showMessageDialog(AdBut, "Стаж или коэффицент должен быть больше чем 0", "Внимание!", JOptionPane.INFORMATION_MESSAGE);
                            }
                        } 
                    
                        catch (NumberFormatException e) {
                        JOptionPane.showMessageDialog(AdBut, "Числа в полях 'Стаж' и 'Коэффицент' должны быть целыми'. Повторите ввод", "Внимание!", JOptionPane.WARNING_MESSAGE);
                    }
            }
        });
                   
     
        
                     

        RRab.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                BoxAdd.remove(BtAd);
                BoxAdd.add(BtAd);
                RRab.setSelected(true);
                RInj.setSelected(false);
                RInj.setSelected(false);
                repaint();
                pack();
            }
        });

        RInj.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                BoxAdd.remove(BtAd);
                BoxAdd.add(BtAd);
                RRab.setSelected(false);
                RInj.setSelected(true);
                RAdmin.setSelected(false);
                repaint();
                pack();
            }
        });

        RAdmin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                BoxAdd.remove(BtAd);
                BoxAdd.add(BtAd);
                RRab.setSelected(false);
                RInj.setSelected(false);
                RAdmin.setSelected(true);
                repaint();
                pack();
            }
        });                 

        RYes.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                RYes.setSelected(true);
                RNo.setSelected(false);
                repaint();
                pack();
            }
        });

        RNo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                RYes.setSelected(false);
                RNo.setSelected(true);
                repaint();
                pack();
            }
        });
        
        R1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                BoxAdd.remove(BtAd);
                BoxAdd.add(BtAd);
                R1.setSelected(true);
                R2.setSelected(false);
                R3.setSelected(false);
                R4.setSelected(false);
                repaint();
                pack();
            }
        }); 
        
        R2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                BoxAdd.remove(BtAd);
                BoxAdd.add(BtAd);
                R1.setSelected(false);
                R2.setSelected(true);
                R3.setSelected(false);
                R4.setSelected(false);
                repaint();
                pack();
            }
        }); 
        
        R3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                BoxAdd.remove(BtAd);
                BoxAdd.add(BtAd);
                R1.setSelected(false);
                R2.setSelected(false);
                R3.setSelected(true);
                R4.setSelected(false);
                repaint();
                pack();
            }
        }); 
        
        R4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                BoxAdd.remove(BtAd);
                BoxAdd.add(BtAd);
                R1.setSelected(false);
                R2.setSelected(false);
                R3.setSelected(false);
                R4.setSelected(true);
                repaint();
                pack();
            }
        }); 
        
        pack();
    }

    private void ReShow() {
        getContentPane().remove(Scroll);
        Tab = new JTable(people.showTabData(), Cols);
        Tab.getColumnModel().getColumn(0).setMaxWidth(30);
        Tab.getColumnModel().getColumn(5).setMinWidth(150);
        Scroll = new JScrollPane(Tab);
        getContentPane().add(Scroll, BorderLayout.CENTER);
        pack();
    }
    
    
    
    private void ReShowFind(int[] a) {
        getContentPane().remove(Scroll);
        Tab = new JTable(people.showTabDataFind(a), Cols);
        Tab.getColumnModel().getColumn(0).setMaxWidth(30);
        Tab.getColumnModel().getColumn(5).setMinWidth(150);
        Scroll = new JScrollPane(Tab);
        getContentPane().add(Scroll, BorderLayout.CENTER);
        pack();
    }
}