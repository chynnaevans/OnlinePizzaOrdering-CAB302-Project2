package asgn2Tests;

import java.util.ArrayList;
import org.junit.Test;
import asgn2Customers.*;
import asgn2Restaurant.*;
import asgn2Exceptions.*;

/**
 * A class that tests the methods relating to the creation of Customer objects in the asgn2Restaurant.LogHander class.
 *
 * @author Person A
 */
public class LogHandlerCustomerTests {
	
	final static String FILE = ".//logs/customerTest.txt"; 
	
	@Test
	public void TestPopulateCustomerDataset_Correct() throws CustomerException, LogHandlerException{
		ArrayList<Customer> test = new ArrayList<Customer>();
		test.add(CustomerFactory.getCustomer("DVC", "Name", "0123456789", 2, 2));
		
		ArrayList<Customer> c = LogHandler.populateCustomerDataset(FILE);
		assert(test.equals(c));		
	}
	
	@Test
	public void TestCreateCustomer_Correct() throws CustomerException, LogHandlerException {
		Customer c = CustomerFactory.getCustomer("DVC", "Name", "0123456789", 2, 2);
		Customer d = LogHandler.createCustomer("00:00:00,00:00:00,Name,0123456789,DVC,2,2,AAA,0");
		assert(c.equals(d));
	}
	
	
}
