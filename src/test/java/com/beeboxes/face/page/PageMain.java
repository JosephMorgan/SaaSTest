package com.beeboxes.face.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.beeboxes.face.util.JSExecutor;
import com.beeboxes.face.util.ReadXml;

/**
 * Description: SaaS平台-主页-元素
 * @author dengbin
 * @date 2018年11月18日
 * @time 下午10:44:04
 */
public class PageMain {
	public WebDriver driver;
	public PageMain(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	public String getPageSource() {
		return driver.getPageSource();
	}
	public void close() {
		this.driver.close();
	}
	
	By workbench = By.xpath(ReadXml.getElementByXpath("首页左侧栏", "工作台"));
	By homePage = By.xpath(ReadXml.getElementByXpath("首页左侧栏", "首页"));
	By alarmCenter = By.xpath(ReadXml.getElementByXpath("首页左侧栏", "预警中心"));
	By operationLog = By.xpath(ReadXml.getElementByXpath("首页左侧栏", "操作日志"));
	By  peopleManagement= By.xpath(ReadXml.getElementByXpath("首页左侧栏", "大的人员管理"));
	By  personManagement= By.xpath(ReadXml.getElementByXpath("首页左侧栏", "小的人员管理"));
	By  deviceManagement = By.xpath(ReadXml.getElementByXpath("首页左侧栏", "大的设备管理"));
	By  equipmentManagement = By.xpath(ReadXml.getElementByXpath("首页左侧栏", "小的设备管理"));
	By  deviceGrouping = By.xpath(ReadXml.getElementByXpath("首页左侧栏", "设备分组"));
	By  administrator = By.xpath(ReadXml.getElementByXpath("首页左侧栏", "管理员"));
	By  configManagement = By.xpath(ReadXml.getElementByXpath("首页左侧栏", "配置管理"));
	By  recordOfCommand = By.xpath(ReadXml.getElementByXpath("首页左侧栏", "命令下发记录"));
	By   authorityManagement = By.xpath(ReadXml.getElementByXpath("首页左侧栏", "权限管理"));
	By   roleManagement= By.xpath(ReadXml.getElementByXpath("首页左侧栏", "角色管理"));
	By   authorityAllocation = By.xpath(ReadXml.getElementByXpath("首页左侧栏", "权限分配"));
	By   dataManagement = By.xpath(ReadXml.getElementByXpath("首页左侧栏", "数据管理"));
	By   throughRecord = By.xpath(ReadXml.getElementByXpath("首页左侧栏", "通行记录"));
	By   businessManagement = By.xpath(ReadXml.getElementByXpath("首页左侧栏", "业务管理"));
	By   throughRule = By.xpath(ReadXml.getElementByXpath("首页左侧栏", "通行规则"));
	By   rulesSentDown = By.xpath(ReadXml.getElementByXpath("首页左侧栏", "规则下发"));
	By   applicationManagement = By.xpath(ReadXml.getElementByXpath("首页左侧栏", "应用管理"));
	By   wechatAuthorization = By.xpath(ReadXml.getElementByXpath("首页左侧栏", "微信授权"));
	By   systemManagement = By.xpath(ReadXml.getElementByXpath("首页左侧栏", "系统管理"));
	By   organizationalStructure = By.xpath(ReadXml.getElementByXpath("首页左侧栏", "组织架构"));
	
	/** 主页-点工作台 */
	public void clickWorkbench() {
		//new WebDriverWait(driver,60,1).until(ExpectedConditions.visibilityOfElementLocated(workbench)).click();
		JSExecutor.excuteClick(driver, driver.findElement(workbench));
	}
	
	/** 主页-点首页 */
	public void clickHomePage() {
		//new WebDriverWait(driver,60,1).until(ExpectedConditions.visibilityOfElementLocated(homePage)).click();
		JSExecutor.excuteClick(driver, driver.findElement(homePage));

	}
	
	/** 主页-点预警中心 */
	public void clickAlarmCenter() {
		//new WebDriverWait(driver,60,1).until(ExpectedConditions.visibilityOfElementLocated(alarmCenter)).click();
		JSExecutor.excuteClick(driver, driver.findElement(alarmCenter));

	}

	/** 主页-点操作日志 */
	public void clickOperationLog() {
		//new WebDriverWait(driver,60,1).until(ExpectedConditions.visibilityOfElementLocated(operationLog)).click();
		JSExecutor.excuteClick(driver, driver.findElement(operationLog));
	}
	
	/** 主页-点大的人员管理 */
	public void clickPeopleManagement() {
		//new WebDriverWait(driver,60,1).until(ExpectedConditions.visibilityOfElementLocated(peopleManagement)).click();
		JSExecutor.excuteClick(driver, driver.findElement(peopleManagement));
	}
	
	/** 主页-点小的人员管理 */
	public void clickPersonManagement() {
		//new WebDriverWait(driver,60,1).until(ExpectedConditions.visibilityOfElementLocated(personManagement)).click();
		JSExecutor.excuteClick(driver, driver.findElement(personManagement));
	}
	
	/** 主页-点大的设备管理 */
	public void clickDeviceManagement() {
		//new WebDriverWait(driver,60,1).until(ExpectedConditions.visibilityOfElementLocated(deviceManagement)).click();
		JSExecutor.excuteClick(driver, driver.findElement(deviceManagement));
	}
	
	/** 主页-点小的设备管理 */
	public void clickEquipmentManagement() {
		//new WebDriverWait(driver,60,1).until(ExpectedConditions.visibilityOfElementLocated(equipmentManagement)).click();
		JSExecutor.excuteClick(driver, driver.findElement(equipmentManagement));
	}
	
	/** 主页-点设备分组 */
	public void clickDeviceGrouping() {
		//new WebDriverWait(driver,60,1).until(ExpectedConditions.visibilityOfElementLocated(deviceGrouping)).click();
		JSExecutor.excuteClick(driver, driver.findElement(deviceGrouping));
	}	
	
	/** 主页-点管理员 */
	public void clickAdministrator() {
		//new WebDriverWait(driver,60,1).until(ExpectedConditions.visibilityOfElementLocated(administrator)).click();
		JSExecutor.excuteClick(driver, driver.findElement(administrator));
	}	
	
	/** 主页-点配置管理 */
	public void clickConfigManagement() {
		//new WebDriverWait(driver,60,1).until(ExpectedConditions.visibilityOfElementLocated(configManagement)).click();
		JSExecutor.excuteClick(driver, driver.findElement(configManagement));
	}	
	
	/** 主页-点命令下发记录 */
	public void clickRecordOfCommand() {
		//new WebDriverWait(driver,60,1).until(ExpectedConditions.visibilityOfElementLocated(recordOfCommand)).click();
		JSExecutor.excuteClick(driver, driver.findElement(recordOfCommand));
	}
	
	/** 主页-点权限管理 */
	public void clickAuthorityManagement() {
		JSExecutor.excuteClick(driver, driver.findElement(authorityManagement));
	}
	
	/** 主页-点角色管理 */
	public void clickRoleManagement() {
		JSExecutor.excuteClick(driver, driver.findElement(roleManagement));
	}
	
	/** 主页-点权限分配 */
	public void clickAuthorityAllocation() {
		JSExecutor.excuteClick(driver, driver.findElement(authorityAllocation));
	}
	
	/** 主页-点数据管理 */
	public void clickDataManagement() {
		JSExecutor.excuteClick(driver, driver.findElement(dataManagement));
	}
	
	/** 主页-点通行记录 */
	public void clickThroughRecord() {
		JSExecutor.excuteClick(driver, driver.findElement(throughRecord));
	}
	
	/** 主页-点业务管理 */
	public void clickBusinessManagement() {
		JSExecutor.excuteClick(driver, driver.findElement(businessManagement));
	}
	
	/** 主页-点通行规则 */
	public void clickThroughRule() {
		JSExecutor.excuteClick(driver, driver.findElement(throughRule));
	}
	
	/** 主页-点规则下发 */
	public void clickRulesSentDown() {
		JSExecutor.excuteClick(driver, driver.findElement(rulesSentDown));
	}
	
	/** 主页-点应用管理 */
	public void clickApplicationManagement() {
		JSExecutor.excuteClick(driver, driver.findElement(applicationManagement));
	}
	
	/** 主页-点微信授权 */
	public void clickWechatAuthorization() {
		JSExecutor.excuteClick(driver, driver.findElement(wechatAuthorization));
	}
	
	/** 主页-点系统管理 */
	public void clickSystemManagement() {
		JSExecutor.excuteClick(driver, driver.findElement(systemManagement));
	}
	
	/** 主页-点组织架构 */
	public void clickOrganizationalStructure() {
		JSExecutor.excuteClick(driver, driver.findElement(organizationalStructure));
	}

}
