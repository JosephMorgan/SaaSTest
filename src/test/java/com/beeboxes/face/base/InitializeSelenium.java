package com.beeboxes.face.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * Description: 选择浏览器后，初始化Web浏览器启动
 * @author dengbin
 * @date 2018年11月14日
 * @time 下午12:09:55
 */
public class InitializeSelenium {
	public   WebDriver driver;
	
	/** 用chrome打开网页 */
	public static WebDriver useChrome(WebDriver driver) {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--test-type", "--start-maximized","disable-infobars");
		driver = new ChromeDriver(options);
		return driver;
	}

	/** 用firefox打开网页 */
	public static WebDriver useFirefox(WebDriver driver) {
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		return driver;
	}

}
