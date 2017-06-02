package asgn2GUIs;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import asgn2Customers.Customer;
import asgn2Exceptions.CustomerException;
import asgn2Exceptions.LogHandlerException;
import asgn2Exceptions.PizzaException;
import asgn2Pizzas.Pizza;
import asgn2Restaurant.PizzaRestaurant;
import java.awt.*;
import javax.swing.*;


/**
 * This class is the graphical user interface for the rest of the system. 
 * 
 * @author Daniel Abreu
 *
 */
public class PizzaGUI extends javax.swing.JFrame implements Runnable, ActionListener {
	
	// GUI ELEMENTS
	private PizzaRestaurant restaurant;
	private JFrame frame;
	private JPanel pnl_main;
	private JPanel pnl_buttons;
	private JPanel pnl_logs;
	private JPanel pnl_text;
	private JTable tbl_customers;
	private JTable tbl_pizzas;
	private JScrollPane jsp_customers;
	private JScrollPane jsp_pizzas;
	private BorderLayout windowLayout;
	private GridLayout buttonLayout;
	private GridLayout textLayout;
	private GridLayout tableLayout;
	private JFileChooser fileChooser;
	private JButton bttn_loadLog;
	private JButton bttn_displayLog;
	private JButton bttn_calculate;
	private JButton bttn_reset;
	private JTextField tf_distance;
	private JTextField tf_profit;
	
	/**
	 * Creates a new Pizza GUI with the specified title 
	 * @param title - The title for the supertype JFrame
	 */
	public PizzaGUI(String title) {
		frame = new JFrame(title);
		pnl_main = new JPanel();
		pnl_buttons = new JPanel();
		pnl_logs = new JPanel();
		pnl_text = new JPanel();
		windowLayout = new BorderLayout();
		buttonLayout = new GridLayout(1,4);
		textLayout = new GridLayout(1,2);
		tableLayout = new GridLayout(1,2);
		fileChooser = new JFileChooser();
		bttn_loadLog = new JButton("Load Logs");
		bttn_displayLog = new JButton("Display Logs");
		bttn_calculate = new JButton("Perform Calculation");
		bttn_reset = new JButton("Reset Logs");
		tf_distance = new JTextField ("Distance");
		tf_profit = new JTextField("Profit");
		
		
		// Main window
		frame.setSize(500,500);
		frame.setContentPane(pnl_main);
		pnl_main.setLayout(windowLayout);
		
		// Buttons
		pnl_main.add(pnl_buttons, BorderLayout.NORTH);
		pnl_buttons.setLayout(buttonLayout);
		pnl_buttons.add(bttn_loadLog);
		pnl_buttons.add(bttn_displayLog);
		bttn_displayLog.setEnabled(false);
		pnl_buttons.add(bttn_calculate);
		bttn_calculate.setEnabled(false);
		pnl_buttons.add(bttn_reset);
		bttn_reset.setEnabled(false);
		
		// Log Display
		pnl_main.add(pnl_logs, BorderLayout.CENTER);
		pnl_logs.setLayout(tableLayout);
		
		// Calculation Display
		pnl_main.add(pnl_text, BorderLayout.SOUTH);
		pnl_text.setLayout(textLayout);
		pnl_text.add(tf_distance);
		pnl_text.add(tf_profit);
		
		// Extra
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    frame.setVisible(true);
	}

	/*
	 *  Adds action listeners to the JButtons. Initiates an instance of Pizza Restaurant.
	 */
	@Override
	public void run() {
		restaurant = new PizzaRestaurant();
		bttn_loadLog.addActionListener(this);
		bttn_displayLog.addActionListener(this);
		bttn_calculate.addActionListener(this);
		bttn_reset.addActionListener(this);
	}

	/*
	 * Controls the flow of the program. Triggers all actions within the GUI environment.
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	public void actionPerformed(ActionEvent e){
		if(e.getSource().equals(bttn_loadLog)) loadLog();
		if(e.getSource().equals(bttn_displayLog)) displayLog();
		if(e.getSource().equals(bttn_calculate)) calculate();
		if(e.getSource().equals(bttn_reset)) reset();	
	}
	
	/*
	 * 	Allows user to choose a log file. File gets proccessed by PizzaRestaurant class.
	 */
	public void loadLog(){
		fileChooser.setCurrentDirectory(new java.io.File("."));
		fileChooser.showOpenDialog(bttn_loadLog);
		fileChooser.setDialogTitle("Choose a log");
		try {
			restaurant.processLog(fileChooser.getSelectedFile().getAbsolutePath());
		} catch (Exception e) {
			JOptionPane.showMessageDialog(frame,
				    e.getMessage(),
				    "Something Went Wrong...",
				    JOptionPane.WARNING_MESSAGE);
			e.printStackTrace();
		}
		JOptionPane.showMessageDialog(pnl_main, "Log loaded sucessfully");
		bttn_displayLog.setEnabled(true);
	}
	
