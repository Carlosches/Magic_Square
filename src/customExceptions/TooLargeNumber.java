package customExceptions;

public class TooLargeNumber extends Exception{


	public static final int MAX_NUMBER = 31;
	
	
	public TooLargeNumber(String causa) {
		super(causa + " try with a number less than " + MAX_NUMBER);
	}

}
