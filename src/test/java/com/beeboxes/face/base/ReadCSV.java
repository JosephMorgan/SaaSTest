package com.beeboxes.face.base;

import java.nio.charset.Charset;
import java.util.ArrayList;

import com.csvreader.CsvReader;

/**
 * Description: 读取csv文件
 * @author dengbin
 * @date 2018年11月21日
 * @time 下午1:05:15
 */
public class ReadCSV {
	public  static ArrayList<String[]> readCSVFile(String filePath) {
		ArrayList<String[]> csvList = null;
		try {
			csvList = new ArrayList<String[]>();//保存数据
			CsvReader reader = new CsvReader(filePath,',', Charset.forName("UTF-8"));//编码设置
			reader.readHeaders();//跳过表头，如果需要的话
			
			//逐行读,除表头的数据
			while (reader.readRecord()) {
				csvList.add(reader.getValues());				
			}
			reader.close();
			
//			for (int row = 0; row < csvList.size(); row++) {
//				System.out.println(csvList.get(row)[0]);
//				System.out.println(csvList.get(row)[1]);
//				System.out.println(csvList.get(row)[2]);
//				System.out.println(csvList.get(row)[3]);
//				System.out.println("-----------------");
//			}
			
//			//只读取某一列,比如第一列
//			for (int row = 0; row < csvList.size(); row++) {
//				String cell = csvList.get(row)[0];
//				//System.out.println(cell);			
//			}
		} catch (Exception ex) {
			System.out.println(ex);
		}
		return csvList;
}
	public static void main(String[] args) {
		String filePath = "C:/Users/Administrator/Desktop/PeopleTemplate.csv";
		
		ArrayList<String[]> dataArrayList = ReadCSV.readCSVFile(filePath);
		for(int row = 0 ; row < dataArrayList.size();row++) {
			System.out.println(dataArrayList.get(row)[0]);
			System.out.println(dataArrayList.get(row)[1]);
		}
		
	}
	}
