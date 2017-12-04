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
		final JTextField text = new JTextField();
		text.setBounds(150, 20, 50, 30);
		f.add(l1);
		f.add(label);
		f.add(b);
		f.add(text);
		f.setSize(300, 300);
		f.setLayout(null);
		f.setVisible(true);
		b.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String data = "Members " + text.getText();
				label.setText(data);
			}
		});
		
	
		int[] professionalism  = {5,4,5,1,2};
		int[] meetingParticipation  = {5,4,5,1,2};
		int[] workEvaluation  = {5,4,5,1,2};
	
		
		Normalize normalizeObj = new Normalize();
		double[] result =  normalizeObj.doNormalization(professionalism, meetingParticipation, workEvaluation, 5);
		
	
		
		Helper helper = new Helper();
		helper.printArray(result);
		
	}
	
}
