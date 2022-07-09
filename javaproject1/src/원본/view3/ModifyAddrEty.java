package 원본.view3;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JOptionPane;

import 업데이트.DBConnectionMgr;


public class ModifyAddrEty {
	
	DBConnectionMgr dbMgr = new DBConnectionMgr();
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	public AddressVO modify(AddressVO vo) {
	
	
		StringBuilder sql = new StringBuilder();
		sql.append("UPDATE mkaddrtb                                                               ");
        sql.append("   SET name = ? , address = ?, telephone = ?, gender = ?, relationship = ?,   ");
        sql.append("       birthday = ?, comments = ?, registedate = to_cahr                           ");   
        sql.append(" WHERE id = ?                                                                 ");		
		int result = 0;
		try {
				pstmt.setString(1, vo.getName());
				pstmt.setString(2, vo.getAddress());
				pstmt.setString(3, vo.getTelephone());
				pstmt.setString(4, vo.getGender());
				pstmt.setString(5, vo.getRelationship());
				pstmt.setString(6, vo.getBirthday());
				pstmt.setString(7, vo.getComments());
				pstmt.setInt   (8, vo.getId());
				result = pstmt.executeUpdate();	
			
				if(result == 1) {
					System.out.println("데이터가 수정되었습니다.");
					
				}			
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				DBConnectionMgr.freeConnection(pstmt, con);
			}
			return vo;
		}

