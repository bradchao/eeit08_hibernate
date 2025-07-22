package tw.brad.hi1;

import java.util.List;

import tw.brad.apis.BCrypt;
import tw.brad.dao.MemberDao;
import tw.brad.entity.Member;

public class Brad05 {

	public static void main(String[] args) {
		Member member = new Member();
		member.setAccount("eric4");
		member.setPasswd(BCrypt.hashpw("123456", BCrypt.gensalt()));
		member.setName("艾瑞克");
		
		MemberDao dao = new MemberDao();
		//dao.save(member);
		//dao.update(member);
		
		Member m3 = dao.getById(3);
		System.out.println(m3.getId() + ":" + m3.getAccount() +":" + m3.getName());
		m3.setName("艾米");
		dao.update(m3);
		
		//--------------------
		List<Member> members = dao.getAll();
		for (Member mb : members) {
			System.out.println(mb.getAccount());
		}
		
		
		
		
		
	}

}
