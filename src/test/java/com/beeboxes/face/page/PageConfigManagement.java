package com.beeboxes.face.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.beeboxes.face.util.PageBase;
import com.beeboxes.face.util.ReadXml;

/**
 * Description: SaaS-设备管理-配置管理-元素
 * 
 * @author dengbin
 * @date 2018年11月14日
 * @time 下午11:01:43
 */
public class PageConfigManagement extends PageBase {

	/**SaaS-管理员*/
	public PageConfigManagement(WebDriver driver) {
		super(driver);
	}

	By addAdministratorBtn = By.xpath(ReadXml.getElementByXpath("管理员页面", "新增管理员按钮"));


	
	/** 管理员页-点添加管理员 */
	public void clickAddAdministrator() {
		new WebDriverWait(driver, 60,1).until(ExpectedConditions.visibilityOfElementLocated(addAdministratorBtn)).click();
	}
	
//	/** 管理员页-添加管理员-输入管理员姓名 */
//	public void inputAdministratorName(String name) {
//		new WebDriverWait(driver, 60,1).until(ExpectedConditions.visibilityOfElementLocated(administratorName)).sendKeys(Keys.CONTROL + "a");
//		new WebDriverWait(driver, 60,1).until(ExpectedConditions.visibilityOfElementLocated(administratorName)).sendKeys(name);
//	}

}