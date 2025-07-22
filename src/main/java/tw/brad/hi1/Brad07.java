package tw.brad.hi1;

import tw.brad.apis.BCrypt;
import tw.brad.dao.MemberDao;
import tw.brad.entity.Member;
import tw.brad.entity.MemberInfo;

public class Brad07 {

	public static void main(String[] args) {
		MemberDao dao = new MemberDao();
		
		Member member = new Member();
		member.setAccount("ok2");
		member.setPasswd(BCrypt.hashpw("123456", BCrypt.gensalt()));
		member.setName("OK2");
		
		MemberInfo info = new MemberInfo();
		info.setBirthday("1999-01-02");
		info.setGender("male");
		
		member.setMemberinfo(info);
		
		dao.save(member);
	}

}
