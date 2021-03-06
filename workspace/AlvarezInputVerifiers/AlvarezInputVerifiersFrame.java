import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.text.NumberFormat;

import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class AlvarezInputVerifiersFrame extends JFrame {

	private JPanel contentPane;
	
	NumberFormat numFormat = NumberFormat.getNumberInstance();
	NumberFormat currencyFormat = NumberFormat.getCurrencyInstance();
	NumberFormat percentageFormat = NumberFormat.getPercentInstance();	
	
	private final JFormattedTextField FirstFTF = new JFormattedTextField(numFormat);
	private final JFormattedTextField SecondFTF = new JFormattedTextField(currencyFormat);
	private final JFormattedTextField ThirdFTF = new JFormattedTextField(percentageFormat);
	private final JLabel lblFirstText = new JLabel("First Text");
	private final JLabel lblFirstValue = new JLabel("First Value");
	
	double num1 = 1.0;
	double num2 = 2.0;
	double num3 = 3.0;
	private final JLabel lblCurrency = new JLabel("Currency");
	private final JLabel lblPercentage = new JLabel("Percentage");
	private final JLabel lblSecondValue = new JLabel("Second Value");
	private final JLabel lblThirdValue = new JLabel("Third Value");
	private final JButton btnAdd = new JButton("Add 1");
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AlvarezInputVerifiersFrame frame = new AlvarezInputVerifiersFrame();
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
	public AlvarezInputVerifiersFrame() {
		jbInit();
	}
	private void jbInit() {
		setTitle("Alvarez Input Verifiers Example");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		FirstFTF.addPropertyChangeListener(new PropertyChangeListener() {
			public void propertyChange(PropertyChangeEvent evt) {
				do_FirstFTF_propertyChange(evt);
			}
		});
		FirstFTF.setBounds(111, 41, 83, 26);
		FirstFTF.setValue(num1);
		contentPane.add(FirstFTF);
		SecondFTF.addPropertyChangeListener(new PropertyChangeListener() {
			public void propertyChange(PropertyChangeEvent evt) {
				do_SecondFTF_propertyChange(evt);
			}
		});
		SecondFTF.setBounds(111, 79, 83, 26);
		SecondFTF.setValue(num2);
		contentPane.add(SecondFTF);
		ThirdFTF.addPropertyChangeListener(new PropertyChangeListener() {
			public void propertyChange(PropertyChangeEvent evt) {
				do_ThirdFTF_propertyChange(evt);
			}
		});
		ThirdFTF.setBounds(111, 117, 83, 26);
		ThirdFTF.setValue(num3);
		contentPane.add(ThirdFTF);
		
		
		lblFirstText.setBounds(206, 46, 75, 16);
		contentPane.add(lblFirstText);
		lblFirstValue.setBounds(321, 46, 83, 16);
		
		contentPane.add(lblFirstValue);
		lblCurrency.setBounds(206, 84, 61, 16);
		
		contentPane.add(lblCurrency);
		lblPercentage.setBounds(206, 122, 75, 16);
		
		contentPane.add(lblPercentage);
		lblSecondValue.setBounds(321, 84, 89, 16);
		
		contentPane.add(lblSecondValue);
		lblThirdValue.setBounds(321, 122, 83, 16);
		
		contentPane.add(lblThirdValue);
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_btnAdd_actionPerformed(e);
			}
		});
		btnAdd.setBounds(6, 41, 93, 29);
		
		contentPane.add(btnAdd);
	}
	//with input verifies we dont want the focus lost event we want the property change event
	
	protected void do_FirstFTF_propertyChange(PropertyChangeEvent evt) {
		lblFirstText.setText(FirstFTF.getText());
		lblFirstValue.setText(FirstFTF.getValue().toString());
	}
	protected void do_SecondFTF_propertyChange(PropertyChangeEvent evt) {
		lblCurrency.setText(SecondFTF.getText());
		lblSecondValue.setText(SecondFTF.getValue().toString());
	}
	protected void do_ThirdFTF_propertyChange(PropertyChangeEvent evt) {
		lblPercentage.setText(ThirdFTF.getText());
		lblThirdValue.setText(ThirdFTF.getValue().toString());
	}
	protected void do_btnAdd_actionPerformed(ActionEvent e) {
		//this allows to make anytype of conversion
		num1 = ((Number)(FirstFTF.getValue())).doubleValue();
		//specifically a double type conversion
		num1 = (double)(FirstFTF.getValue())+1;
		FirstFTF.setValue(num1);
	}
}
