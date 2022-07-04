package 원본.view3;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Vector;

public class RetrieveAddrEty {
	DBConnectionMgr dbMgr = new DBConnectionMgr();
	// DB에 연결해줄 수 있는 통로를 열어준다.
	Connection con = null;
	// DB에 접속할 수 있는 객체를 생성해준다.
	PreparedStatement pstmt = null;
	// sql 구문을 실행하는 역할을 하는 클래스
	ResultSet rs = null;
	// sql 결과값을 저장할 수 있고 한행 단위로 값을 가져올 때 타입을 지정해서 불러올 수 있는 타입 반환기
	// 클래스 선언부에 인스턴스화를 시켜놓은 이유는 이 클래스 전체에 사용되기 떄문이다.
	
	/***************************************************************************
	 * 회원정보 중 상세보기 구현 - 1건 조회
	 * SELECT id, name, address, DECODE(gender,'1','남','여') as "성별"
            , relationship, comments, registedate, birthday
         FROM mkaddrtb
        WHERE id = 5
	 * @param vo : 사용자가 선택한 값
	 * @return AddressVO : 조회 결과 1건을 담음
	 **************************************************************************/
	public AddressVO retrieve(AddressVO vo) {
		System.out.println("RetrieveAddrEty retrieve(AddressVO vo) 호출 성공");
        StringBuilder sql = new StringBuilder();
        // 한번에 많은 문자열을 선언할 수 있게 해주는 클래스이다, 그래서 지금과 같이 sql 문이 많을 때 사용한다.
        AddressVO rVO = null; 
        AddressBook book = null;
        // VO클래스 와 book클래스에  값을 넘길때 null 처리해주고 넘기려고 선언했다.
        sql.append("   SELECT id, name, address, telephone       						");
        sql.append("   , gender, relationship, comments                                 ");
        sql.append("   , registedate, birthday											");
        sql.append("   FROM mkaddrtb                                                    ");
        sql.append("   WHERE id = ?                                                 	");
		
        // id의 값을 ?로 집어넣은 이유는 해당 id의 값이 바뀌어도 상관없도록 한 것이다.
        try { 
        	con = dbMgr.getConnection();
        	// getConnection() : 지정된 사용자의 이름및 암호를 사용하여 sql 개체가 나타내는 데이터 원본과의 연결을 설정해준다.
        	pstmt = con.prepareStatement(sql.toString());
        	// 문자열 처리한 내용을 toString으로 타입지정을 해주었다.
        	pstmt.setInt(1, vo.getId());
        	// pre로 getId에 sql 구문이 실행 되었을 때 1의 값을 넘겨주는 역할을 한다.
        	rs = pstmt.executeQuery();
            // execute은 리턴값이 ResultSet일 경우에는 true 그외일 경우에는  false로 출력되는 것을 의미한다.
        	// 또한 sql 문을 사용할때는 Query가 붙는다.
        	
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
        		// true 일떄는 위 언급되어있는 변수에 해당 String 값이 담기도록 처리해 놓았다.
        		
        	}
        } catch (Exception e) { 
        	System.out.println(e.toString());
             // 예외가 발생할 경우 아무런 값을 출력하지 않게 처리해놓았다.
        	} finally {
        		DBConnectionMgr.freeConnection(rs, pstmt, con);
	         // DBConnectionMgr 에 freeConnection 메서드에 rs, pstmt, con 값을 보내고 만약 그 값이  
             // null 값이 아니면 close 되도록 설정 되어있다.
        
        }
		return rVO;
	}
	/***************************************************************************
	 * 회원 목록 보기 구현 - n건 조회
	 * SELECT id, name, address, DECODE(gender,'1','남','여') as "성별"
            , relationship, comments, registedate, birthday
         FROM mkaddrtb
	 * @param vo : 사용자가 선택한 값
	 * @return AddressVO : 조회 결과 1건을 담음
	 **************************************************************************/
	public AddressVO[] retrieve() {
		// vo클래스를 배열화 시켜놓았다. 그로 인해해당 값에 여러 값을 효율적으로 넣어 놓을 수 있다.
		System.out.println("RetrieveAddrEty retrieve() 호출 성공");		
		AddressVO[] vos = null;
		StringBuilder sql = new StringBuilder();
		AddressVO raVO = null; 
		Vector<AddressVO> imsi = new Vector<>();
		// Vector 클래스는 데이터를 가변 크기로 설정할 수 있고 요소의 개수에 따라 자동으로 크기를 조절이 가능하기에 
	    // 데이터의 크기를 예측이 불가능한 지금과 같이 오라클서버에 연동할때 사용이 용이하다, 그래서 Vector클래스를 사용하였다.
		// 또한 list 보다 검색 관련 내용에서는 vector의 기능적 우위에 위치해 있다.
		
		sql.append("SELECT id, name, address, telephone, DECODE(gender,'1','남','여') as gender  ");
		sql.append("            , relationship, comments, registedate, birthday                 ");
		sql.append("         FROM mkaddrtb                                                      ");
		sql.append("         ORDER BY id asc                                                    ");
		// 정신차리자 영진아 gender에 'gender' 싱글쿼테이션을 왜 넣었니?? 다음부터는 작은거 하나하나 조심하자!! 
		
		try {
			con = dbMgr.getConnection();
        	pstmt = con.prepareStatement(sql.toString());
        	rs = pstmt.executeQuery();
        	// pstmt.setInt(1, vo.getId()); : 위에있는  상세보기 클래스(1건만 조회)와는 달리 회원목록 보기(n건조회) 클래스는 사이즈가 정해져 있지 
        	// 않아서 생략을 하게 되었다.
        	
        	while(rs.next()) {
        	// for문을 쓰지 않고 while 문을 사용한 이유는 for문은 반복횟수가 얼마인지를 알아야 하는 경우에 적합한데 
            // 지금과같이 횟수가 정해져있지 않은 조건에 경우에는 whlie 문과 같이 조건이 성립이 되어야 끝나는 조건문이 가장 
            // 적합하여 while문을 작성하게 되었다.
        		
        		int id = rs.getInt("id");
        		String name = rs.getString("name");
        		String address = rs.getString("address");
        		String telephone = rs.getString("telephone");
        		String gender = rs.getString("gender");
        		String relationship = rs.getString("relationship");
        		String comments = rs.getString("comments");
        		String registedate = rs.getString("registedate");
        		String birthday = rs.getString("birthday");
        		raVO = new AddressVO(name, address, telephone, gender, relationship, 
        				            comments, registedate, birthday, id);
        		// 위와 달리 회원목록 보기 같은경우에는 배열을 사용하여 vo에 한개씩 인스턴스화를 해야할 필요가없이  
        		// raVO에 배열의 값만을 담기만 해도되서 따로 VO에 담는 코드를 생략할 수 있었다.  
        		// 그래서 String 처리만을 해놨다.
        		imsi.add(raVO);
        		// Vector에 raVO의 데이터를 대입 시켜놨다.
        	}
        	vos = new AddressVO[imsi.size()];
        	// vos(AddressVO) 클래스에 해당 Vector리스트의 값과 size(해당 컬렉션프레임워크의)길이를 담아놨다.
        	imsi.copyInto(vos);
        	// 그리고 다시 imsi에 vos의 값을 복사해 놨다.
		} catch (Exception e) { 
        	System.out.println(e.toString());
       	} finally { 
       		DBConnectionMgr.freeConnection(rs, pstmt, con);
       	}   
		return vos;
	

	}
}