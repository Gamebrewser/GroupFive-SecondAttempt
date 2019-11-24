//this search gui should pop up after an item is searched for.

package STAPM_UI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.GridLayout;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextField;
import javax.swing.JButton;

public class SearchGUI {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SearchGUI window = new SearchGUI(); // this is just here so that no error pops up. Should be changed
					window.frame.setVisible(true);		//with another name eventually. - Kyle
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public SearchGUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		frame.getContentPane().setLayout(gridBagLayout);
		
		JLabel lblItem = new JLabel("Item:");
		GridBagConstraints gbc_lblItem = new GridBagConstraints();
		gbc_lblItem.anchor = GridBagConstraints.EAST;
		gbc_lblItem.insets = new Insets(0, 0, 5, 5);
		gbc_lblItem.gridx = 0;
		gbc_lblItem.gridy = 1;
		frame.getContentPane().add(lblItem, gbc_lblItem);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Motor Oil", "Wipers", "Paint", "Brake Fluid", "Oil Filter", "Gas Hose"}));
		GridBagConstraints gbc_comboBox = new GridBagConstraints();
		gbc_comboBox.insets = new Insets(0, 0, 5, 0);
		gbc_comboBox.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox.gridx = 1;
		gbc_comboBox.gridy = 1;
		frame.getContentPane().add(comboBox, gbc_comboBox);
		
		
		JLabel lblQuantityInStock = new JLabel("Quantity in Stock:");
		GridBagConstraints gbc_lblQuantityInStock  = new GridBagConstraints();
		gbc_lblQuantityInStock .anchor = GridBagConstraints.EAST;
		gbc_lblQuantityInStock .insets = new Insets(0, 0, 5, 5);
		gbc_lblQuantityInStock .gridx = 0;
		gbc_lblQuantityInStock .gridy = 3;
		frame.getContentPane().add(lblQuantityInStock , gbc_lblQuantityInStock );
		
		// The search function should return the values for the searched item in the text fields. - Kyle
		//values = quantity, cost per unit and date added - Kyle
		
		textField = new JTextField();
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.insets = new Insets(0, 0, 5, 0);
		gbc_textField.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField.gridx = 1;
		gbc_textField.gridy = 3;
		frame.getContentPane().add(textField, gbc_textField);
		textField.setColumns(10);
		
		JLabel lblCostPerUnit = new JLabel("Cost Per Unit:");
		GridBagConstraints gbc_lblCostPerUnit = new GridBagConstraints();
		gbc_lblCostPerUnit.anchor = GridBagConstraints.EAST;
		gbc_lblCostPerUnit.insets = new Insets(0, 0, 5, 5);
		gbc_lblCostPerUnit.gridx = 0;
		gbc_lblCostPerUnit.gridy = 5;
		frame.getContentPane().add(lblCostPerUnit, gbc_lblCostPerUnit);
		
		textField_1 = new JTextField();
		GridBagConstraints gbc_textField_1 = new GridBagConstraints();
		gbc_textField_1.insets = new Insets(0, 0, 5, 0);
		gbc_textField_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_1.gridx = 1;
		gbc_textField_1.gridy = 5;
		frame.getContentPane().add(textField_1, gbc_textField_1);
		textField_1.setColumns(10);
		
		JLabel lblDateAdded = new JLabel("Date Added:");
		GridBagConstraints gbc_lblDateAdded = new GridBagConstraints();
		gbc_lblDateAdded.anchor = GridBagConstraints.EAST;
		gbc_lblDateAdded.insets = new Insets(0, 0, 5, 5);
		gbc_lblDateAdded.gridx = 0;
		gbc_lblDateAdded.gridy = 7;
		frame.getContentPane().add(lblDateAdded, gbc_lblDateAdded);
		
		textField_2 = new JTextField();
		GridBagConstraints gbc_textField_2 = new GridBagConstraints();
		gbc_textField_2.insets = new Insets(0, 0, 5, 0);
		gbc_textField_2.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_2.gridx = 1;
		gbc_textField_2.gridy = 7;
		frame.getContentPane().add(textField_2, gbc_textField_2);
		textField_2.setColumns(10);
		
		JButton btnBack = new JButton("Back");
		GridBagConstraints gbc_btnBack = new GridBagConstraints();
		gbc_btnBack.insets = new Insets(0, 0, 5, 0);
		gbc_btnBack.gridwidth = 2;
		gbc_btnBack.gridx = 0;
		gbc_btnBack.gridy = 8;
		frame.getContentPane().add(btnBack, gbc_btnBack);
		
	}

}

