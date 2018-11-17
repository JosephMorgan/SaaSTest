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
	public  WebDriver driver;
	
	/** 用chrome打开网页 */
	public static WebDriver useChrome(WebDriver driver) {
		// System.setProperty("webdriver.chrome.driver","D:/browser/chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		//options.addArguments("--test-type", "--start-maximized","disable-infobars");
		//设置启动谷歌时，使用默认用户的配置信息（包括书签、扩展程序等）
		//options.addArguments("user-data-dir=C:/Users/lgl/AppData/Local/Google/Chrome/User Data/Default");
		//driver = new ChromeDriver(options);	

		options.addArguments("--test-type", "--start-maximized","disable-infobars");
		//options.addArguments("--test-type", "disable-infobars","--window-position=0,0","--window-size=0,0");
		//options.addArguments("--test-type", "disable-infobars");
		// driver = new FirefoxDriver();
		// driver = new InternetExplorerDriver();
		// driver.manage().window().maximize();
		//options.addArguments("--headless");
		driver = new ChromeDriver(options);
		// 将浏览器大小设置成宽1，高1
	    //Dimension arg0 = new Dimension(500, 1028);
		//driver.manage().window().setSize(arg0);
		return driver;
	}
//	@SuppressWarnings("deprecation")
//	public static WebDriver useIE() {
//		DesiredCapabilities dc = DesiredCapabilities.internetExplorer();
//		dc.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
//		//IE默认启动保护模式，可手动在浏览器的设置中关闭保护模式，也可在代码中加上这一句，即可
//		dc.setCapability("ignoreProtectedModeSettings", true);
//		driver = new InternetExplorerDriver(dc);
//		driver.manage().window().maximize();
//		return driver;
//	}

	public static WebDriver useFirefox(WebDriver driver) {
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		return driver;
	}

}
