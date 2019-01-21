package com.beeboxes.face.throughrule.testcase;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.beeboxes.face.page.PageLogin;
import com.beeboxes.face.page.PageMain;
import com.beeboxes.face.page.PageThroughRule;
import com.beeboxes.face.util.OperateConfig;
import com.beeboxes.face.util.ReadXml;
import com.beeboxes.face.util.TestBase;
import com.beeboxes.face.util.Wait;

/**
 * Description: 通行规则的用例
 * @author dengbin
 * @date 2018年12月10日
 * @time 下午5:12:03
 */
public class TestThroughRule extends TestBase {
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
		Assert.assertEquals(driver.getTitle(),mainWindowTitle);	
	}
	
	@Test(description="进入通行规则页")
	public void getThroughRule() {
		PageMain mainPage = new PageMain(driver);
		Reporter.log("步骤1：点业务管理");
		mainPage.clickBusinessManagement();
		driver.switchTo().defaultContent(); 
		Reporter.log("步骤2：点通行规则页");
		mainPage.clickThroughRule();
		Wait.sleep(2000);
		WebElement addThroughRuleBtn = driver.findElement(By.xpath(ReadXml.getElementByXpath("通行规则页面", "新增通行规则按钮")));
		Assert.assertEquals("新增通行规则", addThroughRuleBtn.getText());
	}
	
	@Test(description="添加通行规则")
	public void testAddThroughRule() {
		String throughRulename = new OperateConfig().getProp("通行规则名称");
		String timeRulename = new OperateConfig().getProp("时间规则名称");
		String startTime = new OperateConfig().getProp("时间规则开始时间");
		String endTime = new OperateConfig().getProp("时间规则结束时间");
		PageThroughRule throughRulePage = new PageThroughRule(driver);
		
		Reporter.log("步骤1：点新增通行规则");
		throughRulePage.clickAddThoughRule();
		Reporter.log("步骤2：输入通行规则名称");
		throughRulePage.inputRuleName(throughRulename);
		Reporter.log("步骤3：通行方式选人脸");
		throughRulePage.selectThroughByFace();
		Reporter.log("步骤4：点时间规则");
		throughRulePage.clickTimeRuleBtn();
		Wait.sleep(2000);
		Reporter.log("步骤5：输入时间规则名称");
		throughRulePage.inputTimeRuleName(timeRulename);
		Reporter.log("步骤6：时间规则日期选长期");
		throughRulePage.selectTimeRuleLongTerm();
		Reporter.log("步骤7：时间规则星期选星期一");
		throughRulePage.selectTimeRuleMonday();
		Reporter.log("步骤8：时间选00:00:00至23:59:59");
		throughRulePage.inputTimeRuleStartTime(startTime);
		throughRulePage.inputTimeRuleEndTime(endTime);
		throughRulePage.clickTimeControlConfirm();
		throughRulePage.inputTimeRuleStartTime(startTime);
		throughRulePage.inputTimeRuleEndTime(endTime);
		throughRulePage.clickTimeControlConfirm();
		Wait.sleep(1000);
		Reporter.log("步骤9：通行方式选允许通行");
		throughRulePage.clickThroughWayDropDownBox();
		Wait.sleep(1000);
		throughRulePage.clickthroughWayPass();
		Reporter.log("步骤10：时间规则点确定");
		throughRulePage.clickTimeRuleConfirm();
		Wait.sleep(1000);
		Reporter.log("步骤11：下发方式选组织下发");
		throughRulePage.clickSendWayDropDownBox();
		throughRulePage.clickSentByOrganization();
		Wait.sleep(1000);
		Reporter.log("步骤12：选所有的组织");
		throughRulePage.clickAllOrganization();
		Reporter.log("步骤13：把选了的组织移到右边");
		throughRulePage.clickSelectedOrganization();
		Reporter.log("步骤14：通行规则点确定");
		throughRulePage.clickOrganizationConfirm();

	}
	
}
