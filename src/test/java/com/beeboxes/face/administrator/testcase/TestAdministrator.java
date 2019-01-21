package com.beeboxes.face.administrator.testcase;

import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.beeboxes.face.page.PageAdministrator;
import com.beeboxes.face.page.PageLogin;
import com.beeboxes.face.page.PageMain;
import com.beeboxes.face.util.OperateConfig;
import com.beeboxes.face.util.ReadXml;
import com.beeboxes.face.util.TestBase;
import com.beeboxes.face.util.Wait;

/**
 * Description: 设备管理员的用例
 * @author dengbin
 * @date 2018年12月10日
 * @time 下午5:12:03
 */
public class TestAdministrator extends TestBase {
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
	
	@Test(description="进入管理员页")
	public void getAdministrator() {
		PageMain mainPage = new PageMain(driver);
		Reporter.log("步骤1：点大的设备管理");
		mainPage.clickDeviceManagement();
		driver.switchTo().defaultContent(); 
		Reporter.log("步骤2：点开管理员页面");
		mainPage.clickAdministrator();
		Wait.sleep(2000);
		WebElement rebootDeviceBtn = driver.findElement(By.xpath(ReadXml.getElementByXpath("管理员页面", "搜索按钮")));
		Assert.assertEquals("搜 索", rebootDeviceBtn.getText());
	}
	
	@Test(description="添加管理员")
	public void testAddAdministrator() {
		PageAdministrator administratorPage = new PageAdministrator(driver);
		String projectPath = new File(System.getProperty("user.dir")).getParentFile().toString();
		String name = new OperateConfig().getProp("管理员姓名");
		String password = new OperateConfig().getProp("管理员密码");
		String administratorPic = new OperateConfig().getProp("管理员图片路径");
		String picPath = projectPath+File.separator + "data"+ File.separator + "admin"+File.separator+administratorPic;
		
		Reporter.log("步骤1：点新增管理员");
		administratorPage.clickAddAdministrator();
		Reporter.log("步骤2：输入管理员姓名");
		administratorPage.inputAdministratorName(name);
		Reporter.log("步骤3：输入管理员密码");
		administratorPage.inputAdministratorPassword(password);
		Reporter.log("步骤4：上传管理员图片");
		administratorPage.inputAdministratorPic(picPath);
		Reporter.log("步骤5：保存管理员");
		Wait.sleep(2000);
		administratorPage.clickSaveAdministrator();

	}
	
	@Test(description="搜索管理员")
	public void testSearchAdministrator() {
		PageAdministrator administratorPage = new PageAdministrator(driver);
		String name = new OperateConfig().getProp("管理员姓名");
		
		Reporter.log("步骤1：输入管理员姓名");
		administratorPage.inputAdminName(name);
		Reporter.log("步骤2：点管理员搜索");
		administratorPage.clickSearchBtn();
		Wait.sleep(2000);
		WebElement adminSearchResultName = driver.findElement(By.xpath(ReadXml.getElementByXpath("管理员页面", "管理员搜索结果姓名")));
		Assert.assertEquals(name, adminSearchResultName.getText());
		
	}
}
