package GUI;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import ControlLayer.WarehouseController;
import Exceptions.ValidationException;
import ValidatorLayer.Validator;
import ValidatorLayer.SavedErrors;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
 
 
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
 
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import java.awt.Dimension;
import javax.swing.JTextPane;

public class ReadWarehouse extends JFrame {
	private JTextField textField;
	public ReadWarehouse() {
		getContentPane().setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(128, 45, 116, 22);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btnSubmit.setBounds(12, 202, 97, 25);
		getContentPane().add(btnSubmit);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				WarehouseMenu.main(null);
			}
		});
		btnBack.setBounds(121, 202, 97, 25);
		getContentPane().add(btnBack);
		
		JLabel lblWarehouseId = new JLabel("Warehouse ID");
		lblWarehouseId.setBounds(12, 47, 97, 19);
		getContentPane().add(lblWarehouseId);
		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
	}
}

