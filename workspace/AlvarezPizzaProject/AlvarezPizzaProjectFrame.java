import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JList;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.AbstractListModel;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;

public class AlvarezPizzaProjectFrame extends JFrame {

	private JPanel contentPane;
	private final JLabel lblName = new JLabel("Name:");
	private final JLabel lblSize = new JLabel("Size:");
	private final JLabel lblToppings = new JLabel("Toppings:");
	private final JTextField NameTextField = new JTextField();
	private final JButton btnPlaceOrder = new JButton("Place Order");
	private final JTextArea reciept = new JTextArea();
	private final JScrollPane scrollPane = new JScrollPane();
	private final JList toppings = new JList();
	private final JScrollPane scrollPane_1 = new JScrollPane();
	private final JComboBox SizeOfPizza = new JComboBox();
	private final JLabel lblPleasePlaceYour = new JLabel("Please Place Your Order");

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AlvarezPizzaProjectFrame frame = new AlvarezPizzaProjectFrame();
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
	public AlvarezPizzaProjectFrame() {
		NameTextField.setToolTipText("The name of the person goes here");
		NameTextField.setBounds(63, 38, 130, 26);
		NameTextField.setColumns(10);
		jbInit();
	}
	private void jbInit() {
		setTitle("Alvarez's Pizza");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setToolTipText("");
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		lblName.setToolTipText("The person who is ordering");
		lblName.setBounds(18, 43, 47, 16);
		
		contentPane.add(lblName);
		lblSize.setToolTipText("These are the pizza Sizes");
		lblSize.setBounds(25, 90, 40, 16);
		
		contentPane.add(lblSize);
		lblToppings.setToolTipText("You can pick up to three toppings!");
		lblToppings.setBounds(6, 137, 70, 16);
		
		contentPane.add(lblToppings);
		
		contentPane.add(NameTextField);
		btnPlaceOrder.setToolTipText("Continue with order");
		btnPlaceOrder.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_btnPlaceOrder_actionPerformed(e);
			}
		});
		btnPlaceOrder.setBounds(180, 226, 117, 29);
		
		contentPane.add(btnPlaceOrder);
		scrollPane.setToolTipText("The reciept");
		scrollPane.setBounds(263, 41, 166, 169);
		
		contentPane.add(scrollPane);
		reciept.setEditable(false);
		scrollPane.setColumnHeaderView(reciept);
		scrollPane_1.setBounds(76, 137, 117, 77);
		
		contentPane.add(scrollPane_1);
		toppings.setToolTipText("Pick Three Toppings");
		toppings.setModel(new AbstractListModel() {
			String[] values = new String[] {"Onions", "Bacon", "Mushroom", "Chicken", "Salami", "Sausage", "Pepperoni", "Pineapple", "Broccli", "Spinach", "Green peppers", "Ranch"};
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
		scrollPane_1.setViewportView(toppings);
		SizeOfPizza.setToolTipText("There are five different pizza sizes");
		SizeOfPizza.setModel(new DefaultComboBoxModel(new String[] {"Extra Large", "Large", "Medium", "Small", "Individual"}));
		SizeOfPizza.setBounds(63, 90, 130, 16);
		
		contentPane.add(SizeOfPizza);
		lblPleasePlaceYour.setToolTipText("Place your order");
		lblPleasePlaceYour.setForeground(Color.MAGENTA);
		lblPleasePlaceYour.setBounds(142, 10, 155, 16);
		
		contentPane.add(lblPleasePlaceYour);
	}
	
	protected void do_btnPlaceOrder_actionPerformed(ActionEvent e) {
		reciept.setText("");
		String inputName = NameTextField.getText();
		List<String> ListofToppings = toppings.getSelectedValuesList();
		String size = SizeOfPizza.getSelectedItem().toString();
		if(inputName.equals("")) {
			reciept.append("Please input Name." + "\n");
			lblName.setForeground(Color.RED);
		} else {
			lblName.setForeground(Color.BLACK);
			reciept.append("Hello " + inputName + "." + "\n");
			reciept.append("You ordered a" + "\n");
			reciept.append(size + "\n");
			for(String t: ListofToppings) {
				reciept.append(t + "\n");
			}
		}
		
	}
}
