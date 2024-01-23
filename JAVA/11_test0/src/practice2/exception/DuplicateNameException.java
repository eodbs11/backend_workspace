package practice2.exception;

public class DuplicateNameException extends Exception{

	public DuplicateNameException() {
		this("중복된 회원이 있어서 에러 발생!");
	}

	public DuplicateNameException(String message) {
		super(message);
	}
	
}
