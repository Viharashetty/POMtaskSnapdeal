package com.mystore.pageobjects;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.mystore.actiondriver.Action;
import com.mystore.base.BaseClass;



public class SearchResultPage extends BaseClass {

Action action= new Action();

@FindBy(xpath="//span[text()='add to cart']")
private WebElement addToCartBtn;

@FindBy(xpath="//a[text()='Proceed To Checkout']")
private WebElement proceedBtn;


@FindBy(xpath="//img[@class='product-image '] ")
private WebElement productResult;

public SearchResultPage() {
PageFactory.initElements(driver, this);
}

public boolean isProductAvailable() throws Throwable {
return action.isDisplayed(driver, productResult);
}

public boolean clickOnProduct() throws Throwable {
action.click(driver, productResult);
Thread.sleep(3000);
Set<String> window =driver.getWindowHandles();
Iterator<String> it = window.iterator();
String parentwind = it.next();
System.out.println(parentwind);
String childwind = it.next();
driver.switchTo().window(childwind);
action.click(driver, addToCartBtn);
return action.isDisplayed(driver, proceedBtn);

}

}