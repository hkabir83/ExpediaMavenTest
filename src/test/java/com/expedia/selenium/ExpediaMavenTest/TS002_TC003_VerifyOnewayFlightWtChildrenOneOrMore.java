package com.expedia.selenium.ExpediaMavenTest;

import org.testng.annotations.Test;

import com.expedia.selenium.ExpediaMavenTest.utilities.AbstractTest;

public class TS002_TC003_VerifyOnewayFlightWtChildrenOneOrMore extends AbstractTest{
	
	/*
	 * Verify Oneway flight from New York to Dhaka on departing date as 
	 * 12/05/2015 and Children more than zero and ages 2 or more
	 * 
	 */

	@Test(description = "Verify Oneway Flight from Home Screen with children ages greater than 1")
	public void onewayFlightWtChildrenAgesGt1() throws Exception{
		String departure = "New York";
		String destination = "Dhaka";
		homeScreen().clickOnFlightButton();
		homeScreen().clickOnOnewayButton();
		homeScreen().clearFlyingFromCity();
		homeScreen().enterFlyingFromCity(departure);
		homeScreen().clearFlyingToCity();
		homeScreen().enterFlyingToCity(destination);
		homeScreen().clearDepartingDate();
		homeScreen().setDepartingDate("03/05/2016");
		homeScreen().selectChildren(4);
		homeScreen().selectOneOrMoreChildAges(2,3,4,5);
		homeScreen().clickOnSearchButton();
		homeScreen().verifyDestInNextPage(destination);
		//driver.navigate().to(expedia);
	}
	
}
