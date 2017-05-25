package asgn2GUIs;

import java.awt.event.ActionEvent;


import java.awt.event.ActionListener;
import java.io.File;
import java.text.DecimalFormat;

import javax.swing.JPanel;
import javax.swing.text.DefaultCaret;

import asgn2Customers.Customer;
import asgn2Pizzas.Pizza;
import asgn2Restaurant.PizzaRestaurant;

import javax.swing.JFrame;

import java.awt.*;
import javax.swing.*;


/**
 * This class is the graphical user interface for the rest of the system. 
 * Currently it is a ‘dummy’ class which extends JFrame and implements Runnable and ActionLister. 
 * It should contain an instance of an asgn2Restaurant.PizzaRestaurant object which you can use to 
 * interact with the rest of the system. You may choose to implement this class as you like, including changing 
 * its class signature – as long as it  maintains its core responsibility of acting as a GUI for the rest of the system. 
 * You can also use this class and asgn2Wizards.PizzaWizard to test your system as a whole
 * 
 * 
 * @author Person A and Person B
 *
 */
public class PizzaGUI extends javax.swing.JFrame implements Runnable, ActionListener {
	
	private PizzaRestaurant restaurant;
	private JFrame frame;
	private JPanel pnl_main;
	private JPanel pnl_buttons;
	private BorderLayout windowLayout;
	private GridLayout buttonLayout;
	private JFileChooser fileChooser;
	private JButton bttn_loadLog;
	private JButton bttn_displayLog;
	private JButton bttn_calculate;
	private JButton bttn_reset;
	
	/**
	 * Creates a new Pizza GUI with the specified title 
	 * @param title - The title for the supertype JFrame
	 */
	public PizzaGUI(String title) {
		frame = new JFrame(title);
		pnl_main = new JPanel();
		pnl_buttons = new JPanel();
		windowLayout = new BorderLayout();
		buttonLayout = new GridLayout(1,4);
		fileChooser = new JFileChooser();
		bttn_loadLog = new JButton("Load Logs");
		bttn_displayLog = new JButton("Display Logs");
		bttn_calculate = new JButton("Perform Calculation");
		bttn_reset = new JButton("Reset Logs");
		
		frame.setSize(500,500);
		frame.setContentPane(pnl_main);
		pnl_main.setLayout(windowLayout);
		pnl_buttons.setLayout(buttonLayout);
	    
		pnl_main.add(pnl_buttons, BorderLayout.NORTH);
		pnl_buttons.add(bttn_loadLog);
		pnl_buttons.add(bttn_displayLog);
		pnl_buttons.add(bttn_calculate);
		pnl_buttons.add(bttn_reset);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    frame.setVisible(true);

	}

	
	@Override
	public void run() {
		
		
		
		

	}

	

}
