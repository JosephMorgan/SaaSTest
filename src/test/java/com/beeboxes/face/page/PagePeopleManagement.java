package com.beeboxes.face.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

//import com.beeboxes.face.base.JSExecutor;
import com.beeboxes.face.base.ReadXml;

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
	
	/** 人员管理页-点批量导入按钮 */
	public void clickBatchAddBtn() {
		new WebDriverWait(driver,60,1).until(ExpectedConditions.visibilityOfElementLocated(batchAddBtn)).click();
		//JSExecutor.excuteClick(driver, driver.findElement(batchAddBtn));
	}

}
