package 업데이트;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Vector;
import 업데이트.DBConnectionMgr;
import 업데이트.AddressVO;


public class RetrieveAddrEty {
	
	DBConnectionMgr dbMgr = new DBConnectionMgr();
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	
	/***************************************************************************
	 * 회원정보 중 상세보기 구현 - 1건 조회
	 * SELECT id, name, address, gender
            , relationship, comments, registedate, birthday
         FROM mkaddrtb
        WHERE id = 5
	 * @param vo : 사용자가 선택한 값
	 * @return AddressVO : 조회 결과 1건을 담음
	 **************************************************************************/
	public AddressVO retrieve(AddressVO vo) {
		System.out.println("RetrieveAddrEty retrieve(AddressVO vo) 호출 성공");
		AddressVO rVO = null;
		AddressBook book = null;
		StringBuilder sql = new StringBuilder();

		sql.append("   SELECT id, name, address, telephone       						");
        sql.append("   , gender, relationship, comments   								");
        sql.append("   , registedate, birthday											");
        sql.append("   FROM mkaddrtb                                                    ");
        sql.append("   WHERE id = ?                                                 	");
		
		try {
        	con = dbMgr.getConnection();
        	pstmt = con.prepareStatement(sql.toString());
        	pstmt.setInt(1, vo.getId());
        	
        	rs = pstmt.executeQuery();
        	
        	if(rs.next()) {
        		rVO = new AddressVO();
        		rVO.setId(rs.getInt("id"));
        		rVO.setName(rs.getString("name"));
        		rVO.setAddress(rs.getString("address"));
        		rVO.setTelephone(rs.getString("telephone"));
        		rVO.setGender(rs.getString("gender"));
        		rVO.setRelationship(rs.getString("relationship"));
        		rVO.setComments(rs.getString("comments"));
        		rVO.setRegistedate(rs.getString("registedate"));
        		rVO.setBirthday(rs.getString("birthday"));
        		
        		
        	}
        	//System.out.println(rVO.getGender());
        	
		} catch (Exception e) {
			System.out.println(e.toString());
		} finally {
			DBConnectionMgr.freeConnection(rs, pstmt, con);
		}
		
		return rVO;
	}
	/***************************************************************************
	 * 회원 목록 보기 구현 - n건 조회
	 * SELECT id, name, address, DECODE(gender,'1','남','여') as gender
            , relationship, comments, registedate, birthday
         FROM mkaddrtb
         ORDER BY id asc
	 * @param vo : 사용자가 선택한 값
	 * @return AddressVO : 조회 결과 1건을 담음
	 **************************************************************************/
	public AddressVO[] retrieve() {
		

	
		System.out.println("RetrieveAddrEty retrieve() 호출 성공");
		AddressVO[] vos = null;
		Vector<AddressVO> v = new Vector<>();
		StringBuilder sql = new StringBuilder();

		sql.append("   SELECT id, name, address, telephone       						");
        sql.append("   , DECODE(gender,'1','남','여') as gender, relationship, comments   ");
        sql.append("   , registedate, birthday											");
        sql.append("   FROM mkaddrtb                                                    ");
        sql.append("   ORDER BY id asc                                                 ");

 try {
        	
        	con = dbMgr.getConnection();
        	pstmt = con.prepareStatement(sql.toString());
        	rs = pstmt.executeQuery();
        	
        	AddressVO raVO = null;
			while (rs.next()) {
				
				int id = rs.getInt("id");
				String name = rs.getString("name");
				String address = rs.getString("address");
				String telephone = rs.getString("telephone");
				String gender = rs.getString("gender");
				String relationship = rs.getString("relationship");
				String comments = rs.getString("comments");
				String registedate = rs.getString("registedate");
				String birthday = rs.getString("birthday");
				raVO = new AddressVO(name, address,telephone, gender
						, relationship, comments, registedate, birthday, id);
				v.add(raVO);
				
			}

			vos = new AddressVO[v.size()];
			v.copyInto(vos);
			//System.out.println(vos[0].getGender());
        
		} catch (Exception e) {
			System.out.println(e.toString());
		} finally {
			DBConnectionMgr.freeConnection(rs, pstmt, con);
		}
		
		return vos;
		
	}
	/*
	 * public static void main(String[] args) { RetrieveAddrEty aa = new
	 * RetrieveAddrEty(); aa.retrieve(null); }
	 */
	
}

/*
ID,NAME,ADDRESS,TELEPHONE,GENDER,RELATIONSHIP,BIRTHDAY,COMMENTS,REGISTEDATE
3,나초보,서울시 마포구 공덕동,025556968,2,2,19801215,주연테크,REGISTEDATE
1,홍길동,서울시 영등포구 당산동,111,1,동창,19901010,222,20081117
2,이순신,서울시 서초구 양재동,222,2,회사동료,19901110,333,20100113
4,강감찬,경기도 광명시,11,1,동창,19801120,테스트합니다.,2011-03-20
9,나초조,4455,44455,1,44555,19800702,자영업,20110320
7,223,223,223,2,223,223,223,20190609
10,조조,경기도 화성시,44455,1,44555,19800702,자영업,20110320
*/