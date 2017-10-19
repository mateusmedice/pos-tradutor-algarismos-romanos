package aula.tradutor.exception;

public class WrongParamException extends RuntimeException {

	private static final long serialVersionUID = 7326164049124470336L;

	public WrongParamException() {
		super();
	}
	
	public WrongParamException(String msg) {
		super(msg);
	}

	public WrongParamException(Throwable e) {
		super(e);
	}

	public WrongParamException(String msg, Throwable e) {
		super(msg, e);
	}
	
}
