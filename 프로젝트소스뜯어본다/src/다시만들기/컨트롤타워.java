package 다시만들기;

public class 컨트롤타워 {
   
	private Voclass returnVO = new Voclass();
	private Voclass invo = new Voclass();
	
	private static String _DEL = "delete";
	private static String _INS = "insert";
	private static String _MOD = "update";
	private static String _SEL = "select";
	private static String _ALL = "selectall"; 
	
    public 컨트롤타워() {
    }	
    public 컨트롤타워(Voclass vo) {
    	this.invo = vo; 
    	}
    // https://bvc12.tistory.com/193 : Excetion 즉 예외가 발생했을 때 어떻게 처리하는지
    // https://bvc12.tistory.com/194 : try catch 블럭은 예외가 발생했을때 발생하는 오류를 사전에 미리 옆으로 
    // 비껴나가도록 처리 하는 구문입니다.
    public Voclass send(Voclass vo) throws Exception {
      String commend = vo.getCommand();
      
      if(command.equals(_DEL)) {
    	  DeleteAddrEty delEty = new DeleteAddrEty();
    	  retrnVO = delEty.delete(vo);
      }
      
    };
    


              
             



