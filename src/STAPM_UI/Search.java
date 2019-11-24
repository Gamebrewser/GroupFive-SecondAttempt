package STAPM_UI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.GridBagLayout;
import javax.swing.JTextField;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;

public class Search {

	private JFrame frame;
	private JTextField txtItem;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Search window = new Search();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Search() {
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
		gridBagLayout.columnWidths = new int[]{0, 0, 0, 0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		frame.getContentPane().setLayout(gridBagLayout);
		
		txtItem = new JTextField();
		txtItem.setText("Item:");
		GridBagConstraints gbc_txtItem = new GridBagConstraints();
		gbc_txtItem.anchor = GridBagConstraints.NORTH;
		gbc_txtItem.insets = new Insets(0, 0, 5, 5);
		gbc_txtItem.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtItem.gridx = 3;
		gbc_txtItem.gridy = 3;
		frame.getContentPane().add(txtItem, gbc_txtItem);
		txtItem.setColumns(10);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Motor Oil", "Wipers", "Paint", "Brake Fluid", "Oil Filter", "Gas Hose"}));
		GridBagConstraints gbc_comboBox = new GridBagConstraints();
		gbc_comboBox.insets = new Insets(0, 0, 5, 0);
		gbc_comboBox.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox.gridx = 4;
		gbc_comboBox.gridy = 3;
		frame.getContentPane().add(comboBox, gbc_comboBox);
		
		JButton btnNewButton = new JButton("Search");
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.gridwidth = 5;
		gbc_btnNewButton.gridx = 0;
		gbc_btnNewButton.gridy = 5;
		frame.getContentPane().add(btnNewButton, gbc_btnNewButton);
	}

}
