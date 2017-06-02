package asgn2Tests;

import java.util.ArrayList;

import org.junit.Test;

import asgn2Customers.Customer;
import asgn2Customers.CustomerFactory;
import asgn2Exceptions.CustomerException;
import asgn2Exceptions.LogHandlerException;
import asgn2Exceptions.PizzaException;
import asgn2Restaurant.*;

/**
 * A class that that tests the methods relating to the handling of Customer objects in the asgn2Restaurant.PizzaRestaurant
 * class as well as processLog and resetDetails.
 * 
 * @author Daniel Abreu
 */
public class RestaurantCustomerTests {
	
	final static String FILE = ".//logs/20170101.txt";
	
	//correctly returns by index
	@Test
	public void TestGetCustomerByIndex_valid() throws CustomerException, LogHandlerException, PizzaException{	
		PizzaRestaurant test = new PizzaRestaurant();
		test.processLog(FILE);
		test.getCustomerByIndex(0);
	}
	
	//correctly returns error if invalid index
	@Test(expected = CustomerException.class)
	public void TestGetCustomerByIndex_invalid() throws CustomerException, LogHandlerException, PizzaException{	
		PizzaRestaurant test = new PizzaRestaurant();
		test.processLog(FILE);
		test.getCustomerByIndex(10);
	}
	
	//correctly gets number of customer orders
	@Test
	public void TestGetNumCustomerOrders_correct() throws CustomerException, LogHandlerException, PizzaException{	
		PizzaRestaurant test = new PizzaRestaurant();
		test.processLog(FILE);
		assert(3 == test.getNumCustomerOrders());
	}
	
	//correctly gets total delivery distance
	@Test
	public void TestGetTotalDeliveryDistance_corect() throws CustomerException, LogHandlerException, PizzaException{	
		PizzaRestaurant test = new PizzaRestaurant();
		test.processLog(FILE);
		assert(15 == test.getTotalDeliveryDistance());
	}
}
