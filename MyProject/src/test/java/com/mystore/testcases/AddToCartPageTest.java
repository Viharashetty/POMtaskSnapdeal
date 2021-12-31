package com.mystore.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.mystore.base.BaseClass;
import com.mystore.pageobjects.IndexPage;
import com.mystore.pageobjects.SearchResultPage;


public class AddToCartPageTest extends BaseClass {

	private IndexPage index;
	private SearchResultPage searchResultPage;
	

	@BeforeMethod
	public void setup() {
		launchApp();
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	@Test
	public void addToCartTest() throws Throwable {
		index= new IndexPage();
		searchResultPage=index.searchProduct("Puchmukhi Rudraksha Mala");
		boolean result=searchResultPage.clickOnProduct();
		Assert.assertTrue(result);

	}
}