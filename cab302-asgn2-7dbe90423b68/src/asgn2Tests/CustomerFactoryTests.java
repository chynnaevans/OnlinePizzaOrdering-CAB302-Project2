package asgn2Tests;

import static org.junit.Assert.*;
import org.junit.Test;
import asgn2Customers.*;
import asgn2Exceptions.CustomerException;
import junit.framework.Assert;


/**
 * A class the that tests the asgn2Customers.CustomerFactory class.
 * 
 * @author Daniel Abreu
 *
 */
public class CustomerFactoryTests {
	
	@Test
	public void TestgetCustomer_CorrectPUC(){
		Customer c = CustomerFactory.getCustomer("PUC", "name", "0123456789", "0", "0");
		Assert.assertTrue(c instanceof PickUpCustomer);
	}
	
	@Test
	public void TestgetCustomer_CorrectDNC(){
		Customer c = CustomerFactory.getCustomer("DNC", "name", "0123456789", "2", "2");
		Assert.assertTrue(c instanceof PickUpCustomer);
	}
	
	@Test
	public void TestgetCustomer_CorrectDVC(){
		Customer c = CustomerFactory.getCustomer("DVC", "name", "0123456789", "2", "2");
		Assert.assertTrue(c instanceof PickUpCustomer);
	}
	
}
