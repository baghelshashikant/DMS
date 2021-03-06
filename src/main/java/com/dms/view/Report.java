package com.dms.view;
import java.awt.Color;  
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;  
import javax.swing.JTextPane;  
import javax.swing.text.BadLocationException;  
import javax.swing.text.Document;  
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import com.dms.dao.PatientDaoImpl;
import com.dms.model.TreatmentMasterModel;  
public class Report implements ActionListener {  
	
	JButton printButton,backButton;
	JFrame frame;
	Container cp;
	JTextPane pane; 
	static int i=0;
	TreatmentMasterModel masterModel;
	public Report(TreatmentMasterModel masterModel1) throws BadLocationException {
		    
		    this.masterModel=masterModel1;
		    frame  = new JFrame("Report");  
	        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);  
	         cp = frame.getContentPane();  
	     
	         pane = new JTextPane();  

	     //    pane.setPreferredSize(new Dimension(550,400));
	         pane.setPreferredSize(new Dimension(800,500));
	       
	       
	       printButton=new JButton("Print");
		   backButton=new JButton("Back");
			
			printButton.addActionListener(this);
			backButton.addActionListener(this);
			
	        
	        SimpleAttributeSet attributeSet = new SimpleAttributeSet();  
	        StyleConstants.setBold(attributeSet, true);  
	  
	        // Set the attributes before adding text  
	       
	  
	        attributeSet = new SimpleAttributeSet();  
	        StyleConstants.setItalic(attributeSet, true);  
	        StyleConstants.setForeground(attributeSet, Color.red);  
	       // StyleConstants.setBackground(attributeSet, Color.blue);  
	        StyleConstants.setFontSize(attributeSet, 18);
	  
	        Document doc = pane.getStyledDocument();  
	                         
	        String clinicName="Shri Govind Dental Clinic";
	        doc.insertString(doc.getLength(), clinicName, attributeSet);  
	  
	        attributeSet = new SimpleAttributeSet();
	        StyleConstants.setItalic(attributeSet, true);
	        StyleConstants.setForeground(attributeSet, Color.black);
	        String doctorName="                                                         "
	        		+ "                                                                Dr. Dinesh Kumar\n"+"     "
	        		+ "                                                                                                             "
	        		+ "                                     "
	        		+ "                                B.D.S";
	        String doctor1Name="\n                                                                       "
	        		+ "                                                                "
	        		+"                       "
	        		+ "                         Dr. Pooja\n"+"      "
	        		+ "                        "
	        		+ "                                          "
	        		+ "                                                                    "
	        		+ "                                           B.D.S";
	        String line="\n\n--------------------------------------------------------------------------------------------------------------------------------"
	        		+ "-------------------------------------------------------";
	        String address="\n                                                                           In front of bus stand,Sadabad (hathras)-281306";
	        String phones="\n                                                "
	        		+ "                                           Phone No : +91 9760724124";
	        String patientName="\n Name : "+masterModel.getPatientName();
	        String simpleformatdate=new SimpleDateFormat("dd/MM/yyyy").format(new Date());
	        String date="\n Date : "+simpleformatdate;
	        String patuentAge="\n Age :"+new PatientDaoImpl().getPatientbyName(masterModel.getPatientName()).getAge();
	        String pateintSex="\n Sex : "+new PatientDaoImpl().getPatientbyName(masterModel.getPatientName()).getSex();
	       String prescription="\n\n\n "+masterModel.getPrescription();
	       
	        String treatmentName="\nTreatment Name : "+masterModel.getTreatmentName();
	        String doctorNamesign="\n\n\n\n\n"
	        		+ "       "
	        		+ "     "
	        		+ "                                                                                          "
	        		+ "                                 "
	        		+ "                                               Dr. Dinesh Kumar\n"+"     "
	        		+ "                                                                                                             "
	        		+ "                                                     "
	        		+ "               B.D.S";
	        doc.insertString(doc.getLength(), doctorName, attributeSet);  
	        doc.insertString(doc.getLength(),doctor1Name , attributeSet);  
	        doc.insertString(doc.getLength(),line , attributeSet);
	        doc.insertString(doc.getLength(),address , attributeSet);
	        doc.insertString(doc.getLength(),phones , attributeSet);
	        doc.insertString(doc.getLength(),line , attributeSet);
	        doc.insertString(doc.getLength(),date , attributeSet);
	        doc.insertString(doc.getLength(),patientName, attributeSet);   
	        doc.insertString(doc.getLength(),patuentAge , attributeSet);
	        doc.insertString(doc.getLength(),pateintSex , attributeSet);
	        doc.insertString(doc.getLength(),line , attributeSet);
	        doc.insertString(doc.getLength(),treatmentName , attributeSet);
	        doc.insertString(doc.getLength(),prescription , attributeSet);

	        doc.insertString(doc.getLength(), doctorNamesign, attributeSet);
	       
	        JScrollPane scrollPane = new JScrollPane(pane,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);  
	      
	        cp.add(scrollPane);
	        frame.add(printButton);
	        frame.add(backButton);
	         
