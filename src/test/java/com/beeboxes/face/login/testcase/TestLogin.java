package com.beeboxes.face.login.testcase;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.beeboxes.face.base.InitializeSelenium;
import com.beeboxes.face.base.OperateConfig;
import com.beeboxes.face.base.ReadXml;
import com.beeboxes.face.base.Wait;
import com.beeboxes.face.page.PageLogin;

/**
 * Description: SaaS平台-登录页-用例
 * 
 * @author dengbin
 * @date 2018年11月13日
 * @time 下午2:58:14
 */
public class TestLogin {
	public WebDriver driver;

	@BeforeClass
	public void setUp() {
		driver = InitializeSelenium.useChrome(driver);
		driver.get(new OperateConfig().getProp("SaaS地址"));
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);// 全局最长等10秒
	}

	@Test
	public void testLogin() {	
		String username = new OperateConfig().getProp("登录账号");
		String password = new OperateConfig().getProp("登录密码");
		
		new PageLogin(driver).inputUserName(username);
		driver.findElement(By.name(ReadXml.getElementByName("登录页面","账号密码"))).sendKeys(password);
		//new Actions(driver).sendKeys(Keys.ENTER).perform();
		driver.findElement(By.xpath(ReadXml.getElementByXpath("登录页面", "登录平台"))).click();
		
		driver.findElement(By.xpath(ReadXml.getElementByXpath("首页左侧栏", "大的设备管理"))).click();//设备管理
		driver.findElement(By.xpath(ReadXml.getElementByXpath("首页左侧栏", "小的设备管理"))).click();//设备管理
				
		//Screenshot.snapshot((TakesScreenshot)driver, "设备管理.png");
	}
	
	@Test(invocationCount=5000000,threadPoolSize=1)
	public void testDeviceReboot() {
		String sn1 = new OperateConfig().getProp("设备sn1");
		String sn2 = new OperateConfig().getProp("设备sn2");
		String sn3 = new OperateConfig().getProp("设备sn3");
		
		Wait.sleep(5000);		
		driver.findElement(By.xpath(ReadXml.getElementByXpath("设备管理页面", "sn号搜索框"))).sendKeys(Keys.CONTROL + "a");
		driver.findElement(By.xpath(ReadXml.getElementByXpath("设备管理页面", "sn号搜索框"))).sendKeys(sn3);//输入sn
		driver.findElement(By.xpath(ReadXml.getElementByXpath("设备管理页面", "搜索按钮"))).click();//点搜索

        Wait.sleep(5000);
		
		driver.findElement(By.xpath(ReadXml.getElementByXpath("设备管理页面", "第一个勾选框"))).click();//点勾选框
		driver.findElement(By.xpath(ReadXml.getElementByXpath("设备管理页面", "重启按钮"))).click();//点重启
		
//		Wait.sleep(5000);
//	
//		//又搜索一设备再重启
//		driver.findElement(By.xpath(ReadXml.getElementByXpath("设备管理页面", "sn号搜索框"))).sendKeys(Keys.CONTROL + "a");
//		driver.findElement(By.xpath(ReadXml.getElementByXpath("设备管理页面", "sn号搜索框"))).sendKeys(sn2);//输入sn
//		driver.findElement(By.xpath(ReadXml.getElementByXpath("设备管理页面", "搜索按钮"))).click();//点搜索
//		
//		Wait.sleep(5000);
//		
//		driver.findElement(By.xpath(ReadXml.getElementByXpath("设备管理页面", "第一个勾选框"))).click();//点勾选框
		//driver.findElement(By.xpath(ReadXml.getElementByXpath("设备管理页面", "重启按钮"))).click();//点重启	
	}

	@AfterClass
	public void tearDown() {
		Wait.sleep(5000);
		driver.quit();
	}
}
