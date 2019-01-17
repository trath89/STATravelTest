package com.statravel.util;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Utility {
	
	public static String screenshotPath;
	public static String screenshotName;
	static int i=0;
	
	public static void captureScreenshot(WebDriver webDriver) {
		
		File file = ((TakesScreenshot) webDriver).getScreenshotAs(OutputType.FILE);
		Date date = new Date();
		i = i + 1;
		screenshotName = date.toString().replace(":", "_").replace(" ", "_") + "_"+i+".jpg";
		try {
			FileUtils.copyFile(file, new File(System.getProperty("user.dir") + "/reports/" + screenshotName));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
