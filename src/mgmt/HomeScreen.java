package mgmt;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;

import STAPM_UI.AddStockGUI;
import STAPM_UI.UpdateStockGUI;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JButton;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class HomeScreen {
	STAPM stapm;
	public JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HomeScreen window = new HomeScreen(null);
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
	public HomeScreen(STAPM stapm) {
		this.stapm = stapm;
		initialize(stapm);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	public void initialize(STAPM stapm) {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.LIGHT_GRAY);
		frame.setBounds(100, 100, 800, 400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		//STAPM stapm = null;
		
		JLabel lblWelcome = new JLabel("STAP Management System Prototype");
		lblWelcome.setBounds(207, 10, 395, 29);
		lblWelcome.setBackground(Color.CYAN);
		lblWelcome.setFont(new Font("Tahoma", Font.PLAIN, 24));
		frame.getContentPane().add(lblWelcome);
		
		JLabel lblImage = new JLabel("Image");
		lblImage.setBounds(232, 170, 70, 13);
		frame.getContentPane().add(lblImage);
		
		JButton btnUpdateStock = new JButton("Update Stock");
		btnUpdateStock.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UpdateStockGUI UpdateStockGUI = new UpdateStockGUI(stapm);
				UpdateStockGUI.frame.setVisible(true);
			}
		});
		btnUpdateStock.setBounds(192, 70, 100, 40);
		btnUpdateStock.setPreferredSize(new Dimension(80, 40));
		frame.getContentPane().add(btnUpdateStock);
		
		JButton btnGenerateFinancialReport = new JButton("Report");
		btnGenerateFinancialReport.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
			});
		btnGenerateFinancialReport.setBounds(343, 70, 100, 40);
		btnGenerateFinancialReport.setPreferredSize(new Dimension(80, 40));
		frame.getContentPane().add(btnGenerateFinancialReport);
		
		JButton btnProcessSale = new JButton("Process Sale");
		btnProcessSale.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//code for process sale
			}
			});
		btnProcessSale.setBounds(495, 70, 100, 40);
		btnProcessSale.setPreferredSize(new Dimension(80, 40));
		frame.getContentPane().add(btnProcessSale);
		
		JButton btnViewInventory = new JButton("Inventory");
		btnViewInventory.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				InventoryList initGUI = new InventoryList();
				initGUI.frame.setVisible(true);
			}
			});
		btnViewInventory.setPreferredSize(new Dimension(80, 40));
		btnViewInventory.setBounds(642, 70, 100, 40);
		frame.getContentPane().add(btnViewInventory);
		
		JButton btnAddStock = new JButton("Add Stock");
		btnAddStock.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//AddStockGUI AddStockGUI = new AddStockGUI(stapm);
				//AddStockGUI.frame.setVisible(true);
			}
		});
		btnAddStock.setPreferredSize(new Dimension(80, 40));
		btnAddStock.setBounds(41, 70, 100, 40);
		frame.getContentPane().add(btnAddStock);
	}
}
