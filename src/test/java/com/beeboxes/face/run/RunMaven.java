package com.beeboxes.face.run;

import java.io.File;
import java.io.IOException;

/**
 * Description: 运行mvn
 * @author dengbin
 * @date 2018年12月12日
 * @time 上午11:49:39
 */
public class RunMaven {

	public static void main(String[] args) {
		String s = new File(System.getProperty("user.dir")).toString();
		Runtime runtime=Runtime.getRuntime();
        try {
            runtime.exec("cmd /k cd "+s+" && mvn test");
        } catch (IOException e) {        
            e.printStackTrace();
        }        

	}

}
