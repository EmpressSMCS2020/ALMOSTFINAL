//IMPORTS-----------------------------------------------------------------------------------------------------------------------------
import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.codoid.products.exception.FilloException;

@SuppressWarnings("serial")
public class GUIScreen extends JFrame implements ActionListener{
	
//FIELDS------------------------------------------------------------------------------------------------------------------------------
	public Color logocolor;
	
	public final static JPanel P1 = new JPanel(new GridBagLayout());
	public static JLabel logolabel;
	
	public final static JPanel P2 = new JPanel(new GridBagLayout());
	public final static JLabel welcome = new JLabel("PLEASE SIGN IN TO COUNSELING:");
	public final static JLabel confirm  = new JLabel("PLEASE CONFIRM THE FOLLOWING:");
	
	public final static JPanel P3 = new JPanel(new GridBagLayout());
	public final static JLabel askID = new JLabel("PLEASE ENTER YOUR STUDENT ID:   ");
	public final static JLabel askTeacher  = new JLabel("TEACHER THIS PERIOD:   ");
	public JTextField inputID  = new JTextField(10);
	public JComboBox<String> enterTeacher  = new JComboBox<String>(); 		
	
	public final static JPanel P4 = new JPanel(new GridBagLayout());
	public final static JLabel askReason = new JLabel("PLEASE SELECT YOUR REASON FOR VISITING:   ");
	public final static JLabel askCounselor  = new JLabel("COUNSELOR:   ");
	public JComboBox<String> inputReason  = new JComboBox<String>(); 		
	public JComboBox<String> enterCounselor  = new JComboBox<String>(); 	
	
	public final static JPanel P5 = new JPanel(new GridBagLayout());
	public static JLabel fullName = new JLabel("");
	
	public final static JPanel P6 = new JPanel(new GridBagLayout());
	public final JButton cancel  = new JButton("");
	
	public final static JPanel P7 = new JPanel(new GridBagLayout());
	public final JButton cont  = new JButton("CONTINUE");
	public final JButton finish  = new JButton("FINISH");
	
	public final static JPanel SPACEPANEL = new JPanel(new GridBagLayout());
	
	public static GridBagConstraints c;
	
//(SCREEN ONE) CONSTRUCTOR--------------------------------------------------------------------------------------------------------------------------
	
	public GUIScreen(Color co) {
		logocolor = co;
		initializeFrame();
		initializePanels();
		initializeScreenOneComponents();
		initializeScreenTwoComponents();
	}

//METHODS-----------------------------------------------------------------------------------------------------------------------------------------
	
	private void initializeFrame() {
		setTitle("Poolesville High School - Counseling Office Sign In (1/2)");
		setSize(1000,800);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(new GridBagLayout());
	}

	private void initializeScreenOneComponents() {
		
	//P1
		try {               
			BufferedImage LOGO = ImageIO.read(new File("phslogo.png"));
			JLabel logolabel = new JLabel(new ImageIcon(LOGO));
							
			P1.add(logolabel);
		}
		catch (IOException ex) {
			System.out.println(ex.getMessage());
		}
		
	//P2
		welcome.setFont(new Font("Rockwell", Font.PLAIN, 25));
		P2.add(welcome);
		
	//P3
		askID.setFont(new Font("Rockwell", Font.PLAIN, 25));
		P3.add(askID);
		inputID.setFont(new Font("Rockwell", Font.PLAIN, 25));
		P3.add(inputID);
	
	//P4
		askReason.setFont(new Font("Rockwell", Font.PLAIN, 25));
		P4.add(askReason);
		
		inputReason.addItem("(Select a Reason)");
		Scanner reasons;
		try {
			reasons = new Scanner(new File("reasonsList.txt"));
			while(reasons.hasNextLine()){
				inputReason.addItem(reasons.nextLine());
			}
			reasons.close();
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		}
		
		inputReason.setFont(new Font("Rockwell",Font.PLAIN,25));
		P4.add(inputReason);
	
	//P5
		
	//P6
		cancel.setFont(new Font("Rockwell", Font.PLAIN, 35));
		cancel.setText("CLEAR");
		cancel.setBackground(Color.getHSBColor((float)0.05, (float)0.9, (float)0.8));
		P6.add(cancel);
	
	//P7
		cont.setFont(new Font("Rockwell", Font.PLAIN, 35));
		cont.setBackground(Color.getHSBColor((float)0.4, (float)0.9, (float)0.8));
		P7.add(cont);
	
	
		
	}
	
