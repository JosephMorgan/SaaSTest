package com.beeboxes.face.page;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.beeboxes.face.util.PageBase;
import com.beeboxes.face.util.ReadXml;

/**
 * Description: SaaS-管理员-元素
 * 
 * @author dengbin
 * @date 2018年11月14日
 * @time 下午11:01:43
 */
public class PageAdministrator extends PageBase {

	/**SaaS-管理员*/
	public PageAdministrator(WebDriver driver) {
		super(driver);
	}

	By addAdministratorBtn = By.xpath(ReadXml.getElementByXpath("管理员页面", "新增管理员按钮"));
	By administratorName = By.xpath(ReadXml.getElementByXpath("管理员页面", "管理员姓名"));
	By administratorPassword = By.xpath(ReadXml.getElementByXpath("管理员页面", "管理员密码"));
	By administratorPicture = By.xpath(ReadXml.getElementByXpath("管理员页面", "管理员照片"));
	By saveAdministratorBtn = By.xpath(ReadXml.getElementByXpath("管理员页面", "管理员确定"));
	By searchAdminName = By.xpath(ReadXml.getElementByXpath("管理员页面", "管理员姓名搜索框"));
	By searchBtn = By.xpath(ReadXml.getElementByXpath("管理员页面", "搜索按钮"));

	
	/** 管理员页-点添加管理员 */
	public void clickAddAdministrator() {
		new WebDriverWait(driver, 60,1).until(ExpectedConditions.visibilityOfElementLocated(addAdministratorBtn)).click();
	}
	
	/** 管理员页-添加管理员-输入管理员姓名 */
	public void inputAdministratorName(String name) {
		new WebDriverWait(driver, 60,1).until(ExpectedConditions.visibilityOfElementLocated(administratorName)).sendKeys(Keys.CONTROL + "a");
		new WebDriverWait(driver, 60,1).until(ExpectedConditions.visibilityOfElementLocated(administratorName)).sendKeys(name);
	}
	
	/** 管理员页-添加管理员-输入管理员密码 */
	public void inputAdministratorPassword(String password) {
		new WebDriverWait(driver, 60,1).until(ExpectedConditions.visibilityOfElementLocated(administratorPassword)).sendKeys(Keys.CONTROL + "a");
		new WebDriverWait(driver, 60,1).until(ExpectedConditions.visibilityOfElementLocated(administratorPassword)).sendKeys(password);
	}

	/** 管理员页-添加管理员-上传管理员图片 */
	public void inputAdministratorPic(String picture) {
		new WebDriverWait(driver,60,1).until(ExpectedConditions.presenceOfElementLocated(administratorPicture)).sendKeys(picture);
	}
	
	/** 管理员页-添加管理员-点确定 */
	public void clickSaveAdministrator() {
		new WebDriverWait(driver, 60,1).until(ExpectedConditions.visibilityOfElementLocated(saveAdministratorBtn)).click();
	}
	
	/** 管理员页-搜索管理员-输入管理员姓名 */
	public void inputAdminName(String name) {
		new WebDriverWait(driver, 60,1).until(ExpectedConditions.visibilityOfElementLocated(searchAdminName)).sendKeys(Keys.CONTROL + "a");
		new WebDriverWait(driver, 60,1).until(ExpectedConditions.visibilityOfElementLocated(searchAdminName)).sendKeys(name);
	}
	
	/** 管理员页-点搜索按钮 */
	public void clickSearchBtn() {
		new WebDriverWait(driver, 60,1).until(ExpectedConditions.visibilityOfElementLocated(searchBtn)).click();
	}
}