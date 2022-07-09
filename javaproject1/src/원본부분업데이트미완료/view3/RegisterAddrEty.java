package 원본부분업데이트미완료.view3;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class RegisterAddrEty {
    /****************************************************************************
     * 회원등록 구현
	   INSERT INTO mkaddrtb(id, name, address, telephone
                          , gender, relationship, birthday
                          , comments, registedate)
                     values(11,'나신입','서울시 강남구 대치동','0105557777'
                           ,1, '회사동료', '1999-10-27'
                           ,'Front-End개발자', '2022-04-16')
     * @param vo - 사용자가 입력한 값 담기
     * @return - 등록 성공 여부 담기
     ***************************************************************************/
	public AddressVO register(AddressVO vo) {
		DBConnectionMgr 	dbMgr	= new DBConnectionMgr();
		// DB에 연결해줄 수 있는 통로를 열어준다.
		Connection 			con		= null;
		// DB에 접속할 수 있는 객체를 생성해준다.
		PreparedStatement 	pstmt 		= null;
		// sql 구문을 실행하는 역할을 하는 클래스
		StringBuilder sql = new StringBuilder();
		
		// 한번에 많은 문자열을 선언할 수 있게 해주는 클래스이다, 그래서 지금과 같이 sql 문이 많을 때 사용한다.
		sql.append(" INSERT INTO mkaddrtb                                    ");
		sql.append(" (name, address, telephone, gender, relationship,        ");
		sql.append("  birthday, comments, registedate, id)                   ");
		sql.append(" VALUES (?, ?, ?, ?, ?, ?, ?, to_char(sysdate,'yyyy/mm/dd'), seq_mkaddrtb_id.nextval)");
		try {
			con = dbMgr.getConnection();
			pstmt = con.prepareStatement(sql.toString());
			
			pstmt.setString(1, vo.getName());
			pstmt.setString(2, vo.getAddress());
			pstmt.setString(3, vo.getTelephone());
			pstmt.setString(4, vo.getGender());
			pstmt.setString(5, vo.getRelationship());
			pstmt.setString(6, vo.getBirthday());
			pstmt.setString(7, vo.getComments());
			//pstmt.setString(8, vo.getRegistedate());
			// 이게 빠지는 이유는 getRegistedate는 생성날짜를 결정하는 항목이라 
			// 만약이게 추가되어 있으면 SQLException 이 일어난다.
			if(pstmt.executeUpdate() < 1) {
			//executeUpdate 메서드는 데이터베이스에서 데이터를 Insert, 
			//Delete, Update하는 SQL 문을 실행한다. 
			//메서드의 반환 값은 해당 SQL 문 실행에 영향을 받는 행 수를 반환합니다.
				
				String msg = "데이터 입력에 실패했습니다.";
				System.out.println(msg);
			} else {
				System.out.println("데이터 입력에 성공했습니다.");
				vo.setResult(1);
			}
	        } catch(Exception e) {
			System.out.println(e.toString());
		} finally {
		      DBConnectionMgr.freeConnection(pstmt, con);
		}	
		System.out.println("RegisterAddrEty register 호출 성공");
		return vo;
	}////////////////////// end of register

}////////////////////////// end of RegisterAddrEty
