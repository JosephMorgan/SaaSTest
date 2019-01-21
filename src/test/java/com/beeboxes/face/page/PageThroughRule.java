package com.beeboxes.face.page;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.beeboxes.face.util.PageBase;
import com.beeboxes.face.util.ReadXml;

/**
 * Description: SaaS-通行规则-元素
 * 
 * @author dengbin
 * @date 2018年11月14日
 * @time 下午11:01:43
 */
public class PageThroughRule extends PageBase {

	/**SaaS-通行规则*/
	public PageThroughRule(WebDriver driver) {
		super(driver);
	}

	By  addThoughRuleBtn = By.xpath(ReadXml.getElementByXpath("通行规则页面", "新增通行规则按钮"));
	By  ruleName= By.xpath(ReadXml.getElementByXpath("通行规则页面", "规则名称"));
	By  throughByFace= By.xpath(ReadXml.getElementByXpath("通行规则页面", "通行方式人脸"));
	By  timeRuleBtn= By.xpath(ReadXml.getElementByXpath("通行规则页面", "时间规则按钮"));
	By  timeRuleName= By.xpath(ReadXml.getElementByXpath("通行规则页面", "时间规则名称"));
	By  timeRuleLongTerm= By.xpath(ReadXml.getElementByXpath("通行规则页面", "时间规则日期长期"));
	By  timeRuleMonday= By.xpath(ReadXml.getElementByXpath("通行规则页面", "时间规则星期一"));
	By  timeRuleStartTime= By.xpath(ReadXml.getElementByXpath("通行规则页面", "时间规则开始时间"));
	By  timeRuleEndTime= By.xpath(ReadXml.getElementByXpath("通行规则页面", "时间规则结束时间"));
	By  timeControlConfirm= By.xpath(ReadXml.getElementByXpath("通行规则页面", "时间规则时间控件确定"));
	By  throughWayDropDownBox= By.xpath(ReadXml.getElementByXpath("通行规则页面", "时间规则通行方式下拉框"));
	By  throughWayPass= By.xpath(ReadXml.getElementByXpath("通行规则页面", "时间规则通行方式允许通行"));
	By  timeRuleConfirm= By.xpath(ReadXml.getElementByXpath("通行规则页面", "时间规则确定按钮"));
	By  sendWayDropDownBox= By.xpath(ReadXml.getElementByXpath("通行规则页面", "通行规则下发方式下拉框"));
	By  sentByOrganization= By.xpath(ReadXml.getElementByXpath("通行规则页面", "通行规则下发方式组织下发"));
	By  allOrganization= By.xpath(ReadXml.getElementByXpath("通行规则页面", "所有组织"));
	By  selectedOrganization= By.xpath(ReadXml.getElementByXpath("通行规则页面", "选择组织右移"));
	By  organizationConfirm= By.xpath(ReadXml.getElementByXpath("通行规则页面", "通行规则确定"));

	
	/** 通行规则页-点新增通行规则 */
	public void clickAddThoughRule() {
		new WebDriverWait(driver, 60,1).until(ExpectedConditions.visibilityOfElementLocated(addThoughRuleBtn)).click();
	}
	
	/** 通行规则页-添加通行规则-输入通行规则名称 */
	public void inputRuleName(String name) {
		new WebDriverWait(driver, 60,1).until(ExpectedConditions.visibilityOfElementLocated(ruleName)).sendKeys(Keys.CONTROL + "a");
		new WebDriverWait(driver, 60,1).until(ExpectedConditions.visibilityOfElementLocated(ruleName)).sendKeys(name);
	}
	
	/** 通行规则页-添加通行规则-通行方式选人脸 */
	public void selectThroughByFace() {
		new WebDriverWait(driver, 60,1).until(ExpectedConditions.visibilityOfElementLocated(throughByFace)).click();
	}

	/** 通行规则页-添加通行规则-点时间规则按钮 */
	public void clickTimeRuleBtn() {
		new WebDriverWait(driver, 60,1).until(ExpectedConditions.visibilityOfElementLocated(timeRuleBtn)).click();
	}
	
