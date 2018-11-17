package com.beeboxes.face.base;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.Properties;

/**
 * Description: 操作配置文件/config/test.properties
 * 类说明：
 * 读取配置文件中的key和value；
 * 2个方法：通过key获取value、往配置文件写入key和value
 * @author dengbin
 * @date 2018年11月14日
 * @time 下午12:14:34
 */

public class OperateConfig {
	/** 属性1-文件存储路径 */
	private String filePath="../config/test.properties";
	/** 属性2-Properties类，是Map的子类,用于读取和存储key和value */
	private Properties prop;
	/** 构造方法-操作properties文件 */
	public OperateConfig() {
		//this.filePath = filePath;
		this.prop = readProperties();// 下面写的方法
	}
	
	/** 方法：将key和value读取并放入properties中 */
	public Properties readProperties() {
		Properties properties = new Properties();
		try {
			InputStream ins = new FileInputStream(filePath);
			BufferedReader bf = new BufferedReader(new InputStreamReader(ins,"utf-8"));
			properties.load(bf);
			ins.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return properties;
	}

	/** 方法：通过key获取value */

	public String getProp(String key) {
		if (prop.containsKey(key)) {
			return prop.getProperty(key);
		} else {
			System.out.println("获取的键不存在！");
		}
		return "";
	}

	/** 方法：写入key和value */
	public void setProp(String key, String value) {
		if (prop == null) {
			prop = new Properties();
		}
		try {
			OutputStream outputStream = new FileOutputStream(filePath);
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(outputStream, "utf-8"));
			prop.setProperty(key, value);
			prop.store(bw, key + "value");// 第二个参数是配置文件的注释
			bw.close();
			outputStream.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/** 测试 */
	public static void main(String agrs[]) {
		//OperateConfig firstTest = new OperateConfig("./config/test.properties");
		OperateConfig firstTest = new OperateConfig();
		firstTest.setProp("设备名称", "邓斌的设备");
		firstTest.setProp("服务器的地址", "172.16.20.211");
		firstTest.setProp("激活码", "123456789012");
		firstTest.setProp("人员姓名", "邓斌");
		firstTest.setProp("人员编号", "00001");
				
		System.out.println(firstTest.getProp("设备名称"));
		System.out.println(firstTest.getProp("服务器的地址"));
		System.out.println(firstTest.getProp("激活码"));
		System.out.println(firstTest.getProp("人员姓名"));
		System.out.println(firstTest.getProp("人员编号"));

	}

}