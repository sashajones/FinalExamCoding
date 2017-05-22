package rocketBase;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import rocketDomain.RateDomainModel;

public class Rate_Test {

	
	
	@Test
	public void Testrate_Test(){
		ArrayList<RateDomainModel> allRatesTest = RateDAL.getAllRates();
		assertEquals(allRatesTest.get(0).getiMinCreditScore(),800);
	}
	
	@Test
	public void get_allRatesTest(){
		ArrayList<RateDomainModel> rates = RateDAL.getAllRates();
		assertTrue(rates.get(0).getiMinCreditScore()>rates.get(1).getiMinCreditScore());
		assertTrue(rates.get(1).getiMinCreditScore()>rates.get(2).getiMinCreditScore());
		assertTrue(rates.get(2).getiMinCreditScore()>rates.get(3).getiMinCreditScore());
		assertTrue(rates.get(3).getiMinCreditScore()>rates.get(4).getiMinCreditScore());
		//assertTrue(ArrayList<RateDomainModel>)
	}
	
	@Test
	public void test() {
		
		
		ArrayList<RateDomainModel> rates = RateDAL.getAllRates();
		int sizeRates = rates.size();
		
		System.out.println ("Number of Rates is: " + sizeRates);
		assert(sizeRates > 0);

	}
	


}
