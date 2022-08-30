package org.ron.m3.examples;

import javax.swing.*;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyMVC {

    public static void main(String[] args) {
        MyMVC myMVC = new MyMVC();
        myMVC.simpleTable();
    }

    private void simpleTable() {
        JButton hiButton = new JButton("Hi");
        hiButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Hi there!");
            }
        });

        JButton byeButton = new JButton("Bye");
        byeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        JTable table = new JTable(new MyTableModel());
        JScrollPane scrollPane = new JScrollPane(table);

        JFrame frame = new JFrame("My MVC");
        frame.setLayout(new BorderLayout());
        frame.add(scrollPane, BorderLayout.CENTER);
        frame.add(hiButton, BorderLayout.NORTH);
        frame.add(byeButton, BorderLayout.SOUTH);
        frame.setSize(400, 500);
        frame.setLocation(500, 500);
        frame.setVisible(true);
    }

    private void simpleButton() {
        JButton button = new JButton("Hi");
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("button clicked");
            }
        });
        JFrame frame = new JFrame("My MVC");
        frame.setLayout(new BorderLayout());
        frame.add(button, BorderLayout.SOUTH);
        frame.setSize(300, 100);
        frame.setLocation(500, 500);
        frame.setVisible(true);
    }

    private class MyTableModel implements TableModel {

        private String[] colNames = new String[]{"Dogs", "Cats", "Rats", "Gerbils", "Goldfish", "Bats"};

        @Override
        public int getRowCount() {
            return 1000;
        }

        @Override
        public int getColumnCount() {
            return colNames.length;
        }

        @Override
        public String getColumnName(int columnIndex) {
            return colNames[columnIndex];
        }

        @Override
        public Class<?> getColumnClass(int columnIndex) {
            return String.class;
        }

        @Override
        public boolean isCellEditable(int rowIndex, int columnIndex) {
            return false;
        }

        @Override
        public Object getValueAt(int rowIndex, int columnIndex) {
            System.out.println("getValueAt() row=" + rowIndex + ", col=" + columnIndex);
            return colNames[columnIndex] + ":" + rowIndex;
        }

        @Override
        public void setValueAt(Object aValue, int rowIndex, int columnIndex) {

        }

        @Override
        public void addTableModelListener(TableModelListener l) {

        }

        @Override
        public void removeTableModelListener(TableModelListener l) {

        }
    }
}
