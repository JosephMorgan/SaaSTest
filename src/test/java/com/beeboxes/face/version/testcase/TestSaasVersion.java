package com.beeboxes.face.version.testcase;

import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.alibaba.fastjson.JSONObject;
import com.beeboxes.face.util.InitializeSelenium;
import com.beeboxes.face.util.OperateConfig;
import com.beeboxes.face.util.TestBase;

/**
 * Description: SaaS平台的版本
 * @author dengbin
 * @date 2018年12月3日
 * @time 下午2:52:31
 */
public class TestSaasVersion extends TestBase {	
	@Override
	@BeforeClass
	public void setUp() {
		driver = InitializeSelenium.useChrome(driver);
		driver.get(new OperateConfig().getProp("SaaS地址")+"saas_version");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	@Test(description="看SaaS的版本号")
	public void testSaasVersion() {
		String expextedSaasVersion = new OperateConfig().getProp("SaaS的版本");
		String html = driver.getPageSource(); 
		String strHead = "<html xmlns=\"http://www.w3.org/1999/xhtml\"><head></head><body><pre style=\"word-wrap: break-word; white-space: pre-wrap;\">"; 
		String strLast = "</pre></body></html>"; 
		String strJson = html.substring(strHead.length(), html.length()-strLast.length());
		JSONObject jsonObj = JSONObject.parseObject(strJson);
		String saasVersion = jsonObj.getString("saas_version");
		Reporter.log("SaaS的实际版本："+saasVersion);
		Assert.assertEquals(saasVersion, expextedSaasVersion); 
	}

}
