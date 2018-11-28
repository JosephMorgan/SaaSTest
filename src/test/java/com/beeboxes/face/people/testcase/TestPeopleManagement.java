package com.beeboxes.face.people.testcase;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.beeboxes.face.base.InitializeSelenium;
import com.beeboxes.face.base.OperateConfig;
import com.beeboxes.face.base.ReadCSV;
import com.beeboxes.face.base.Wait;
import com.beeboxes.face.page.PageLogin;
import com.beeboxes.face.page.PageMain;
import com.beeboxes.face.page.PagePeopleManagement;

/**
 * Description: SaaS平台-人员管理页-用例
 * @author dengbin
 * @date 2018年11月18日
 * @time 下午10:29:51
 */
public class TestPeopleManagement {
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
	
	@Test(description="进入人员管理页")
	public void getPeopleManagement() {	
		String username = new OperateConfig().getProp("登录账号");
		String password = new OperateConfig().getProp("登录密码");
		PageLogin loginPage = new PageLogin(driver);
		PageMain mainPage = new PageMain(driver);
		
		Reporter.log("步骤1：输入正确用户名");
		loginPage.inputUserName(username);
		Reporter.log("步骤2：输入正确密码");
		loginPage.inputPassword(password);
		Reporter.log("步骤3：点记住账号和密码");
		loginPage.clickRememberAccount();
		Reporter.log("步骤4：点登录平台");
		loginPage.clickLoginBtn();
		Reporter.log("步骤5：点大的人员管理");
		mainPage.clickPeopleManagement();
		driver.switchTo().defaultContent(); 
		Reporter.log("步骤6：点小的人员管理");
		mainPage.clickPersonManagement();
		//Wait.sleep(3000);
        //Assert.assertEquals(driver.getTitle(), "蜂盒云平台2.0"); 
	}
	
	@Test(description="批量添加人员",dependsOnMethods="getPeopleManagement",dataProvider="batchAddPeopleTemplate")
	public void  batchAddingStaff(String excelPath,String imagePath) {
		PagePeopleManagement peopleManagementPage = new PagePeopleManagement(driver);
		
		Wait.sleep(5000);
		Reporter.log("步骤1：点批量导入按钮");
		peopleManagementPage.clickBatchAddBtn();
		Reporter.log("步骤2：导入人员的Excel表");
		peopleManagementPage.clickImportExcel(excelPath);
		Reporter.log("步骤3：导入人员的图片zip");
		peopleManagementPage.clickImportImageZip(imagePath);
		Reporter.log("步骤4：点下一步按钮");
		peopleManagementPage.clickNextStepBtn();
		Wait.sleep(4000);
		Reporter.log("步骤5：点确定按钮");
		peopleManagementPage.clickConfirmBtn();
		Wait.sleep(8000);
		Reporter.log("步骤6：点处理按钮");
		peopleManagementPage.clickResolveBtn();
		Wait.sleep(3000);
		Reporter.log("步骤7：点导入按钮");
		peopleManagementPage.clickImportBtn();
		Wait.sleep(8000);
		Reporter.log("步骤8：点完成按钮");
		peopleManagementPage.clickCompleteBtn();
			
	}

	@DataProvider(name="batchAddPeopleTemplate")	
	public Object[][] providePeopleTemplate() {
		String peopleDataFilePath = new OperateConfig().getProp("批量导入人员的文件路径");
		ArrayList<String[]> dataArrayList = ReadCSV.readCSVFile(peopleDataFilePath);
		int row = dataArrayList.size();
		Object[][] peopleData = new Object[row][2];
		for(int i = 0 ; i < row ; i++) {
			peopleData[i][0] = dataArrayList.get(i)[0];
			peopleData[i][1] = dataArrayList.get(i)[1];
		}		
		return peopleData;
	}
}
