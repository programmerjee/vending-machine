package vendingmachine;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class VendingMachineCanAcceptCoins {
	VendingMachine underTest;

	@Before
	public void setup() {
		underTest = new VendingMachine();
	}

	@Test
	public void vendingMachineAcceptsNickels() {
		double result = underTest.insertCoin("nickel");
		assertEquals(0.05, result, 0.01);
	}

	@Test
	public void vendingMachineAcceptsDimes() {
		double result = underTest.insertCoin("dime");
		assertEquals(0.10, result, 0.01);
	}

	@Test
	public void vendingMachineAcceptsQuarters() {
		double result = underTest.insertCoin("quarter");
		assertEquals(0.25, result, 0.01);
	}

	@Test
	public void vendingMachineDoesntAcceptPennies() {
		double result = underTest.insertCoin("penny");
		assertEquals(0, result, 0.01);
	}
	@Test
	public void vendingMachineDisplaysInsertCoinWhenNoCoinsAreInserted() {
		String result = underTest.getDisplay();
		assertEquals("INSERT COIN", result);
	}
	@Test
	public void vendingMachineDisplaysCoinValueWhenCoinIsInserted() {
		underTest.insertCoin("nickel");
		String result = underTest.getDisplay();
		assertEquals("$0.05", result);
	}
	@Test
	public void vendingMachineShowsTotalValueWhenMultipleCoinsAreInserted() {
		underTest.insertCoin("nickel");
		underTest.insertCoin("dime");
		String result = underTest.getDisplay();
		assertEquals("$0.15", result);
	}
	@Test
	public void vendingMachineShowsTotalValueWhenLastCoinEnteredIsInvalid() {
		underTest.insertCoin("dime");
		underTest.insertCoin("penny");
		String result = underTest.getDisplay();
		assertEquals("$0.10", result);
	}
	@Test
	public void vendingMachineShouldAddInvalidCoinToCoinReturn() {
		underTest.insertCoin("dinar");
		String result = underTest.getCoinReturn();
		assertEquals("dinar", result);
	}

}
