package com.dms.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Record_1 extends JFrame implements ActionListener {

	private JPanel contentPane;
	JLabel lblrecord;
	JButton patientHistoryButton, treatmentHistoryButton, backButton;

	@Autowired
	Home home;
	
	@Autowired
	PatientHistory_1 patientHistory_1;
	
	@Autowired
	TreatmentHistory_1 treatmentHistory_1;
	
	
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Record_1 frame = new Record_1();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Record_1() {

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1400, 800);
		contentPane = new JPanel();
		contentPane.setBorder(new LineBorder(new Color(139, 0, 0), 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		setUndecorated(true);
		setLocationRelativeTo(null);

		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(210, 110, 30));
		panel_1.setBounds(0, 0, 1400, 60);
		panel.add(panel_1);

		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(210, 105, 30));
		panel_2.setBounds(0, 0, 66, 802);
		panel.add(panel_2);

		lblrecord = new JLabel("Record");
		lblrecord.setFont(new Font("Arial", Font.BOLD, 25));
		panel_1.add(lblrecord);

		patientHistoryButton = new JButton("Patient History");
		patientHistoryButton.setFont(new Font("Lucida Grande", Font.BOLD, 14));
		treatmentHistoryButton = new JButton("Treatment History");
		treatmentHistoryButton.setFont(new Font("Lucida Grande", Font.BOLD, 14));
		backButton = new JButton("Back");
		backButton.setForeground(new Color(0, 0, 255));
		backButton.setFont(new Font("Lucida Grande", Font.BOLD | Font.ITALIC, 14));

		patientHistoryButton.setBounds(200, 150, 202, 50);
		treatmentHistoryButton.setBounds(800, 150, 202, 50);
		backButton.setBounds(530, 564, 182, 50);

		patientHistoryButton.addActionListener(this);
		treatmentHistoryButton.addActionListener(this);
		backButton.addActionListener(this);

		panel.add(treatmentHistoryButton);
		panel.add(patientHistoryButton);
		panel.add(backButton);

		panel.setLayout(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// panel.pack();
		setLocationRelativeTo(null);
	//	panel.setVisible(true);

	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == patientHistoryButton) {
			this.dispose();
			patientHistory_1.setVisible(true);
		} else if (e.getSource() == treatmentHistoryButton) {
			this.dispose();
			treatmentHistory_1.setVisible(true);
		} else if (e.getSource() == backButton) {
			this.dispose();
			home.setVisible(true);
		}
	}

}
