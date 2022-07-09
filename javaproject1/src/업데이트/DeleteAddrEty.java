package 업데이트;

import java.sql.Connection;
import java.sql.PreparedStatement;


public class DeleteAddrEty {
	/*********************************************************************************
	 * DELETE FROM MKADDRTB WHERE id = 2
	 * @param vo
	 * @return 
	 *********************************************************************************/

	public AddressVO delete(AddressVO vo) {
		
		DBConnectionMgr dbMgr = new DBConnectionMgr();
		Connection con = null;
		PreparedStatement pstmt = null;
		
		int result = 0;
		
		StringBuilder sql = new StringBuilder();
		sql.append(" DELETE FROM MKADDRTB ");
		sql.append("		WHERE id = ?  ");
		
		try {
			con = dbMgr.getConnection();
			pstmt = con.prepareStatement(sql.toString());
			pstmt.setInt(1, vo.getId());
			
			result = pstmt.executeUpdate();
			if(result == 1) {
				System.out.println("데이터가 삭제되었습니다.");
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
