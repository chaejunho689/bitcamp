package exception;

public class MakeException extends Exception {
	private String errormsg;
	
	public MakeException(String errormsg) {
		super();
		this.errormsg = errormsg;
	}
	
	@Override
	public String toString() {
		return errormsg;
	}
}
