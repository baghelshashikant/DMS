package com.dms.view;

import java.awt.Dimension;
import java.awt.Font;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.dms.dao.PatientDaoImpl;
import com.dms.model.Patient;
import com.dms.services.PatientService;
import com.dms.services.PatientserviceImpl;

import net.sourceforge.jdatepicker.impl.JDatePanelImpl;
import net.sourceforge.jdatepicker.impl.JDatePickerImpl;
import net.sourceforge.jdatepicker.impl.UtilDateModel;

@Component
public class PatientMaster implements ActionListener {

	JFrame patientMasterFrame;
	JLabel nameLabel, addressLabel, mobilelabel, ageLabel, sexlabel, statusLabel, headingLabel, appointmentDateLabel;
	JTextField nameField, addressField, mobileField, ageField, sextypeField, statustypeField;
	UtilDateModel model;
	JDatePanelImpl datePanel;
	JDatePickerImpl datePicker;
	JComboBox sexBox, statusBox, patientBox;
	JButton saveButton, resetButton, deleteButton, modifyButton, backButton;
	SimpleDateFormat formatter;

	String[] sextypes = new String[] { "Select", "MALE", "FEMALE" };
	String[] statustypes = new String[] { "Select", "ACTIVE", "INACTIVE" };

	@Autowired
	PatientService patientService;
	
	@Autowired 
	Home home;

	public PatientMaster() {

		patientMasterFrame = new JFrame("Patient Master");
		patientMasterFrame.setPreferredSize(new Dimension(1366, 768));

		headingLabel = new JLabel("Patient Master");
		headingLabel.setFont(new Font("Aerial", Font.PLAIN, 50));

		nameLabel = new JLabel("NAME");
		addressLabel = new JLabel("ADDRESS");
		mobilelabel = new JLabel("MOBILE");
		ageLabel = new JLabel("AGE");

		sexlabel = new JLabel("SEX");
		statusLabel = new JLabel("STATUS");
		appointmentDateLabel = new JLabel("APPONITMENT DATE");

		nameField = new JTextField();
		addressField = new JTextField();
		mobileField = new JTextField();
		ageField = new JTextField();
		sextypeField = new JTextField();
		statustypeField = new JTextField();
		Date date = new Date();
		formatter = new SimpleDateFormat("dd/MM/yyyy");
		String strDate = formatter.format(date);

		model = new UtilDateModel();
		// model.setDate(1990, 9, 24);
		model.setSelected(true);
		datePanel = new JDatePanelImpl(model);
		datePicker = new JDatePickerImpl(datePanel);
		datePicker = new JDatePickerImpl(datePanel, new DateLabelFormatter());

		sextypeField.setEditable(false);
		statustypeField.setEditable(false);
		sexBox = new JComboBox(sextypes);
		statusBox = new JComboBox(statustypes);
		patientBox = new JComboBox();

		List<String> l = new PatientDaoImpl().getPatientNames();

		for (String i : l) {
			patientBox.addItem(i);
		}

		saveButton = new JButton("Save");
		resetButton = new JButton("Reset");
		deleteButton = new JButton("Delete");
		modifyButton = new JButton("Modify");
		backButton = new JButton("Back");

		saveButton.addActionListener(this);
		resetButton.addActionListener(this);
		deleteButton.addActionListener(this);
		modifyButton.addActionListener(this);
		backButton.addActionListener(this);
		sexBox.addActionListener(this);
		statusBox.addActionListener(this);
		patientBox.addActionListener(this);

		headingLabel.setBounds(50, -25, 400, 100);
		nameLabel.setBounds(200, 100, 202, 30);
		addressLabel.setBounds(200, 150, 202, 50);
		mobilelabel.setBounds(200, 260, 202, 30);
		ageLabel.setBounds(200, 300, 202, 30);
		sexlabel.setBounds(200, 350, 202, 30);
		statusLabel.setBounds(200, 400, 202, 30);
		appointmentDateLabel.setBounds(200, 450, 202, 30);

		nameField.setBounds(400, 100, 202, 30);
		patientBox.setBounds(700, 100, 202, 30);
		addressField.setBounds(400, 150, 202, 70);
		mobileField.setBounds(400, 260, 202, 30);
		ageField.setBounds(400, 300, 202, 30);
		sextypeField.setBounds(400, 350, 202, 30);
		statustypeField.setBounds(400, 400, 202, 30);
		// apponitmentDateField.setBounds(400, 450, 202, 30);
		datePicker.setBounds(400, 450, 202, 30);

		sexBox.setBounds(700, 350, 202, 30);
		statusBox.setBounds(700, 400, 202, 30);

		saveButton.setBounds(200, 520, 100, 30);
		resetButton.setBounds(350, 520, 100, 30);
		deleteButton.setBounds(500, 520, 100, 30);
		modifyButton.setBounds(650, 520, 100, 30);
		backButton.setBounds(800, 520, 100, 30);

		patientMasterFrame.add(headingLabel);
		patientMasterFrame.add(nameLabel);
		patientMasterFrame.add(addressLabel);
		patientMasterFrame.add(mobilelabel);
		patientMasterFrame.add(ageLabel);
		patientMasterFrame.add(sexlabel);
		patientMasterFrame.add(statusLabel);
		patientMasterFrame.add(appointmentDateLabel);

		patientMasterFrame.add(nameField);
		patientMasterFrame.add(addressField);
		patientMasterFrame.add(mobileField);
		patientMasterFrame.add(ageField);
		patientMasterFrame.add(sextypeField);
		patientMasterFrame.add(statustypeField);
		// patientMasterFrame.add(apponitmentDateField);
		patientMasterFrame.add(datePicker);

		patientMasterFrame.add(patientBox);
		patientMasterFrame.add(sexBox);
		patientMasterFrame.add(statusBox);
		patientMasterFrame.add(saveButton);
		patientMasterFrame.add(resetButton);
		patientMasterFrame.add(deleteButton);
		patientMasterFrame.add(modifyButton);
		patientMasterFrame.add(backButton);

		patientMasterFrame.setLayout(null);
		patientMasterFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		patientMasterFrame.pack();
		patientMasterFrame.setLocationRelativeTo(null);
		//patientMasterFrame.setVisible(true);

	}

