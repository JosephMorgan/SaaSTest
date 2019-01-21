package com.beeboxes.face.device.testcase;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.beeboxes.face.page.PageDeviceManagement;
import com.beeboxes.face.page.PageLogin;
import com.beeboxes.face.page.PageMain;
import com.beeboxes.face.util.OperateConfig;
import com.beeboxes.face.util.ReadXml;
import com.beeboxes.face.util.TestBase;
import com.beeboxes.face.util.Wait;

/**
 * Description: SaaS平台-设备管理页-用例
 * @author dengbin
 * @date 2018年12月1日
 * @time 下午6:59:24
 */
public class TestDeviceManagement extends TestBase {
	
	@Test(description="登录SaaS平台")
	public void testLogin() {
		String username = new OperateConfig().getProp("登录账号");
		String password = new OperateConfig().getProp("登录密码");
		String mainWindowTitle = new OperateConfig().getProp("首页窗口标题");
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
		Assert.assertEquals(driver.getTitle(), mainWindowTitle);	
	}
	
	@Test(description="进入设备管理页")
	public void getDeviceManagement() {
		PageMain mainPage = new PageMain(driver);
		Reporter.log("步骤1：点大的设备管理");
		mainPage.clickDeviceManagement();
		driver.switchTo().defaultContent(); 
		Reporter.log("步骤2：点小的设备管理");
		mainPage.clickEquipmentManagement();
		Wait.sleep(2000);
		WebElement rebootDeviceBtn = driver.findElement(By.xpath(ReadXml.getElementByXpath("设备管理页面", "重启按钮")));
		Assert.assertEquals("重启", rebootDeviceBtn.getText());
	}
	
	@Test(description="用sn搜索设备")
	public void testDeviceSearchBySN() {
		String sn1 = new OperateConfig().getProp("设备sn1");
		PageDeviceManagement pageDeviceManagement = new PageDeviceManagement(driver);
		Reporter.log("步骤1：输入sn");
		pageDeviceManagement.inputSn(sn1);
		Reporter.log("步骤2：点搜索按钮");
		pageDeviceManagement.clickSearchBtn();
		Wait.sleep(2000);
		WebElement searchResultSn = driver.findElement(By.xpath(ReadXml.getElementByXpath("设备管理页面", "搜索结果的sn")));
		Assert.assertEquals(sn1, searchResultSn.getText());
		
	}
	
	@Test(description="重启设备",invocationCount=1,threadPoolSize=1)
	public void testDeviceReboot() {
		String sn1 = new OperateConfig().getProp("设备sn1");
		PageDeviceManagement pageDeviceManagement = new PageDeviceManagement(driver);
		Reporter.log("步骤1：输入sn");
		pageDeviceManagement.inputSn(sn1);
		Reporter.log("步骤2：点搜索按钮");
		Wait.sleep(3000);
		pageDeviceManagement.clickSearchBtn();
		Wait.sleep(5000);	
		Reporter.log("步骤3：勾选设备");
		pageDeviceManagement.clickFirstCheckBox();
		Reporter.log("步骤4：点重启");
		pageDeviceManagement.clickRebootDeviceBtn();
	}
	
	@Test(description="获取设备激活码")
	public void testActivationCode() {
		//String  terminalTestConfigPath = new File(System.getProperty("user.dir")).getParentFile().toString();
		//String filePath = terminalTestConfigPath+File.separator + "config"+ File.separator + "test.properties";
		PageDeviceManagement pageDeviceManagement = new PageDeviceManagement(driver);
		Reporter.log("步骤1：点设备激活码按钮");
		pageDeviceManagement.clickActivationCodeBtn();
		Wait.sleep(2000);
		Reporter.log("步骤2：获取激活码");
		WebElement activationCode = driver.findElement(By.xpath(ReadXml.getElementByXpath("设备管理页面", "激活码")));
		Reporter.log("激活码："+activationCode.getText());
		//new OperateConfig(filePath).setProp("激活码1", activationCode.getText());
		
		
	}
}
