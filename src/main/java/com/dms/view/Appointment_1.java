package com.dms.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

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

import com.dms.dao.PatientDaoImpl;
import com.dms.model.Patient;
import com.dms.view.Home;

import com.dms.view.DateLabelFormatter;
import net.sourceforge.jdatepicker.impl.JDatePanelImpl;
import net.sourceforge.jdatepicker.impl.JDatePickerImpl;
import net.sourceforge.jdatepicker.impl.UtilDateModel;

import javax.swing.JButton;
import java.awt.Font;

@Component
public class Appointment_1 extends JFrame implements ActionListener{

	JButton TodayAppointment, backButton, exportButton, todayButton,seachButton;
	JLabel fromdateLabel, todateLabel, lblappntdetail;
	UtilDateModel utilmodel,utilmodel1;
	JDatePanelImpl datePanel,datePanel1;
	JDatePickerImpl datePicker,datePicker1;	
	DefaultTableModel model;
	JTable jtable;
	JScrollPane jScrollPane;
	private JPanel contentPane;
	
	@Autowired
	Home home;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Appointment_1 frame = new Appointment_1();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	public Appointment_1() {
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
		panel_2.setBounds(0, 6, 66, 796);
		panel.add(panel_2);
		
		lblappntdetail = new JLabel("Appointment Details");
		lblappntdetail.setFont(new Font("Arial", Font.BOLD, 25));
		panel_1.add(lblappntdetail);
		
		
//	    TodayAppointment = new JButton("Today's Appointment");
//		TodayAppointment.setBounds(276, 134, 178, 29);
//		panel.add(TodayAppointment);
//		TodayAppointment.addActionListener(this);
		
	    fromdateLabel = new JLabel("FROM");
	    fromdateLabel.setFont(new Font("Lucida Grande", Font.BOLD, 14));
	    fromdateLabel.setBounds(320,100,50,30);
		panel.add(fromdateLabel);
		
	    todateLabel = new JLabel("TO");
		todateLabel.setFont(new Font("Lucida Grande", Font.BOLD, 14));
		todateLabel.setBounds(620,100,50,30);
		panel.add(todateLabel);
		setLocationRelativeTo(null);
		
		seachButton=new JButton("Search");
		seachButton.addActionListener(this);
		seachButton.setBounds(700,150,150,30);
		panel.add(seachButton);
		
		backButton = new JButton("Back");
		backButton.setBackground(new Color(255, 69, 0));
		backButton.setForeground(new Color(0, 0, 255));
		backButton.setFont(new Font("Lucida Grande", Font.BOLD | Font.ITALIC, 15));
		backButton.setBounds(100,570,100,30);
		panel.add(backButton);
		backButton.addActionListener(this);
			
		exportButton = new JButton("Export");
		exportButton.setForeground(new Color(50, 205, 50));
		exportButton.addActionListener(this);
		exportButton.setBackground(new Color(255, 99, 71));
		exportButton.setFont(new Font("Lucida Grande", Font.BOLD | Font.ITALIC, 15));
		exportButton.setBounds(910,300,100,30);
		panel.add(exportButton);
		
		todayButton = new JButton("Today");
		todayButton.setBounds(100,100,150,30);
		panel.add(todayButton);
		todayButton.addActionListener(this);
		
		utilmodel = new UtilDateModel();
		utilmodel.setSelected(true);
		datePanel = new JDatePanelImpl(utilmodel);
		datePicker = new JDatePickerImpl(datePanel, new DateLabelFormatter());
		datePicker.setBounds(400,100,150,30);
		panel.add(datePicker);
		
		utilmodel1 = new UtilDateModel();
		utilmodel1.setSelected(true);
		datePanel1 = new JDatePanelImpl(utilmodel1);
		datePicker1 = new JDatePickerImpl(datePanel1, new DateLabelFormatter());
		datePicker1.setBounds(700,100,150,30);
		panel.add(datePicker1);
		
	   String column[]={"APPOINTMENT DATE","PATIENT NAME","MOBILE","STATUS"};    
	   model = new DefaultTableModel();
	   model.setColumnIdentifiers(column);
	   jtable=new JTable();
	
	jtable.setModel(model);
	jtable.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
	jtable.setFillsViewportHeight(true);
	jScrollPane=new JScrollPane(jtable);
	jScrollPane.setBounds(100,300,800,200);
	jScrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
	jScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
	panel.add(jScrollPane);
	}
	
	public static void exportTable(JTable table,File file) throws IOException {
      TableModel model = table.getModel();
      FileWriter out = new FileWriter(file);
      for(int i=0; i < model.getColumnCount(); i++) {
  out.write(model.getColumnName(i) + "\t");
      }
      out.write("\n");

      for(int i=0; i< model.getRowCount(); i++) {
  for(int j=0; j < model.getColumnCount(); j++) {
      out.write(model.getValueAt(i,j).toString()+"\t");
      }
       out.write("\n");
      }
  }


	@Override
	public void actionPerformed(ActionEvent e) {
		
		((DefaultTableModel)jtable.getModel()).setRowCount(0);
		
		 if(e.getSource()==exportButton)
		{

			try {
				exportTable(jtable, new File("D:\\tabledata.xls"));
				JOptionPane.showMessageDialog(null,"excel file saved successfully");
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
		 else if(e.getSource()==backButton)
			{
				this.dispose();
				home.setVisible(true);
			}
		 else if(e.getSource()==todayButton)
		 {
			 //select all patient having appointment today
			 if(new PatientDaoImpl().getTodayAppointmentPatient() != null)
			 {
				 List<Patient> list=new PatientDaoImpl().getTodayAppointmentPatient();
				 
				 Iterator<Patient> iterator=list.iterator();
					while(iterator.hasNext())
					{
						Patient patient=(Patient)iterator.next();
						Date appointmentDate=patient.getApponitmentdate();
						String patientName=patient.getName();
						String mobile=patient.getMobile();
						String status=patient.getStatus();
						
						
						model.addRow(new Object[]{appointmentDate, patientName, mobile, status});
					}
			
			 }
		 }
		
	}

}








