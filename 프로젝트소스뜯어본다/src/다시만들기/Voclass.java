package 다시만들기;

import java.io.Serializable;
// java.io.Serializable; : 직렬화를 가능하게 하는 권한부여
// 자바 직렬화란 자바 시스템 내부에서 사용되는 객체 또는 데이터를 외부의 자바 
// 시스템에서도 사용할 수 있도록 바이트(byte) 형태로 데이터 변환하는 기술과
// 바이트로 변환된 데이터를 다시 객체로 변환하는 기술(역직렬화)을 아울러서 이야기한다.

public class Voclass implements Serializable {
//  implements 정의 와 왜 사용하였는가!! : https://wooono.tistory.com/261
//  Serializable : 라이브러리에서 가져 온거 사용한 거임! 
	
	private static final long  serialVersionUTD = 1L;
// private 의 정의 : https://mozi.tistory.com/471
// static 의 정의 : 	https://coding-factory.tistory.com/524
// final 의 정의 : https://advenoh.tistory.com/13
// serialVersionUTD 정의 : https://madplay.github.io/post/java-serialization-advanced	
// serialVersionUTD 값이 서로 맞는지 확인하기 위해서 사용하는 클래스이다.
// 짤막한 용어 사전 메소드, 클래스 : https://sundrystore.tistory.com/8
	
    private String name;  
	private String address;
    private String telepone;
    private String gender;
    private String realtionship;
    private String birthday;
    private String comments;
    private String registedate;
    private int id; // 이것만 유일하게 숫자로 되어있어서 int로 처리한 것이다.
	
    private String command;
    // command 란 : https://zeroco.tistory.com/12
    
    private int result;
    // 지금은 선언만 시켜놓은 상태  
    
    private Voclass[] Voclass; 
    // 객체 배열화 클래스를 배열로 만드는 구문!
    // 이거는 도저히 모르곘다~~~
    
    public Voclass() {}
    
    public Voclass{} 
    
    // 그다음에는 geter set 클래스가 필요하다 그러면 일단 겟터 셋터를 만들어야 할 것이다.
    	
    
	}

}
