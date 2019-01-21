package com.beeboxes.face.main.testcase;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.beeboxes.face.page.PageLogin;
import com.beeboxes.face.page.PageMain;
import com.beeboxes.face.util.OperateConfig;
import com.beeboxes.face.util.ReadXml;
import com.beeboxes.face.util.TestBase;
import com.beeboxes.face.util.Wait;

/**
 * Description: SaaS平台-主页-用例
 * @author dengbin
 * @date 2018年11月17日
 * @time 下午13:10:14
 */
public class TestMain extends TestBase {
	
	@Test(description="用正确账号登录")
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
		Assert.assertEquals(driver.getTitle(),mainWindowTitle);
	}
	
	@Test(description="点开主页左侧栏的各个页面")
	public void tesLeftColumn(){
		PageMain mainPage = new PageMain(driver);
		Reporter.log("步骤1：点工作台");
		mainPage.clickWorkbench();
		driver.switchTo().defaultContent(); 
		Reporter.log("步骤2：点首页");
		mainPage.clickHomePage();
		Wait.sleep(2000);
		WebElement deviceAlarm = driver.findElement(By.xpath(ReadXml.getElementByXpath("首页页面", "设备预警")));
		Assert.assertEquals("设备预警", deviceAlarm.getText());
		driver.switchTo().defaultContent(); 
		Reporter.log("步骤3：点预警中心");
		mainPage.clickAlarmCenter();
		Wait.sleep(2000);
		WebElement searchAlarmBtn = driver.findElement(By.xpath(ReadXml.getElementByXpath("预警中心页面", "搜索按钮")));
		Assert.assertEquals("搜 索", searchAlarmBtn.getText());
		driver.switchTo().defaultContent(); 
		Reporter.log("步骤4：点操作日志");
		mainPage.clickOperationLog();
		Wait.sleep(2000);
		WebElement searchLogBtn = driver.findElement(By.xpath(ReadXml.getElementByXpath("操作日志页面", "搜索按钮")));
		Assert.assertEquals("搜 索", searchLogBtn.getText());
		driver.switchTo().defaultContent(); 
		
		Reporter.log("步骤5：点大的人员管理");
		mainPage.clickPeopleManagement();
		driver.switchTo().defaultContent(); 
		Reporter.log("步骤6：点小的人员管理");
		mainPage.clickPersonManagement();
		Wait.sleep(2000);
		WebElement searchPeopleBtn = driver.findElement(By.xpath(ReadXml.getElementByXpath("人员管理页面", "搜索按钮")));
		Assert.assertEquals("搜 索", searchPeopleBtn.getText());
		
		Reporter.log("步骤7：点大的设备管理");
		mainPage.clickDeviceManagement();
		Reporter.log("步骤8：点小的设备管理");
		mainPage.clickEquipmentManagement();
		Wait.sleep(2000);
		WebElement searchDeviceBtn = driver.findElement(By.xpath(ReadXml.getElementByXpath("设备管理页面", "搜索按钮")));
		Assert.assertEquals("搜 索", searchDeviceBtn.getText());
		Reporter.log("步骤9：点设备分组");
		mainPage.clickDeviceGrouping();
		Wait.sleep(2000);
		WebElement searchDeviceGroupBtn = driver.findElement(By.xpath(ReadXml.getElementByXpath("设备分组页面", "搜索按钮")));
		Assert.assertEquals("搜 索", searchDeviceGroupBtn.getText());
		Reporter.log("步骤10：点管理员");
		mainPage.clickAdministrator();
		Wait.sleep(2000);
		WebElement searchAdministratorBtn = driver.findElement(By.xpath(ReadXml.getElementByXpath("管理员页面", "搜索按钮")));
		Assert.assertEquals("搜 索", searchAdministratorBtn.getText());
		Reporter.log("步骤11：点配置管理");
		mainPage.clickConfigManagement();
		Wait.sleep(2000);
		WebElement chooseDeviceSynchronizationBtn = driver.findElement(By.xpath(ReadXml.getElementByXpath("配置管理页面", "选择设备并同步按钮")));
		Assert.assertEquals("选择设备并同步", chooseDeviceSynchronizationBtn.getText());
		Reporter.log("步骤12：点命令下发记录");
		mainPage.clickRecordOfCommand();
		Wait.sleep(2000);
		WebElement searchCommandRecordBtn = driver.findElement(By.xpath(ReadXml.getElementByXpath("命令下发记录页面", "搜索按钮")));
		Assert.assertEquals("搜 索", searchCommandRecordBtn.getText());
		
		Reporter.log("步骤13：点权限管理");
		mainPage.clickAuthorityManagement();
		Reporter.log("步骤14：点角色管理");
		mainPage.clickRoleManagement();
		Wait.sleep(2000);
		WebElement addRoleBtn = driver.findElement(By.xpath(ReadXml.getElementByXpath("角色管理页面", "新增角色按钮")));
		Assert.assertEquals("新增角色", addRoleBtn.getText());
		Reporter.log("步骤15：点权限分配");
		mainPage.clickAuthorityAllocation();
		Wait.sleep(2000);
		WebElement searchAccountBtn = driver.findElement(By.xpath(ReadXml.getElementByXpath("权限分配页面", "搜索按钮")));
		Assert.assertEquals("搜 索", searchAccountBtn.getText());
		
		Reporter.log("步骤16：点数据管理");
		mainPage.clickDataManagement();
		Reporter.log("步骤17：点通行记录");
		mainPage.clickThroughRecord();
		Wait.sleep(2000);
		WebElement searchThroughRecordBtn = driver.findElement(By.xpath(ReadXml.getElementByXpath("通行记录页面", "搜索按钮")));
		Assert.assertEquals("搜 索", searchThroughRecordBtn.getText());
		
		Reporter.log("步骤18：点业务管理");
		mainPage.clickBusinessManagement();
		Reporter.log("步骤19：点通行规则");
		mainPage.clickThroughRule();
		Wait.sleep(2000);
		WebElement addThroughRuleBtn = driver.findElement(By.xpath(ReadXml.getElementByXpath("通行规则页面", "新增通行规则按钮")));
		Assert.assertEquals("新增通行规则", addThroughRuleBtn.getText());
		Reporter.log("步骤20：点规则下发");
		mainPage.clickRulesSentDown();
		Wait.sleep(2000);
		WebElement synchronizationDevice = driver.findElement(By.xpath(ReadXml.getElementByXpath("规则下发页面", "同步设备标签")));
		Assert.assertEquals("同步设备", synchronizationDevice.getText());
		
		Reporter.log("步骤21：点应用管理");
		mainPage.clickApplicationManagement();
		Reporter.log("步骤22：点微信授权");
		mainPage.clickWechatAuthorization();
		Wait.sleep(2000);
		WebElement wechatAuthorizationBtn = driver.findElement(By.xpath(ReadXml.getElementByXpath("微信授权页面", "去授权按钮")));
		Assert.assertEquals("去授权", wechatAuthorizationBtn.getText());
		
		Reporter.log("步骤23：点系统管理");
		mainPage.clickSystemManagement();
		Reporter.log("步骤24：点组织架构");
		mainPage.clickOrganizationalStructure();
		Wait.sleep(2000);
		WebElement addOrganizationBtn = driver.findElement(By.xpath(ReadXml.getElementByXpath("组织架构页面", "新增按钮")));
		Assert.assertEquals("新增", addOrganizationBtn.getText());
	}
	
}
