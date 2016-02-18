import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.text.MaskFormatter;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

public class AlvarezTabbedPaneFrame extends JFrame {

	private JPanel contentPane;
	private final JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
	private final JPanel firstPanel = new JPanel();
	private final JLabel lblName = new JLabel("Name:");
	private final JTextField nameTF = new JTextField();
	private final JPanel secondPanel = new JPanel();
	private final JLabel lblName_1 = new JLabel("Name:");
	private final JLabel lblStreet = 	new JLabel("Street:");
	private final JLabel lblCity = new JLabel("City:");
	private final JLabel lblState = new JLabel("State:");
	private final JLabel lblZip = new JLabel("ZIP:");
	private final JPanel thirdPanel = new JPanel();
	private final JLabel lblName_2 = new JLabel("Name:");
	private final JLabel lblStreet_1 = new JLabel("Street:");
	private final JLabel lblCity_1 = new JLabel("City:");
	private final JLabel lblState_1 = new JLabel("State:");
	private final JLabel lblZip_1 = new JLabel("ZIP:");
	private final JTextField streetTFA = new JTextField();
	private final JTextField cityTFA = new JTextField();
	private final JFormattedTextField stateTFA = new JFormattedTextField();
	private final JTextField zipTFA = new JTextField();
	MaskFormatter numMask1 = createFormatter("  ");
	MaskFormatter numMask2 = createFormatter("(###)###-####");
	MaskFormatter numMask3 = createFormatter("UU");
	private final JLabel label = new JLabel("");
	   

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AlvarezTabbedPaneFrame frame = new AlvarezTabbedPaneFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	//A Panel is a container for other options
	//A tabbed pane is a container for panels
	public MaskFormatter createFormatter(String s) {
	     MaskFormatter formatter = null;
	     try {
	          formatter = new MaskFormatter(s);
	         } 
	     catch (java.text.ParseException exc) {
		          System.err.println("formatter is bad: " + exc.getMessage());
		          System.exit(-1);
		      }
	      return formatter;
	}//createFormatter
	/**
	 * Create the frame.
	 */
	public AlvarezTabbedPaneFrame() {
		zipTFA.setBounds(149, 179, 91, 26);
		zipTFA.setColumns(10);
		stateTFA.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				do_stateTFA_focusLost(e);
			}
		});
		stateTFA.setBounds(152, 146, 61, 26);
		stateTFA.setColumns(10);
		cityTFA.setBounds(152, 113, 149, 26);
		cityTFA.setColumns(10);
		streetTFA.setBounds(152, 76, 240, 26);
		streetTFA.setColumns(10);
		nameTF.setBounds(221, 118, 143, 26);
		nameTF.setColumns(10);
		jbInit();
	}
	private void jbInit() {
		setTitle("Alvarez Tabbed Pane Example");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 649, 384);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		tabbedPane.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				do_tabbedPane_stateChanged(e);
			}
		});
		tabbedPane.setBounds(6, 31, 589, 325);
		
		contentPane.add(tabbedPane);
		firstPanel.setToolTipText("First Tab");
		
		numMask1.setPlaceholderCharacter('#');
		numMask1.install(stateTFA);
		tabbedPane.addTab("Name", null, firstPanel, "First Tab");
		firstPanel.setLayout(null);
		firstPanel.setLayout(null);
		lblName.setBounds(179, 123, 61, 16);
		
		firstPanel.add(lblName);
		
		firstPanel.add(nameTF);
		secondPanel.setToolTipText("Second Tab");
		tabbedPane.addTab("Address", null, secondPanel, "Second Tab");
		secondPanel.setLayout(null);
		secondPanel.setLayout(null);
		lblName_1.setBounds(198, 29, 268, 16);
		
		secondPanel.add(lblName_1);
		lblStreet.setBounds(116, 81, 97, 16);
		
		secondPanel.add(lblStreet);
		lblCity.setBounds(126, 118, 114, 16);
		
		secondPanel.add(lblCity);
		lblState.setBounds(120, 151, 51, 16);
		
		secondPanel.add(lblState);
		lblZip.setBounds(126, 184, 87, 16);
		
		secondPanel.add(lblZip);
		
		secondPanel.add(streetTFA);
		
		secondPanel.add(cityTFA);
		
		secondPanel.add(stateTFA);
		
		secondPanel.add(zipTFA);
		thirdPanel.setToolTipText("Third Tab");
		
		tabbedPane.addTab("Summary", null, thirdPanel, "Third Panel");
		thirdPanel.setLayout(null);
		thirdPanel.setLayout(null);
		lblName_2.setBounds(118, 53, 265, 16);
		
		thirdPanel.add(lblName_2);
		lblStreet_1.setBounds(118, 85, 296, 16);
		
		thirdPanel.add(lblStreet_1);
		lblCity_1.setBounds(118, 113, 325, 16);
		
		thirdPanel.add(lblCity_1);
		lblState_1.setBounds(118, 136, 351, 16);
		
		thirdPanel.add(lblState_1);
		lblZip_1.setBounds(118, 164, 351, 16);
		
		thirdPanel.add(lblZip_1);
	}
	protected void do_tabbedPane_stateChanged(ChangeEvent e) {		
			do {
					if(nameTF.getText().equals("")) {			
						lblName_1.setForeground(Color.red);
						lblName_1.setText("No Name Inputed.");  
					} else{
						lblName_1.setText("Name: " + nameTF.getText());
						lblName_1.setForeground(Color.black);	
					}
				} while(secondPanel.equals(true));
			do {
				if(streetTFA.getText().equals("")) {
					lblStreet_1.setForeground(Color.red);
					lblStreet_1.setText("No Street Address Inputed.");  
				} else {
					lblStreet_1.setText("Street: " + streetTFA.getText());
					lblStreet_1.setForeground(Color.black);
				}
				
				if(cityTFA.getText().equals("")) {
					lblCity_1.setForeground(Color.red);
					lblCity_1.setText("No City Inputed.");  
				} else {
					lblCity_1.setText("City: " + cityTFA.getText());
					lblCity_1.setForeground(Color.black);
				}
				
				if(stateTFA.getText().equals("")) {
					lblState_1.setForeground(Color.red);
					lblState_1.setText("No State Inputed.");  
				} else {
					lblState_1.setText("State: " + stateTFA.getText());
					lblState_1.setForeground(Color.black);
				}
				
				if(zipTFA.getText().equals("")) {
					lblZip_1.setForeground(Color.red);
					lblZip_1.setText("No Zip Inputed.");  
				} else {
					lblZip_1.setText("Zip: " + zipTFA.getText());
					lblZip_1.setForeground(Color.black);
				}
				
				if(lblName_1.getText().equals("No Name Inputed.")) {
					lblName_2.setForeground(Color.red);
					lblName_2.setText("No Name Inputed.");  
				} else{
					lblName_2.setText("Name: " + nameTF.getText());
					lblName_2.setForeground(Color.black);	
				}
			} while(thirdPanel.equals(true));
							
	}
	 
	protected void do_stateTFA_focusLost(FocusEvent e) {
		label.setText(String.valueOf(stateTFA.getText()))
	}
}
