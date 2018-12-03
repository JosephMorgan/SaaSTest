package com.beeboxes.face.page;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.beeboxes.face.base.PageBase;
import com.beeboxes.face.base.ReadXml;

/**
 * Description: SaaS平台-设备管理页-元素
 * @author dengbin
 * @date 2018年12月1日
 * @time 下午1:56:34
 */
public class PageDeviceManagement extends  PageBase{

	public PageDeviceManagement(WebDriver driver) {
		super(driver);
	}
	
	By searchSnEdit = By.xpath(ReadXml.getElementByXpath("设备管理页面", "sn号搜索框"));
	By searchBtn = By.xpath(ReadXml.getElementByXpath("设备管理页面", "搜索按钮"));
	By firstCheckBox = By.xpath(ReadXml.getElementByXpath("设备管理页面", "第一个勾选框"));
	By rebootDeviceBtn = By.xpath(ReadXml.getElementByXpath("设备管理页面", "重启按钮"));
	By activationCodeBtn = By.xpath(ReadXml.getElementByXpath("设备管理页面", "设备激活码按钮"));
	
	/** 设备管理页-点搜索按钮 */
	public void clickSearchBtn() {
		new WebDriverWait(driver,60,1).until(ExpectedConditions.visibilityOfElementLocated(searchBtn)).click();
	}
	
	/**设备管理页-输入sn */
	public void inputSn(String sn) {
		new WebDriverWait(driver, 60,1).until(ExpectedConditions.visibilityOfElementLocated(searchSnEdit)).sendKeys(Keys.CONTROL + "a");
		new WebDriverWait(driver, 60,1).until(ExpectedConditions.visibilityOfElementLocated(searchSnEdit)).sendKeys(sn);
	}
	
	/** 设备管理页-点设备列表搜索结果的第一个勾选框*/
	public void clickFirstCheckBox() {
		new WebDriverWait(driver, 60,1).until(ExpectedConditions.visibilityOfElementLocated(firstCheckBox)).click();
	}
	
	/** 设备管理页-点设备重启按钮*/
	public void clickRebootDeviceBtn() {
		new WebDriverWait(driver, 60,1).until(ExpectedConditions.visibilityOfElementLocated(rebootDeviceBtn)).click();
	}
	
	/** 设备管理页-点设备激活码按钮*/
	public void clickActivationCodeBtn() {
		new WebDriverWait(driver, 60,1).until(ExpectedConditions.visibilityOfElementLocated(activationCodeBtn)).click();
	}
}