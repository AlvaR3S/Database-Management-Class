import java.awt.EventQueue;

import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

public class AlvarezInputMaskFrame extends JFrame {

	private JPanel contentPane;
	private final JFormattedTextField numberFormattedTextField = new JFormattedTextField();
	private final JLabel lblEnterANumber = new JLabel("Enter A Phone Number:");
	
	MaskFormatter numMask1 = createFormatter("###-##-####");
	MaskFormatter numMask2 = createFormatter("(###)###-####");
	MaskFormatter numMask3 = createFormatter("UU");
	private final JLabel lblEnterYourSocial = new JLabel("Enter Your Social Security:");
	private final JFormattedTextField socialTextField = new JFormattedTextField();
	private final JLabel lblState = new JLabel("State:");
	private final JFormattedTextField stateFTF = new JFormattedTextField();
	private final JLabel label = new JLabel("");
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AlvarezInputMaskFrame frame = new AlvarezInputMaskFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	//place this code after main()

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
	//Prevents the user from entering invalid characters
	//input verify doesn't block anything takes what they gave us and try's to fix it
	public AlvarezInputMaskFrame() {
		jbInit();
	}
	
	private void jbInit() {
		setTitle("Alvarez Input Mask Example");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		numberFormattedTextField.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				do_numberFormattedTextField_focusLost(e);
			}
		});
		numberFormattedTextField.setBounds(185, 68, 106, 26);
		
		numMask1.setPlaceholderCharacter('#');
		numMask1.install(numberFormattedTextField);
		contentPane.add(numberFormattedTextField);
		lblEnterANumber.setBounds(43, 101, 145, 16);
		numMask2.setPlaceholderCharacter('#');
		numMask2.install(socialTextField);
		contentPane.add(lblEnterANumber);
		lblEnterYourSocial.setBounds(24, 73, 164, 16);
		
		contentPane.add(lblEnterYourSocial);
		socialTextField.setBounds(185, 96, 116, 26);
		
		contentPane.add(socialTextField);
		lblState.setBounds(153, 129, 35, 16);
		numMask3.setPlaceholder("SS");
		numMask3.install(stateFTF);
		contentPane.add(lblState);
		stateFTF.setBounds(185, 124, 52, 26);
		
		contentPane.add(stateFTF);
		label.setBounds(312, 73, 116, 16);
		
		contentPane.add(label);
	}
	protected void do_numberFormattedTextField_focusLost(FocusEvent e) {
		label.setText(String.valueOf(numberFormattedTextField.getText()));
	}
}
