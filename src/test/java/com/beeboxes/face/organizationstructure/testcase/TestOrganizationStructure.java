package com.beeboxes.face.organizationstructure.testcase;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.beeboxes.face.page.PageLogin;
import com.beeboxes.face.page.PageMain;
import com.beeboxes.face.page.PageOrganizationalStructure;
import com.beeboxes.face.util.OperateConfig;
import com.beeboxes.face.util.ReadXml;
import com.beeboxes.face.util.TestBase;
import com.beeboxes.face.util.Wait;

/**
 * Description: 组织架构的用例
 * @author dengbin
 * @date 2018年12月10日
 * @time 下午5:12:03
 */
public class TestOrganizationStructure extends TestBase {
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
	
	@Test(description="进入组织架构页")
	public void getOrganizationStructure() {
		PageMain mainPage = new PageMain(driver);
		Reporter.log("步骤1：点系统管理");
		mainPage.clickSystemManagement();
		Reporter.log("步骤2：点组织架构");
		mainPage.clickOrganizationalStructure();
		Wait.sleep(2000);
		WebElement addOrganizationBtn = driver.findElement(By.xpath(ReadXml.getElementByXpath("组织架构页面", "新增按钮")));
		Assert.assertEquals("新增", addOrganizationBtn.getText());
	}
	
	@Test(description="添加组织")
	public void testAddGroup() {
		PageOrganizationalStructure groupPage = new PageOrganizationalStructure(driver);
		String name = new OperateConfig().getProp("新增的组织名称");

		Reporter.log("步骤1：点新增组织");
		groupPage.clickAddGroup();
		Reporter.log("步骤2：输入新增组织的名称");
		groupPage.inputAddGroupName(name);
		Reporter.log("步骤3：新增组织点确定");
		groupPage.clickAddGroupConfirm();
	}
	
}
