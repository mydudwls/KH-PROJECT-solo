package 다시만들기;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.PreparedStatement;

public class orecleserver {
	
   Connection con  = null; // DB 연결하는 구문 
   PreparedStatement pstmt = null; // connect를 이용해 SQL명령을 실행하는 객체
   ResultSet rs   = null; // SQL실행 후 SELECT 결과를 저장하는 객체
    
    
    public static final String driver = "oracle.jdbc.driver.OracleDriver"; 
    public static final String    url = "jdbc:oracle:thin:@192.168.0.18:1521:orcll";
    public static final String userid = "scott";
    public static final String passwd = "tiger";
    // 오라클 서버에 저장된 데이터를 넘겨준다.
    // 또한 public을 사용하여 데이터를 외부로 부터 참조할 수 있게 해놓았고 
    // 이유는 메모리에 해당 값은 모든 객체가 값을 공유할 수 있게 된다. 또한 프로그램이 종료시까지 해당 값이 남게된다. 
    // finnal은 한번 할당된 값이 변하지 않도록 하는 장치라고 생각하면 된다.
    
    public Connection getConnection() {
    	 // 이 SQLServerDataSource 개체가 나타내는 데이터 원본과의 연결을 설정합니다.
    	try {
    		 Class.forName("oracle.jdbc.driver.OracleDriver");
    		 //	클래스의 정보를 얻기위한 클래스 즉, 클래스의 정보를 얻어오는 클래스입니다.
    		 con = DriverManager.getConnection(url, userid, passwd); 
    		 // DB와 연결하는 구문에 class forname 의 정보를 대입 시켜주는 역할을 한다.
    		 
    	} catch (Exception e){
    		  e.printStackTrace();
    		 // 예외 발생당시 호출스택에 있던 메소드의 정보와 예외 결과를 화면에 출력한다.
    		 // 예외 상황을 분석하기 위한 도구로 사용된다. 
    	} return con;
    }
    public static void freeConnection(ResultSet rs, PreparedStatement pstmt, Connection con) {
    	// 자원 반납하려고 쓰는거다 쉽게 말해서 오라클에 데이터를 가
    	// 져올 때 preparedstatement나 connection을 생성해서 데이터를 가져오는데 
    	// 그 데이터를 다 가져오고 나면 생성했 던 것들을 없애줘야 한다. 
    	// 그래서 그 때 마다 각 객체에 .close()라는 메서드를 써줘야 하는데 일일이 
    	// 쓰기 귀찮으니까 freeConnection이라는 메서드를 이용해서 생성된 객체를 
    	// 닫아주는 .close()메서드를 수행하
    	// 게 끔 만든거다!! 
    	// 검색하시려면 java dbutil검색하시면 되세요!! - 같이 수업을 듣는 민준님 말씀!! 
    	
    	try {   
    		if(pstmt != null) 
    	      pstmt.close();
    		if(con != null) 
      	      con.close();
    	} catch (Exception e) {
    		e.printStackTrace();    		
    	}
    }

}

// 통로 만드는 연습 1번 완료!! (앞으로 남은 횟수 99번)
// 이 클래스는 도끼의 손잡이 부분이다.
// 오라클 하고 연결을 해주고 값을 넣고 뺼 수 있게 통로를 만들어 주는 역할을 하기 때문이다.
