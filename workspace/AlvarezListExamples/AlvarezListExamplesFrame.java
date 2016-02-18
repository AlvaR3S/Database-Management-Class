import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JList;
import javax.swing.AbstractListModel;
import javax.swing.JCheckBox;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.ButtonModel;

public class AlvarezListExamplesFrame extends JFrame {

	private JPanel contentPane;
	private final JButton btnPrint = new JButton("Print");
	private final JTextArea displayList = new JTextArea();
	private final JScrollPane scrollPane_1 = new JScrollPane();
	private final JList optionList = new JList();
	private final JScrollPane scrollPane = new JScrollPane();
	private final JRadioButton rdbtnFirstRadioButton = new JRadioButton("First Radio Button");
	private final JRadioButton rdbtnSecondRadioButton = new JRadioButton("Second Radio Button");
	private final JRadioButton rdbtnThirdRadioButton = new JRadioButton("Third Radio Button");
	private final ButtonGroup buttonGroup = new ButtonGroup();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AlvarezListExamplesFrame frame = new AlvarezListExamplesFrame();
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
	public AlvarezListExamplesFrame() {
		jbInit();
	}
	private void jbInit() {
		setTitle("Alvarez List Selection");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		btnPrint.setToolTipText("Press to display numbers");
		btnPrint.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_btnPrint_actionPerformed(e);
			}
		});
		btnPrint.setBounds(285, 183, 117, 29);
		
		contentPane.add(btnPrint);
		scrollPane_1.setBounds(262, 20, 162, 145);
		
		contentPane.add(scrollPane_1);
		displayList.setEditable(false);
		displayList.setToolTipText("The print output");
		scrollPane_1.setViewportView(displayList);
		scrollPane.setBounds(17, 19, 141, 107);
		
		contentPane.add(scrollPane);
		optionList.setModel(new AbstractListModel() {
			String[] values = new String[] {"One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten"};
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
		optionList.setToolTipText("List of numbers");
		scrollPane.setViewportView(optionList);
		buttonGroup.add(rdbtnFirstRadioButton);
		rdbtnFirstRadioButton.setToolTipText("Radio button");
		rdbtnFirstRadioButton.setBounds(17, 150, 162, 23);
		
		contentPane.add(rdbtnFirstRadioButton);
		buttonGroup.add(rdbtnSecondRadioButton);
		rdbtnSecondRadioButton.setToolTipText("Radio button");
		rdbtnSecondRadioButton.setBounds(17, 184, 162, 23);
		
		contentPane.add(rdbtnSecondRadioButton);
		buttonGroup.add(rdbtnThirdRadioButton);
		rdbtnThirdRadioButton.setToolTipText("Radio button");
		rdbtnThirdRadioButton.setBounds(17, 219, 162, 23);
		
		contentPane.add(rdbtnThirdRadioButton);
	}
	protected void do_btnPrint_actionPerformed(ActionEvent e) {
		displayList.setText("");
		List<String> theList = optionList.getSelectedValuesList();
		String display = "";
		for(String l: theList) {
			displayList.append(l + "\n");
		}
		
		if(rdbtnFirstRadioButton.isSelected()) {
			display = rdbtnFirstRadioButton.getText();
			displayList.append("\n" + display + "\n");
		}
		
		if(rdbtnSecondRadioButton.isSelected()) {
			display = rdbtnSecondRadioButton.getText();
			displayList.append("\n" + display + "\n");
		}
		
		if(rdbtnThirdRadioButton.isSelected()) {
			display = rdbtnThirdRadioButton.getText();
			displayList.append("\n" + display + "\n");
		}
		
	}
}
