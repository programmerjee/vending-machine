package vendingmachine;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class VendingMachineCanMakeChange {
	VendingMachine underTest;

	@Before
	public void setup() {
		underTest = new VendingMachine();
	}
	@Test
	public void whenRunningTotalIsGreaterThanPriceDifferenceIsCalculated() {
		underTest.insertCoin("quarter");
		underTest.insertCoin("quarter");
		underTest.insertCoin("quarter");
		underTest.selectProduct("candy");
		String result = underTest.getCoinReturn();
		assertEquals("dime", result);
	}

}
