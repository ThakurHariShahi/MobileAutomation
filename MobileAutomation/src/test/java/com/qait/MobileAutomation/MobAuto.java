package com.qait.MobileAutomation;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class MobAuto {
	AppiumDriver<MobileElement> d;
	URL u;
	String s1,s2;
	
	
	@BeforeTest
	public void setUp() throws MalformedURLException {
		
	DesiredCapabilities a=new DesiredCapabilities();
	
	a.setCapability("deviceName", "emulator-5554"); 
	a.setCapability("platformName", "Android");
	a.setCapability("app", "C:/Users/harishahi/Downloads/flipkart.apk");
	a.setCapability("platformVersion", "7.0");
	a.setCapability("automationName", "Appium");
	a.setCapability("appPackage", "com.android.chrome");
	
		u=new URL("http://0.0.0.0:4723/wd/hub");
		d=new AppiumDriver<MobileElement>(u,a);
	}
	@Test
	public void test() {
		
		d.get("https://google.com");
        d.findElement(By.name("q")).sendKeys("www.qainfotech.com");
        d.findElement(By.name("q")).sendKeys(Keys.ENTER);
        s1= "QA InfoTech";
        s2 = d.findElement(By.xpath("(//span[text()=\"QA InfoTech\"])[1]")).getText();
        Assert.assertEquals(s1, s2,"Wrong Page");
		System.out.println("first test");
		
		
	}
	
	@AfterTest
	public void tearDown() {
		d.quit();
	}

 }
