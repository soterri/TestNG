package com.utils;

import java.time.Duration;

public class Constants {

	public static final String CONFIGURATION_FILEPATH = System.getProperty("user.dir")
			+ "\\configs\\configurations.properties";

	public static final String CHROME_DRIVER_PATH = System.getProperty("user.dir") + "\\drivers\\chromedriver.exe";

	public static final String GECKO_DRIVER_PATH = System.getProperty("user.dir") + "\\drivers\\geckodriver.exe";

	public static final int IMPLICIT_WAIT_TIME = 10;
	
	public static final int EXPLICIT_WAIT_TIME=20;
}
