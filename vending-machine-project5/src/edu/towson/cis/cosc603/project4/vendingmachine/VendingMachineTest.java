/**
 *
 */
package edu.towson.cis.cosc603.project4.vendingmachine;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * @author ssarip1
 *
 */
public class VendingMachineTest {

    VendingMachine vendingMachine;
    VendingMachineItem vendingMachineItem;
    VendingMachineException vendingMachineException;

    /**
     * @throws java.lang.Exception
     *             Instantiating two new objects vendingMachine and vending MachineItem. Adding one unique  <br>
     *             item to the vendingMachine object, duplicating it will throw an exception which is tested later <br>
     *              
     */
    @Before
    public void setUp() throws Exception {
	vendingMachine = new VendingMachine();
	vendingMachineItem = new VendingMachineItem("Dew", 1.70);
	vendingMachineException = new VendingMachineException();
	vendingMachine.addItem(vendingMachineItem, VendingMachine.D_CODE);
    }

    /**
     * @throws java.lang.Exception
     * assigning all objects to null
     */
    @After
    public void tearDown() throws Exception {
	vendingMachine = null;
	vendingMachineItem = null;
    }

    /**
     * Test method for
     * let's add an item and check if the vending machine accepts or not.<br>
     * After adding we will again try to add another item, and check for the
     * expected exception in the next method
     *
     */
    @Test
    public void testAddItem() {
	vendingMachine.addItem(vendingMachineItem, VendingMachine.B_CODE);
    }
    /**
     * Test method for exception
     * Let's try another add item method see if it throws the exception<br />
     *  to check if we added a unique item or not
     * 
     *
     */
    @Test(expected = VendingMachineException.class)
    public void testAddItemForException() {
    vendingMachine.addItem(vendingMachineItem, VendingMachine.A_CODE);
	vendingMachine.addItem(vendingMachineItem, VendingMachine.B_CODE);
	vendingMachine.addItem(vendingMachineItem, VendingMachine.C_CODE);
	vendingMachine.addItem(vendingMachineItem, VendingMachine.D_CODE);
    }
    
    @Test(expected = VendingMachineException.class)
    public void testAddItemUnknown(){
    vendingMachine.addItem(vendingMachineItem, "Unknown");
    }

    /**
     * Remove method test method. Test if the item object is removed if yes it is going to return a null value
     * when we try to retrieve the same item again
     * 
     */
    @Test
    public void testRemoveItem() {
	vendingMachine.removeItem(VendingMachine.D_CODE);
	assertNull(vendingMachine.getItem(VendingMachine.D_CODE));
    }
    
    @Test(expected = VendingMachineException.class)
    public void testRemoveItemExceptionCheck(){
    	vendingMachine.removeItem(VendingMachine.D_CODE);
    	vendingMachine.removeItem(VendingMachine.D_CODE);
    }
    
    //Testing for Unknown
    @Test(expected = VendingMachineException.class)
    public void testRemoveUnknownItem(){
    	vendingMachine.removeItem("Unknown");
    }

    /**
     * Test method for
     * {@link edu.towson.cis.cosc603.project4.vendingmachine.VendingMachine#insertMoney(double)}
     * Inserting some money and checking if the value persists
     */
    @Test
    public void testInsertMoney() {
	vendingMachine.insertMoney(1.75);
	assertEquals(1.75, vendingMachine.getBalance(), 0.0);
    }
    
    @Test(expected = VendingMachineException.class)
    public void testInsertMoneyNegativeValue(){
    	vendingMachine.insertMoney(-5.0);
    }

    /**
     * Test method for
     * {@link edu.towson.cis.cosc603.project4.vendingmachine.VendingMachine#getBalance()}
     * this is will return the balance which we have inserted.
     */
    @Test
    public void testGetBalance() {
	vendingMachine.insertMoney(1.75);
	assertEquals(1.75, vendingMachine.getBalance(), 0.0);
    }
    

    /**
     * Test method for
     * {@link edu.towson.cis.cosc603.project4.vendingmachine.VendingMachine#makePurchase(java.lang.String)}
     * We will try to purchase the item and check if it succeeds
     */
    @Test
    public void testMakePurchase() {
	vendingMachine.insertMoney(2.0);
	assertTrue(vendingMachine.makePurchase(VendingMachine.D_CODE));
    }

    @Test
    /**
     * we will check if the vending machine allows to purchase the item again
     */
    public void testPurchaseForNull() {
	assertTrue(!vendingMachine.makePurchase(VendingMachine.D_CODE));
    }

    /**
     * Test method for
     * {@link edu.towson.cis.cosc603.project4.vendingmachine.VendingMachine#returnChange()}
     * We will check if the vending machine returns the balance correctly to the user
     */
    @Test
    public void testReturnChange() {
	vendingMachine.insertMoney(2.0);
	assertTrue(vendingMachine.makePurchase(VendingMachine.D_CODE));
	assertEquals(0.25, vendingMachine.returnChange(), 0.5);
    }

}
