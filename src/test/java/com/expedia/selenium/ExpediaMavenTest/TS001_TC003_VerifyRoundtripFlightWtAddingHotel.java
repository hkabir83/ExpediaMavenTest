package com.expedia.selenium.ExpediaMavenTest;

import org.testng.annotations.Test;

import com.expedia.selenium.ExpediaMavenTest.utilities.AbstractTest;

public class TS001_TC003_VerifyRoundtripFlightWtAddingHotel extends AbstractTest{
	
	/*
	 * Verify the Roundtrip flight by clicking adding hotel check box from New York to Dhaka on departing date as 
	 * 12/05/2015 to Returning date as 12/10/2015
	 * 
	 */
	
	
	@Test(description = "Verify Roundtrip Flight with adding hotel")
	public void flightRoundTripWtAddingHotel(){
		String departure = "New York";
		String destination = "Dhaka";
		String departingDate = "03/05/2016";
		String returningDate = "03/10/2016";
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
		homeScreen().clickOnAddingHotelCheckBox();
		homeScreen().clearHoteCheckInDate();
		homeScreen().setHotelCheckInDate(departingDate);
		homeScreen().clearHoteCheckOutDate();
		homeScreen().setHotelCheckOutDate(returningDate);
		homeScreen().clickOnSearchButton();
		homeScreen().verifyNextPageByaddingHotel();
		//driver.navigate().to(expedia);
	}

}
