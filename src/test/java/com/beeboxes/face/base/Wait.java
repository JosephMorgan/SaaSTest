package com.beeboxes.face.base;
/**
 * Description: 页面等待
 * @author dengbin
 * @date 2018年11月15日
 * @time 下午7:31:10
 */
public class Wait {
	
	/** 等待time毫秒 */
	public  static void sleep (long time) {
		try {
			Thread.sleep(time);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
