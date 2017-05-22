package exceptions;

import rocketData.LoanRequest;

public class LoanRequestException extends Exception {

	private LoanRequest LRQ;
	public LoanRequestException(LoanRequest lQ)
	{super();
		LRQ = lQ;}
	
	public LoanRequest getLQ() {
		return LRQ;
	}

}
