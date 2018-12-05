package com.beeboxes.face.util;

import java.util.Set;

import org.openqa.selenium.NoSuchWindowException;
import org.openqa.selenium.WebDriver;

/**
 * Description: 窗口的切换
 * @author dengbin
 * @date 2018年12月2日
 * @time 下午11:49:55
 */
public class WindowSwitch {
	    
	     /** 根据窗口标题切换窗口*/
		public static void switchtoWindow(WebDriver driver,String windowTitle) {
			try {
				String currentHandle = driver.getWindowHandle();
				Set<String> handles = driver.getWindowHandles();
				for (String handle : handles) {
					if (handle.equals(currentHandle))
						continue;
					else {
						driver.switchTo().window(handle);
						if (driver.getTitle().contains(windowTitle)) {
							break;
						} else
							continue;
					}
				}
			} catch (NoSuchWindowException e) {
				 e.fillInStackTrace();
			}		
		}
}
