package ss.week3.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import ss.week3.hotel.Bill;
import ss.week3.hotel.Item;

public class BillTest {
	Bill.Item banaan;
	Bill.Item koffie;
	Bill.Item shizzle;
	Bill bill;
	

	@Before
	public void setUp() throws Exception {
		banaan = new Item("banaan", 0.6);
		koffie = new Item("koffie", 0.25);
		shizzle = new Item("Shizzle", 50);
		bill = new Bill(System.out);
	}
	//-----------------------------Instance Variables

	@Test
	public void testAddingItems() {
		bill.newItem(this.banaan);
		bill.newItem(this.banaan);
		assertTrue(bill.getSum()==1.2);
		
	}
	
	@Test
	public void testClosing(){
		bill.newItem(this.banaan);
		bill.newItem(this.shizzle);
		bill.close();
		assertTrue(bill.getSum()==0);
		
	}

	//-----------------------------Constructor

	//-----------------------------Queries

	//-----------------------------Commands
}
