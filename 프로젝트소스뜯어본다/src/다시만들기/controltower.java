package 다시만들기;

public class controltower {
   
	private Voclass returnVO = new Voclass();
	private Voclass invo = new Voclass();
	// ????? 잠만 아!!! 외부 클래스에서 해당 값을 인스턴스 화 
	// 하려면 비워져있는 클래스가 하나 선언되어 있어야 한다.
	// 그래서 선생님이 Voclass에 만들어 놨구먼!! 
	private static String _DEL = "delete";
	private static String _INS = "insert";
	private static String _MOD = "update";
	private static String _SEL = "select";
	private static String _ALL = "selectall"; 
	
    public controltower() {
    }	
    public controltower(Voclass vo) {
    	this.invo = vo; 
    	}
    // https://bvc12.tistory.com/193 : Excetion 즉 예외가 발생했을 때 어떻게 처리하는지
    // https://bvc12.tistory.com/194 : try catch 블럭은 예외가 발생했을때 발생하는 오류를 사전에 미리 옆으로 
    // 비껴나가도록 처리 하는 구문입니다.
    public Voclass send(Voclass vo) throws Exception {
    	// 강제 예외처리!! : https://makecodework.tistory.com/entry/Java-%EC%98%88%EC%99%B8%EC%B2%98%EB%A6%AC104-%EB%8B%A4%EC%A4%91-catch-%EB%A9%80%ED%8B%B0-catch
    	String commend = vo.getCommand();
        // 왜?? 강제로 에러를 발생시키지?? 
        // throws 를 사용하여 예외객체를 전달하는 이유가 시스템 과부하를 줄이기 위함이다. 
    	// 즉 commend에 너무 많은 부하를 줄이기 위함이다.
    	// 즉 commend를 많이 사용할 수 있게 했다는 소리이다.
        // vo 클래스에서 Command 를 가져와서 commend변수에 대입시켜줬다, 이걸 초기화!! 라고 하지!! 
    	if(commend.equals(_DEL)) {
    	   // equals 문자열의 값이 같다 를 뜻함!! 
    		DeleteAddrEty delEty = new DeleteAddrEty();
    	   // 삭제클래스. 내일 만들 예정 
    		returnVO = delEty.delete(vo);
    	} else if (commend.equals(_INS)) {
    	   RegisterAddrEty insEty = new RegisterAddrEty(); 
    	   // 입력클래스. 내일 만들 예정
    	  returnVO = insEty.register(vo); 
    	} else if (commend.equals(_MOD)) {
    		ModifyAddrEty modEty = new ModifyAddrEty(); 
    	   // 수정클래스. 내일 만들예정  
    		returnVO = modEty.modify(vo);
    	} else if (commend.equals(_SEL)) {
    	    RetrieveAddrEty selEty = new RetrieveAddrEty();  
    	   // 삭제클래스. 내일 만들예정 
    	   returnVO = selEty.retrieve(vo);
    	} else throw new Exception("잘못된 Command명(" + commend + ")입니다.");
           return returnVO;         
    } 
    // 여기서 하나 짚고 넘어가야 할 것이 과연 왜 이렇게 코드를 만드셨을까?? 
    // commend 를 가지고서 삭제부터 입력까지 if문으로 만드이유를 모르겠네?? 
    // 뭐를 위해서??  이 클래스를 실행 시키는 거지?? 
    // 잠만 생각을 해보자 아!! 혹시 이 프로그램이 실행될때 두번째(첫번째는 화면 ui)로 실행되면서 
    // 각 ui 버튼에 값을 할당하고 그 값이 실행되도록 하기 위해서인가?? 
    // 이건가?? 이거는 ui 화면을 만들면서 생각해 봐야 겠다!! 
    // 아...... 하아~~ 힘들다.. 
    


              
             



