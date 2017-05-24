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
	
	@Test
	public void TestgetCustomer_CorrectPUC() throws CustomerException{
		Customer c = CustomerFactory.getCustomer("PUC", "name", "0123456789", 0, 0);
		assert(c instanceof PickUpCustomer);
	}
	
	@Test
	public void TestgetCustomer_CorrectDNC() throws CustomerException{
		Customer c = CustomerFactory.getCustomer("DNC", "name", "0123456789", 2, 2);
		assert(c instanceof DroneDeliveryCustomer);
	}
	
	@Test
	public void TestgetCustomer_CorrectDVC() throws CustomerException{
		Customer c = CustomerFactory.getCustomer("DVC", "name", "0123456789", 2, 2);
		assert(c instanceof DriverDeliveryCustomer);
	}
	
}
