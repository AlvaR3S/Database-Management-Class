import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.KeyStroke;
import java.awt.event.KeyEvent;
import java.awt.event.InputEvent;
import javax.swing.JCheckBox;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.JToggleButton;
import javax.swing.JProgressBar;
import java.awt.Color;

public class AlvarezMenusAndMoreFrame extends JFrame {

	private JPanel contentPane;
	private final JMenuBar menuBar = new JMenuBar();
	private final JMenu mnFile = new JMenu("File");
	private final JMenuItem mntmNew = new JMenuItem("New...");
	private final JMenuItem mntmOpen = new JMenuItem("Open...");
	private final JMenuItem mntmSave = new JMenuItem("Save");
	private final JMenuItem mntmClose = new JMenuItem("Close");
	private final JMenuItem mntmExit = new JMenuItem("Exit");
	private final JMenu mnEdit = new JMenu("Edit");
	private final JMenuItem mntmCopy = new JMenuItem("Copy");
	private final JMenuItem mntmPaste = new JMenuItem("Paste");
	private final JMenu mnMore = new JMenu("More");
	private final JLabel lblSelection = new JLabel("Selection:");
	private final JMenuItem mntmOne = new JMenuItem("One");
	private final JMenuItem mntmTwo = new JMenuItem("Two");
	private final JMenuItem mntmThree = new JMenuItem("Three");
	private final JCheckBox chckbxFirst = new JCheckBox("First");
	private final JCheckBox chckbxSecond = new JCheckBox("Second");
	private final JCheckBox chckbxThird = new JCheckBox("Third");
	public String Selection = lblSelection.getText();
	public String FirstChck = chckbxFirst.getText();
	public String SecondChck = chckbxSecond.getText();
	public String ThirdChck = chckbxThird.getText();
	public String labelText = " ";	
	private final JPasswordField passwordField = new JPasswordField();
	private final JLabel lblPassword = new JLabel("Password:");
	private final JButton btnPrint = new JButton("Print");
	private final JButton btnAdvance = new JButton("Advance");
	private final JProgressBar progressBar = new JProgressBar();
	private final JToggleButton tglbtnToggle = new JToggleButton("Toggle");
	/**
	 * @param Sets lblSelection.setText() to something
	 */
	public void setDefault() {
		lblSelection.setText(Selection + labelText);
	}
	public void chckBox() {
		
		if(chckbxFirst.isSelected()) {
			lblSelection.setText(Selection + labelText + FirstChck + "\n");
		} else if(chckbxSecond.isSelected()) {
			lblSelection.setText(Selection + labelText + SecondChck + "\n");
		} else if(chckbxThird.isSelected()) {
			lblSelection.setText(Selection + labelText + ThirdChck + "\n");
		} else {
			setDefault();
		}
		if((chckbxFirst.isSelected()) && (chckbxSecond.isSelected())) {
			lblSelection.setText(Selection + labelText + FirstChck + labelText + SecondChck + "\n");
		} 
		if((chckbxFirst.isSelected()) && (chckbxThird.isSelected())) {
			lblSelection.setText(Selection + labelText + FirstChck + labelText + ThirdChck + "\n");
		} 
		if((chckbxSecond.isSelected()) && (chckbxThird.isSelected())) {
			lblSelection.setText(Selection + labelText + SecondChck + labelText + ThirdChck + "\n");
		} 
		if((chckbxFirst.isSelected()) && (chckbxSecond.isSelected()) && (chckbxThird.isSelected())) {
			lblSelection.setText(Selection + labelText + FirstChck + labelText + SecondChck + labelText + ThirdChck + "\n");
		}
		
	}


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AlvarezMenusAndMoreFrame frame = new AlvarezMenusAndMoreFrame();
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
	public AlvarezMenusAndMoreFrame() {
		jbInit();
	}
	private void jbInit() {
		setTitle("Alvarez Menus and More");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		
		setJMenuBar(menuBar);
		
		menuBar.add(mnFile);
		mntmNew.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_mntmNew_actionPerformed(e);
			}
		});
		
		mnFile.add(mntmNew);
		
		mnFile.add(mntmOpen);
		
		mnFile.add(mntmSave);
		
		mnFile.add(mntmClose);
		
		mnFile.add(mntmExit);
		
		menuBar.add(mnEdit);
		mntmCopy.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_mntmCopy_actionPerformed(e);
			}
		});
		mntmCopy.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, InputEvent.CTRL_MASK));
		
		mnEdit.add(mntmCopy);
		
		mnEdit.add(mntmPaste);
		
		mnEdit.add(mnMore);
		
		mnMore.add(mntmOne);
		
		mnMore.add(mntmTwo);
		
		mnMore.add(mntmThree);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		lblSelection.setBounds(61, 106, 210, 16);
		
		contentPane.add(lblSelection);
		chckbxFirst.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_chckbxFirst_actionPerformed(e);
			}
		});
		chckbxFirst.setBounds(262, 77, 128, 23);
		
		contentPane.add(chckbxFirst);
		chckbxSecond.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_chckbxSecond_actionPerformed(e);
			}
		});
		chckbxSecond.setBounds(262, 102, 128, 23);
		
		contentPane.add(chckbxSecond);
		chckbxThird.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_chckbxThird_actionPerformed(e);
			}
		});
		chckbxThird.setBounds(262, 126, 128, 23);
		
		contentPane.add(chckbxThird);
		passwordField.setBounds(124, 178, 90, 26);
		
		contentPane.add(passwordField);
		lblPassword.setBounds(61, 183, 90, 16);
		
		contentPane.add(lblPassword);
		btnPrint.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_btnPrint_actionPerformed(e);
			}
		});
		btnPrint.setBounds(216, 178, 117, 29);
		
		contentPane.add(btnPrint);
		btnAdvance.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_btnAdvance_actionPerformed(e);
			}
		});
		btnAdvance.setBounds(308, 46, 117, 29);
		
		contentPane.add(btnAdvance);
		progressBar.setBounds(298, 24, 146, 20);
		
		contentPane.add(progressBar);
		tglbtnToggle.setBackground(Color.LIGHT_GRAY);
		tglbtnToggle.setBounds(93, 205, 161, 29);
		
		contentPane.add(tglbtnToggle);
	}
	

	protected void do_mntmNew_actionPerformed(ActionEvent e) {
		lblSelection.setText("New...");
		
	} 
	protected void do_mntmCopy_actionPerformed(ActionEvent e) {
		lblSelection.setText("Copy");
	}
	//make first checkbox work. make a method and call on other checkboxes.
	protected void do_chckbxFirst_actionPerformed(ActionEvent e) {
		chckBox();
	}
	protected void do_chckbxSecond_actionPerformed(ActionEvent e) {
		chckBox();
	}
	protected void do_chckbxThird_actionPerformed(ActionEvent e) {
		chckBox();
	}
	//can something else either than little dots pop up
	protected void do_btnPrint_actionPerformed(ActionEvent e) {
		char[] password = passwordField.getPassword();
		boolean pass = passwordField.isDisplayable();		
		
//		if(pass.equals("")) {
//			lblSelection.setText("Error. Please input a valid password");
//		} else {
//			lblSelection.setText(String.valueOf(password));
//		}
		if(!(tglbtnToggle.isSelected())) {
			lblSelection.setText(String.valueOf(password));
		} else {
			//lblSelection.(passwordField);
//			lblSelection.setText(passwordField.g);
			int length = passwordField.getPassword().length;
			String str = "";
			for (int i = 0; i < length; i++) {
				str += "●";
			}
			lblSelection.setText(str);
		}
		
}	protected void do_btnAdvance_actionPerformed(ActionEvent e) {
	int progress = progressBar.getValue();
	progressBar.setValue(progress + 5); 
}
	}

