package com.beeboxes.face.login.testcase;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.beeboxes.face.base.AssertContent;
import com.beeboxes.face.base.DotTestListener;
import com.beeboxes.face.base.OperateConfig;
import com.beeboxes.face.base.ReadXml;
import com.beeboxes.face.base.TestBase;
import com.beeboxes.face.base.Wait;
import com.beeboxes.face.page.PageLogin;

/**
 * Description: SaaS平台-登录页-用例
 * @author dengbin
 * @date 2018年11月13日
 * @time 下午2:58:14
 */
@Listeners({ DotTestListener.class })
public class TestLogin extends TestBase{

	@Test(description="用正确账号登录")
	public void testLogin() {	
		String username = new OperateConfig().getProp("登录账号");
		String password = new OperateConfig().getProp("登录密码");
		PageLogin loginPage = new PageLogin(driver);
		
		Reporter.log("步骤1：输入正确用户名");
		loginPage.inputUserName(username);
		Reporter.log("步骤2：输入正确密码");
		loginPage.inputPassword(password);
		Reporter.log("步骤3：点记住账号和密码");
		loginPage.clickRememberAccount();
		Reporter.log("步骤4：点登录平台");
		loginPage.clickLoginBtn();
		Wait.sleep(2000);
		AssertContent.assertByTitle(driver, "蜂盒云平台2.0", "登录失败");
	}
	
	@Test(invocationCount=1,threadPoolSize=1)
	public void testDeviceReboot() {
		String sn1 = new OperateConfig().getProp("设备sn1");
		//String sn2 = new OperateConfig().getProp("设备sn2");
		//String sn3 = new OperateConfig().getProp("设备sn3");
		driver.findElement(By.xpath(ReadXml.getElementByXpath("首页左侧栏", "大的设备管理"))).click();
		driver.findElement(By.xpath(ReadXml.getElementByXpath("首页左侧栏", "小的设备管理"))).click();
		Wait.sleep(5000);		
		driver.findElement(By.xpath(ReadXml.getElementByXpath("设备管理页面", "sn号搜索框"))).sendKeys(Keys.CONTROL + "a");
		driver.findElement(By.xpath(ReadXml.getElementByXpath("设备管理页面", "sn号搜索框"))).sendKeys(sn1);//输入sn
		driver.findElement(By.xpath(ReadXml.getElementByXpath("设备管理页面", "搜索按钮"))).click();//点搜索

        Wait.sleep(5000);	
		driver.findElement(By.xpath(ReadXml.getElementByXpath("设备管理页面", "第一个勾选框"))).click();//点勾选框
		//driver.findElement(By.xpath(ReadXml.getElementByXpath("设备管理页面", "重启按钮"))).click();//点重启
	}
}
