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
	
// ----- Abstract Customer Class ----- //
	
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
		Customer c = CustomerFactory.getCustomer("DVC", "Name", "0123456789", 2, 2);
		assert("Name" == c.getName());
	}
	
	@Test
	public void TestGetMobileNumber() throws CustomerException{
		Customer c = CustomerFactory.getCustomer("DVC", "Name", "0123456789", 2, 2);
		assert("0123456789" == c.getMobileNumber());
	}
	
	@Test
	public void TestGetMobileNumber() throws CustomerException{
		Customer c = CustomerFactory.getCustomer("DVC", "Name", "0123456789", 2, 2);
		assert("0123456789" == c.getMobileNumber());
	}
	
	@Test
	public void TestGetCustomerType() throws CustomerException{
		Customer c = CustomerFactory.getCustomer("DVC", "Name", "0123456789", 2, 2);
		assert("DVC" == c.getCustomerType());
	}
	
	@Test
	public void TestGetLocationX() throws CustomerException{
		Customer c = CustomerFactory.getCustomer("DVC", "Name", "0123456789", 2, 2);
		assert(2 == c.getLocationX());
	}
	
	@Test
	public void TestGetLocationY() throws CustomerException{
		Customer c = CustomerFactory.getCustomer("DVC", "Name", "0123456789", 2, 2);
		assert(2 == c.getLocationY());
	}
	
// --------- Driver Delivery Customer -------- //
	
	@Test
	public void TestDVCDeliveryDistance_Positive() throws CustomerException{
		Customer c = CustomerFactory.getCustomer("DVC", "Name", "0123456789", 2, 2);
		assert(4 == c.getDeliveryDistance());
	}
	
	@Test
	public void TestDVCDeliveryDistance_OneNegative() throws CustomerException{
		Customer c = CustomerFactory.getCustomer("DVC", "Name", "0123456789", -2, 2);
		assert(4 == c.getDeliveryDistance());
	}
	
	@Test
	public void TestDVCDeliveryDistance_BothNegative() throws CustomerException{
		Customer c = CustomerFactory.getCustomer("DVC", "Name", "0123456789", -2, -2);
		assert(4 == c.getDeliveryDistance());
	}
	
// --------- Drone Delivery Customer -------- //

	@Test
	public void TestDNCDeliveryDistance_Postive() throws CustomerException{
		Customer c = CustomerFactory.getCustomer("DNC", "Name", "0123456789", 3, 2);
		assert( Math.sqrt(13) == c.getDeliveryDistance());
	}
	
	@Test
	public void TestDNCDeliveryDistance_OneNegative() throws CustomerException{
		Customer c = CustomerFactory.getCustomer("DNC", "Name", "0123456789", 3, -2);
		assert( Math.sqrt(13) == c.getDeliveryDistance());
	}
	
	@Test
	public void TestDNCDeliveryDistance_BothNegative() throws CustomerException{
		Customer c = CustomerFactory.getCustomer("DNC", "Name", "0123456789", -3, -2);
		assert( Math.sqrt(13) == c.getDeliveryDistance());
	}
	
}






























