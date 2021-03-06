package com.jav.Domestic.fixture;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import org.openqa.selenium.WebDriver;


import bsh.Capabilities;

import com.jav.Domestic.pageobjects.EOLDomesticReceiveInfo_UI;
import com.jav.Domestic.pageobjects.EOLDomesticReceiveInfo_nocourse_UI;
import com.jav.Domestic.pageobjects.EOLEnrollNow_UI;
import com.jav.Domestic.pageobjects.EOLEnrollNow_nocourse_UI;
import com.jav.Domestic.pageobjects.SiteCoreULR_Feature_UI;
import com.jav.Domestic.util.Utilities;


public class BaseFixture {
	
	public WebDriver driver;
	public DesiredCapabilities capabilities;
	
	
	
	EOLDomesticReceiveInfo_nocourse_UI PanFoster;
	EOLDomesticReceiveInfo_UI DomReciveInfo;
	EOLEnrollNow_UI DomEnrollNow;
	EOLEnrollNow_nocourse_UI DomEnrollNowNoCourse;
	SiteCoreULR_Feature_UI SiteCore;
	
	public void startBrowserSession()
	{
		capabilities = new DesiredCapabilities();
	    capabilities.setJavascriptEnabled(true);
	    if (getYamlVal("browser").equalsIgnoreCase("firefox")) {
		capabilities.setBrowserName("firefox");
		driver = new FirefoxDriver();
		}else if (getYamlVal("browser").equalsIgnoreCase("iexplore")){
			File file = new File("IEDriverServer.exe");
            System.setProperty("webdriver.ie.driver", file.getAbsolutePath());
            DesiredCapabilities dc = new DesiredCapabilities();
            dc.setJavascriptEnabled(true);
            Utilities.hardWait(5);
            driver = new InternetExplorerDriver(dc);
            
            Utilities.hardWait(5);

		} else if (getYamlVal("browser").equalsIgnoreCase("chrome")){
                    if((System.getProperty("os.name")).contains("Linux")){
                    DesiredCapabilities caps = DesiredCapabilities.chrome();             
                    caps.setJavascriptEnabled(true);
                    System.setProperty("webdriver.chrome.driver","chromedriver");
                    driver = new ChromeDriver(caps);        
                } else if((System.getProperty("os.name")).contains("Windows")){
                    capabilities.setBrowserName("chrome");
                    System.setProperty("webdriver.chrome.driver",
                    "chromedriver.exe");
                    driver = new ChromeDriver();
		}
                }
		int ajax_timeout = Integer.parseInt(getYamlVal("ajax_timeout"));
        driver.manage().timeouts().implicitlyWait(ajax_timeout, TimeUnit.SECONDS);
        initPageObjects();
        driver.manage().window().maximize();

	}
	
	public void initPageObjects() {
		
		PanFoster = new EOLDomesticReceiveInfo_nocourse_UI(driver);
		DomReciveInfo = new EOLDomesticReceiveInfo_UI(driver);
		DomEnrollNow = new EOLEnrollNow_UI(driver);
		DomEnrollNowNoCourse = new EOLEnrollNow_nocourse_UI(driver);
		SiteCore = new SiteCoreULR_Feature_UI(driver);
	}
	
	public void launchUrl(String url)
	{
		driver.get(url);
		
	}
	
	public void stopBrowserSession() {
        driver.quit();
	}
	
	
	
	public void setUpDataFile(String dataFilePath) {
        Utilities.setYamlFilePath(dataFilePath);
    }
	
	public String getYamlVal(String yamlMapObj) {
        return Utilities.getYamlValue(yamlMapObj);
    }

}
