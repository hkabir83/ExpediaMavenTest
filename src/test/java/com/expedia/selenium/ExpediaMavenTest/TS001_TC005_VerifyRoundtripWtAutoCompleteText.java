package com.expedia.selenium.ExpediaMavenTest;

import org.testng.annotations.Test;

import com.expedia.selenium.ExpediaMavenTest.utilities.AbstractTest;

public class TS001_TC005_VerifyRoundtripWtAutoCompleteText extends AbstractTest{
	
	/*
	 * Verify the Roundtrip flight from New York to Dhaka on departing date as 
	 * 12/05/2015 to Returning date as 12/10/2015 with auto complete text
	 * 
	 */
	
	
	@Test(description = "Verify Flight RoundTrip with auto complete text")
	public void flightRoundTripWtAutoCompleteText(){
		String flyingFromPartialText = "Ne";
		String flyingFromText = "New York, NY (NYC - All Airports)";
		String flyingFromExpected = "New York, NY (NYC-All Airports)";
		String flyingToPartialText = "Dha";
		String flyingToText = "Dhaka, Bangladesh (DAC - Zia Intl.)";
		String flyingToExpected = "Dhaka, Bangladesh (DAC-Zia Intl.)";
		homeScreen().clickOnFlightButton();
		homeScreen().clickOnroundTripButton();
		homeScreen().clearFlyingFromCity();
		waitForSeconds(10);
		homeScreen().autoCompleteFlyingFromTextField(flyingFromText, flyingFromPartialText);
		homeScreen().verifyAutoCompleteFlyingFrom(flyingFromExpected);
		homeScreen().clearFlyingToCity();
		waitForSeconds(10);
		homeScreen().autoCompleteFlyingToTextField(flyingToText, flyingToPartialText);
		homeScreen().verifyAutoCompleteFlyingTo(flyingToExpected);
		homeScreen().clearDepartingDate();
		homeScreen().setDepartingDate("03/05/2016");
		homeScreen().clearReturnDate();
		homeScreen().setReturningDate("03/10/2016");
		homeScreen().clickOnSearchButton();
		homeScreen().verifyDestInNextPage("Dhaka");
		//driver.navigate().to(expedia);
	}


}
