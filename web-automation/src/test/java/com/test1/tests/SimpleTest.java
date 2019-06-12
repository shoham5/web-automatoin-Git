package com.test1.tests;

import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import org.testng.annotations.Test;

import com.pages.HomePagePom;

import com.pages.LoginPom;


	public class SimpleTest {
		  WebDriver driver;

    LoginPom objLogin;

    HomePagePom objHomePage;

    // prepring 
    
    @BeforeTest

    public void setup(){
    	//System.setProperty("webdriver.chrome.driver", "D:\\chromedriver\\chromedriver.exe");
    	System.setProperty("webdriver.gecko.driver", "D:\\gekodriver\\geckodriver.exe");
    
    	driver = new FirefoxDriver();
    	//driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.get("http://demo.guru99.com/V4/");

    }

    /**

     * This test case will login in http://demo.guru99.com/V4/

     * Verify login page title as mgr123

     * Login to application

     * Verify the home page using Dashboard message

     */

    @Test(priority=0)

    public void test_Home_Page_Appear_Correct()
    {

        //Create Login Page object

    objLogin = new LoginPom(driver);

    //Verify login page title

    String loginPageTitle = objLogin.getLoginTitle();

    Assert.assertTrue(loginPageTitle.toLowerCase().contains("guru99 bank"));

    //login to application

    objLogin.loginToGit("mgr123", "mgr!23");

    // go the next page

    objHomePage = new HomePagePom(driver);

    //Verify home page

    Assert.assertTrue(objHomePage.getHomePageDashboardUserName().toLowerCase().contains("manger id : mgr123"));

	
    }
    @AfterTest
    public void firefoxClose(){
    	 driver.quit();
    }

    
}
