package com.expedia.selenium.ExpediaMavenTest;

import org.testng.annotations.Test;

import com.expedia.selenium.ExpediaMavenTest.utilities.AbstractTest;
import com.relevantcodes.extentreports.LogStatus;

public class TS001_TC002_VerifyRoundTripWtPreferredAirlines extends AbstractTest{
	
	/*
	 * Verify the Roundtrip flight with preferred airlines from New York to Dhaka on departing date as 
	 * 11/05/2015 to Returning date as 11/10/2015
	 * 
	 */
	
	
	@Test(description = "Verify Flight RoundTrip with preferred airlines")
	public void flightRoundTripWtPrefAirlines(){
		String departure = "New York";
		String destination = "Dhaka";
		extentTest = extentReport.startTest("RoundTrip Flight Verification with preferred airlines");
		homeScreen().clickOnFlightButton();
		extentTest.log(LogStatus.PASS, "Click on the Flight Button");
		homeScreen().clickOnroundTripButton();
		extentTest.log(LogStatus.PASS, "Click on the Roundtrip Button");
		homeScreen().clearFlyingFromCity();
		extentTest.log(LogStatus.PASS, "Clear Text field of Flying from");
		homeScreen().enterFlyingFromCity(departure);
		extentTest.log(LogStatus.PASS, "Enter City name into Flying from text field");
		homeScreen().clearFlyingToCity();
		extentTest.log(LogStatus.PASS, "Clear text field of Flying to ");
		homeScreen().enterFlyingToCity(destination);
		extentTest.log(LogStatus.PASS, "Enter Destination City name into Flying to text field");
		homeScreen().clearDepartingDate();
		extentTest.log(LogStatus.PASS, "Clear departing date text field");
		homeScreen().setDepartingDate("03/03/2016");
		extentTest.log(LogStatus.PASS, "Set departing date to 03/03/2016");
		homeScreen().clearReturnDate();
		extentTest.log(LogStatus.PASS, "Clear returning date");
		homeScreen().setReturningDate("03/10/2016");
		extentTest.log(LogStatus.PASS, "Set returning date to 03/10/2016");
		homeScreen().clickOnAdvanceOptionLink();
		extentTest.log(LogStatus.PASS, "Click on Advance option link");
		homeScreen().selectPreferredAirlineDropdown("QR");
		extentTest.log(LogStatus.PASS, "Select preferred airlines QR for Qatar from preferred airlines dropdown");
		homeScreen().clickOnSearchButton();
		extentTest.log(LogStatus.PASS, "Click on Search button");
		homeScreen().verifyDestInNextPage(destination);
		extentTest.log(LogStatus.PASS, "Verify Next page destination title using Assert");
		extentTest.log(LogStatus.PASS, "RoundTrip Flight Verification with preferred airlines");
		extentReport.endTest(extentTest);
		//driver.navigate().to(expedia);

	}
}