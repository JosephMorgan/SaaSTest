package com.beeboxes.face.base;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

/**
 * Description: 屏幕截图
 * @author dengbin
 * @date 2018年11月14日
 * @time 下午10:43:29
 */
public class Screenshot {
	//截图方法	
	public static void snapshot(TakesScreenshot drivername,String filename) {
		 SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmss");  //转换时间格式
		 String time = dateFormat.format(Calendar.getInstance().getTime());  //获取当前时间
	     File srcFile = drivername.getScreenshotAs(OutputType.FILE);
		  try {
			FileUtils.copyFile(srcFile, new File("snapshot",filename+time+".png"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	  }

}
