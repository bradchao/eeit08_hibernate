package tw.brad.hi1;

import tw.brad.apis.BCrypt;
import tw.brad.dao.MemberDao;
import tw.brad.entity.Member;
import tw.brad.entity.MemberInfo;

public class Brad07 {

	public static void main(String[] args) {
		MemberDao dao = new MemberDao();
		
//		Member member = new Member();
//		member.setAccount("ok3");
//		member.setPasswd(BCrypt.hashpw("123456", BCrypt.gensalt()));
//		member.setName("OK3");
//		
//		MemberInfo info = new MemberInfo();
//		info.setBirthday("1999-03-04");
//		info.setGender("female");
//		
//		member.setMemberinfo(info);
//		
//		dao.save(member);

		//----------------
//		Member member = dao.getById(1);
//		
//		MemberInfo info = new MemberInfo();
//		info.setBirthday("1999-05-06");
//		info.setGender("male");
//		
//		member.setMemberinfo(info);
//		
//		dao.update(member);
		
		//------------------
//		Member member = dao.getById(15);
//		dao.delete(member);
		
		Member member = dao.getById(1);
		MemberInfo info =  member.getMemberinfo();
		System.out.println(info.getBirthday());
		
		
	
	}

}
