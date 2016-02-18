import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextArea;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JFormattedTextField;

public class AlvarezTestOutputFrame extends JFrame {

	private JPanel contentPane;
	private final JTextArea textArea = new JTextArea();
	private final JButton btnSayHello = new JButton("Say Hello");
	private final JScrollPane scrollPane = new JScrollPane();
	private final JLabel lblName = new JLabel("Name:");
	private final JFormattedTextField NameTextField = new JFormattedTextField();
	private final JLabel lblEmail = new JLabel("Email:");
	private final JTextField EmailTextField = new JTextField();
	private final JLabel lblPhone = new JLabel("Phone:");
	private final JTextField PhoneTextField = new JTextField();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AlvarezTestOutputFrame frame = new AlvarezTestOutputFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public AlvarezTestOutputFrame() {
		PhoneTextField.setBounds(356, 205, 92, 26);
		PhoneTextField.setColumns(10);
		EmailTextField.setBounds(356, 160, 92, 26);
		EmailTextField.setColumns(10);
		NameTextField.setBounds(356, 116, 92, 26);
		NameTextField.setColumns(10);
		jbInit();
	}
	private void jbInit() {
		setTitle("Alvarez Same Output");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		scrollPane.setBounds(6, 23, 300, 226);
		
		contentPane.add(scrollPane);
		textArea.setEditable(false);
		scrollPane.setViewportView(textArea);
		btnSayHello.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_btnSayHello_actionPerformed(e);
			}
		});
		btnSayHello.setBounds(327, 63, 117, 29);
		
		contentPane.add(btnSayHello);
		lblName.setBounds(313, 121, 47, 16);
		
		contentPane.add(lblName);
		
		contentPane.add(NameTextField);
		lblEmail.setBounds(313, 165, 47, 16);
		
		contentPane.add(lblEmail);
		
		contentPane.add(EmailTextField);
		lblPhone.setBounds(313, 210, 47, 16);
		
		contentPane.add(lblPhone);
		
		contentPane.add(PhoneTextField);
	}
	//CHallenege add email and phone fields and verify so that if one of them arent field out message is 
	//printed, if 2 of them then vice cersa.
	protected void do_btnSayHello_actionPerformed(ActionEvent e) {
		String inputName = NameTextField.getText().toString();
		String inputEmail = EmailTextField.getText().toString();
		String inputPhone = PhoneTextField.getText().toString();
		if(inputName.equals("") || inputEmail.equals("") || inputPhone.equals("")) {
			textArea.append("Please fill missing information." + "\n");		
		} else {
			textArea.append("\n" + "\n" + "Hello..." + "\n" + "Name: " + inputName + "\n");
			textArea.append("Email: " + inputEmail + "\n");
			textArea.append("Phone: " + inputPhone);
		}
		
	}
}
