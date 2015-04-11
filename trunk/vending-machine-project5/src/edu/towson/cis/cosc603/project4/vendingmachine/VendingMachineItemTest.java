/**
 *
 */
package edu.towson.cis.cosc603.project4.vendingmachine;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertSame;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * @author ssarip1
 *
 */
public class VendingMachineItemTest {

    VendingMachineItem product_item;
    VendingMachineException machineException;

    /**
     * Initiliaze two objects as per the requirement of the test cases.
     *
     * @throws Exception
     *             the exception
     */
    @Before
    public void setUp() throws Exception {
	product_item = new VendingMachineItem("Dew", 1.75);
	machineException = new VendingMachineException();
    }

    @Test
    /**
     * Test custom constructor 
     */
    public void testConstructor() {
	assertNotNull(product_item);
    }

    @Test(expected = VendingMachineException.class)
    public void testConstructorNegativeValues() {
	assertSame(machineException, new VendingMachineItem("Water", -0.0));
    }

    @Test
    /**
     * Test for the getName method 
     * Test to see if the item returns the correct name
     */
    public void testGetName() {
	assertEquals("Dew", product_item.getName());
    }

    @Test
    /**
     *Test for the getPrice method 
     *Test to see if the price of the item is correct as initiliazed 
     */
    public void testPrice() {
	assertEquals(1.75, product_item.getPrice(), 0.001);
    }

    /**
     * @throws java.lang.Exception
     * Assign objects to null
     */
    @After
    public void tearDown() throws Exception {
	product_item = null;
	machineException = null;
    }
}
