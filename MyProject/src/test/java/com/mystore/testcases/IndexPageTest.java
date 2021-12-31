
package com.mystore.testcases;import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;import com.mystore.base.BaseClass;
import com.mystore.pageobjects.IndexPage;public class IndexPageTest extends BaseClass {
IndexPage indexPage; @BeforeMethod
public void setup() {
launchApp();
} @AfterMethod
public void tearDown() {
driver.close();
} @Test
public void verifyLogo() throws Throwable {
indexPage= new IndexPage();
boolean result=indexPage.validateLogo();
Assert.assertTrue(result);
}
@Test
public void verifyTitle() {
String actTitle=indexPage.getMyStoreTitle();
Assert.assertEquals(actTitle, "Shop Online for Men, Women & Kids Clothing, Shoes, Home Decor Items"); }
}

