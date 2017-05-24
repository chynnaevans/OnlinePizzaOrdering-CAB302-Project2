package asgn2Tests;

import static org.junit.Assert.*;
import org.junit.Test;
import asgn2Customers.*;
import asgn2Exceptions.CustomerException;

/**
 * A class that tests the that tests the asgn2Customers.PickUpCustomer, asgn2Customers.DriverDeliveryCustomer,
 * asgn2Customers.DroneDeliveryCustomer classes. Note that an instance of asgn2Customers.DriverDeliveryCustomer 
 * should be used to test the functionality of the  asgn2Customers.Customer abstract class. 
 * 
 * @author Daniel Abreu
 * 
 *
 */
public class CustomerTests {
	
	@Test
	public void TestCustomerConstructor_Correct() throws CustomerException{
		Customer c = CustomerFactory.getCustomer("DVC", "name", "0123456789", 2, 2);
		assert(c instanceof DriverDeliveryCustomer);
	}
	
	@Test(expected = CustomerException.class)
	public void TestCustomerConstructor_EmptyName() throws CustomerException{
		Customer c = CustomerFactory.getCustomer("DVC", " ", "0123456789", 2, 2);
	}
	
	@Test(expected = CustomerException.class)
	public void TestCustomerConstructor_LongName() throws CustomerException{
		Customer c = CustomerFactory.getCustomer("DVC", "This name is too long!!!", "0123456789", 2, 2);
	}
	
	@Test(expected = CustomerException.class)
	public void TestCustomerConstructor_BadNumber() throws CustomerException{
		Customer c = CustomerFactory.getCustomer("DVC", "Name", "9123456789", 2, 2);
	}

	@Test(expected = CustomerException.class)
	public void TestCustomerConstructor_LongNumber() throws CustomerException{
		Customer c = CustomerFactory.getCustomer("DVC", "Name", "0123456789876543210", 2, 2);
	}
	
	@Test(expected = CustomerException.class)
	public void TestCustomerConstructor_PickUpNotAtRestaurant() throws CustomerException{
		Customer c = CustomerFactory.getCustomer("PUC", "Name", "9123456789", 2, 2);
	}
	
	@Test(expected = CustomerException.class)
	public void TestCustomerConstructor_DeliveryAtRestaurant() throws CustomerException{
		Customer c = CustomerFactory.getCustomer("DVC", "Name", "9123456789", 0, 0);
	}
	
	@Test
	public void TestGetName() throws CustomerException{
		Customer c = CustomerFactory.getCustomer("DVC", "Name", "0123456789", 0, 0);
		assert("name" == c.getName());
	}
	
}