package com.mystore.base;
import java.io.*;
import java.util.*;




import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeTest;



import com.mystore.actiondriver.Action;



import io.github.bonigarcia.wdm.WebDriverManager;



public class BaseClass {
public static Properties prop;
public static WebDriver driver;

@BeforeTest
public void loadConfig()
{
try {
prop = new Properties();
System.out.println("Super constructor invoked");
FileInputStream ip = new FileInputStream(
System.getProperty("user.dir")+"\\configuration\\Config.Properties");
prop.load(ip);
System.out.println("driver:"+driver);
}
catch(FileNotFoundException e) {
e.printStackTrace();
}
catch(IOException e) {
e.printStackTrace();
}
}

public void launchApp()
{
WebDriverManager.chromedriver().setup();
//WebDriverManager.geckodriver().setup();
String browsername = prop.getProperty("browser");
if(browsername.contains("chrome"))
driver = new ChromeDriver();
else if(browsername.contains("firefox")) {
System.setProperty("webdriver.gecko.driver","C:\\Users\\Admin\\Downloads\\geckodriver-v0.30.0-win64\\geckodriver.exe");
driver=new FirefoxDriver();
}

Action ac = new Action();
ac.implicitWait(driver,10);
ac.pageLoadTimeOut(driver,30);
driver.get(prop.getProperty("url"));
driver.manage().window().maximize();
}



public static void getDriver() {
// Get Driver from threadLocalmap
driver.quit();
}

public boolean findElement(WebDriver driver, WebElement ele) throws Throwable {
// TODO Auto-generated method stub
return false;
}



}
