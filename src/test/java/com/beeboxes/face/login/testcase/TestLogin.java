package com.beeboxes.face.login.testcase;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * Description: SaaS平台-登录页-用例
 * 
 * @author dengbin
 * @date 2018年11月13日
 * @time 下午2:58:14
 */
public class TestLogin {
	private WebDriver driver;

	@BeforeMethod
	public void setUp() throws Exception {
		// System.setProperty("webdriver.chrome.driver","D:/browser/chromedriver.exe");
		// 窗口最大化
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--test-type", "--start-maximized",
				"disable-infobars");
		// dr = new FirefoxDriver();
		// dr = new InternetExplorerDriver();
		// dr.manage().window().maximize();
		driver = new ChromeDriver(options);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);// 全局最长等10秒

	}

	@Test(invocationCount=50000,threadPoolSize=1)
	public void testLogin() {
		// long startTime = System.currentTimeMillis();
		driver.get("https://172.16.20.211/");

		driver.findElement(By.name("uname")).sendKeys("dengbin");
		driver.findElement(By.name("pass")).sendKeys("123.com");
		new Actions(driver).sendKeys(Keys.ENTER).perform();
		// driver.findElement(By.xpath("/html/body/div/div[1]/div[2]/div/div[4]/form/div[4]/div/button")).click();

		// System.out.println(driver.findElements(By.linkText("设备管理")).size());
		// driver.findElements(By.linkText("设备管理")).get(0).click();

		driver.findElement(
				By.xpath("/html/body/div/div[1]/div/div/div[1]/div/div/ul/li[3]/div/span"))
				.click();
		driver.findElement(
				By.xpath("/html/body/div/div[1]/div/div/div[1]/div/div/ul/li[3]/ul/a[1]/li"))
				.click();
		driver.findElement(
				By.xpath("/html/body/div/div[1]/div/div/div[2]/div[2]/div/div/div[5]/div/div[3]/table/tbody/tr/td[1]/div/label/span/span"))
				.click();
		driver.findElement(
				By.xpath("/html/body/div/div[1]/div/div/div[2]/div[2]/div/div/div[3]/button[3]"))
				.click();

		// long endTime = System.currentTimeMillis();
		// System.out.println("耗时："+(endTime-startTime));

	}

	@AfterMethod
	public void tearDown() {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		driver.quit();

	}
}
