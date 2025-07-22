package tw.brad.hi1;

import tw.brad.apis.BCrypt;
import tw.brad.dao.MemberDao;
import tw.brad.entity.Member;

public class Brad05 {

	public static void main(String[] args) {
		Member member = new Member();
		member.setAccount("eric3");
		member.setPasswd(BCrypt.hashpw("123456", BCrypt.gensalt()));
		member.setName("艾瑞克");
		
		MemberDao dao = new MemberDao();
		dao.save(member);
	}

}
