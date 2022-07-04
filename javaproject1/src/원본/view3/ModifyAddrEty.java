package 원본.view3;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JOptionPane;


public class ModifyAddrEty {
	
	DBConnectionMgr dbMgr = new DBConnectionMgr();
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	public AddressVO modify(AddressVO vo) {
	
	
		StringBuilder sql = new StringBuilder();
		sql.append("UPDATE mkaddrtb                                                               ");
        sql.append("   SET name = ? , address = ?, telephone = ?, gender = ?, relationship = ?,   ");
        sql.append("       birthday = ?, comments = ?, registedate = ?                           ");   
        sql.append(" WHERE id = ?                                                                 ");		
		int result = 0;
		int i = 1;
		try {
			con = dbMgr.getConnection();
			pstmt = con.prepareStatement(sql.toString());
				
				pstmt.setString(i++, vo.getName());
				pstmt.setString(i++, vo.getAddress());
				pstmt.setString(i++, vo.getTelephone());
				pstmt.setString(i++, vo.getGender());
				pstmt.setString(i++, vo.getRelationship());
				pstmt.setString(i++, vo.getBirthday());
				pstmt.setString(i++, vo.getComments());
				pstmt.setString(i++, vo.getRegistedate());
				pstmt.setInt   (i--, vo.getId());
				result = pstmt.executeUpdate();	
			
				if(result == 1) {
					System.out.println();
				}			
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				DBConnectionMgr.freeConnection( rs, pstmt, con );
			}
			return vo;
		}
}
