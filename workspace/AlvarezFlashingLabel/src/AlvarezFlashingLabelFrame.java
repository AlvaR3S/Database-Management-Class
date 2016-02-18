import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Label;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AlvarezFlashingLabelFrame extends JFrame {

	private JPanel contentPane;
	private final JLabel lblCmptRocks = new JLabel("CMPT 330 Rocks!");
	private final JButton btnFlash = new JButton("Flash");
	private final JLabel lblCmptIs = new JLabel("Cmpt 330 Is the Best!");
	private final JButton btnFlashBoth = new JButton("Flash Both");

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AlvarezFlashingLabelFrame frame = new AlvarezFlashingLabelFrame();
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
	public AlvarezFlashingLabelFrame() {
		jbInit();
	}
	private void jbInit() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		lblCmptRocks.setBounds(156, 64, 154, 16);
		
		contentPane.add(lblCmptRocks);
		btnFlash.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_btnFlash_actionPerformed(e);
			}
		});
		btnFlash.setBounds(156, 144, 117, 29);
		
		contentPane.add(btnFlash);
		lblCmptIs.setBounds(21, 216, 157, 16);
		lblCmptIs.setVisible(false);
		
		contentPane.add(lblCmptIs);
		btnFlashBoth.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_btnFlashBoth_actionPerformed(e);
			}
		});
		btnFlashBoth.setBounds(327, 222, 117, 29);
		
		contentPane.add(btnFlashBoth);
	}
	protected void do_btnFlash_actionPerformed(ActionEvent e) {
		lblCmptRocks.setVisible(!lblCmptRocks.isVisible());
	}
	protected void do_btnFlashBoth_actionPerformed(ActionEvent e) {
		lblCmptRocks.setVisible(!lblCmptRocks.isVisible());
		lblCmptIs.setVisible(!lblCmptIs.isVisible());
		
	}
}
