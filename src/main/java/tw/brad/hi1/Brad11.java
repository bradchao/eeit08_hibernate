package tw.brad.hi1;

import tw.brad.dao.CustDao;

public class Brad11 {

	public static void main(String[] args) {
		CustDao dao = new CustDao();
		dao.removeOrderFromCust(9, 7);
	}

}
