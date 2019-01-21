package com.beeboxes.face.util;

import java.awt.AWTException;
import java.awt.HeadlessException;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.imageio.ImageIO;

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
	
	/** 截的图带名字fileName的png图片。*/
	public static void snapshot(TakesScreenshot drivername,String fileName) {
		 SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy年MM月dd日 HH时mm分ss秒");  
		 String time = dateFormat.format(Calendar.getInstance().getTime());  //获取当前时间
	     File srcFile = drivername.getScreenshotAs(OutputType.FILE);
		  try {
			File dir = new File("snapshot");
			if (!dir.exists())
				dir.mkdirs();
			FileUtils.copyFile(srcFile, new File("snapshot",fileName+time+".png"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	  }
	
	/** 截的图的名字是failure时间戳png。*/
	public static void snapshot(TakesScreenshot drivername) {
		 SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy年MM月dd日 HH时mm分ss秒");  //转换时间格式yyyyMMddHHmmss
		 String time = dateFormat.format(Calendar.getInstance().getTime());  //获取当前时间
	     File srcFile = drivername.getScreenshotAs(OutputType.FILE);
		  try {
			File dir = new File("snapshot");
			if (!dir.exists())
				dir.mkdirs();
			FileUtils.copyFile(srcFile, new File("snapshot","failure"+time+".png"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	  }
	
	/**用Robot这个类截图。原理大概是，从电脑屏幕左上角画一个长方形，一直画到屏幕右下角，
	 * 然后得到File对象，在把这个File是用png或jpg保存，复制到一个具体路径，这个就是截图的整个流程。*/
	public static void captureScreen()  {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy年MM月dd日 HH时mm分ss秒");
		String time = dateFormat.format(Calendar.getInstance().getTime());  //获取当前时间
		BufferedImage image;
		try {
			File dir = new File("snapshot");
			if (!dir.exists())
				dir.mkdirs();
			image = new Robot().createScreenCapture(new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()));
			ImageIO.write(image, "png", new File("snapshot","failure"+time+".png")); 
		} catch (HeadlessException | AWTException e) {
			e.printStackTrace();
		} catch(IOException e){
			e.printStackTrace();
		}
	}
	
}