	private void initializeScreenTwoComponents() {
		//P2
			confirm.setFont(new Font("Rockwell",Font.PLAIN, 25));
		
		//P3
			askTeacher.setFont(new Font("Rockwell",Font.PLAIN,25));
		
		//P4
			enterTeacher.addItem("(Select a Teacher)");
			Scanner teachers;
			try {
				teachers = new Scanner(new File("teachersList.txt"));
				while(teachers.hasNextLine()){
					enterTeacher.addItem(teachers.nextLine());
				}
				enterTeacher.setFont(new Font("Rockwell",Font.PLAIN,25));
				teachers.close();
			} catch (FileNotFoundException e) {
				System.out.println(e.getMessage());
			}
			
		//P5
			askCounselor.setFont(new Font("Rockwell",Font.PLAIN,25));
		
		//P6
			enterCounselor.addItem("(Select a Counselor)");
			Scanner counselors;
			try {
				counselors = new Scanner(new File("counselorsList.txt"));
				while(counselors.hasNextLine()){
					enterCounselor.addItem(counselors.nextLine());
				}
				enterCounselor.setFont(new Font("Rockwell",Font.PLAIN,25));
				counselors.close();
			} catch (FileNotFoundException e) {
				System.out.println(e.getMessage());
			}
			
		//P8
			finish.setFont(new Font("Rockwell", Font.PLAIN, 35));
			finish.setBackground(Color.getHSBColor((float)0.4, (float)0.9, (float)0.8));
			
		//P9
			
	}

	private void initializePanels() {
		c = new GridBagConstraints(0, 0, 10, 16, 0.5, 0.5, GridBagConstraints.NORTHWEST,
				GridBagConstraints.BOTH, new Insets(0,0,0,0), 0, 0);
		
		P1.setBackground(logocolor);
		c.gridx = 0;
		c.gridy = 0;
		c.gridwidth = 10;
		c.gridheight = 2;
		add(P1, c);
		
		c.gridx = 0;
		c.gridy = 3;
		c.gridwidth = 10;
		c.gridheight = 1;
		add(P2, c);
		
		c.gridx = 0;
		c.gridy = 5;
		c.gridwidth = 10;
		c.gridheight = 1;
		add(P3, c);
		
		c.gridx = 0;
		c.gridy = 7;
		c.gridwidth = 10;
		c.gridheight = 1;
		add(P4, c);
		
		c.gridx = 4;
		c.gridy = 14;
		c.gridwidth = 2;
		c.gridheight = 1;
		add(P5, c);
		
		c.gridx = 1;
		c.gridy = 14;
		c.gridwidth = 2;
		c.gridheight = 2;
		add(P6, c);
		
		c.gridx = 7;
		c.gridy = 14;
		c.gridwidth = 2;
		c.gridheight = 2;
		add(P7, c);
		
		c.gridx = 0;
		c.gridy = 10;
		c.gridwidth = 10;
		c.gridheight = 4;
		add(SPACEPANEL, c);
	}
	
	public void switchScreens(String getname) {
		setTitle("Poolesville High School - Counseling Office Sign In (2/2)");
	
	//P2
		P2.remove(welcome);
		P2.add(confirm);
		
	//P3
		P3.remove(askID);
		P3.remove(inputID);
		P3.add(askTeacher);
		P3.add(enterTeacher);
		
	//P4
		P4.remove(askReason);
		P4.remove(inputReason);
		P4.add(askCounselor);
		P4.add(enterCounselor);
		
	//P5
		fullName.setText(getname);
		fullName.setFont(new Font("rockwell", Font.BOLD, 18));
		P5.add(fullName);
				
	//P6
		cancel.setText("CANCEL");
		
	//P7
		P7.remove(cont);
		P7.add(finish);
		
	
	}

	public void switchBack() {
		setTitle("Poolesville High School - Counseling Office Sign In (1/2)");
		StartApp.ID = "";
    	StartApp.REASON = "";
    	StartApp.TEACHER = "";
    	StartApp.COUNSELOR = "";
    	inputID.setText("");
		inputReason.setSelectedIndex(0);												
		enterTeacher.setSelectedIndex(0);
		enterCounselor.setSelectedIndex(0);
		
	//P2
		P2.remove(confirm);
		P2.add(welcome);
		
	//P3
		P3.remove(askTeacher);
		P3.remove(enterTeacher);
		P3.add(askID);
		P3.add(inputID);
		
	//P4
		P4.remove(askCounselor);
		P4.remove(enterCounselor);
		P4.add(askReason);
		P4.add(inputReason);
		
	//P5
		P5.remove(fullName);
				
	//P6
		cancel.setText("CLEAR");
		
	//P7
		P7.remove(finish);
		P7.add(cont);
		
	
		
	}

	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource()==cont) {
			StartApp.ID = inputID.getText();
			StartApp.REASON = String.valueOf(inputReason.getSelectedItem());
			String getname = "ID: " + (StartApp.ID); 									//change this to get actual name from file
	    	switchScreens(getname);
		}
		
		else if(e.getSource()==cancel) {
			if(cancel.getText()=="CANCEL") {
				switchBack();
			}
			else if(cancel.getText()=="CLEAR") {
				inputID.setText("");
				inputReason.setSelectedIndex(0);												//use this to set automatic teacher and counselor *
			}
		}
		
		else if(e.getSource()==finish) {
			StartApp.TEACHER = String.valueOf(enterTeacher.getSelectedItem());
			StartApp.COUNSELOR = String.valueOf(enterCounselor.getSelectedItem());
			try {
				StartApp.addExcelEntry();
			} catch (FilloException e1) {
				e1.printStackTrace();
			}
	    	StartApp.sendEmail();
	    	switchBack();
		}
		
	}
	
}