package asgn2Tests;

import java.util.ArrayList;
import org.junit.Test;
import asgn2Customers.*;
import asgn2Restaurant.*;
import asgn2Exceptions.*;

/**
 * A class that tests the methods relating to the creation of Customer objects in the asgn2Restaurant.LogHander class.
 *
 * @author Daniel Abreu
 */
public class LogHandlerCustomerTests {
	
	final static String FILE = ".//logs/customerTest.txt"; 
	
	//Test to see if customer dataset can be populated
	@Test
	public void TestPopulateCustomerDataset_Correct() throws CustomerException, LogHandlerException{
		boolean test;
		try{
		ArrayList<Customer> c = LogHandler.populateCustomerDataset(FILE);
		test = true;
		} catch(CustomerException e){
			test = false;
		} catch(LogHandlerException e){
			test = false;
		}	catch(Exception e){
			test = false;
		}
		assert(test);
	}
	
	//test to see if customer can be correctly created
	@Test
	public void TestCreateCustomer_Correct() throws CustomerException, LogHandlerException {
		Customer test = CustomerFactory.getCustomer("DVC", "Name", "0123456789", 2, 2);
		Customer c = LogHandler.createCustomer("00:00:00,00:00:00,Name,0123456789,DVC,2,2,AAA,0");
		assert(test.equals(c));
	}
	
	
}
