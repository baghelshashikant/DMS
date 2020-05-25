package com.dms.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.dms.dao.TreatmentDaoimpl;
import com.dms.dao.TreatmentMasterDaoImpl;
import com.dms.model.TreatmentMasterModel;
import com.dms.view.Record;

@Component
public class TreatmentHistory_1 extends JFrame implements ActionListener {

	private JPanel contentPane;
	JLabel lbltreatHistry, treatmentNameLabel, treatmentLabel;
	JComboBox treatmentNameBox;
	DefaultTableModel model;
	JTable jtable;
	JScrollPane jScrollPane;
	JButton backButton, exportButton;
	
	@Autowired
	Record_1 record_1;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TreatmentHistory_1 frame = new TreatmentHistory_1();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public TreatmentHistory_1() {

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

		lbltreatHistry = new JLabel("Treatment History");
		lbltreatHistry.setFont(new Font("Arial", Font.BOLD, 25));
		panel_1.add(lbltreatHistry);

		backButton = new JButton("Back");
		backButton.setBackground(new Color(255, 69, 0));
		backButton.setForeground(new Color(0, 0, 255));
		backButton.setFont(new Font("Lucida Grande", Font.BOLD | Font.ITALIC, 15));
		backButton.setBounds(1266, 750, 124, 34);
		panel.add(backButton);
		backButton.addActionListener(this);

		exportButton = new JButton("Export");
		exportButton.setForeground(new Color(50, 205, 50));
		exportButton.addActionListener(this);
		exportButton.setBackground(new Color(255, 99, 71));
		exportButton.setFont(new Font("Lucida Grande", Font.BOLD | Font.ITALIC, 15));
		exportButton.setBounds(1267, 246, 117, 34);
		panel.add(exportButton);

		String column[] = { "TREATMENT DATE", "TREATMENT", "AMOUNT PAID", "BALANCE" };
		model = new DefaultTableModel();
		model.setColumnIdentifiers(column);
		jtable = new JTable();

		jtable.setModel(model);
		jtable.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		jtable.setFillsViewportHeight(true);
		jScrollPane = new JScrollPane(jtable);
		jScrollPane.setBounds(100, 350, 800, 200);
		jScrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		jScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);

		panel.add(jScrollPane);

		treatmentNameBox = new JComboBox();

		treatmentNameBox.addActionListener(this);

		List<String> l = new TreatmentDaoimpl().getTreatmentNames();

		for (String i : l) {
			treatmentNameBox.addItem(i);
		}

		treatmentNameLabel = new JLabel("Treatment Name:");
		treatmentNameLabel.setFont(new Font("Lucida Grande", Font.BOLD, 13));
		treatmentLabel = new JLabel("Treatment details");
		treatmentLabel.setFont(new Font("Lucida Grande", Font.BOLD, 13));

		treatmentNameLabel.setBounds(100, 100, 150, 30);
		treatmentLabel.setBounds(100, 300, 150, 30);
		treatmentNameBox.setBounds(260, 100, 200, 30);
		backButton.setBounds(100, 570, 100, 30);
		exportButton.setBounds(910, 350, 100, 30);

		panel.add(treatmentNameLabel);
		panel.add(treatmentLabel);
		panel.add(treatmentNameBox);
		panel.add(backButton);
		panel.add(exportButton);

		panel.setLayout(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// treatmentHistoryFrame.pack();
		setLocationRelativeTo(null);
		//setVisible(true);

	}

	public static void exportTable(JTable table, File file) throws IOException {
		TableModel model = table.getModel();
		FileWriter out = new FileWriter(file);
		for (int i = 0; i < model.getColumnCount(); i++) {
			out.write(model.getColumnName(i) + "\t");
		}
		out.write("\n");

		for (int i = 0; i < model.getRowCount(); i++) {
			for (int j = 0; j < model.getColumnCount(); j++) {
				out.write(model.getValueAt(i, j).toString() + "\t");
			}
			out.write("\n");
		}

		out.close();
		System.out.println("write out to: " + file);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (treatmentNameBox.hasFocus()) {
			if (!"select".equalsIgnoreCase(treatmentNameBox.getSelectedItem().toString())) {
				((DefaultTableModel) jtable.getModel()).setRowCount(0);

				List list = new TreatmentMasterDaoImpl()
						.getTreatmentMasterModelByTreatmentName(treatmentNameBox.getSelectedItem().toString());
				Iterator<TreatmentMasterModel> iterator = list.iterator();
				while (iterator.hasNext()) {
					TreatmentMasterModel masterModel = (TreatmentMasterModel) iterator.next();
					String treatmentDate = masterModel.getTreatmentDate().toString();
					String treatmentname = masterModel.getTreatmentName();
					String amountpaid = Integer.toString(masterModel.getTotalpaidamount());
					String balanceamount = Integer.toString(masterModel.getBalanceamount());

					model.addRow(new Object[] { treatmentDate, treatmentname, amountpaid, balanceamount });
				}

			} else if ("select".equalsIgnoreCase(treatmentNameBox.getSelectedItem().toString())) {
				((DefaultTableModel) jtable.getModel()).setRowCount(0);

			} else {
				((DefaultTableModel) jtable.getModel()).setRowCount(0);
			}

		}

		else if (e.getSource() == backButton) {
			this.dispose();
			record_1.setVisible(true);
		} else if (e.getSource() == exportButton) {

			try {
				exportTable(jtable, new File("D:\\tabledata.xls"));
				JOptionPane.showMessageDialog(null, "excel file saved successfully");
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}

	}

}
