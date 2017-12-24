package vendingmachine;

import java.text.DecimalFormat;

public class VendingMachine {

	
	double runningTotal;
	String display;
	String rejectedCoin;
	public double insertCoin(String coin) {
		double value = 0;
		switch(coin) {
		case "nickel": value = 0.05;
			break;
		case "dime": value =0.10;
		break;
		case "quarter": value = 0.25;
		break;
		default: 
			rejectedCoin = coin;
		}
		runningTotal += value;
		return value;
	}
	public String getDisplay() {
		if (runningTotal>0) {
			display = "$" + new DecimalFormat("0.00").format(runningTotal);
		}
		else {
			display = "INSERT COIN";
		}
		
		return display;
	}
	public String getCoinReturn() {
		
		return rejectedCoin;
	}

}