	        frame.setLayout(new FlowLayout());
	        //frame.setSize(600, 500);
	        //frame.setSize(800, 500);
	        frame.setSize(850, 600);
	        frame.setResizable(false);
	        frame.setVisible(true); 
	}
	public Report() throws BadLocationException {
		
	    frame  = new JFrame("Report");  
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);  
         cp = frame.getContentPane();  
     
         pane = new JTextPane();  
      // pane.setPreferredSize(new Dimension(550,400));
         pane.setPreferredSize(new Dimension(800,500));
       //  pane.setPreferredSize(new Dimension(550,730));
       
       
       
       printButton=new JButton("Print");
	   backButton=new JButton("Back");
		
		printButton.addActionListener(this);
		backButton.addActionListener(this);
		
        
        SimpleAttributeSet attributeSet = new SimpleAttributeSet();  
        StyleConstants.setBold(attributeSet, true);  
  
        // Set the attributes before adding text  
       
  
        attributeSet = new SimpleAttributeSet();  
        StyleConstants.setItalic(attributeSet, true);  
        StyleConstants.setForeground(attributeSet, Color.red);  
       // StyleConstants.setBackground(attributeSet, Color.blue);  
        StyleConstants.setFontSize(attributeSet, 18);
  
        Document doc = pane.getStyledDocument();  
        String clinicName="Shri Govind Dental Clinic";
        doc.insertString(doc.getLength(), clinicName, attributeSet);  
  
        attributeSet = new SimpleAttributeSet();
        StyleConstants.setItalic(attributeSet, true);
        StyleConstants.setForeground(attributeSet, Color.black);
        String doctorName="                                                         "
        		+ "                                                                Dr. Dinesh Kumar\n"+"     "
        		+ "                                                                                                             "
        		+ "                                     "
        		+ "                                B.D.S";
        String doctor1Name="\n                                                                       "
        		+ "                                                                "
        		+"                       "
        		+ "                         Dr. Pooja\n"+"      "
        		+ "                        "
        		+ "                                          "
        		+ "                                                                    "
        		+ "                                           B.D.S";
        String line="\n\n--------------------------------------------------------------------------------------------------------------------------------"
        		+ "-------------------------------------------------------";
        String address="\n                                                                           In front of bus stand,Sadabad (hathras)-281306";
        String phones="\n                                                "
        		+ "                                           Phone No : +91 9760724124";
        String patientName="\n Name : ";
        Date date1=new Date();
     
        String simpleformatdate=new SimpleDateFormat("dd/MM/yyyy").format(date1);
        String date="\n Date : "+simpleformatdate;
        String patuentAge="\n Age :";
        String pateintSex="\n Sex : ";
        String prescription="";
        String treatmentName="\nTreatment Name : ";
        String doctorNamesign="\n\n\n\n\n"
        		+ "       "
        		+ "     "
        		+ "                                                                                          "
        		+ "                                 "
        		+ "                                               Dr. Dinesh Kumar\n"+"     "
        		+ "                                                                                                             "
        		+ "                                                     "
        		+ "               B.D.S";
        doc.insertString(doc.getLength(), doctorName, attributeSet);  
        doc.insertString(doc.getLength(),doctor1Name , attributeSet);  
        doc.insertString(doc.getLength(),line , attributeSet);
        doc.insertString(doc.getLength(),address , attributeSet);
        doc.insertString(doc.getLength(),phones , attributeSet);
        doc.insertString(doc.getLength(),line , attributeSet);
        doc.insertString(doc.getLength(),date , attributeSet);
        doc.insertString(doc.getLength(),patientName, attributeSet);
        
        doc.insertString(doc.getLength(),patuentAge , attributeSet);
        doc.insertString(doc.getLength(),pateintSex , attributeSet);
        doc.insertString(doc.getLength(),line , attributeSet);
        doc.insertString(doc.getLength(),treatmentName , attributeSet);
        doc.insertString(doc.getLength(),prescription , attributeSet);
        doc.insertString(doc.getLength(), doctorNamesign, attributeSet);
        JScrollPane scrollPane = new JScrollPane(pane,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);  
      
        cp.add(scrollPane);
        frame.add(printButton);
        frame.add(backButton);
        frame.setResizable(false); 
        frame.setLayout(new FlowLayout());
       // frame.setSize(600, 500);
        frame.setSize(850, 600);
       // frame.setSize(600, 600);
        frame.setVisible(true); 
}
    public static void main(String args[]) throws BadLocationException {  
    	new Report();
      }
	@Override
	public void actionPerformed(ActionEvent e) {
		
		
		if(e.getSource()==backButton)
		{
			frame.setVisible(false);
		}
		else if(e.getSource()==printButton)
		{
			try {
				//com.itextpdf.text.Document document=new com.itextpdf.text.Document();
				//PdfWriter.getInstance(document, new FileOutputStream(i+1+"ReportPdf.pdf"));
				//document.open();
				//document.add(new Paragraph(pane.getText()));
				//ocument.close();
				
				new MainClass().paintToPDF(pane,masterModel);
				JOptionPane.showMessageDialog(null,"Pdf file saved successfully!");
				
			}
			catch (Exception e1) {
				JOptionPane.showMessageDialog(null,"Oops Something went wrong!!");

			}
			
		}
		
	}  
}  