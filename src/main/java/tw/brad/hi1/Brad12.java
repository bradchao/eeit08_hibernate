package tw.brad.hi1;

import java.util.List;

import tw.brad.dao.CustDao;
import tw.brad.entity.Cust;
import tw.brad.entity.Order;

public class Brad12 {

	public static void main(String[] args) {
		CustDao dao = new CustDao();
		Cust cust = dao.getById(1);
		List<Order> os = cust.getOrders();
		for (Order order : os) {
			System.out.printf("%d. %s\n", order.getId(), order.getOrderDate());
		}
	}

}
