package com.expedia.selenium.ExpediaMavenTest;

import org.testng.annotations.Test;

import com.expedia.selenium.ExpediaMavenTest.utilities.AbstractTest;

public class TS001_TC004_VerifyRoundtripFlightWtAddingCar extends AbstractTest{
	

	/*
	 * Verify the Roundtrip flight by clicking adding hotel check box from New York to Dhaka on departing date as 
	 * 12/05/2015 to Returning date as 12/10/2015 (more than 26 night)
	 * 
	 */
	
	
	@Test(description = "Verify Roundtrip Flight with adding car")
	public void flightRoundTripWtAddingCar(){
		String departure = "New York";
		String destination = "Dhaka";
		String departingDate = "03/01/2016";
		String returningDate = "03/30/2016";
		homeScreen().clickOnFlightButton();
		homeScreen().clickOnroundTripButton();
		homeScreen().clearFlyingFromCity();
		homeScreen().enterFlyingFromCity(departure);
		homeScreen().clearFlyingToCity();
		homeScreen().enterFlyingToCity(destination);
		homeScreen().clearDepartingDate();
		homeScreen().setDepartingDate(departingDate);
		homeScreen().clearReturnDate();
		homeScreen().setReturningDate(returningDate);
		homeScreen().clickOnAddingCarCheckBox();
		homeScreen().verifyMsgAfterClickingAddAcarCheckBox();
		homeScreen().clickOnSearchButton();
		homeScreen().verifyErrMsgTitleAfterClickingAddAcarCheckBox();
		homeScreen().verifyErrMsgAfterClickingAddAcarCheckBox();
		//driver.navigate().to(expedia);
	}

}
