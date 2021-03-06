package com.dms.view;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

public class Record implements ActionListener {
	
	JFrame recordFrame;
	JButton patientHistoryButton, treatmentHistoryButton,backButton;
	
	@Autowired
	PatientHistory_1 patientHistory_1;
	
	@Autowired
	Home home;
	public Record() {
	
		recordFrame=new JFrame("Record");
		recordFrame.setPreferredSize(new Dimension(1366,768));
		
		patientHistoryButton = new JButton("Patient History");
		treatmentHistoryButton = new JButton("Treatment History");
		backButton=new JButton("Back");
		
		
		
		patientHistoryButton.setBounds(200, 150, 202, 50);
		treatmentHistoryButton.setBounds(800, 150, 202, 50);
		backButton.setBounds(200,570,202,50);

		
		patientHistoryButton.addActionListener(this);
		treatmentHistoryButton.addActionListener(this);
		backButton.addActionListener(this);
		
		recordFrame.add(treatmentHistoryButton);
		recordFrame.add(patientHistoryButton);
		recordFrame.add(backButton);
		
		recordFrame.setLayout(null);
		recordFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		recordFrame.pack();
		recordFrame.setLocationRelativeTo(null);
		recordFrame.setVisible(true);

		
	}
	
	public static void main(String[] args) {
		new Record();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if (e.getSource() == patientHistoryButton) {
			recordFrame.dispose();
			patientHistory_1.setVisible(true);
		} else if (e.getSource() == treatmentHistoryButton) {
			recordFrame.dispose();
			new TreatmentHistory();
		} 
		else if (e.getSource() == backButton) {
			recordFrame.dispose();
			new Home();
		} 
	}

	
	
	
	
}
