package service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;

import model.StockRequest;
import model.StockResponse;

public class Exchange {

	private ArrayList<StockRequest> StockList;
	private ArrayList<StockResponse> buylist;

	public Exchange() {
		StockList = new ArrayList<StockRequest>();
		buylist = new ArrayList<StockResponse>();
	}

	public void createExchange(int orderId, String time, String name, String type, int quantity, double price)
			throws ParseException {

		SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
		Date t = sdf.parse(time);
		// System.out.println(t);
		StockRequest sr = new StockRequest(orderId, t, name, type, quantity, price);
		// System.out.println(sr.getId());
		StockList.add(sr);

		if (type.equalsIgnoreCase("BUY")) {

			ArrayList<StockRequest> list = getBestAvailableStockInOrder(sr);
//			for(StockRequest s :list ) {
//				System.out.println(s.getId()+" "+s.getName()+" "+s.getTime()+" "+s.getType()+" "+s.getQuantity()+" "+s.getPrice());
//			}
//			}
			int quantityToBuy = sr.getQuantity();

			for (int i = 0; i < list.size() && quantityToBuy != 0;) {

				StockRequest request = list.get(i);
				if (request.getQuantity() <= quantityToBuy && request.getTime().compareTo(sr.getTime()) != 0) {
					StockResponse r = new StockResponse(request.getId(), sr.getId(), request.getQuantity(),
							request.getPrice());
					buylist.add(r);
					// System.out.println(r.getQuantity() +" " +r.getSellerId() +"
					// "+r.getBuyerId());
					quantityToBuy -= request.getQuantity();
					// System.out.println(quantityToBuy);
					removeobject(request);
					list.remove(i);
				} else if (request.getQuantity() > quantityToBuy && request.getTime().compareTo(sr.getTime()) != 0) {
					StockResponse r = new StockResponse(request.getId(), sr.getId(), quantityToBuy, request.getPrice());
					buylist.add(r);
					StockRequest req = getStockRequestById(request.getId());
					
					removeobject(req);
					req.setQuantity(request.getQuantity() - quantityToBuy);
					quantityToBuy = 0;
					// System.out.println(req.getId()+ " "+req.getName()+" "+req.getPrice()+"
					// "+req.getQuantity());
					StockList.add(req);
					list.remove(i);
					request.setQuantity(request.getQuantity() - quantityToBuy);
					list.add(request);
				} else {
					StockResponse r = new StockResponse(request.getId(), sr.getId(), quantityToBuy / list.size(),
							request.getPrice());
					buylist.add(r);
					quantityToBuy -= quantityToBuy / list.size();
					StockRequest req = getStockRequestById(request.getId());
					removeobject(req);
					req.setQuantity(request.getQuantity() - quantityToBuy / list.size());
					StockList.add(req);
					req.setQuantity(request.getQuantity() - quantityToBuy / list.size());
					list.remove(i);
					request.setQuantity(request.getQuantity() - quantityToBuy / list.size());
					list.add(request);
				}
			}

		}

	}

	private ArrayList<StockRequest> getBestAvailableStockInOrder(StockRequest sr) {

		ArrayList<StockRequest> list = new ArrayList<StockRequest>();

		for (StockRequest s : StockList) {

			if (s.getType().equalsIgnoreCase("SELL") && sr.getPrice() >= s.getPrice()
					&& s.getName().equals(sr.getName()) && sr.getTime().compareTo(s.getTime()) > 0) {
				list.add(s);
			}
		}

		Collections.sort(list, new SortBestList());

		return list;
	}

	class SortBestList implements Comparator<StockRequest> {
		public int compare(StockRequest a, StockRequest b) {
			if (a.getPrice() == b.getPrice()) {
				return a.getTime().compareTo(b.getTime());
			} else {
				return (int) (a.getPrice() - b.getPrice());
			}
		}
	}

	private StockRequest getStockRequestById(int id) {

		for (StockRequest sr : StockList) {
			if (sr.getId() == id) {
				return sr;
			}
		}
		return null;
	}

	private void removeobject(StockRequest sr) {

		for (int i = 0; i < StockList.size(); i++) {
			StockRequest val = StockList.get(i);

			if (val.getId() == sr.getId()) {
				StockList.remove(i);
				// System.out.println(val.getId()+ "removed" +val.getQuantity());
			}
		}
	}

	public void printAllResponse() {

		for (StockResponse r : buylist) {
			System.out.println(r.getSellerId() + " " + r.getBuyerId() + " " + r.getQuantity() + " "
					+ String.format("%.2f", r.getPrice()));
		}
	}

}
