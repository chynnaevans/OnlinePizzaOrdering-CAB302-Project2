package asgn2Tests;

import org.junit.Test;
import asgn2Customers.*;
import asgn2Exceptions.CustomerException;

/**
 * A class that tests the that tests the asgn2Customers.PickUpCustomer, asgn2Customers.DriverDeliveryCustomer,
 * asgn2Customers.DroneDeliveryCustomer classes. Note that an instance of asgn2Customers.DriverDeliveryCustomer 
 * should be used to test the functionality of the  asgn2Customers.Customer abstract class. 
 * 
 * @author Daniel Abreut
 * 
 * 
 *
 */
public class CustomerTests {
	
// ----- Abstract Customer Class ----- //
	
	//Test customer constructor returns correctly
	@Test
	public void TestCustomerConstructor_Correct() throws CustomerException{
		Customer customer = CustomerFactory.getCustomer("DVC", "name", "0123456789", 2, 2);
		assert(customer instanceof DriverDeliveryCustomer);
	}
	
	//Test that empty name returns exception
	@Test(expected = CustomerException.class)
	public void TestCustomerConstructor_EmptyName() throws CustomerException{
		Customer customer = CustomerFactory.getCustomer("DVC", " ", "0123456789", 2, 2);
	}
	
	//Test that error is returned if name is too long
	@Test(expected = CustomerException.class)
	public void TestCustomerConstructor_LongName() throws CustomerException{
		Customer customer = CustomerFactory.getCustomer("DVC", "This name is too long!!!", "0123456789", 2, 2);
	}
	
	//Test that error is returned if number doesn't start with a 0
	@Test(expected = CustomerException.class)
	public void TestCustomerConstructor_BadNumber() throws CustomerException{
		Customer customer = CustomerFactory.getCustomer("DVC", "Name", "9123456789", 2, 2);
	}

	//Test that error is returned if number is too long
	@Test(expected = CustomerException.class)
	public void TestCustomerConstructor_LongNumber() throws CustomerException{
		Customer customer = CustomerFactory.getCustomer("DVC", "Name", "0123456789876543210", 2, 2);
	}
	
	//Test that error is returned if number is too short
	@Test(expected = CustomerException.class)
	public void TestCustomerConstructor_ShortNumber() throws CustomerException{
		Customer customer = CustomerFactory.getCustomer("DVC", "Name", "01234", 2, 2);
	}
	
	//Test that if user is not at restaurant, they cannot pick up (error is returned)
	@Test(expected = CustomerException.class)
	public void TestCustomerConstructor_PickUpNotAtRestaurant() throws CustomerException{
		Customer customer = CustomerFactory.getCustomer("PUC", "Name", "9123456789", 2, 2);
	}
	
	//Test that if user is at restuarant, they cannot get delivery (error is returned)
	@Test(expected = CustomerException.class)
	public void TestCustomerConstructor_DeliveryAtRestaurant() throws CustomerException{
		Customer customer = CustomerFactory.getCustomer("DVC", "Name", "9123456789", 0, 0);
	}
	
	//Test that getName returns correct value
	@Test
	public void TestGetName() throws CustomerException{
		Customer customer = CustomerFactory.getCustomer("DVC", "Name", "0123456789", 2, 2);
		assert("Name" == customer.getName());
	}
	
	//Test that getMobileNumber returns correct number
	@Test
	public void TestGetMobileNumber() throws CustomerException{
		Customer customer = CustomerFactory.getCustomer("DVC", "Name", "0123456789", 2, 2);
		assert("0123456789" == customer.getMobileNumber());
	}
	
	//Test that getCustomerType returns correclty
	@Test
	public void TestGetCustomerType() throws CustomerException{
		Customer customer = CustomerFactory.getCustomer("DVC", "Name", "0123456789", 2, 2);
		assert("DVC" == customer.getCustomerType());
	}
	
	//Test getLocationX returns correct
	@Test
	public void TestGetLocationX() throws CustomerException{
		Customer customer = CustomerFactory.getCustomer("DVC", "Name", "0123456789", 2, 1);
		assert(2 == customer.getLocationX());
	}
	
	//Test getLocationY returns correct
	@Test
	public void TestGetLocationY() throws CustomerException{
		Customer customer = CustomerFactory.getCustomer("DVC", "Name", "0123456789", 1, 2);
		assert(2 == customer.getLocationY());
	}
	
// --------- Driver Delivery Customer -------- //
	
	//Test positive delivery distance is correctly returned
	@Test
	public void TestDVCDeliveryDistance_Positive() throws CustomerException{
		Customer customer = CustomerFactory.getCustomer("DVC", "Name", "0123456789", 2, 2);
		assert(4 == customer.getDeliveryDistance());
	}
	
	//Test negative delivery distance is correctly returned
	@Test
	public void TestDVCDeliveryDistance_OneNegative() throws CustomerException{
		Customer customer = CustomerFactory.getCustomer("DVC", "Name", "0123456789", -2, 2);
		assert(4 == customer.getDeliveryDistance());
	}
	
	//Test delivery distance is correctly returned when both negative
	@Test
	public void TestDVCDeliveryDistance_BothNegative() throws CustomerException{
		Customer customer = CustomerFactory.getCustomer("DVC", "Name", "0123456789", -2, -2);
		assert(4 == customer.getDeliveryDistance());
	}
	
// --------- Drone Delivery Customer -------- //

	//Test delivery distance is correctly returned when both positive 
	@Test
	public void TestDNCDeliveryDistance_Postive() throws CustomerException{
		Customer customer = CustomerFactory.getCustomer("DNC", "Name", "0123456789", 3, 2);
		assert( Math.sqrt(13) == customer.getDeliveryDistance());
	}
	
	//Test delivery distance is correctly returned when one negative
	@Test
	public void TestDNCDeliveryDistance_OneNegative() throws CustomerException{
		Customer customer = CustomerFactory.getCustomer("DNC", "Name", "0123456789", 3, -2);
		assert( Math.sqrt(13) == customer.getDeliveryDistance());
	}
	
	//Test delivery distance is correctly returned when both negative
	@Test
	public void TestDNCDeliveryDistance_BothNegative() throws CustomerException{
		Customer customer = CustomerFactory.getCustomer("DNC", "Name", "0123456789", -3, -2);
		assert( Math.sqrt(13) == customer.getDeliveryDistance());
	}
	
}






























