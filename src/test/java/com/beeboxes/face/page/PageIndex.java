package com.beeboxes.face.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.beeboxes.face.util.PageBase;
import com.beeboxes.face.util.ReadXml;

/**
 * Description: SaaS-首页-元素
 * 
 * @author dengbin
 * @date 2018年11月14日
 * @time 下午11:01:43
 */
public class PageIndex extends PageBase {

	/**SaaS-首页*/
	public PageIndex(WebDriver driver) {
		super(driver);
	}

	By guestSystem = By.xpath(ReadXml.getElementByXpath("首页页面", "访客系统"));
	
	/** 首页-点访客系统 */
	public void clickGuestSystem() {
		new WebDriverWait(driver, 60,1).until(ExpectedConditions.visibilityOfElementLocated(guestSystem)).click();
	}

}