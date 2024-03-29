package asgn2Tests;

import static org.junit.Assert.*;
import org.junit.Test;
import asgn2Customers.*;
import asgn2Exceptions.CustomerException;


/**
 * A class the that tests the asgn2Customers.CustomerFactory class.
 * 
 * @author Daniel Abreu
 *
 */
public class CustomerFactoryTests {
	
	//Test that PUC parses correctly
	@Test
	public void TestgetCustomer_CorrectPUC() throws CustomerException{
		Customer customer = CustomerFactory.getCustomer("PUC", "name", "0123456789", 0, 0);
		assert(customer instanceof PickUpCustomer);
	}
	
	//Test that DNC parses correctly
	@Test
	public void TestgetCustomer_CorrectDNC() throws CustomerException{
		Customer customer = CustomerFactory.getCustomer("DNC", "name", "0123456789", 2, 2);
		assert(customer instanceof DroneDeliveryCustomer);
	}
	
	//Test that DVC parses correctly
	@Test
	public void TestgetCustomer_CorrectDVC() throws CustomerException{
		Customer customer = CustomerFactory.getCustomer("DVC", "name", "0123456789", 2, 2);
		assert(customer instanceof DriverDeliveryCustomer);
	}
	
	//Test that wrong customer type returns error
	@Test (expected = CustomerException.class)
	public void TestgetCustomer_WrongCustomerType() throws CustomerException {
		Customer customer = CustomerFactory.getCustomer("AAA", "name", "0123456789", 0, 0);
	}
	
	//Test that if number does not start with a 0, it returns customer exception
	@Test (expected = CustomerException.class)
	public void TestgetCustomer_NumberFormatWrong() throws CustomerException {
		Customer customer = CustomerFactory.getCustomer("PUC", "name", "1234567890", 0, 0);
	}
	
	//Test that if phone number is > 10 digits, it will return an exception
	@Test (expected = CustomerException.class)
	public void TestgetCustomer_NumberLengthLong() throws CustomerException {
		Customer customer = CustomerFactory.getCustomer("PUC", "name", "01234567800", 0, 0);
	}
	
	//Test that if phone number is < 10 digits, it will return an exception
	@Test (expected = CustomerException.class)
	public void TestgetCustomer_NumberLengthShort() throws CustomerException {
		Customer customer = CustomerFactory.getCustomer("PUC", "name", "01234567", 0, 0);
	}
	
}
