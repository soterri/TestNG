package com.utils;

import org.testng.ITestListener;
import org.testng.ITestResult;

public class Listeners implements ITestListener  {
	
	@Override
	public void onTestStart(ITestResult result) {
		System.out.println("Test Started "+result.getName());
	}
	@Override
	public void onTestSuccess(ITestResult result) {
		System.out.println("Test passed " +result.getName());
	}
	@Override
	public void onTestFailure(ITestResult result) {
		System.out.println("Test failed "+ result.getName());
	}
	
	

}
