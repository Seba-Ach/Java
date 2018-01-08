package start;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JLabel;

import java.awt.FlowLayout;
import java.awt.BorderLayout;
import java.util.GregorianCalendar;
import java.util.stream.Stream;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextArea;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.Charset;
import java.nio.file.Files;
import javax.swing.JScrollBar;

public class Frame2 {

	private JFrame frame;
	private JTextField textGender;
	private JTextField textFName;
	private JTextField textLName;
	private JTextField textBDay;
	private JTextField textGradDay;
	private JTextField textYearOfAdmission;
	private JTextField textYearOfStudy;
	private JTextField textIDNum;
	private String format="";
	private JTextArea textArea;
	private JLabel label;
	//FileWriter fw;
	File log = new File("output.txt");
	private JButton btnShowAll;
	private JButton btnClear;

	public static void main(String[] args) throws MyExcepts{
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Frame2 window = new Frame2();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Frame2()throws MyExcepts {
		initialize();
	}

	private void initialize() throws MyExcepts {
		frame = new JFrame();
		frame.setBounds(100, 100, 600, 560);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Gender");
		lblNewLabel.setBounds(10, 10, 91, 14);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblFirstName = new JLabel("First Name");
		lblFirstName.setBounds(10, 35, 91, 14);
		frame.getContentPane().add(lblFirstName);
		
		JLabel lblLastName = new JLabel("Last Name");
		lblLastName.setBounds(10, 60, 91, 14);
		frame.getContentPane().add(lblLastName);
		
		JLabel lblNewLabel_1 = new JLabel("Birth Day");
		lblNewLabel_1.setBounds(10, 85, 91, 14);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblMatricDay = new JLabel("Graduation Day");
		lblMatricDay.setBounds(10, 110, 91, 14);
		frame.getContentPane().add(lblMatricDay);
		
		JLabel lblYearOfStudy = new JLabel("Year of Admission");
		lblYearOfStudy.setBounds(10, 135, 91, 14);
		frame.getContentPane().add(lblYearOfStudy);
		
		JLabel lblYearOfStudy_1 = new JLabel("Year of Study");
		lblYearOfStudy_1.setBounds(10, 160, 91, 14);
		frame.getContentPane().add(lblYearOfStudy_1);
		
		JLabel lblId = new JLabel("ID Number");
		lblId.setBounds(10, 185, 91, 14);
		frame.getContentPane().add(lblId);
		
		textGender = new JTextField();
		textGender.setBounds(111, 9, 120, 16);
		frame.getContentPane().add(textGender);
		textGender.setColumns(10);
		
		textFName = new JTextField();
		textFName.setColumns(10);
		textFName.setBounds(111, 34, 120, 16);
		frame.getContentPane().add(textFName);
		
		textLName = new JTextField();
		textLName.setColumns(10);
		textLName.setBounds(111, 58, 120, 16);
		frame.getContentPane().add(textLName);
		
		textBDay = new JTextField();
		textBDay.setColumns(10);
		textBDay.setBounds(111, 83, 120, 16);
		frame.getContentPane().add(textBDay);
		
		textGradDay = new JTextField();
		textGradDay.setColumns(10);
		textGradDay.setBounds(111, 108, 120, 16);
		frame.getContentPane().add(textGradDay);
		
		textYearOfAdmission = new JTextField();
		textYearOfAdmission.setColumns(10);
		textYearOfAdmission.setBounds(111, 133, 120, 16);
		frame.getContentPane().add(textYearOfAdmission);
		
		textYearOfStudy = new JTextField();
		textYearOfStudy.setColumns(10);
		textYearOfStudy.setBounds(111, 158, 120, 16);
		frame.getContentPane().add(textYearOfStudy);
		
		textIDNum = new JTextField();
		textIDNum.setColumns(10);
		textIDNum.setBounds(111, 183, 120, 16);
		frame.getContentPane().add(textIDNum);
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				format=textGender.getText()+";"+textFName.getText()+";"+textLName.getText()+";"+textBDay.getText()
						+";"+textGradDay.getText()+";"+textYearOfAdmission.getText()+";"
						+textYearOfStudy.getText()+";"+textIDNum.getText();
				
				try {
					UniStudent One = new UniStudent(format); //we put format string to a object
					if(One.getGender()==null || One.getFirstName()==null || One.getLastName()==null|| One.getId()==0){
						throw new MyExcepts(); //we check if they arent null so we cant accept stuff like ;;;;;;
					}
					
					BufferedReader b = new BufferedReader(new FileReader("output.txt")); //create new bufferedreader
		            String readLine = "";//we read until line is null
		            while ((readLine = b.readLine()) != null) {
		            	int a,d;
		            	a=Integer.parseInt(readLine.split(";")[7]);
		            	d=Integer.parseInt(textIDNum.getText());
		                if(a==d){
		                	throw new IDExcepts();
		                }
		            }
		            b.close();
		            
		            textArea.setText(format);  // puts text onto the text area if its ok
					label.setText(""); //changes label to blank
					
		            PrintWriter out = new PrintWriter(new FileWriter(log, true)); 
					out.println(format);
					out.close();
					
				} catch (MyExcepts e) {
					textArea.setText("");
					label.setText(e.toString());
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}catch(NumberFormatException e){
					
				}
				
				
			}
		});
		btnSubmit.setBounds(10, 221, 221, 50);
		frame.getContentPane().add(btnSubmit);
		
		label = new JLabel("");
		label.setForeground(Color.RED);
		label.setBounds(10, 282, 564, 14);
		frame.getContentPane().add(label);
		
		btnShowAll = new JButton("Show all ");
		btnShowAll.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try{
					 BufferedReader b = new BufferedReader(new FileReader("output.txt"));
			         String readLine = "";
			         String outer="All Students in list:\n";
			         while ((readLine = b.readLine()) != null) {
			             outer=outer+readLine+"\n";
			         }
			         textArea.setText(outer);
			         b.close();
				}catch(IOException e){
					
				}
			}
		});
		btnShowAll.setBounds(10, 277, 111, 50);
		frame.getContentPane().add(btnShowAll);
		
		btnClear = new JButton("Clear");
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				textArea.setText("");
			}
		});
		btnClear.setBounds(127, 277, 104, 50);
		frame.getContentPane().add(btnClear);
		
		textArea = new JTextArea();
		textArea.setEditable(false);
		textArea.setBounds(259, 10, 315, 261);
		frame.getContentPane().add(textArea);
	}
}
