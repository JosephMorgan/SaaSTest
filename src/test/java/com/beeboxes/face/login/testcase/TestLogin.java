package com.beeboxes.face.login.testcase;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.beeboxes.face.page.PageLogin;
import com.beeboxes.face.util.OperateConfig;
import com.beeboxes.face.util.TestBase;
import com.beeboxes.face.util.Wait;

/**
 * Description: SaaS平台-登录页-用例
 * @author dengbin
 * @date 2018年11月13日
 * @time 下午2:58:14
 */
//@Listeners({ DotTestListener.class })
public class TestLogin extends TestBase{

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
		Assert.assertEquals(driver.getTitle(), mainWindowTitle);
	}
}
