package kodlamaio.hrms.core.utilities.results;

public class Result { //supper type./en soyut sınıf interface gibi
	private boolean success;
	private String message;
	
	public Result(boolean success, String message) {
		//this.success=success; //dont repeat your self
		this(success); //this su anki mevcut class demek
		
		this.message=message;
	}
	
	public Result(boolean success) {
		this.success=success; //burada aynı islem yapılıyor zaten buraya gonderiyoruz alttaki succesi  //dont repeat your self
	}
	
	
	public boolean isSucces() {
		return this.success;
	}
	
	public String getMessage() {
		return this.message;
	}
}
