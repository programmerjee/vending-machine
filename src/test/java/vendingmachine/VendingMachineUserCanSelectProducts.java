package vendingmachine;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class VendingMachineUserCanSelectProducts {
	VendingMachine underTest;
	
	@Before
	public void setup() {
		underTest = new VendingMachine();
	}
	@Test
	public void userCanPurchaseChipswithFiftyCents() {
		underTest.insertCoin("quarter");
		underTest.insertCoin("quarter");
		String result = underTest.selectProduct("chips");
		assertEquals("THANK YOU", result);
	}
	@Test
	public void userCannotPurchaseChipsWithAQuarter() {
		underTest.insertCoin("quarter");
		String result = underTest.selectProduct("chips");
		assertEquals("PRICE: $0.50", result);
	}
	@Test
	public void userBalanceSubtractsPriceOfPurchasedProduct() {
		underTest.insertCoin("quarter");
		underTest.insertCoin("quarter");
		underTest.selectProduct("chips");
		String result = underTest.getDisplay();
		assertEquals("INSERT COIN", result);
	}
	@Test
	public void userCanPurchaseCandyWithSixtyFiveCents() {
		underTest.insertCoin("quarter");
		underTest.insertCoin("quarter");
		underTest.insertCoin("dime");
		underTest.insertCoin("nickel");
		String result = underTest.selectProduct("candy");
		assertEquals("THANK YOU", result);
	}
	@Test
	public void userCanPurchaseSodaWithOneDollar() {
		underTest.insertCoin("quarter");
		underTest.insertCoin("quarter");
		underTest.insertCoin("quarter");
		underTest.insertCoin("quarter");
		String result = underTest.selectProduct("soda");
		assertEquals("THANK YOU", result);
	}
	
}
