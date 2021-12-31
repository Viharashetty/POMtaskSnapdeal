
package com.mystore.testcases;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;import com.mystore.base.BaseClass;
import com.mystore.pageobjects.IndexPage;
import com.mystore.pageobjects.SearchResultPage;public class SearchResultPageTest extends BaseClass {
IndexPage indexPage;
SearchResultPage searchResultPage;
@BeforeMethod
public void setup() {
launchApp();
} @AfterMethod
public void tearDown() {
//driver.close();
} @Test
public void productAvailabilityTest() throws Throwable {
indexPage= new IndexPage();
searchResultPage=indexPage.searchProduct("Puchmukhi Rudraksha Mala");
Thread.sleep(3000);
boolean result=searchResultPage.isProductAvailable();
Assert.assertTrue(result);
}
}

