package com.ub.sec.studentgrader.client;

import java.awt.event.*;

import javax.swing.*;

public class Main {

	public static void main(String[] args) {
		JFrame f = new JFrame("Student Grading system");
		final JLabel label = new JLabel();
		label.setBounds(100, 150, 250, 50);

		JLabel l1 = new JLabel("Enter no. of members:");
		l1.setBounds(20, 20, 140, 30);
		JButton b = new JButton("Submit");
		b.setBounds(50, 80, 100, 30);
		
		Integer[] members = new Integer[] {2, 3, 4, 5, 6, 7};
		 
		JComboBox<Integer> memberOptions = new JComboBox<Integer>(members);
		memberOptions.setBounds(150, 20, 50, 30);
		//final JTextField text = new JTextField();
		//text.setBounds(150, 20, 50, 30);
		f.add(l1);
		f.add(label);
		f.add(b);
		f.add(memberOptions);
		f.setSize(300, 300);
		f.setLayout(null);
		f.setVisible(true);
		memberOptions.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//String data = "Members " + text.getText();
				JComboBox<Integer> memberOptions = (JComboBox<Integer>)e.getSource();
				int n = (Integer) memberOptions.getSelectedItem();
				System.out.println("Number entered: "+n);
				label.setText("Number entered: "+n);
			}
		});
	}
}
