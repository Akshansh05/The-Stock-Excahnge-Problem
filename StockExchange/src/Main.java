import java.text.ParseException;

import service.Exchange;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Exchange ex = new Exchange();

//		1 09:45 FK Sell 100 240.10
//		2 09:45 FK Sell 90 237.45
//		3 09:47 FK Buy 80 238.10
//		5 09:48 FK Sell 220 241.50
//		6 09:49 FK Buy 50 238.50
//		7 09:52 AZ Buy 10 100.10
//		8 10:01 FK Sell 20 240.10
//		9 10:02 FK Buy 150 242.70

//		2 3 80 237.45
//		2 6 10 237.45
//		1 9 100 240.10
//		8 9 20 240.10
//		5 9 30 241.50

		try {
			ex.createExchange(1, "09:45", "FK", "Sell", 100, 240.10);
			ex.createExchange(2, "09:45", "FK", "Sell", 90, 237.45);
			ex.createExchange(3, "09:47", "FK", "Buy", 80, 238.10);
			ex.createExchange(5, "09:48", "FK", "Sell", 220, 241.50);
			ex.createExchange(6, "09:49", "FK", "Buy", 50, 238.50);
			ex.createExchange(7, "09:52", "AZ", "Buy", 10, 100.10);
			ex.createExchange(8, "10:01", "FK", "Sell", 20, 240.10);
			ex.createExchange(9, "10:02", "FK", "Buy", 150, 242.70);

			ex.printAllResponse();

		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
