package asgn2Tests;

import org.junit.Test;

import java.util.ArrayList;
import asgn2Exceptions.*;
import asgn2Pizzas.*;
import asgn2Restaurant.*;

import java.time.LocalTime;


/** A class that tests the methods relating to the creation of Pizza objects in the asgn2Restaurant.LogHander class.
* 
* @author Person B
* 
*/

 

public class LogHandlerPizzaTests {
	final static String FILE = ".//logs/pizzaTest.txt";
	
	//Test if correctly populates array
	@Test
	public void populatePizzaArray() throws PizzaException, LogHandlerException{
		boolean test;
		try{
		ArrayList<Pizza> test = LogHandler.populatePizzaDataset(FILE);
			test = true;
		} catch(PizzaException e){
			test = false;
		}catch(LogHandlerException e){
			test = false;
		}catch(Exception e){
			test = false;
		}
		assert(test);
	}
}