	/** 通行规则页-添加通行规则-时间规则-输入时间规则名称 */
	public void inputTimeRuleName(String name) {
		new WebDriverWait(driver, 60,1).until(ExpectedConditions.visibilityOfElementLocated(timeRuleName)).sendKeys(Keys.CONTROL + "a");
		new WebDriverWait(driver, 60,1).until(ExpectedConditions.visibilityOfElementLocated(timeRuleName)).sendKeys(name);
	}
	
	/** 通行规则页-添加通行规则-时间规则-日期选长期*/
	public void selectTimeRuleLongTerm() {
		new WebDriverWait(driver, 60,1).until(ExpectedConditions.visibilityOfElementLocated(timeRuleLongTerm)).click();
	}
	
	/** 通行规则页-添加通行规则-时间规则-星期选星期一*/
	public void selectTimeRuleMonday() {
		new WebDriverWait(driver, 60,1).until(ExpectedConditions.visibilityOfElementLocated(timeRuleMonday)).click();
	}
	
	/** 通行规则页-添加通行规则-时间规则-输入开始时间 */
	public void inputTimeRuleStartTime(String startTime) {
		new WebDriverWait(driver, 60,1).until(ExpectedConditions.visibilityOfElementLocated(timeRuleStartTime)).sendKeys(Keys.CONTROL + "a");
		new WebDriverWait(driver, 60,1).until(ExpectedConditions.visibilityOfElementLocated(timeRuleStartTime)).sendKeys(startTime);
	}
	
	/** 通行规则页-添加通行规则-时间规则-输入结束时间 */
	public void inputTimeRuleEndTime(String endTime) {
		new WebDriverWait(driver, 60,1).until(ExpectedConditions.visibilityOfElementLocated(timeRuleEndTime)).sendKeys(Keys.CONTROL + "a");
		new WebDriverWait(driver, 60,1).until(ExpectedConditions.visibilityOfElementLocated(timeRuleEndTime)).sendKeys(endTime);
	}
	
	/** 通行规则页-添加通行规则-时间规则-时间控件点确定*/
	public void clickTimeControlConfirm() {
		new WebDriverWait(driver, 60,1).until(ExpectedConditions.visibilityOfElementLocated(timeControlConfirm)).click();
	}
	
	/** 通行规则页-添加通行规则-时间规则-点通行方式下拉框*/
	public void clickThroughWayDropDownBox() {
		new WebDriverWait(driver, 60,1).until(ExpectedConditions.visibilityOfElementLocated(throughWayDropDownBox)).click();
	}
	
	/** 通行规则页-添加通行规则-时间规则-通行方式选允许通行*/
	public void clickthroughWayPass() {
		new WebDriverWait(driver, 60,1).until(ExpectedConditions.visibilityOfElementLocated(throughWayPass)).click();
	}
	
	/** 通行规则页-添加通行规则-时间规则-点确定*/
	public void clickTimeRuleConfirm() {
		new WebDriverWait(driver, 60,1).until(ExpectedConditions.visibilityOfElementLocated(timeRuleConfirm)).click();
	}
	
	/** 通行规则页-添加通行规则-下发方式下拉框*/
	public void clickSendWayDropDownBox() {
		new WebDriverWait(driver, 60,1).until(ExpectedConditions.visibilityOfElementLocated(sendWayDropDownBox)).click();
	}
	
	/** 通行规则页-添加通行规则-按组织方式下发*/
	public void clickSentByOrganization() {
		new WebDriverWait(driver, 60,1).until(ExpectedConditions.visibilityOfElementLocated(sentByOrganization)).click();
	}
	/** 通行规则页-添加通行规则-选择所有组织*/
	public void clickAllOrganization() {
		new WebDriverWait(driver, 60,1).until(ExpectedConditions.visibilityOfElementLocated(allOrganization)).click();
	}
	
	/** 通行规则页-添加通行规则-选择组织后右移*/
	public void clickSelectedOrganization() {
		new WebDriverWait(driver, 60,1).until(ExpectedConditions.visibilityOfElementLocated(selectedOrganization)).click();
	}
	
	/** 通行规则页-添加通行规则-添加完后点确定*/
	public void clickOrganizationConfirm() {
		new WebDriverWait(driver, 60,1).until(ExpectedConditions.visibilityOfElementLocated(organizationConfirm)).click();
	}
}