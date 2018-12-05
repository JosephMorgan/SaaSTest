package com.beeboxes.face.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

//import com.beeboxes.face.base.JSExecutor;

import com.beeboxes.face.util.ReadXml;

/**
 * Description: SaaS平台-人员管理页-元素
 * @author dengbin
 * @date 2018年11月18日
 * @time 下午10:44:04
 */
public class PagePeopleManagement {
	public WebDriver driver;
	public PagePeopleManagement(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	public String getPageSource() {
		return driver.getPageSource();
	}
	public void close() {
		this.driver.close();
	}
	
	By batchAddBtn = By.xpath(ReadXml.getElementByXpath("人员管理页面", "批量导入按钮"));
	By  importExcel = By.xpath(ReadXml.getElementByXpath("人员管理页面", "导入表"));
	By  importImageZip = By.xpath(ReadXml.getElementByXpath("人员管理页面", "导入图片zip"));
	By  nextStepBtn = By.xpath(ReadXml.getElementByXpath("人员管理页面", "下一步按钮"));
	By  confirmBtn = By.xpath(ReadXml.getElementByXpath("人员管理页面", "确定按钮"));
	By  resolveBtn = By.xpath(ReadXml.getElementByXpath("人员管理页面", "处理按钮"));
	By  importBtn = By.xpath(ReadXml.getElementByXpath("人员管理页面", "导入按钮"));
	By  completeBtn = By.xpath(ReadXml.getElementByXpath("人员管理页面", "完成按钮"));
	
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
}
