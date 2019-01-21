package com.beeboxes.face.index.testcase;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.beeboxes.face.page.PageIndex;
import com.beeboxes.face.page.PageLogin;
import com.beeboxes.face.page.PageMain;
import com.beeboxes.face.util.OperateConfig;
import com.beeboxes.face.util.ReadXml;
import com.beeboxes.face.util.TestBase;
import com.beeboxes.face.util.Wait;

/**
 * Description: 首页的用例
 * @author dengbin
 * @date 2018年12月10日
 * @time 下午5:12:03
 */
public class TestIndex extends TestBase {
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
	
	@Test(description="进入首页")
	public void getIndex() {
		PageMain mainPage = new PageMain(driver);
		Reporter.log("步骤1：点工作台");
		mainPage.clickWorkbench();
		driver.switchTo().defaultContent(); 
		Reporter.log("步骤2：点首页");
		mainPage.clickHomePage();
		Wait.sleep(2000);
		WebElement deviceAlarm = driver.findElement(By.xpath(ReadXml.getElementByXpath("首页页面", "设备预警")));
		Assert.assertEquals("设备预警", deviceAlarm.getText());
	}
	
	@Test(description="打开访客系统")
	public void getGuestSystem() {
		PageIndex indexPage = new PageIndex(driver);
		String guestSystemExpecTitle = new OperateConfig().getProp("访客管理系统标题");
		Reporter.log("步骤1：点访客系统");
		indexPage.clickGuestSystem();
		Wait.sleep(2000);
		WebElement guestSystemFrame = driver.findElement(By.xpath(ReadXml.getElementByXpath("访客系统主页面", "访客管理系统frame框架")));
		driver.switchTo().frame(guestSystemFrame);
		WebElement guestSystemTitle = driver.findElement(By.xpath(ReadXml.getElementByXpath("访客系统主页面", "访客管理系统标题")));
		Assert.assertEquals(guestSystemExpecTitle, guestSystemTitle.getText());

	}
}
