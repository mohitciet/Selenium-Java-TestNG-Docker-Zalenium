package com.sohambko.qa.testcases;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.sohambko.qa.pages.ContactsPage;
import com.sohambko.qa.pages.HomePage;

public class StartTest {
	
	@BeforeSuite()
	public void runDockerCommands() throws Exception {
		Runtime runtime=Runtime.getRuntime();
		runtime.exec("cmd /c start dockerUp.bat");
		verifyDockerIsUp();
		runtime.exec("cmd /c start scaleChrome.bat");
		Thread.sleep(10000);
		runtime.exec("cmd /c start scaleFirefox.bat");
		Thread.sleep(10000);
		runtime.exec("taskkill /f /im cmd.exe") ;
		System.out.println("Docker is up now");
		
		
	
	
	}
	
	
	@AfterSuite()
	public void afterDockerCommands() throws Exception {
		
		Runtime runtime=Runtime.getRuntime();
		runtime.exec("cmd /c start dockerDown.bat");
		System.out.println("Docker is Down now");
	
	}
	
	private static void verifyDockerIsUp() throws FileNotFoundException, Exception {
		Thread.sleep(10000);
		boolean flag=false;
		String file="output.txt";
		BufferedReader reader= new BufferedReader(new FileReader(file));
		String currentline=reader.readLine();

		while(currentline!=null) {
			if((currentline.contains("The node is registered to the hub and ready to use"))||(currentline.contains("Zalenium is now ready!"))) {
				flag=true;
				break;
			}
			currentline=reader.readLine();
		}
		reader.close();

		if(!flag) {
			throw new SkipException("Docker have not started. Please try again or try manually.");
		}
	}


}
