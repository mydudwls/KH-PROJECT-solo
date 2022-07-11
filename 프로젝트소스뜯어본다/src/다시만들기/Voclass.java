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
// 아...~~ 생성자 뭔데?? 하아~~ 하나도 몰라 ㅠㅠㅠ
// 생성자 : https://kephilab.tistory.com/47	
// this : https://smoothiecoding.kr/%EC%9E%90%EB%B0%94-this-%EC%9D%98%EB%AF%B8/
// Stack, heap : https://devkingdom.tistory.com/226 	
	private String name;  
	private String address;
    private String telepone;
    private String gender;
    private String relationship;
    private String birthday;
    private String comments;
    private String registedate;
    private    int id; // 이것만 유일하게 숫자로 되어있어서 int로 처리한 것이다.
	
    private String command;
    // command 란 : https://zeroco.tistory.com/12
    
    private int result;
    // 지금은 선언만 시켜놓은 상태  
    
    public Voclass() {}
    
    private Voclass[] VoclassS; 
    // 객체 배열화 클래스를 배열로 만드는 구문!
    // 이른 인스턴스화 즉 빈 깡통을 생성한다.
    // 그러면 다른 클래스에서 각기 다른 결과 값을 담을 수 있다.
    // 한마디로 빈 깡통을 생성한다고 보면 된다.
   	
    public Voclass(String name, 
    		       String address, 
    		       String telepone, 
    		       String gender, 
    		       String relationship, 
    		       String birthday,
    		       String commennts, 
    		       String registedate, 
    		       int id) { 
    	                this.name         = name;
    	                this.address      = address;
    	                this.telepone     = telepone;
    	                this.gender       = gender;
    	                this.relationship = relationship;
    	                this.birthday     = birthday;
    		            this.comments     = commennts; 
                        this.registedate  = registedate;	
                        this.id           = id;}
                // 이제부터 get set 시작하니까 미리 가서 확인 해야함 
                // https://mozi.tistory.com/466
    public String    getName        (){return this.name;}
    //private의 자원을 가지고 나온다음 다시 반납한다. 
    // 그래서 왜~~ 선생님이 자원 반납은 꼭 해주셔야 합니다. 라고 했잖아 그거야 그거!! 
    public String    getAddress     (){return this.address;}
    public String    getTelephone   (){return this.telepone;} 
    public String    getGender      (){return this.gender;}	
    public String    getRelationship(){return this.relationship;}	
    public String    getBirthday    (){return this.birthday;} 
    public String    getComments    (){return this.comments;}	
    public String    getRegistedate (){return this.registedate;}		
    public String    getCommand     (){return this.command;}
    public int       getId          (){return this.id;} 
    public Voclass []getVoclassS    (){return this.VoclassS;}
    
    public void setName(String name) {this.name = name;}
    public void setAddress(String address){this.address = address;}
    public void setTelephone(String telepone){this.telepone = telepone;}
    public void setGender(String gender){this.gender = gender;}
    public void setRelationship(String relationship){this.relationship = relationship;}
    public void setBirthday(String birthday){this.birthday = birthday;}
    public void setComments(String comments){this.comments = comments;}
    public void setRegistedate(String registedate){this.registedate = registedate;}
    public void setCommeand(String command){this.command = command;}
    public void setId(int id){this.id = id;}
    public void setVoclassS(Voclass[] Voclass){this.VoclassS = Voclass;}
    // 메소드 : https://blog.naver.com/PostView.nhn?isHttpsRedirect=true&blogId=heartflow89&logNo=220951776433&parentCategoryNo=&categoryNo=&viewDate=&isShowPopularPosts=false&from=postView
    // 어떠한 문제를 처리하기 위한 방법을 소스 코드로 묶어놓고 필요(호출)에 따라 동작하는 기능 정도로 생각할 수 있다.
    public int getResult() {
    	return result;
    }
    public void setResult(int result) {
    	this.result = result;
    }
}

// 이소스의 목적은 오라클 서버에 컬럼내용을 내가 검색했을 때 해당 컬럼들의 값이 작동할 수 있게 해주는 소스이다. 
// 24 ~ 31 까지는 생성자 선언, private으로 선언한 문자를 보호(자물쇠로 걸어놓음)(왜냐하면 해당 문자가 다른 문자열에 대입되는 것을 방지목적)해 주고 
// private 으로 보호된 구문을 가져다가 쓸 수 있게 geter(반환해준다 즉 가져갔으니 다시 돌려줘야지!) seter(제약을 걸어서 준다. 즉 설치!)로(열쇠로 자물쇠를 풀음)
// 46 ~ 53 문자열의 값을 선언해준다. 
// 55 ~ 63 은 생성자 영역인데 생성자는 객체의 값을 초기화 시켜준다. 즉 내가 가져다 쓸 수 있게 문자열의 값을 인스턴스화 시켜준다고 보면된다
// 그리고 생성자에 문자열을 대입시켜준다. (그래서 다른 클래스에서 가져다 쓸수 있게 인스턴스 화를 시켜줬다고 생각하면 된다.)
// this영역의 경우에는 같은 이름의 생성자와 문자열의 값을 오버로딩시켜줘서 사용할 수 있게 해준다.
// 66 ~ 77 에는 다른 클래스에서 geter을 사용하게 되면 같은 이름의 생성자를 반환해준다.
// 79 ~ 89 에는 다른 클래스에서 seter을 해당 string 문자열의 값을 같은 이름의 생성자에게 대입을 시켜준다.
// 즉 다른 클래스 에서 seter을 선언한 다음 메소드에 geter 값을 호출하게 되면 해당 생성자 값을 사용할 수 있게 인스턴스화된 값을 얻을 수 있다.
// 즉 이 소스는 다른 클래스에게 문자열 생성자를 전달해주는 역할을 하는 클래스이다.
// 한마디로 도끼의 머리 부분이다.