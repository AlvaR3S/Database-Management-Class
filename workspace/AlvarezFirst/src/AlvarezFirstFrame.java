import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Color;

public class AlvarezFirstFrame extends JFrame {

	private JPanel contentPane;
	private final JLabel lblHello = new JLabel("Hello");
	private final JLabel lblItsMe = new JLabel("ItsMe");
	private final JButton Switch = new JButton("Switch");
	private final JLabel lblYou = new JLabel("You");
	private final JButton btnFont = new JButton("Font");
	private final JButton btnReset = new JButton("Reset");

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AlvarezFirstFrame frame = new AlvarezFirstFrame();
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
	public AlvarezFirstFrame() {
		jbInit();
	}
	private void jbInit() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		lblHello.setForeground(Color.RED);
		lblHello.setFont(new Font("Hoefler Text", Font.BOLD | Font.ITALIC, 38));
		lblHello.setBounds(49, 156, 117, 81);
		
		contentPane.add(lblHello);
		lblItsMe.setFont(new Font("Zapfino", Font.PLAIN, 20));
		lblItsMe.setForeground(Color.BLUE);
		lblItsMe.setBounds(178, 156, 117, 81);
		
		contentPane.add(lblItsMe);
		Switch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_Switch_actionPerformed(e);
			}
		});
		Switch.setBounds(33, 34, 117, 29);
		
		contentPane.add(Switch);
		lblYou.setFont(new Font("HanziPen SC", Font.BOLD | Font.ITALIC, 20));
		lblYou.setForeground(Color.PINK);
		lblYou.setBounds(308, 156, 117, 72);
		
		contentPane.add(lblYou);
		
		JButton btnColor = new JButton("Color");
		btnColor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblHello.setForeground(Color.YELLOW);
				lblItsMe.setForeground(Color.MAGENTA);
				lblYou.setForeground(Color.green);
			}
		});
		btnColor.setBounds(162, 34, 117, 29);
		contentPane.add(btnColor);
		btnFont.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblHello.setFont(new Font("HanziPen SC", Font.BOLD | Font.ITALIC, 10));
				lblItsMe.setFont(new Font("Hoefler Text", Font.BOLD | Font.ITALIC, 25));
				lblYou.setFont(new Font("Zapfino", Font.PLAIN, 30));
			}
		});
		btnFont.setBounds(287, 34, 117, 29);
		
		contentPane.add(btnFont);
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblHello.setForeground(Color.RED);
				lblHello.setFont(new Font("Hoefler Text", Font.BOLD | Font.ITALIC, 38));
				lblHello.setBounds(49, 156, 117, 81);
				

				lblItsMe.setFont(new Font("Zapfino", Font.PLAIN, 20));
				lblItsMe.setForeground(Color.BLUE);
				lblItsMe.setBounds(178, 156, 117, 81);
				
				lblYou.setFont(new Font("HanziPen SC", Font.BOLD | Font.ITALIC, 20));
				lblYou.setForeground(Color.PINK);
				lblYou.setBounds(308, 156, 117, 72);
				
			}
		});
		btnReset.setBounds(162, 104, 117, 29);
		
		contentPane.add(btnReset);
	}
	protected void do_Switch_actionPerformed(ActionEvent e) {
		String temp = lblHello.getText();
		lblHello.setText(lblItsMe.getText());
		lblItsMe.setText(lblYou.getText());
		lblYou.setText(temp);
		
	}
}
