package rocketBase;

import java.util.ArrayList;

import org.apache.poi.ss.formula.functions.*;

import exceptions.RateException;
import rocketDomain.RateDomainModel;
import rocketData.LoanRequest;


public class RateBLL {

	private static RateDAL _RateDAL = new RateDAL();
	
	public static double getRate(int GivenCreditScore) throws RateException 
	{
		double dInterestRate = 0;
		
		ArrayList<RateDomainModel> rates = RateDAL.getAllRates();
		for (RateDomainModel r: rates)
		{
			if (r.getiMinCreditScore() <= GivenCreditScore)
			{
				dInterestRate = r.getdInterestRate();
			}
		}
		
		if (dInterestRate == 0){
			RateDomainModel RDM = new RateDomainModel();
			RDM.setiMinCreditScore(GivenCreditScore);
			
			throw new RateException(RDM);
		}
		
		

		// Filter the ArrayList...  look for the correct rate for the given credit score.
		//	Easiest way is to apply a filter using a Lambda function.
		//
		//	Example... how to use Lambda functions:
		//			https://github.com/CISC181/Lambda
		
		return dInterestRate;
		
		
	}
	
	
	
	
	public static boolean checkPITI(LoanRequest lq)
	{
		boolean checkPITI = false;
		if (lq.getdPayment() < lq.getdIncome()*0.28)
			checkPITI = true;
		if(lq.getdPayment() < (lq.getdIncome()-lq.getdExpenses())*0.36)
			checkPITI = true;
		
		return checkPITI;
		
	}
	
	

	//		how to use:
	//		https://poi.apache.org/apidocs/org/apache/poi/ss/formula/functions/FinanceLib.html
	
	public static double getPayment(double r, double n, double p, double f, boolean t)
	{		
		return FinanceLib.pmt(r, n, p, f, t);
	}
}