	/*
	 * 	Displays two tables with the information loaded from the logs
	 */
	public void displayLog(){
		String[] customer_clms = new String[]{"Name", "Phone", "Type","Location", "Distance"};
		String[] pizza_clms = new String[]{"Type", "Quantity", "Price", "Cost", "Profit"};
		tbl_customers = new JTable(populateCustomerTable(customer_clms.length), customer_clms);
		tbl_pizzas = new JTable(populatePizzaTable(pizza_clms.length), pizza_clms);
		pnl_logs.add(tbl_customers);
		pnl_logs.add(tbl_pizzas);
		pnl_logs.updateUI();
		bttn_loadLog.setEnabled(false);
		bttn_calculate.setEnabled(true);
		bttn_reset.setEnabled(true);
	}
	
	/*
	 *  Populates the Customer table with information from the logs
	 *  @param number of columns in the table
	 *  @return the customer data in a 2D array
	 */
	private String[][] populateCustomerTable(int columns){
		
		String[][] customer_data = new String[restaurant.getNumCustomerOrders()][columns];
		
		for(int i = 0; i < restaurant.getNumCustomerOrders(); i++){
			try {
				Customer c = restaurant.getCustomerByIndex(i);
				customer_data[i][0] = c.getName();
				customer_data[i][1] = c.getMobileNumber();
				customer_data[i][2] = customerTypeToString(c.getCustomerType());
				customer_data[i][3] = Integer.toString(c.getLocationX()) + "," + Integer.toString(c.getLocationY());
				customer_data[i][4] = Double.toString(c.getDeliveryDistance());
			} catch (CustomerException e) {
				JOptionPane.showMessageDialog(frame,
					    e.getMessage(),
					    "Something Went Wrong...",
					    JOptionPane.WARNING_MESSAGE);
				e.printStackTrace();
			}
		}
		return customer_data;
	}
	
	/*
	 * 	Translates the shorthand notation into user friendly phrases
	 */
	private String customerTypeToString(String type){
		if(type.equals("DVC")) return "Driver";
		if(type.equals("DNC")) return "Drone";
		if(type.equals("PUC")) return "Pick-Up";
		return null;
	}
	
	/*
	 * Populates the pizza table with information from the logs
	 * @param the number of columns in the table
	 * @return the pizza dataset in a 2D array
	 */
	private String[][] populatePizzaTable(int columns){
			
			String[][] pizza_data = new String[restaurant.getNumPizzaOrders()][columns];
			
			for(int i = 0; i < restaurant.getNumPizzaOrders(); i++){
				try {
					Pizza p = restaurant.getPizzaByIndex(i);
					pizza_data[i][0] = p.getPizzaType();
					pizza_data[i][1] = Integer.toString(p.getQuantity());
					pizza_data[i][2] = Double.toString(p.getOrderPrice());
					pizza_data[i][3] = Double.toString(p.getOrderCost());
					pizza_data[i][4] = Double.toString(p.getOrderProfit());
				} catch (PizzaException e) {
					JOptionPane.showMessageDialog(frame,
						    e.getMessage(),
						    "Something Went Wrong...",
						    JOptionPane.WARNING_MESSAGE);
					e.printStackTrace();
				}
			}
			return pizza_data;
		}


	/*
	 * Displays the calculated information on total distance and profit
	 */
	public void calculate(){
		tf_distance.setText("Total Distance = " + Double.toString(Math.round(restaurant.getTotalDeliveryDistance())) + " blocks");
		tf_profit.setText("Total Profit = $" + Double.toString(Math.round(restaurant.getTotalProfit())));
		
	}
	
	/*
	 * Resets GUI elements so user can load another log
	 */
	public void reset(){
		restaurant.resetDetails();
		pnl_logs.remove(tbl_customers);
		pnl_logs.remove(tbl_pizzas);
		tbl_customers.removeAll();
		tbl_pizzas.removeAll();
		tf_distance.setText("Distance");
		tf_profit.setText("Profit");
		bttn_loadLog.setEnabled(true);
		bttn_displayLog.setEnabled(false);
		bttn_calculate.setEnabled(false);
		bttn_reset.setEnabled(false);
		pnl_main.updateUI();
		JOptionPane.showMessageDialog(pnl_main, "System reset");
	}
}