	public static void main(String[] args) {
		new PatientMaster();
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (sexBox.hasFocus()) {
			if ("select".equalsIgnoreCase(sexBox.getSelectedItem().toString())) {
				sextypeField.setText("");
			} else {
				sextypeField.setText((String) sexBox.getItemAt(sexBox.getSelectedIndex()));
			}
		}

		if (statusBox.hasFocus()) {
			if ("select".equalsIgnoreCase(statusBox.getSelectedItem().toString())) {
				statustypeField.setText("");
			} else {
				statustypeField.setText((String) statusBox.getItemAt(statusBox.getSelectedIndex()));
			}
		}

		if (patientBox.hasFocus()) {

			if ("select".equalsIgnoreCase(patientBox.getSelectedItem().toString())) {
				nameField.setText("");
				addressField.setText("");
				mobileField.setText("");
				ageField.setText("");
				sextypeField.setText("");
				statustypeField.setText("");
			} else {
				Patient p = new PatientDaoImpl()
						.getPatientbyName((String) patientBox.getItemAt(patientBox.getSelectedIndex()));

				nameField.setText(p.getName());
				addressField.setText(p.getAddress());
				mobileField.setText(p.getMobile());
				ageField.setText(String.valueOf(p.getAge()));
				sextypeField.setText(p.getSex());
				statustypeField.setText(p.getStatus());
				Date date = p.getApponitmentdate();
				System.out.println(formatter.format(date));
				LocalDate localDate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
				// System.out.println(localDate);
				// System.out.println(localDate.getDayOfMonth());
				// System.out.println(localDate.getYear());
				// System.out.println(localDate.getMonthValue());
				datePicker.getModel().setDate(localDate.getYear(), localDate.getMonthValue() - 1,
						localDate.getDayOfMonth());

			}
		}
		// reset data
		if (e.getSource() == resetButton) {
			nameField.setText("");
			addressField.setText("");
			mobileField.setText("");
			ageField.setText("");
			sextypeField.setText("");
			statustypeField.setText("");

		}
		// save method
		else if (e.getSource() == saveButton) {

			Patient patient = new Patient();

			patient.setName(nameField.getText());
			patient.setAddress(addressField.getText());
			patient.setMobile(mobileField.getText());
			try {
				patient.setAge(Integer.parseInt(ageField.getText()));
			} catch (Exception e3) {
				if (!ageField.getText().equals(""))
					JOptionPane.showMessageDialog(null, "Please enter correct age!(only numers)");
			}

			patient.setSex(sextypeField.getText());
			patient.setStatus(statustypeField.getText());
			patient.setApponitmentdate((Date) datePicker.getModel().getValue());

			// PatientService patientService=new PatientserviceImpl();

			boolean[] b = patientService.checkPatientInfo(patient);

			System.out.println(patient);
			System.out.println(b[0] + " " + b[1] + " " + b[2] + " " + b[3] + " " + b[4] + " " + b[5] + " " + b[6]);

			if (b[0] == true || b[1] == true || b[4] == true || b[5] == true || b[6] == true) {

				JOptionPane.showMessageDialog(null, "Please enter correct details!");
			} else if (b[2] == true)
				JOptionPane.showMessageDialog(null, "Please enter correct mobile no!");
			else if (b[3] == true)
				JOptionPane.showMessageDialog(null, "Please enter correct age !");

			if (b[0] == false && b[1] == false && b[2] == false && b[3] == false && b[4] == false && b[5] == false
					&& b[6] == false) {
				if (patientService.savepatient(patient)) {

					JOptionPane.showMessageDialog(null, "Patient saved successfully!");
				}

				else {
					JOptionPane.showMessageDialog(null, "OOPS! There is some problem");
				}

			}

		}
		// delete method
		else if (e.getSource() == deleteButton) {

			Patient patient = new Patient();

			patient.setName(nameField.getText());
			patient.setAddress(addressField.getText());
			patient.setMobile(mobileField.getText());
			try {
				patient.setAge(Integer.parseInt(ageField.getText()));
			} catch (Exception e3) {
				if (!ageField.getText().equals(""))
					JOptionPane.showMessageDialog(null, "Please enter correct age!(only numers)");
			}

			patient.setSex(sextypeField.getText());
			patient.setStatus(statustypeField.getText());
			patient.setApponitmentdate((Date) datePicker.getModel().getValue());

			PatientService patientService = new PatientserviceImpl();

			boolean[] b = patientService.checkPatientInfo(patient);

			System.out.println(patient);
			System.out.println(b[0] + " " + b[1] + " " + b[2] + " " + b[3] + " " + b[4] + " " + b[5] + " " + b[6]);

			if (b[0] == true || b[1] == true || b[4] == true || b[5] == true || b[6] == true) {

				JOptionPane.showMessageDialog(null, "Please enter correct details!");
			} else if (b[2] == true)
				JOptionPane.showMessageDialog(null, "Please enter correct mobile no!");
			else if (b[3] == true)
				JOptionPane.showMessageDialog(null, "Please enter correct age !");

			if (b[0] == false && b[2] == false && b[3] == false && b[4] == false && b[5] == false && b[6] == false) {
				if (new PatientDaoImpl().deltePatient(patient)) {
					JOptionPane.showMessageDialog(null, "Patient deleted successfully!");
				} else {
					JOptionPane.showMessageDialog(null, "OOPS! There is some problem");
				}
			}

		}
		// update method
		else if (e.getSource() == modifyButton) {

			Patient patient = new Patient();

			patient.setName(nameField.getText());
			patient.setAddress(addressField.getText());
			patient.setMobile(mobileField.getText());
			try {
				patient.setAge(Integer.parseInt(ageField.getText()));
			} catch (Exception e3) {
				if (!ageField.getText().equals(""))
					JOptionPane.showMessageDialog(null, "Please enter correct age!(only numers)");
			}

			patient.setSex(sextypeField.getText());
			patient.setStatus(statustypeField.getText());
			patient.setApponitmentdate((Date) datePicker.getModel().getValue());

			PatientService patientService = new PatientserviceImpl();

			boolean[] b = patientService.checkPatientInfo(patient);

			System.out.println(patient);
			System.out.println(b[0] + " " + b[1] + " " + b[2] + " " + b[3] + " " + b[4] + " " + b[5] + " " + b[6]);

			if (b[0] == true || b[1] == true || b[4] == true || b[5] == true || b[6] == true) {

				JOptionPane.showMessageDialog(null, "Please enter correct details!");
			} else if (b[2] == true)
				JOptionPane.showMessageDialog(null, "Please enter correct mobile no!");
			else if (b[3] == true)
				JOptionPane.showMessageDialog(null, "Please enter correct age !");

			if (b[0] == false && b[2] == false && b[3] == false && b[4] == false && b[5] == false && b[6] == false) {
				if (new PatientDaoImpl().modifyPatient(patient)) {
					JOptionPane.showMessageDialog(null, "Patient modified successfully!");
				} else {
					JOptionPane.showMessageDialog(null, "OOPS! There is some problem");
				}
			}
		} else if (e.getSource() == backButton) {
			patientMasterFrame.dispose();
			//Home frame = new Home();
			//frame.setVisible(true);
			home.setVisible(true);

		}

	}
}
