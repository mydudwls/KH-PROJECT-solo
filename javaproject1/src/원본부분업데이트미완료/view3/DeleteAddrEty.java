package 원본부분업데이트미완료.view3;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class DeleteAddrEty {

	public AddressVO delete(AddressVO vo) {

		DBConnectionMgr dbMgr = new DBConnectionMgr();
		Connection con = null;
		PreparedStatement pstmt = null;
		
		int result = 0;
		// result = 0을 선언해 준 이유는 밑에 20번 행에서 id 값이 들어오면 result 값이 
	    // 1로 변화 시키는 목적으로 0값 즉 디폴트 값을 선언해주었다!
		StringBuilder sql = new StringBuilder();
		sql.append(" DELETE FROM MKADDRTB");
		sql.append(" WHERE id = ?        ");
 
		try {
			con = dbMgr.getConnection();
        	pstmt = con.prepareStatement(sql.toString());
        	pstmt.setInt(1, vo.getId());
        	
        	result = pstmt.executeUpdate();
        	
        	if(result == 1) {
        		System.out.println("데이터가 삭제 되었습니다.");
        		vo.setResult(result);
        	}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBConnectionMgr.freeConnection(pstmt, con);
		}
	
		System.out.println("DeleteAddrEty delete 호출 성공");
		return null;		
	}

}
