package vendingmachine;

import java.text.DecimalFormat;

public class VendingMachine {

	
	double runningTotal;
	String display;
	String rejectedCoin;
	String coinReturn;
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
		if (runningTotal%10 ==0) {
			coinReturn = "dime";
			runningTotal -= 0.10;
		} else if (runningTotal%25 ==0) {
			coinReturn = "quarter";
			runningTotal -=0.25;
		} else if (runningTotal%5==0) {
			coinReturn = "nickel";
			runningTotal -= .05;
		}
		return coinReturn;
	}
	public String selectProduct(String product) {
		double chipPrice = 0.50;
		double candyPrice = 0.65;
		double sodaPrice = 1.00;
		if (runningTotal == chipPrice && product == "chips") {
			runningTotal -= chipPrice;
			return "THANK YOU";
		} else if (runningTotal < chipPrice && product == "chips") {
			return "PRICE: " + "$" +  new DecimalFormat("0.00").format(chipPrice);
		}
		else if (runningTotal == candyPrice && product=="candy") {
				runningTotal -= candyPrice;
				return "THANK YOU";
		}
				else if (runningTotal > candyPrice && product == "candy") {
					runningTotal -= candyPrice;
					return "THANK YOU";
		} else if (runningTotal < candyPrice && product == "candy") {
			return "PRICE: " + "$" +  new DecimalFormat("0.00").format(candyPrice);
		}
		else if (runningTotal == sodaPrice && product=="soda") {
			runningTotal -= sodaPrice;
			return "THANK YOU";
	} else if (runningTotal < sodaPrice && product == "soda") {
		return "PRICE: " + "$" +  new DecimalFormat("0.00").format(sodaPrice);
	}
		else return getDisplay() + "INSERT COIN";
	}

}
