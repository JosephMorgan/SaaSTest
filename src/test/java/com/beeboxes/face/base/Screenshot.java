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
	
	/** 截的图带名字fileName的png图片*/
	public static void snapshot(TakesScreenshot drivername,String fileName) {
		 SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy年MM月dd日 HH时mm分ss秒");  //转换时间格式
		 String time = dateFormat.format(Calendar.getInstance().getTime());  //获取当前时间
	     File srcFile = drivername.getScreenshotAs(OutputType.FILE);
		  try {
			FileUtils.copyFile(srcFile, new File("snapshot",fileName+time+".png"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	  }
	
	/** 截的图的名字是failure时间戳png*/
	public static void snapshot(TakesScreenshot drivername) {
		 SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy年MM月dd日 HH时mm分ss秒");  //转换时间格式yyyyMMddHHmmss
		 String time = dateFormat.format(Calendar.getInstance().getTime());  //获取当前时间
	     File srcFile = drivername.getScreenshotAs(OutputType.FILE);
		  try {
			FileUtils.copyFile(srcFile, new File("snapshot","failure"+time+".png"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	  }

}
