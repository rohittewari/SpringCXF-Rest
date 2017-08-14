package server.exceptions;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class DoNotFoundException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;
	private String error;
	private int errorCode;
	
	public DoNotFoundException(){
		
	}
	
	public DoNotFoundException(String error, int errorCode) {
		super(error);
		this.error = error;
		this.errorCode = errorCode;
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

	public int getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(int errorCode) {
		this.errorCode = errorCode;
	}
	
	
}
