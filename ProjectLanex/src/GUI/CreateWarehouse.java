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

public class CreateWarehouse extends JFrame {
	private WarehouseController warehouseController = new WarehouseController();
	private JTextField length;
	private JTextField width;
	private JTextField height;
	 
	    
	 public static void main(String[] args) {
	        EventQueue.invokeLater(new Runnable() {
	            public void run() {
	                try {
	                    CreateWarehouse frame = new CreateWarehouse();
	                    frame.setVisible(true);
	                } catch (Exception e) {
	                    e.printStackTrace();
	                }
	            }
	        });
	    }
	 public CreateWarehouse() {
		getContentPane().setLayout(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 616, 530);
		length = new JTextField();
		length.setBounds(80, 43, 116, 22);
		getContentPane().add(length);
		length.setColumns(10);
		
		width = new JTextField();
		width.setColumns(10);
		width.setBounds(80, 78, 116, 22);
		getContentPane().add(width);
		
		height = new JTextField();
		height.setColumns(10);
		height.setBounds(80, 113, 116, 22);
		getContentPane().add(height);
		
		JLabel lengthLabel = new JLabel("Length");
		lengthLabel.setBounds(12, 46, 56, 16);
		getContentPane().add(lengthLabel);
		
		JLabel widthLabel = new JLabel("Width");
		widthLabel.setBounds(12, 81, 56, 16);
		getContentPane().add(widthLabel);
		
		JLabel heightLabel = new JLabel("Height");
		heightLabel.setBounds(12, 116, 56, 16);
		getContentPane().add(heightLabel);
		
		JButton btnNewButton_2 = new JButton("Add");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//public void actionPerformed(ActionEvent arg0) {
					int l = Integer.parseInt(length.getText()); 
					int w = Integer.parseInt(width.getText()); 
					int h = Integer.parseInt(height.getText()); 
					
					 
					 try {new WarehouseController().create(l,w,h);} catch (ValidationException er) {/* print e.getMessage - it is a string with new lines for each error thrown */}}
			
		});
		btnNewButton_2.setBounds(12, 202, 97, 25);
		getContentPane().add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Back");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				WarehouseMenu.main(null);
			}
		});
		btnNewButton_3.setBounds(121, 202, 97, 25);
		getContentPane().add(btnNewButton_3);
		
		
		
	
		
		
		
	
}
	 
	 private boolean tryParseInt(Object object) {
	        try {
	            Integer.parseInt(object.toString());
	            return true;
	        } catch (NumberFormatException e){
	            return false;
	        }
	    }}
