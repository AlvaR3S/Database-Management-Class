import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Line2D;
import java.text.NumberFormat;

import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AlvarezAdditionFrame extends JFrame {

	private JPanel contentPane;
	
	NumberFormat numFormat = NumberFormat.getIntegerInstance(); 
	
	private final JFormattedTextField firstFTF = new JFormattedTextField(numFormat);
	private final JFormattedTextField secondFTF = new JFormattedTextField(numFormat);
	private final JLabel label = new JLabel("+");
	private final JLabel lblInputNumbersTo = new JLabel("Input numbers to be added");
	private final JFormattedTextField sumOfFirstAndSecondFTF = new JFormattedTextField(numFormat);
	public double num1 = 0.0;
	public double num2 = 0.0;
	public double num3;
	private final JButton btnAdd = new JButton("Add");
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AlvarezAdditionFrame frame = new AlvarezAdditionFrame();
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
	public AlvarezAdditionFrame() {
		jbInit();
	}
	private void jbInit() {
		setTitle("Alvarez Addition Example");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		firstFTF.setBounds(150, 68, 149, 26);
		firstFTF.setValue(num1);
		
		contentPane.add(firstFTF);
		secondFTF.setBounds(150, 91, 149, 26);
		secondFTF.setValue(num2);
			
		contentPane.add(secondFTF);
		label.setBounds(132, 96, 61, 16);
		
		contentPane.add(label);
		lblInputNumbersTo.setBounds(132, 40, 190, 16);
		
		contentPane.add(lblInputNumbersTo);
		sumOfFirstAndSecondFTF.setEditable(false);
		sumOfFirstAndSecondFTF.setBounds(150, 124, 149, 19);
		
		contentPane.add(sumOfFirstAndSecondFTF);
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_btnAdd_actionPerformed(e);
			}
		});
		sumOfFirstAndSecondFTF.setValue(num3);
		btnAdd.setBounds(160, 147, 117, 29);
		
		contentPane.add(btnAdd);
	}
	public void paint(Graphics g) {
        super.paint(g);  // fixes the immediate problem.
        Graphics2D g2 = (Graphics2D) g;
        Line2D lin = new Line2D.Float(100, 140, 350, 140);
        g2.draw(lin);
    }
	protected void do_btnAdd_actionPerformed(ActionEvent e) {
		num1 = ((Number)(firstFTF.getValue())).doubleValue();
		num2= ((Number)(secondFTF.getValue())).doubleValue();
		sumOfFirstAndSecondFTF.setValue(num1 + num2);
		
	}
}
