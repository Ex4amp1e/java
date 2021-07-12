package javalaba5;

import java.util.ArrayList;
import java.awt.*;
import java.awt.event.*;
import javalaba4.Group;
import javax.swing.*;
import javax.swing.border.*;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import static java.awt.Component.CENTER_ALIGNMENT;

public class Form extends JFrame {

    private static Group organisations = new Group();

    private JButton AdBut = new JButton("Добавить организацию");
    private JButton DelBut = new JButton("Удалить организацию");
    private JButton FindBut = new JButton("Поиск");
    private JButton CancelBut = new JButton("Сбросить");
    private JButton ExBut = new JButton("Выйти");

    private JTable Tab;

    private JScrollPane Scroll;

    private String[] Cols = {"№", "Тип", "Название", "Число рабочих", "Государственная?", "Спецификация"};

    private JLabel LabelAdd, LabelSall, LabelSull, LabelDel;

    //private Component VerticalStrut = Box.createVerticalStrut(5);

    private Box BoxMain, BoxAdd, BoxDel, BoxExit;

    private JPanel RType, RType1, RType2, Bts, ExPanel, BtAd, BtSc;

    private JRadioButton RStrahComp, RStroiComp, RZavod, R1, R2, R3, R4, RYes, RNo;
                   

    private JTextField AddName, AddchisRab, AddField, DelField, Search;

