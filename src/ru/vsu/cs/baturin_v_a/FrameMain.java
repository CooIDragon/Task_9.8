package ru.vsu.cs.baturin_v_a;

import ru.vsu.cs.baturin_v_a.util.ArrayUtils;
import ru.vsu.cs.baturin_v_a.util.JTableUtils;
import ru.vsu.cs.baturin_v_a.util.ListUtils;
import ru.vsu.cs.baturin_v_a.util.SwingUtils;

import javax.swing.*;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.List;

public class FrameMain extends JFrame {

    private JButton buttonLoadInput1FromFile;
    private JButton buttonRandomInput;
    private JButton buttonSaveInput1IntoFile;
    private JButton buttonRun;
    private JButton buttonSaveOutputIntoFile;
    private JTable tableOutput;
    private JTable tableInput1;
    private JPanel panelMain;
    private JTable tableInput2;
    private JButton buttonLoadInput2FromFile;
    private JButton buttonSaveInput2IntoFile;

    private JFileChooser fileChooserOpen;
    private JFileChooser fileChooserSave;


    public FrameMain() {
        this.setTitle("Task_9");
        this.setContentPane(panelMain);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setBounds(700, 100, 300, 300);
        this.setResizable(true);
        this.pack();

        JTableUtils.initJTableForArray(tableInput1, 30, false, true, false, true);
        JTableUtils.initJTableForArray(tableInput2, 30, false, true, false, true);
        JTableUtils.initJTableForArray(tableOutput, 30, false, true, false, true);

        tableInput1.setRowHeight(30);
        tableInput2.setRowHeight(30);
        tableOutput.setRowHeight(30);

        fileChooserOpen = new JFileChooser();
        fileChooserSave = new JFileChooser();
        fileChooserOpen.setCurrentDirectory(new File("."));
        fileChooserSave.setCurrentDirectory(new File("."));
        FileFilter filter = new FileNameExtensionFilter("Text files", "txt");
        fileChooserOpen.addChoosableFileFilter(filter);
        fileChooserSave.addChoosableFileFilter(filter);

        buttonRun.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                try {
                    FindingElementsThatOnlyInOneList findingElementsThatOnlyInOneList = new FindingElementsThatOnlyInOneList();
                    int[] array1 = JTableUtils.readIntArrayFromJTable(tableInput1);
                    int[] array2 = JTableUtils.readIntArrayFromJTable(tableInput2);
                    List<Integer> list1 = ListUtils.intArrayToList(array1);
                    List<Integer> list2 = ListUtils.intArrayToList(array2);
                    List<Integer> listResult = findingElementsThatOnlyInOneList.isOnlyInTheFirstAndSecondList(list1, list2);
                    int[] resultArray = ListUtils.intListToArray(listResult);
                    JTableUtils.writeArrayToJTable(tableOutput, resultArray);
                } catch (Exception e) {
                    SwingUtils.showErrorMessageBox(e);
                }
            }
        });

        buttonLoadInput1FromFile.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                try {
                    if (fileChooserOpen.showOpenDialog(panelMain) == JFileChooser.APPROVE_OPTION) {
                        int[] arr = ArrayUtils.readIntArrayFromFile(fileChooserOpen.getSelectedFile().getPath());
                        JTableUtils.writeArrayToJTable(tableInput1, arr);
                    }
                } catch (Exception e) {
                    SwingUtils.showErrorMessageBox(e);
                }
            }
        });

        buttonRandomInput.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                try {
                    int[] inputArr1 = ArrayUtils.createRandomIntArray(tableInput1.getColumnCount(), -99, 99);
                    int[] inputArr2 = ArrayUtils.createRandomIntArray(tableInput2.getColumnCount(), -99, 99);
                    JTableUtils.writeArrayToJTable(tableInput1, inputArr1);
                    JTableUtils.writeArrayToJTable(tableInput2, inputArr2);
                } catch (Exception e) {
                    SwingUtils.showErrorMessageBox(e);
                }
            }
        });

        buttonSaveInput1IntoFile.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                try {
                    if (fileChooserSave.showSaveDialog(panelMain) == JFileChooser.APPROVE_OPTION) {
                        int[] arr = JTableUtils.readIntArrayFromJTable(tableInput1);
                        String file = fileChooserSave.getSelectedFile().getPath();
                        if (!file.toLowerCase().endsWith(".txt")) {
                            file += ".txt";
                        }
                        ArrayUtils.writeArrayToFile(file, arr);
                    }
                } catch (Exception e) {
                    SwingUtils.showErrorMessageBox(e);
                }
            }
        });

        buttonSaveOutputIntoFile.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                try {
                    if (fileChooserSave.showSaveDialog(panelMain) == JFileChooser.APPROVE_OPTION) {
                        int[] arr = JTableUtils.readIntArrayFromJTable(tableOutput);
                        String file = fileChooserSave.getSelectedFile().getPath();
                        if (!file.toLowerCase().endsWith(".txt")) {
                            file += ".txt";
                        }
                        ArrayUtils.writeArrayToFile(file, arr);
                    }
                } catch (Exception e) {
                    SwingUtils.showErrorMessageBox(e);
                }
            }
        });

        buttonLoadInput2FromFile.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                try {
                    if (fileChooserOpen.showOpenDialog(panelMain) == JFileChooser.APPROVE_OPTION) {
                        int[] arr = ArrayUtils.readIntArrayFromFile(fileChooserOpen.getSelectedFile().getPath());
                        JTableUtils.writeArrayToJTable(tableInput2, arr);
                    }
                } catch (Exception e) {
                    SwingUtils.showErrorMessageBox(e);
                }
            }
        });
        buttonSaveInput2IntoFile.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                try {
                    if (fileChooserSave.showSaveDialog(panelMain) == JFileChooser.APPROVE_OPTION) {
                        int[] arr = JTableUtils.readIntArrayFromJTable(tableInput2);
                        String file = fileChooserSave.getSelectedFile().getPath();
                        if (!file.toLowerCase().endsWith(".txt")) {
                            file += ".txt";
                        }
                        ArrayUtils.writeArrayToFile(file, arr);
                    }
                } catch (Exception e) {
                    SwingUtils.showErrorMessageBox(e);
                }
            }
        });
    }
}

