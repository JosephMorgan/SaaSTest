package com.beeboxes.face.page;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.beeboxes.face.util.PageBase;
import com.beeboxes.face.util.ReadXml;

/**
 * Description: SaaS平台-人员管理页-元素
 * @author dengbin
 * @date 2018年11月18日
 * @time 下午10:44:04
 */
public class PagePeopleManagement extends PageBase{
	
	public PagePeopleManagement(WebDriver driver) {
		super(driver);
	}

	By  batchAddBtn = By.xpath(ReadXml.getElementByXpath("人员管理页面", "批量导入按钮"));
	By  importExcel = By.xpath(ReadXml.getElementByXpath("人员管理页面", "导入表"));
	By  importImageZip = By.xpath(ReadXml.getElementByXpath("人员管理页面", "导入图片zip"));
	By  nextStepBtn = By.xpath(ReadXml.getElementByXpath("人员管理页面", "下一步按钮"));
	By  confirmBtn = By.xpath(ReadXml.getElementByXpath("人员管理页面", "确定按钮"));
	By  resolveBtn = By.xpath(ReadXml.getElementByXpath("人员管理页面", "处理按钮"));
	By  importBtn = By.xpath(ReadXml.getElementByXpath("人员管理页面", "导入按钮"));
	By  completeBtn = By.xpath(ReadXml.getElementByXpath("人员管理页面", "完成按钮"));
	By  singleAddBtn = By.xpath(ReadXml.getElementByXpath("人员管理页面", "新增人员按钮"));
	By  singleAddName = By.xpath(ReadXml.getElementByXpath("人员管理页面", "单个添加人员姓名"));
	By  singleAddId = By.xpath(ReadXml.getElementByXpath("人员管理页面", "单个添加人员编号"));
	By  singleAddPic = By.xpath(ReadXml.getElementByXpath("人员管理页面", "单个添加人员照片"));
	By  singleAddSaveBtn = By.xpath(ReadXml.getElementByXpath("人员管理页面", "单个添加人员确定"));
	
	/** 人员管理页-点批量导入按钮 */
	public void clickBatchAddBtn() {
		new WebDriverWait(driver,60,1).until(ExpectedConditions.visibilityOfElementLocated(batchAddBtn)).click();
		//JSExecutor.excuteClick(driver, driver.findElement(batchAddBtn));
	}
	
	/** 人员管理页-点导入表 */
	public void clickImportExcel(String excelPath) {
		new WebDriverWait(driver,60,1).until(ExpectedConditions.presenceOfElementLocated(importExcel)).sendKeys(excelPath);
		//JSExecutor.excuteClick(driver, driver.findElement());
	}
	
	/** 人员管理页-点导入图片zip */
	public void clickImportImageZip(String imagePath) {
		new WebDriverWait(driver,60,1).until(ExpectedConditions.presenceOfElementLocated(importImageZip)).sendKeys(imagePath);
		//JSExecutor.excuteClick(driver, driver.findElement());
	}	
	
	/** 人员管理页-点下一步按钮 */
	public void clickNextStepBtn() {
		new WebDriverWait(driver,60,1).until(ExpectedConditions.visibilityOfElementLocated(nextStepBtn)).click();
		//JSExecutor.excuteClick(driver, driver.findElement());
	}	
	
	/** 人员管理页-点确定按钮 */
	public void clickConfirmBtn() {
		new WebDriverWait(driver,60,1).until(ExpectedConditions.visibilityOfElementLocated(confirmBtn)).click();
		//JSExecutor.excuteClick(driver, driver.findElement());
	}	
	
	/** 人员管理页-点处理按钮 */
	public void clickResolveBtn() {
		new WebDriverWait(driver,60,1).until(ExpectedConditions.visibilityOfElementLocated(resolveBtn)).click();
		//JSExecutor.excuteClick(driver, driver.findElement());
	}	
	
	/** 人员管理页-点导入按钮 */
	public void clickImportBtn() {
		new WebDriverWait(driver,60,1).until(ExpectedConditions.visibilityOfElementLocated(importBtn)).click();
		//JSExecutor.excuteClick(driver, driver.findElement());
	}	
	
	/** 人员管理页-点完成按钮 */
	public void clickCompleteBtn() {
		new WebDriverWait(driver,60,1).until(ExpectedConditions.visibilityOfElementLocated(completeBtn)).click();
		//JSExecutor.excuteClick(driver, driver.findElement());
	}
	
	/** 人员管理页-点单个新增人员按钮 */
	public void clickSingleAddBtn() {
		new WebDriverWait(driver,60,1).until(ExpectedConditions.visibilityOfElementLocated(singleAddBtn)).click();
	}
	
	/**设备管理页-单个添加人员-输入姓名 */
	public void inputSingleAddName(String name) {
		new WebDriverWait(driver, 60,1).until(ExpectedConditions.visibilityOfElementLocated(singleAddName)).sendKeys(Keys.CONTROL + "a");
		new WebDriverWait(driver, 60,1).until(ExpectedConditions.visibilityOfElementLocated(singleAddName)).sendKeys(name);
	}
	
	/**设备管理页-单个添加人员-输入人员编号*/
	public void inputSingleAddId(String id) {
		new WebDriverWait(driver, 60,1).until(ExpectedConditions.visibilityOfElementLocated(singleAddId)).sendKeys(Keys.CONTROL + "a");
		new WebDriverWait(driver, 60,1).until(ExpectedConditions.visibilityOfElementLocated(singleAddId)).sendKeys(id);
	}
	
	/** 管理员页-单个添加人员-上传人脸图片 */
	public void inputSinglePeoplePic(String picture) {
		new WebDriverWait(driver,60,1).until(ExpectedConditions.presenceOfElementLocated(singleAddPic)).sendKeys(picture);
	}
	
	/** 人员管理页-点单个新增人员-确定按钮 */
	public void clickSingleAddSaveBtn() {
		new WebDriverWait(driver,60,1).until(ExpectedConditions.visibilityOfElementLocated(singleAddSaveBtn)).click();
	}
}