    public Form() {

        super("Организации");

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setMinimumSize(new Dimension(1300, 680));
        //setMaximumSize(new Dimension(1000, 700));

        Tab = new JTable(organisations.showTabData(), Cols);
        Tab.getColumnModel().getColumn(0).setMaxWidth(30);
        Scroll = new JScrollPane(Tab);
        getContentPane().add(Scroll, BorderLayout.CENTER);

        BoxAdd = Box.createVerticalBox();
        Dimension AddSize = new Dimension(350, 550);
        BoxAdd.setMinimumSize(AddSize);
        BoxAdd.setPreferredSize(AddSize);
        BoxAdd.setMaximumSize(AddSize);
        BoxAdd.setBorder(new TitledBorder("Запись"));

        LabelAdd = new JLabel("Введите название");
        LabelAdd.setAlignmentX(CENTER_ALIGNMENT);

        AddName = new JTextField("", 40);
        AddName.setMinimumSize(AddSize);
        AddName.setMaximumSize(AddSize);
        AddName.setHorizontalAlignment(JTextField.LEFT);

        LabelSall = new JLabel("Введите число рабочих");
        LabelSall.setAlignmentX(CENTER_ALIGNMENT);
        
        LabelSull = new JLabel("Введите кол-во цехов: ");
        LabelSull.setAlignmentX(CENTER_ALIGNMENT);

        AddchisRab = new JTextField("", 40);
        AddchisRab.setMinimumSize(AddSize);
        AddchisRab.setMaximumSize(AddSize);
        AddchisRab.setHorizontalAlignment(JTextField.LEFT);

        AddField = new JTextField("", 40);
        AddField.setMinimumSize(AddSize);
        AddField.setMaximumSize(AddSize);
        AddField.setHorizontalAlignment(JTextField.LEFT);

        Search = new JTextField("", 40);
        Search.setMinimumSize(AddSize);
        Search.setMaximumSize(AddSize);
        Search.setHorizontalAlignment(JTextField.LEFT);

        BtAd = new JPanel();
        BtAd.setLayout(new GridLayout(1, 1));
        BtAd.add(AdBut);

        BtSc = new JPanel();
        BtSc.setLayout(new GridLayout(1, 2));
        BtSc.add(FindBut);
        BtSc.add(CancelBut);

        RType = new JPanel();
        RType.setBorder(new TitledBorder("Выберите тип"));
        RType.setLayout(new GridLayout(3, 1));
        RStrahComp = new JRadioButton("Страховая компания");
        RStroiComp = new JRadioButton("Строительная компания");
        RZavod = new JRadioButton("Завод");
        RZavod.setSelected(true);
        RType.add(RZavod);
        RType.add(RStrahComp);
        RType.add(RStroiComp);
        
        
        RType2 = new JPanel();
        RType2.setBorder(new TitledBorder("Государственная ли организация?"));
        RType2.setLayout(new GridLayout(1, 2));
        RYes = new JRadioButton("Да");
        RYes.setSelected(true);
        RNo = new JRadioButton("Нет");
        RType2.add(RYes);
        RType2.add(RNo);

        RType1 = new JPanel();
        RType1.setBorder(new TitledBorder("Поиск"));
        RType1.setLayout(new GridLayout(4, 1));
        R1 = new JRadioButton("По типу");
        R1.setSelected(true);
        R2 = new JRadioButton("По названию");
        R3 = new JRadioButton("По числу рабочих");
        R4 = new JRadioButton("По принадлежности к государству");
        RType1.add(R1);
        RType1.add(R2);
        RType1.add(R3);
        RType1.add(R4);

        BoxAdd.add(LabelAdd);
        BoxAdd.add(AddName);
        BoxAdd.add(LabelSall);
        BoxAdd.add(AddchisRab);
        //BoxAdd.add(LabelSell);
        //BoxAdd.add(AddPrice);
        BoxAdd.add(LabelSull);
        BoxAdd.add(AddField);
        BoxAdd.add(Box.createVerticalStrut(5));
        BoxAdd.add(RType);
        BoxAdd.add(Box.createVerticalStrut(5));
        BoxAdd.add(RType2);
        BoxAdd.add(Box.createVerticalStrut(5));
        BoxAdd.add(BtAd);
        BoxAdd.add(Box.createVerticalStrut(5));
        BoxAdd.add(RType1);
        BoxAdd.add(Box.createVerticalStrut(5));
        BoxAdd.add(Search);
        BoxAdd.add(Box.createVerticalStrut(5));
        BoxAdd.add(BtSc);

        BoxDel = Box.createVerticalBox();
        Dimension DelSize = new Dimension(350, 90);
        BoxDel.setMinimumSize(DelSize);
        BoxDel.setPreferredSize(DelSize);
        BoxDel.setMaximumSize(DelSize);
        BoxDel.setBorder(new TitledBorder("Удаление записи"));

        LabelDel = new JLabel("Введите номер записи");
        LabelDel.setAlignmentX(CENTER_ALIGNMENT);

        Bts = new JPanel();
        Bts.setLayout(new GridLayout(1, 1));
        Bts.add(DelBut);

        DelField = new JTextField("", 40);
        DelField.setHorizontalAlignment(JTextField.LEFT);
        DelField.setMinimumSize(DelSize);
        DelField.setMaximumSize(DelSize);

        BoxDel.add(LabelDel);
        BoxDel.add(DelField);
        BoxDel.add(Box.createVerticalStrut(5));
        BoxDel.add(Bts);

        BoxExit = Box.createVerticalBox();
        Dimension ExSize = new Dimension(350, 50);
        BoxExit.setMinimumSize(ExSize);
        BoxExit.setMaximumSize(ExSize);

        ExPanel = new JPanel();
        ExPanel.setLayout(new GridLayout(1, 1));
        ExPanel.add(ExBut);
        BoxExit.setBorder(new TitledBorder("Выход из базы данных"));
        BoxExit.add(ExPanel);

        BoxMain = Box.createVerticalBox();
        BoxMain.add(BoxAdd);
        //BoxMain.add(Box.createVerticalGlue());
        BoxMain.add(BoxDel);
        //BoxMain.add(Box.createVerticalGlue());
        BoxMain.add(BoxExit);
        getContentPane().add(BoxMain, BorderLayout.EAST);

        FindBut.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                String search = Search.getText();

                if (R1.isSelected()) {
                    int[] a = organisations.findType(search);
                    if (a.length > 0) {
                        JOptionPane.showMessageDialog(FindBut, "Найдены записи по вашему запросу", "Внимание!", JOptionPane.INFORMATION_MESSAGE);
                        ReShowFind(a);
                    } else {
                        JOptionPane.showMessageDialog(FindBut, "Не найдено ни одно записи по этому запросу", "Внимание!", JOptionPane.INFORMATION_MESSAGE);
                    }
                }

               if (R2.isSelected()) {
                    int[] a = organisations.findName(search);
                    if (a.length > 0) {
                        JOptionPane.showMessageDialog(FindBut, "Найдены записи по вашему запросу", "Внимание!", JOptionPane.INFORMATION_MESSAGE);
                        ReShowFind(a);
                    } else {
                        JOptionPane.showMessageDialog(FindBut, "Не найдено ни одно записи по этому запросу", "Внимание!", JOptionPane.INFORMATION_MESSAGE);
                    }
                }
               
               if (R3.isSelected()) {
                    int[] a = organisations.findchisRab(Integer.parseInt(search));
                    if (a.length > 0) {
                        JOptionPane.showMessageDialog(FindBut, "Найдены записи по вашему запросу", "Внимание!", JOptionPane.INFORMATION_MESSAGE);
                        ReShowFind(a);
                    } else {
                        JOptionPane.showMessageDialog(FindBut, "Не найдено ни одно записи по этому запросу", "Внимание!", JOptionPane.INFORMATION_MESSAGE);
                    }
                }
               
               if (R4.isSelected()) {
                    int[] a = organisations.findgos(search);
                    if (a.length > 0) {
                        JOptionPane.showMessageDialog(FindBut, "Найдены записи по вашему запросу", "Внимание!", JOptionPane.INFORMATION_MESSAGE);
                        ReShowFind(a);
                    } else {
                        JOptionPane.showMessageDialog(FindBut, "Не найдено ни одно записи по этому запросу", "Внимание!", JOptionPane.INFORMATION_MESSAGE);
                    }
                } 

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
        
        CancelBut.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                ReShow();
                Search.setText("");
            }
        });
        
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
                if (organisations.delete(Name)) {
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
                String Name, chisRab, Field = null;
                boolean gos;
                Name = AddName.getText();
                if (Name.equals("")) {
                    organisations.addStrahComp("Страховая компания", "Название", 10, true, 15);
                    organisations.addStrahComp("Страховая компания", "Название", 10, true, 15);
                    organisations.addStrahComp("Страховая компания", "Название", 10, true, 15);
                    organisations.addStrahComp("Страховая компания", "Название", 10, true, 15);
                    organisations.addStrahComp("Страховая компания", "Название", 10, true, 15);
                    ReShow();
                }
                
                chisRab = AddchisRab.getText();
                Field = AddField.getText();
                if (RYes.isSelected()){gos=true;}
                else{gos=false;}
                try {
                    chisRab = AddchisRab.getText();
                    //Price = AddPrice.getText();
                    if ((Integer.parseInt(chisRab) > 0) && (Integer.parseInt(Field) > 0)) {
                        if (RStrahComp.isSelected()) {
                            organisations.addStrahComp("Страховая компания", Name, Integer.parseInt(chisRab), gos, Integer.parseInt(Field));
                            ReShow();
                            JOptionPane.showMessageDialog(AdBut, "Страховая компания успешно добавлена", "Внимание!", JOptionPane.INFORMATION_MESSAGE);
                        }
                        if (RStroiComp.isSelected()) {
                            organisations.addStroiComp("Строительная компания", Name, Integer.parseInt(chisRab), gos, Integer.parseInt(Field));
                            ReShow();
                            JOptionPane.showMessageDialog(AdBut, "Строительная компания успешно добавлена", "Внимание!", JOptionPane.INFORMATION_MESSAGE);
                        }
                        if (RZavod.isSelected()) {
                            organisations.addZavod("Завод", Name, Integer.parseInt(chisRab), gos, Integer.parseInt(Field));
                            ReShow();
                            JOptionPane.showMessageDialog(AdBut, "Завод успешно добавлен", "Внимание!", JOptionPane.INFORMATION_MESSAGE);
                        }
                    } else {
                        JOptionPane.showMessageDialog(AdBut, "Число рабочих и спецификация должны быть больше 0", "Внимание!", JOptionPane.INFORMATION_MESSAGE);
                    }
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(AdBut, "Числа в полях 'Число рабочих' и 'Спецификация' должны быть целыми'. Повторите ввод", "Внимание!", JOptionPane.WARNING_MESSAGE);
                }
            }
        });

        R1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
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
                R1.setSelected(false);
                R2.setSelected(false);
                R3.setSelected(false);
                R4.setSelected(true);
                repaint();
                pack();
            }
        });

        RStrahComp.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                LabelSull.setText("Введите страховую выплату: ");
                RStrahComp.setSelected(true);
                RStroiComp.setSelected(false);
                RZavod.setSelected(false);
                repaint();
                pack();
            }
        });

        RStroiComp.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                LabelSull.setText("Построенных сооружений: ");
                RStrahComp.setSelected(false);
                RStroiComp.setSelected(true);
                RZavod.setSelected(false);
                repaint();
                pack();
            }
        });

        RZavod.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                LabelSull.setText("Введите кол-во цехов: ");
                RStrahComp.setSelected(false);
                RStroiComp.setSelected(false);
                RZavod.setSelected(true);
                repaint();
                pack();
            }
        });

        pack();
    }

    private void ReShow() {
        getContentPane().remove(Scroll);
        Tab = new JTable(organisations.showTabData(), Cols);
        Tab.getColumnModel().getColumn(0).setMaxWidth(30);
        Scroll = new JScrollPane(Tab);
        getContentPane().add(Scroll, BorderLayout.CENTER);
        pack();
    }

    private void ReShowFind(int[] a) {
        getContentPane().remove(Scroll);
        Tab = new JTable(organisations.showTabDataFind(a), Cols);
        Tab.getColumnModel().getColumn(0).setMaxWidth(30);
        Scroll = new JScrollPane(Tab);
        getContentPane().add(Scroll, BorderLayout.CENTER);
        pack();
    }
}
