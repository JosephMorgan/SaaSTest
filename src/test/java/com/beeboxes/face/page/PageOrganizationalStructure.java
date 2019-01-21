package com.beeboxes.face.page;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.beeboxes.face.util.PageBase;
import com.beeboxes.face.util.ReadXml;

/**
 * Description: SaaS-系统管理-组织架构-元素
 * 
 * @author dengbin
 * @date 2018年11月14日
 * @time 下午11:01:43
 */
public class PageOrganizationalStructure extends PageBase {

	/**SaaS-组织架构*/
	public PageOrganizationalStructure(WebDriver driver) {
		super(driver);
	}

	By addGroupBtn = By.xpath(ReadXml.getElementByXpath("组织架构页面", "新增按钮"));
	By addGroupName = By.xpath(ReadXml.getElementByXpath("组织架构页面", "新增组织的名称"));
	By addGroupConfirm = By.xpath(ReadXml.getElementByXpath("组织架构页面", "新增组织的确定"));


	
	/** 组织架构页-点新增组织 */
	public void clickAddGroup() {
		new WebDriverWait(driver, 60,1).until(ExpectedConditions.visibilityOfElementLocated(addGroupBtn)).click();
	}
	
	/** 组织架构页-新增组织-输入组织名称 */
	public void inputAddGroupName(String name) {
		new WebDriverWait(driver, 60,1).until(ExpectedConditions.visibilityOfElementLocated(addGroupName)).sendKeys(Keys.CONTROL + "a");
		new WebDriverWait(driver, 60,1).until(ExpectedConditions.visibilityOfElementLocated(addGroupName)).sendKeys(name);
	}
	
	/** 组织架构页-新增组织-点确定 */
	public void clickAddGroupConfirm() {
		new WebDriverWait(driver, 60,1).until(ExpectedConditions.visibilityOfElementLocated(addGroupConfirm)).click();
	}

}