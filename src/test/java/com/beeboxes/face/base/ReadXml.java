package com.beeboxes.face.base;

import java.io.File;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

/**
 * Description: 读取xml文件中的元素
 * 
 * @author dengbin
 * @date 2018年11月14日
 * @time 下午1:58:06
 */
public class ReadXml {

	/**通过id属性获取元素*/
	public static String getElementById(String activityName, String elementName) {
		String element = "";
		SAXReader sax = new SAXReader();
		try {
			Document doc = sax.read(new File("../config/test.xml"));
			Element rootElement = doc.getRootElement();
			String xpath = "/root/activity[@name='" + activityName
					+ "']/element[@name='" + elementName + "']/id";
			Element nodeElement = (Element) rootElement.selectSingleNode(xpath);
			element = nodeElement.getText();

		} catch (DocumentException e) {
			e.printStackTrace();
		}
		return element;
	}

	/**通过name属性获取元素*/
	public static String getElementByName(String activityName,
			String elementName) {
		String element = "";
		SAXReader sax = new SAXReader();
		try {
			Document doc = sax.read(new File("../config/test.xml"));
			Element rootElement = doc.getRootElement();
			String xpath = "/root/activity[@name='" + activityName
					+ "']/element[@name='" + elementName + "']/name";
			Element nodeElement = (Element) rootElement.selectSingleNode(xpath);
			element = nodeElement.getText();

		} catch (DocumentException e) {
			e.printStackTrace();
		}
		return element;
	}
	
	/**通过xpath属性获取元素*/
	public static String getElementByXpath(String activityName,
			String elementName) {
		String element = "";
		SAXReader sax = new SAXReader();
		try {
			Document doc = sax.read(new File("../config/test.xml"));
			Element rootElement = doc.getRootElement();
			String xpath = "/root/activity[@name='" + activityName
					+ "']/element[@name='" + elementName + "']/xpath";
			Element nodeElement = (Element) rootElement.selectSingleNode(xpath);
			element = nodeElement.getText();

		} catch (DocumentException e) {
			e.printStackTrace();
		}
		return element;
	}

	public static void main(String[] args) {

		System.out.println(ReadXml.getElementById("基础设置", "高级"));

	}

}
