package kodlamaio.hrms.core.utilities.results;

public class ErrorResult extends Result{
	
	public ErrorResult() {
		super(false); //super = Result sınıfındaki success'i false yapar
	}
	public ErrorResult(String message) {
		super(false,message); //super = Result sınıfındaki success'i false yapar ve message'i gelen mesaj bilgisi ile değiştirir.
	}
}
