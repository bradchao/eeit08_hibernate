package tw.brad.hi1;

import java.io.FileInputStream;

import tw.brad.dao.MemberDao;
import tw.brad.entity.Member;
import tw.brad.entity.MemberInfo;

public class Brad08 {
	public static void main(String[] args) {
		MemberDao dao = new MemberDao();
		
		Member member = dao.getById(3);
		if (member != null) {
			try {
				FileInputStream fin = 
					new FileInputStream("C:\\Users\\User\\eclipse-workspac\\Hi1\\dir1\\ball.png");
				byte[] ball = fin.readAllBytes();
				member.setMyicon(ball);
			}catch(Exception e) {
				System.out.println(e);
			}
			
			MemberInfo info = new MemberInfo();
			info.setBirthday("2000-01-02");
			info.setGender("female");
			member.setMemberinfo(info);
			
			dao.update(member);
			
		}else {
			System.out.println("Member 2 NOT EXIST!");
		}
		
	}
}
