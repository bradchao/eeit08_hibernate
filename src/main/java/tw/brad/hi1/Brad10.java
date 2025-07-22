package tw.brad.hi1;

import java.util.Date;

import tw.brad.dao.CustDao;
import tw.brad.entity.Cust;
import tw.brad.entity.Order;

public class Brad10 {

	public static void main(String[] args) {
		CustDao dao = new CustDao();
		
		Cust cust = new Cust();
		cust.setCname("ispan");
		cust.setBirthday("1999-09-09");
		cust.setTel("1234567");
		
		
		Order order1 = new Order();
		order1.setOrderDate(new Date());

		Order order2 = new Order();
		order2.setOrderDate(new Date());
		
		cust.addOrder(order1);
		cust.addOrder(order2);

		dao.update(cust);		
	}

}
