package com.sgs;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;

public class TScreen {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					// showThirdScreen(table);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public static void showThirdScreen(JTable table) {

		Map<String, Double> map = normalize(table);

		JFrame frame = new JFrame();
		frame.setBounds(700, 300, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(new BorderLayout());

		JTable fTable = new JTable(new MyFinalTableModel(map));
		fTable.setPreferredScrollableViewportSize(new Dimension(500, 70));
		fTable.setFillsViewportHeight(true);
		
		frame.add(fTable.getTableHeader(), BorderLayout.NORTH);
		frame.add(fTable, BorderLayout.CENTER);
		
		frame.pack();
		frame.setVisible(true);

	}

	public static Map<String, Double> normalize(JTable table) {

		int dataSize = table.getRowCount();
		String[] names = new String[dataSize];
		double[] normalizedScores = new double[dataSize];
		int sum = 0;

		for (int i = 0; i < dataSize; i++) {

			String memName = (String) table.getValueAt(i, 0);

			int lsum = 0;
			for (int j = 1; j <= 3; j++) {
				lsum += Integer.parseInt((String) table.getValueAt(i, j));
			}
			names[i] = memName;
			normalizedScores[i] = lsum;
			sum += lsum;

		}

		for (int i = 0; i < normalizedScores.length; i++) {

			normalizedScores[i] = roundValue(normalizedScores[i] / sum, 2);

		}

		Map<String, Double> nMap = new LinkedHashMap<String, Double>();

		for (int i = 0; i < dataSize; i++) {

			nMap.put(names[i], normalizedScores[i]);

		}

		return nMap;
	}

	public static double roundValue(double value, int places) {

		BigDecimal bd = new BigDecimal(value);
		bd = bd.setScale(places, RoundingMode.HALF_UP);
		return bd.doubleValue();

	}

}

class MyFinalTableModel extends AbstractTableModel {

	private static final long serialVersionUID = 1L;
	private String[] columnNames = { "Name   ", "Normalized Score   " };

	public final Object[] longValues = { "Averylongvalue", " " };
	private Object[][] data;

	public MyFinalTableModel(Map<String, Double> map) {

		data = new Object[map.size()][2];

		int idx = 0;

		for (String key : map.keySet()) {

			data[idx][0] = key;
			data[idx][1] = map.get(key);
			idx++;

		}

	}

	public int getColumnCount() {
		return columnNames.length;
	}

	public int getRowCount() {
		return data.length;
	}

	public String getColumnName(int col) {
		return columnNames[col];
	}

	public Object getValueAt(int row, int col) {
		return data[row][col];
	}

}
