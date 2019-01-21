package com.beeboxes.face.people.testcase;

import java.io.File;
import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.beeboxes.face.page.PageLogin;
import com.beeboxes.face.page.PageMain;
import com.beeboxes.face.page.PagePeopleManagement;
import com.beeboxes.face.util.OperateConfig;
import com.beeboxes.face.util.ReadCSV;
import com.beeboxes.face.util.ReadXml;
import com.beeboxes.face.util.TestBase;
import com.beeboxes.face.util.Wait;

/**
 * Description: SaaS平台-人员管理页-用例
 * @author dengbin
 * @date 2018年11月18日
 * @time 下午10:29:51
 */
public class TestPeopleManagement extends TestBase {
	
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
	
	@Test(description="进入人员管理页")
	public void getPeopleManagement() {	
		PageMain mainPage = new PageMain(driver);
		Reporter.log("步骤1：点大的人员管理");
		mainPage.clickPeopleManagement();
		driver.switchTo().defaultContent(); 
		Reporter.log("步骤2：点小的人员管理");
		mainPage.clickPersonManagement();
		Wait.sleep(2000);
		WebElement batchImportBtn = driver.findElement(By.xpath(ReadXml.getElementByXpath("人员管理页面", "批量导入按钮")));
		Assert.assertEquals("批量导入", batchImportBtn.getText());
		
	}
	
	@Test(description="批量添加人员",dependsOnMethods="getPeopleManagement",dataProvider="batchAddPeopleTemplate")
	public void  batchAddingStaff(String excelPath,String imagePath) {
		PagePeopleManagement peopleManagementPage = new PagePeopleManagement(driver);
		
		Wait.sleep(3000);
		Reporter.log("步骤1：点批量导入按钮");
		peopleManagementPage.clickBatchAddBtn();
		Reporter.log("步骤2：导入人员的Excel表");
		peopleManagementPage.clickImportExcel(excelPath);
		Reporter.log("步骤3：导入人员的图片zip");
		peopleManagementPage.clickImportImageZip(imagePath);
		Reporter.log("步骤4：点下一步按钮");
		peopleManagementPage.clickNextStepBtn();
		Wait.sleep(30000);
		Reporter.log("步骤5：点确定按钮");
		peopleManagementPage.clickConfirmBtn();
		Wait.sleep(1800000);
		Reporter.log("步骤6：点处理按钮");
		peopleManagementPage.clickResolveBtn();
		Wait.sleep(60000);
		Reporter.log("步骤7：点导入按钮");
		peopleManagementPage.clickImportBtn();
		Wait.sleep(180000);
		Reporter.log("步骤8：点完成按钮");
		peopleManagementPage.clickCompleteBtn();
			
	}
	
	@Test(description="单个添加人员")
	public void testSingleAddPeople() {
		PagePeopleManagement peopleManagementPage = new PagePeopleManagement(driver);
		String projectPath = new File(System.getProperty("user.dir")).getParentFile().toString();
		String name = new OperateConfig().getProp("单个添加人员的姓名");
		String id = new OperateConfig().getProp("单个添加人员的编号");
		String administratorPic = new OperateConfig().getProp("管理员图片路径");
		String picPath = projectPath+File.separator + "data"+ File.separator + "admin"+File.separator+administratorPic;
				
		Reporter.log("步骤1：点新增人员按钮");
		peopleManagementPage.clickSingleAddBtn();
		Reporter.log("步骤2：输入姓名");
		peopleManagementPage.inputSingleAddName(name);
		Reporter.log("步骤3：输入人员编号");
		peopleManagementPage.inputSingleAddId(id);
		Reporter.log("步骤4：上传人脸图片");
		peopleManagementPage.inputSinglePeoplePic(picPath);
		Reporter.log("步骤5：点确定按钮");
		Wait.sleep(2000);
		peopleManagementPage.clickSingleAddSaveBtn();
	}

	@DataProvider(name="batchAddPeopleTemplate")	
	public Object[][] providePeopleTemplate() {
		String projectPath = new File(System.getProperty("user.dir")).getParentFile().toString();
		String peopleDataDirPath = projectPath+File.separator+"config"+File.separator+new OperateConfig().getProp("批量导入人员的文件路径");
		//String peopleDataFilePath = projectPath+File.separator+"data"+File.separator+"frequenter";
		ArrayList<String[]> dataArrayList = ReadCSV.readCSVFile(peopleDataDirPath);
		int row = dataArrayList.size();
		Object[][] peopleData = new Object[row][2];
		for(int i = 0 ; i < row ; i++) {
			//peopleData[i][0] = peopleDataFilePath+ File.separator +dataArrayList.get(i)[0];
			//peopleData[i][1] = peopleDataFilePath+ File.separator +dataArrayList.get(i)[1];
			peopleData[i][0] = dataArrayList.get(i)[0];
			peopleData[i][1] = dataArrayList.get(i)[1];
		}		
		return peopleData;
	}
}
