package 업데이트부분추가;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class ModifyAddrEty {
	
	/**********************************************************************************
	 * UPDATE mkaddrtb
	 * SET 		name = ?
	 * 			address = ?
	 * 			telephone = ?
	 * 			gender = ?
	 * 			relationship = ? 
	 * 			birthday = ?
	 * 			comments = ? 
	 * 			registedate = to_char(sysdate, 'YYYY/MM/DD')
	 * 		WHERE id = ?
	 * @param vo
	 * @return
	 **********************************************************************************/

	public AddressVO modify(AddressVO vo) {
		System.out.println("ModifyAddrEty modify 호출 성공");
		
		DBConnectionMgr dbMgr = new DBConnectionMgr();
		// DB연결하는 통로
		Connection con = null;
		// DB입력하는 구문 
		PreparedStatement pstmt = null;
		// 코드량이 증가하여 매개변수는 set을 해줘야한다. 
		// 코드의 안전성이 높고 가독성을 높여준다.
		StringBuilder sql = new StringBuilder();
		// StringBuilder은 변경이 가능한 문자열을 만들어주기 때문에 String을 합치는 작업시 하나의 대안이 
		// 될수 있다, 
		// 아래와 같이 선언변수.append( ); 이렇게 처리해준다. 
		// 또한 호출시에는 toString()dmf 붙여서 호출하게 된다.
		sql.append(" UPDATE mkaddrtb                                    		");
		sql.append(" SET  name = ?                                   			");
		sql.append("     , address = ?                                  		");
		sql.append("     , telephone = ?                                		");
		sql.append("     , gender = ?                                   		");
		sql.append("     , relationship = ?                             		");
		sql.append("     , birthday = ?                                 		");
		sql.append("     , comments = ?                                 		");
		sql.append("     , registedate = to_char(sysdate,'YYYY/MM/DD hh24:mi:ss') ");
		sql.append(" WHERE id = ?                                       		");
		int result = 0;
		// result 에 0을 굳이 처리해주는 이유는 아무것도 들어있지 않은 변수에 혹시 모를 
	    // 쓰레기 값이 들어가는 경우가 생길 수 있다, 그런 경우를 미연의 방지하기 위해서 
		// 0의 값을 넣어줘서 문제를 방지하는 것이다. 자바의 경우에는 컴파일 에러가 발생하게 된다.

		
		try {
			// try catch 블럭 예외 처리해주는 구문! 
			// catch(혹시 모를 에러) 가 발생하였을 시 미리 예외로 처리해서 문제를 미연에 방지하기 위해서 
			// 쓰는 구문이다!.
			con = dbMgr.getConnection();
			pstmt = con.prepareStatement(sql.toString());
			
			pstmt.setString(1, vo.getName());
			pstmt.setString(2, vo.getAddress());
			pstmt.setString(3, vo.getTelephone());
			pstmt.setString(4, vo.getGender());
			pstmt.setString(5, vo.getRelationship());
			pstmt.setString(6, vo.getBirthday());
			pstmt.setString(7, vo.getComments());
			pstmt.setInt(8, vo.getId());

			result = pstmt.executeUpdate();
			if(result == 1) {
				System.out.println("데이터가 수정되었습니다.");
				vo.setResult(result);
			}else {
				System.out.println("수정에 실패했습니다.");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.toString());
		}finally {
			DBConnectionMgr.freeConnection(pstmt, con);
		}
		
		
		return null;
	}
	
	/*
	 * public static void main(String[] args) { ModifyAddrEty aa = new
	 * ModifyAddrEty(); aa.modify(null); }
	 */

}
