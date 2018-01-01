package start;

import java.awt.EventQueue;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextArea;

public class Frame1 {

	private JFrame frame;
	private JLabel labelone;
	private StudSelection sel=StudSelection.NAME; //default value of name
	private JRadioButton rdbtnGender;
	private JRadioButton rdbtnFName;
	private JRadioButton rdbtnLName;
	private JRadioButton rdbtnBday;
	private JRadioButton rdbtnMatricDate;
	private JRadioButton rdbtnError;
	private JRadioButton rdbtnProper;
	private JRadioButton rdbtnName;
	private ButtonGroup bg = new ButtonGroup();
	private JTextField textFieldOne;
	private JTextArea outArea;

	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Frame1 window = new Frame1();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public Frame1() {
		initialize();
	}

	
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 800, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		
		JMenu mnMenu = new JMenu("Menu");
		menuBar.add(mnMenu);
		
		JMenuItem mntmHelloWorld = new JMenuItem("Hello World");
		mntmHelloWorld.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				labelone.setText("Hello World");
			}
		});
		mnMenu.add(mntmHelloWorld);
		
		JMenuItem mntmGoodbyeWorld = new JMenuItem("Goodbye World");
		mntmGoodbyeWorld.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				labelone.setText("Goodbye World");
			}
		});
		mnMenu.add(mntmGoodbyeWorld);
		frame.getContentPane().setLayout(null);
		
		labelone = new JLabel("");
		labelone.setBounds(0, 411, 277, 18);
		frame.getContentPane().add(labelone);
		
		rdbtnGender = new JRadioButton("Gender");
		rdbtnGender.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				sel=StudSelection.GENDER;
			}
		});
		rdbtnGender.setBounds(694, 0, 90, 20);
		frame.getContentPane().add(rdbtnGender);
		
		rdbtnFName = new JRadioButton("First Name");
		rdbtnFName.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				sel=StudSelection.FIRST_NAME;
			}
		});
		rdbtnFName.setBounds(694, 23, 90, 20);
		frame.getContentPane().add(rdbtnFName);
		
		rdbtnLName = new JRadioButton("Last Name");
		rdbtnLName.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				sel=StudSelection.LAST_NAME;
			}
		});
		rdbtnLName.setBounds(694, 46, 90, 20);
		frame.getContentPane().add(rdbtnLName);
		
		rdbtnBday = new JRadioButton("Birth Day");
		rdbtnBday.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				sel=StudSelection.BIRTH_DATE;
			}
		});
		rdbtnBday.setBounds(694, 69, 90, 20);
		frame.getContentPane().add(rdbtnBday);
		
		rdbtnMatricDate = new JRadioButton("Matric Day");
		rdbtnMatricDate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				sel=StudSelection.MATRICULATION_DATE;
			}
		});
		rdbtnMatricDate.setBounds(694, 92, 90, 20);
		frame.getContentPane().add(rdbtnMatricDate);
		
		rdbtnError = new JRadioButton("Any Error");
		rdbtnError.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				sel=StudSelection.ANY_ERROR;
			}
		});
		rdbtnError.setBounds(694, 115, 90, 20);
		frame.getContentPane().add(rdbtnError);
		
		rdbtnProper = new JRadioButton("Proper");
		rdbtnProper.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				sel=StudSelection.PROPER;
			}
		});
		rdbtnProper.setBounds(694, 138, 90, 20);
		frame.getContentPane().add(rdbtnProper);
		
		rdbtnName = new JRadioButton("Name");
		rdbtnName.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				sel=StudSelection.NAME;
			}
		});
		rdbtnName.setBounds(694, 161, 90, 20);
		frame.getContentPane().add(rdbtnName);
		
		bg.add(rdbtnGender);
		bg.add(rdbtnFName);
		bg.add(rdbtnLName);
		bg.add(rdbtnBday);
		bg.add(rdbtnMatricDate);
		bg.add(rdbtnError);
		bg.add(rdbtnProper);
		bg.add(rdbtnName);
		
		textFieldOne = new JTextField();
		textFieldOne.setBounds(287, 411, 187, 18);
		frame.getContentPane().add(textFieldOne);
		textFieldOne.setColumns(10);
		
		JButton btnNewButton = new JButton("GO");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String file;
				file=textFieldOne.getText();
				outArea.setText(StudentData.showLinesForGUI(file,sel));
			}
		});
		btnNewButton.setBounds(625, 372, 149, 57);
		frame.getContentPane().add(btnNewButton);
		
		outArea = new JTextArea();
		outArea.setBounds(10, 11, 678, 349);
		frame.getContentPane().add(outArea);
	}
}
