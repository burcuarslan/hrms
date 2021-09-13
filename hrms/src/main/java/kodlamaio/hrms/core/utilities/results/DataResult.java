package kodlamaio.hrms.core.utilities.results;

public class DataResult<T> extends Result{

	private T data;

	
	public DataResult(T data,boolean success, String message) {
		super(success, message); // super= base sınıfın construction metotlarına gonderiyor bu metot içinde success ve message bilgisini set etmeye gerek yok
		this.data=data;
		//this(data);
	}
	
	public DataResult(T data,boolean success) {
		super(success); // super= base sınıfın construction metotlarına gonderiyor bu metot içinde success bilgisini set etmeye gerek yok
		this.data=data; 
		
	}

	public T getData() {
		return this.data;
	}


}
