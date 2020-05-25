package com.dms.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.util.Date;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.text.BadLocationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.dms.dao.PatientDaoImpl;
import com.dms.dao.TreatmentDaoimpl;
import com.dms.dao.TreatmentMasterDaoImpl;
import com.dms.model.Treatment;
import com.dms.model.TreatmentMasterModel;
import com.dms.services.TreatmentMasterServiceIml;
import com.dms.view.Home;
import com.dms.view.Report;


@Component
public class TreatmentMaster_1 extends JFrame implements ActionListener {

	private JPanel contentPane;
	JComboBox patientNameBox, treatmentNameBox, phoneBox;
	JTextField apprximatetimeField, approximatecostField, totalpaidamountField, balanceamountField;
	JLabel selectpatientNameLabel, selecttreatmentNameLabel, approximatetimeLabel, approximatecostLabel,
			totalpaidamountLabel, balanceamountLabel, headingLabel, prescriptionLabel, phoneLabel, lbltreatMaster;
	JTextArea prescriptionArea;
	JButton saveButton, save_Printbutton, restbutton, backButton;

	@Autowired
	Home home;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TreatmentMaster_1 frame = new TreatmentMaster_1();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public TreatmentMaster_1() {

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

		lbltreatMaster = new JLabel("Treatment Master");
		lbltreatMaster.setFont(new Font("Arial", Font.BOLD, 25));
		panel_1.add(lbltreatMaster);

		backButton = new JButton("Back");
		backButton.setBackground(new Color(255, 69, 0));
		backButton.setForeground(new Color(0, 0, 255));
		backButton.setFont(new Font("Lucida Grande", Font.BOLD | Font.ITALIC, 15));

		panel.add(backButton);
		backButton.addActionListener(this);

		selectpatientNameLabel = new JLabel("Patient Name");
		selecttreatmentNameLabel = new JLabel("Treatment Name");
		approximatetimeLabel = new JLabel("Approximate Time:");
		approximatecostLabel = new JLabel("Approximate Cost:");
		totalpaidamountLabel = new JLabel("Total Paid");
		balanceamountLabel = new JLabel("Balance Amonut");
		prescriptionLabel = new JLabel("Prescription");
		prescriptionLabel.setFont(new Font("Lucida Grande", Font.BOLD, 14));
		phoneLabel = new JLabel("Phone");

		patientNameBox = new JComboBox();
		treatmentNameBox = new JComboBox();
		phoneBox = new JComboBox();

		prescriptionArea = new JTextArea();
		prescriptionArea.setPreferredSize(new Dimension(100, 100));
		prescriptionArea.setLayout(new BorderLayout());
		prescriptionArea.setBorder(BorderFactory.createLineBorder(Color.BLACK));

		saveButton = new JButton("Save");
		saveButton.setForeground(new Color(0, 0, 255));
		saveButton.setFont(new Font("Lucida Grande", Font.BOLD | Font.ITALIC, 14));
		save_Printbutton = new JButton("Save & Print");
		save_Printbutton.setFont(new Font("Lucida Grande", Font.BOLD | Font.ITALIC, 14));
		save_Printbutton.setForeground(new Color(0, 0, 255));
		restbutton = new JButton("Reset");
		restbutton.setForeground(new Color(0, 0, 255));
		restbutton.setFont(new Font("Lucida Grande", Font.BOLD | Font.ITALIC, 14));

		saveButton.addActionListener(this);
		save_Printbutton.addActionListener(this);
		restbutton.addActionListener(this);
		backButton.addActionListener(this);
		// patientNameBox.addActionListener(this);
		// patientNameBox.addItemListener(this);
		treatmentNameBox.addActionListener(this);
		phoneBox.addActionListener(this);

		apprximatetimeField = new JTextField();
		approximatecostField = new JTextField();
		totalpaidamountField = new JTextField();
		balanceamountField = new JTextField();

		List<String> l = new PatientDaoImpl().getPatientNames();

		for (String i : l) {
			patientNameBox.addItem(i);
		}
		List<String> l1 = new TreatmentDaoimpl().getTreatmentNames();

		for (String i : l1) {
			treatmentNameBox.addItem(i);
		}

		selectpatientNameLabel.setBounds(107, 100, 202, 30);
		selecttreatmentNameLabel.setBounds(566, 100, 202, 30);
		approximatetimeLabel.setBounds(829, 100, 202, 30);
		approximatecostLabel.setBounds(1123, 100, 291, 30);
		totalpaidamountLabel.setBounds(818, 200, 202, 30);
		balanceamountLabel.setBounds(1123, 200, 202, 30);
		prescriptionLabel.setBounds(107, 200, 202, 30);
		phoneLabel.setBounds(337, 100, 202, 30);

		patientNameBox.setBounds(107, 142, 182, 30);
		treatmentNameBox.setBounds(566, 142, 182, 30);
		phoneBox.setBounds(323, 142, 182, 30);

		apprximatetimeField.setBounds(818, 149, 182, 30);
		approximatecostField.setBounds(1123, 142, 174, 30);
		totalpaidamountField.setBounds(818, 242, 182, 30);
		balanceamountField.setBounds(1123, 242, 174, 30);

		prescriptionArea.setBounds(107, 248, 488, 266);

		saveButton.setBounds(650, 422, 100, 30);
		save_Printbutton.setBounds(800, 422, 122, 30);
		restbutton.setBounds(972, 422, 100, 30);
		backButton.setBounds(1122, 422, 100, 30);

		panel.add(selectpatientNameLabel);
		panel.add(selecttreatmentNameLabel);
		panel.add(approximatetimeLabel);
		panel.add(approximatecostLabel);
		panel.add(totalpaidamountLabel);
		panel.add(balanceamountLabel);
		panel.add(prescriptionLabel);
		panel.add(phoneLabel);

		panel.add(patientNameBox);
		panel.add(treatmentNameBox);
		panel.add(phoneBox);

		panel.add(apprximatetimeField);
		panel.add(approximatecostField);
		panel.add(totalpaidamountField);
		panel.add(balanceamountField);

		panel.add(prescriptionArea);

		panel.add(saveButton);
		panel.add(save_Printbutton);
		panel.add(restbutton);
		panel.add(backButton);

		panel.setLayout(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// panel.pack();
		setLocationRelativeTo(null);
		panel.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == saveButton) {
			TreatmentMasterModel masterModel = new TreatmentMasterModel();
			masterModel.setPatientName(patientNameBox.getSelectedItem().toString());
			masterModel.setTreatmentName(treatmentNameBox.getSelectedItem().toString());
			masterModel.setApproximatetime(apprximatetimeField.getText());
			masterModel.setPrescription(prescriptionArea.getText());
			masterModel.setTreatmentDate(new Date());
			try {
				masterModel.setApprximatecost(Integer.parseInt(approximatecostField.getText()));
				masterModel.setTotalpaidamount(Integer.parseInt(totalpaidamountField.getText()));
				masterModel.setBalanceamount(Integer.parseInt(balanceamountField.getText()));
			} catch (Exception e1) {

			}
			boolean[] b = new TreatmentMasterServiceIml().checkTreatmentMasterInfo(masterModel);
			System.out.println(masterModel);
			System.out.println(b[0] + "" + b[1] + "" + b[2] + "" + b[3] + "" + b[4] + "" + b[5]);

			if (b[0] == true || b[1] == true || b[2] == true || b[3] == true || b[4] == true || b[5] == true) {

				JOptionPane.showMessageDialog(null, "Please enter the correct details!");
			}
			if (b[0] == false && b[1] == false && b[2] == false && b[3] == false && b[4] == false && b[5] == false) {
				if (new TreatmentMasterDaoImpl().saveTreatment(masterModel)) {
					JOptionPane.showMessageDialog(null, "Treatment saved successfully!");
				} else {
					JOptionPane.showMessageDialog(null, "Oops Something went wrong!");
				}

			}

		} else if (e.getSource() == save_Printbutton) {

			TreatmentMasterModel masterModel = new TreatmentMasterModel();
			masterModel.setPatientName(patientNameBox.getSelectedItem().toString());
			masterModel.setTreatmentName(treatmentNameBox.getSelectedItem().toString());
			masterModel.setApproximatetime(apprximatetimeField.getText());
			masterModel.setPrescription(prescriptionArea.getText());
			masterModel.setTreatmentDate(new Date());
			try {
				masterModel.setApprximatecost(Integer.parseInt(approximatecostField.getText()));
				masterModel.setTotalpaidamount(Integer.parseInt(totalpaidamountField.getText()));
				masterModel.setBalanceamount(Integer.parseInt(balanceamountField.getText()));
			} catch (Exception e1) {

			}
			boolean[] b = new TreatmentMasterServiceIml().checkTreatmentMasterInfo(masterModel);
			System.out.println(masterModel);
			System.out.println(b[0] + "" + b[1] + "" + b[2] + "" + b[3] + "" + b[4] + "" + b[5]);

			if (b[0] == true || b[1] == true || b[2] == true || b[3] == true || b[4] == true || b[5] == true) {

				JOptionPane.showMessageDialog(null, "Please enter the correct details!");
			}
			if (b[0] == false && b[1] == false && b[2] == false && b[3] == false && b[4] == false && b[5] == false) {

				if (new TreatmentMasterDaoImpl().saveTreatment(masterModel)) {
					try {
						new Report(masterModel);
						JOptionPane.showMessageDialog(null, "Treatment saved successfully!");
					} catch (BadLocationException e1) {

						e1.printStackTrace();
						JOptionPane.showMessageDialog(null, "Oops Something went wrong!");
					}

				} else {
					JOptionPane.showMessageDialog(null, "Oops Something went wrong!");
				}

			}

		} else if (e.getSource() == restbutton) {

			approximatecostField.setText("");
			apprximatetimeField.setText("");
			totalpaidamountField.setText("");
			balanceamountField.setText("");
		} else if (e.getSource() == backButton) {

			this.dispose();
			home.setVisible(true);
		}

		else if (treatmentNameBox.hasFocus()) {
			if ("select".equalsIgnoreCase(treatmentNameBox.getSelectedItem().toString())
					|| "".equals(treatmentNameBox.getSelectedItem().toString())) {
				approximatecostField.setText("");
				apprximatetimeField.setText("");
				totalpaidamountField.setText("");
				balanceamountField.setText("");
			} else {
				Treatment treatment = new TreatmentDaoimpl()
						.getTreatmentbyName(treatmentNameBox.getSelectedItem().toString());
				approximatecostField.setText(Integer.toString(treatment.getCost()));
				apprximatetimeField.setText(treatment.getTime());
				totalpaidamountField.setText(Integer.toString(treatment.getCost()));
				balanceamountField.setText((Integer.toString(treatment.getCost())));
			}
		}

	}

	public void itemStateChanged(ItemEvent event) {

		if (event.getStateChange() == ItemEvent.SELECTED) {
			Object item = event.getItem();

			if (!item.equals("Select")) {
				phoneBox.removeAllItems();
				List<String> list = null;
				list = new PatientDaoImpl().getPhonenumberListByName(item.toString());

				for (String i : list) {

					phoneBox.addItem(i);
				}
			} else if (item.equals("Select")) {
				phoneBox.removeAllItems();

			}
		}

	}

}
