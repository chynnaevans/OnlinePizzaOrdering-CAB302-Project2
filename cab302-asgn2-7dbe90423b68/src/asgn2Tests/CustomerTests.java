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
	public void TestCustomerConstructor_Correct(){
		Customer c = new Customer("name", "0123456789", "2", "2", "DVC");
	}
	
	@Test(expected = CustomerException.class)
	public void TestCustomerConstructor_EmptyName(){
		Customer c = new Customer("", "0123456789", "2", "2", "DVC");
	}
	@Test(expected = CustomerException.class)
	public void TestCustomerConstrctor_LongName(){
		Customer c = new Customer("This name is too long!!", "0123456789", "2", "2", "DVC");
	}
	
	@Test(expected = CustomerException.class)
	public void TestCustomerConstrctor_BadNumber(){
		Customer c = new Customer("Name", "9123456789", "2", "2", "DVC");
	}
	
	@Test(expected = CustomerException.class)
	public void TestCustomerConstrctor_LongNumber(){
		Customer c = new Customer("Name", "0123456789876543210", "2", "2", "DVC");
	}
	
	@Test(expected = CustomerException.class)
	public void TestCustomerConstrctor_PickUpNotAtRestaurant(){
		Customer c = new Customer("Name", "0123456789", "2", "2", "PUC");
	}
	
	@Test(expected = CustomerException.class)
	public void TestCustomerConstrctor_DeliveryAtRestaurant(){
		Customer c = new Customer("Name", "0123456789", "0", "0", "DVC");
	}
	
}