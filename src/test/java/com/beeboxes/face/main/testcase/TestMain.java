package com.beeboxes.face.main.testcase;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
//import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.beeboxes.face.page.PageLogin;
import com.beeboxes.face.page.PageMain;
import com.beeboxes.face.util.InitializeSelenium;
import com.beeboxes.face.util.OperateConfig;
import com.beeboxes.face.util.Wait;

/**
 * Description: SaaS平台-主页-用例
 * @author dengbin
 * @date 2018年11月17日
 * @time 下午13:10:14
 */
public class TestMain {
	public WebDriver driver;

	@BeforeClass
	public void setUp() {
		driver = InitializeSelenium.useChrome(driver);
		driver.get(new OperateConfig().getProp("SaaS地址"));
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	@AfterClass
	public void tearDown() {
		Wait.sleep(5000);
		driver.quit();
	}
	
	@Test(description="用正确账号登录")
	public void testLogin() {	
		String username = new OperateConfig().getProp("登录账号");
		String password = new OperateConfig().getProp("登录密码");
		PageLogin loginPage = new PageLogin(driver);
		
		Reporter.log("-----------步骤1：输入正确用户名-----------");
		loginPage.inputUserName(username);
		Reporter.log("步骤2：输入正确密码");
		loginPage.inputPassword(password);
		Reporter.log("步骤3：点记住账号和密码");
		loginPage.clickRememberAccount();
		Reporter.log("步骤4：点登录平台");
		loginPage.clickLoginBtn();
		//Wait.sleep(3000);
        //Assert.assertEquals(driver.getTitle(), "蜂盒云平台2.0"); 
	}
	
	@Test(description="点开主页左侧栏的各个页面",dependsOnMethods="testLogin")
	public void testMain(){
		PageMain mainPage = new PageMain(driver);
		Reporter.log("-----------步骤1：点工作台-----------");
		mainPage.clickWorkbench();
		driver.switchTo().defaultContent(); 
		Reporter.log("步骤2：点首页");
		mainPage.clickHomePage();
		driver.switchTo().defaultContent(); 
		Reporter.log("步骤3：点预警中心");
		mainPage.clickAlarmCenter();
		driver.switchTo().defaultContent(); 
		Reporter.log("步骤4：点操作日志");
		mainPage.clickOperationLog();
		driver.switchTo().defaultContent(); 
		Reporter.log("----------步骤5：点大的人员管理----------");
		mainPage.clickPeopleManagement();
		driver.switchTo().defaultContent(); 
		Reporter.log("步骤6：点小的人员管理");
		mainPage.clickPersonManagement();
		Reporter.log("----------步骤7：点大的设备管理----------");
		mainPage.clickDeviceManagement();
		Reporter.log("步骤8：点小的设备管理");
		mainPage.clickEquipmentManagement();
		Reporter.log("步骤9：点设备分组");
		mainPage.clickDeviceGrouping();
		Reporter.log("步骤10：点管理员");
		mainPage.clickAdministrator();
		Reporter.log("步骤11：点配置管理");
		mainPage.clickConfigManagement();
		Reporter.log("步骤12：点命令下发记录");
		mainPage.clickRecordOfCommand();
		Reporter.log("----------步骤13：点权限管理----------");
		mainPage.clickAuthorityManagement();
		Reporter.log("步骤14：点角色管理");
		mainPage.clickRoleManagement();
		Reporter.log("步骤15：点权限分配");
		mainPage.clickAuthorityAllocation();
		Reporter.log("----------步骤16：点数据管理----------");
		mainPage.clickDataManagement();
		Reporter.log("步骤17：点通行记录");
		mainPage.clickThroughRecord();
		Reporter.log("----------步骤18：点业务管理----------");
		mainPage.clickBusinessManagement();
		Reporter.log("步骤19：点通行规则");
		mainPage.clickThroughRule();
		Reporter.log("步骤20：点规则下发");
		mainPage.clickRulesSentDown();
		Reporter.log("----------步骤21：点应用管理----------");
		mainPage.clickApplicationManagement();
		Reporter.log("步骤22：点微信授权");
		mainPage.clickWechatAuthorization();
		Reporter.log("----------步骤23：点系统管理----------");
		mainPage.clickSystemManagement();
		Reporter.log("步骤24：点组织架构");
		mainPage.clickOrganizationalStructure();
	}
	
}
