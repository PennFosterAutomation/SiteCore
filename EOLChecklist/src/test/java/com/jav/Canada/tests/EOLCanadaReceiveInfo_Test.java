package com.jav.Canada.tests;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import com.jav.Canada.fixture.*;
import com.jav.Canada.util.*;
import org.openqa.selenium.WebDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class EOLCanadaReceiveInfo_Test {
	
	WebDriver driverTest;
	
	EOLCanadaReceiveInfo_Fixture test = new EOLCanadaReceiveInfo_Fixture();
	 
	 String preFix;
	 String Fname;
	 String Lname;
	 String Mail;
	 String EmailExt;
	 String Phone;
	 String Address;
	 String City;
	 String State;
	 String Zip;
	 String DOBmonth;
	 String DOBday;
	 String DOByear;
	 String CreditCardNumber;
	 String CVV;
	 
	 EOLCanadaReceiveInfo_Test()
	 {
		 DateFormat dateFormat = new SimpleDateFormat("ddmmssSSS");
		 Date date = new Date();		 
		 preFix = dateFormat.format(date);
	 }
	
	 
	@BeforeClass
    public void initialsettings() 
    {
        test.setUpDataFile("testData/integration_testData_Canada.yml");
        Utilities.createExcel();
       
        
    }
	
	
	@Test
    public void setup()
    {
		Reporter.log(Utilities.logOutputFile(" ########## Start browser session STARTS ###########"));
        test.startBrowserSession();        
		Reporter.log(Utilities.logOutputFile(" ########## Start browser session ENDS ###########"));

    }
	
	
	@Test(dependsOnMethods = "setup")
    public void launchHomePage() throws InterruptedException
    {
		Reporter.log(Utilities.logOutputFile(" ########## Start Launch Home Page STARTS ###########"));
		test.launchUrl(test.getYamlVal("appurl"));
		Utilities.hardWait(4);
		Reporter.log(Utilities.logOutputFile(" ########## Start Launch Home Page ENDS ###########"));

    }
	
	
	@Test(dependsOnMethods = "launchHomePage")
	public void homePageactions()
	{		
		Reporter.log(Utilities.logOutputFile(" ########## Start Launch Home Page STARTS ###########"));
		test.verifyHomepage();		
		Reporter.log(Utilities.logOutputFile(" ########## Start Launch Home Page ENDS ###########"));

	}
	
	
	@Test(dependsOnMethods = "homePageactions")
	public void verifyElementsDisplayOnStep1EnrollmentProcess()
	{	
		Reporter.log(Utilities.logOutputFile(" ########## Start Verify Elements Display On Step1 Enrollment Process STARTS ###########"));
		test.verifyElementsDisplayOnStep1();
		Reporter.log(Utilities.logOutputFile(" ########## Start Verify Elements Display On Step1 Enrollment Process ENDS ###########"));

	}
	
	
	@Test(dependsOnMethods = "verifyElementsDisplayOnStep1EnrollmentProcess")
	public void enterStudentInformationOnStep1Page() throws IOException
	{		
		Reporter.log(Utilities.logOutputFile(" ########## Start Enter Student Information On Step1 Page STARTS ###########"));

		  Fname = test.getYamlVal("CanadaURLReceiveInformation.StudentInformation.FirstName");
		  Lname = Utilities.getFname();
		  Mail = test.getYamlVal("CanadaURLReceiveInformation.StudentInformation.Email");
		  EmailExt = test.getYamlVal("CanadaURLReceiveInformation.StudentInformation.EmailExt");
		  Phone = test.getYamlVal("CanadaURLReceiveInformation.StudentInformation.PrimaryPhone");
		  Address = test.getYamlVal("CanadaURLReceiveInformation.StudentInformation.Address");
		  City = test.getYamlVal("CanadaURLReceiveInformation.StudentInformation.City");
		  State = test.getYamlVal("CanadaURLReceiveInformation.StudentInformation.State");
		  Zip = test.getYamlVal("CanadaURLReceiveInformation.StudentInformation.ZIP");
		

		  test.enterStudentInformationInStep1Form(preFix, Fname, Lname, Mail, EmailExt, Phone, Address, City, State, Zip);		
		  Reporter.log(Utilities.logOutputFile(" ########## Start Enter Student Information On Step1 Page ENDS ###########"));

	}
	
	
	@Test(dependsOnMethods = "enterStudentInformationOnStep1Page")
	public void redirectToThankYouPageAndClickEnrollOnLine()
	{		
		Reporter.log(Utilities.logOutputFile(" ########## Start Redirect To ThankYou Page And Click Enroll OnLine STARTS ###########"));
		test.verifyRedirectToThnakyouPageandClickonEnrollOnlineLink();	
		Reporter.log(Utilities.logOutputFile(" ########## Start Redirect To ThankYou Page And Click Enroll OnLine ENDS ###########"));

	}
	
	
	@Test(dependsOnMethods = "redirectToThankYouPageAndClickEnrollOnLine")
	public void verifyElementDisplayOnPersonalInformationPage()
	{		
		Reporter.log(Utilities.logOutputFile(" ########## Start Verify Element Display On Personal Information Page STARTS ###########"));
		test.verifyElementsPersentOnPersonalInformationPage();	
		Reporter.log(Utilities.logOutputFile(" ########## Start Verify Element Display On Personal Information Page ENDS ###########"));

	}
	
	
	@Test(dependsOnMethods = "verifyElementDisplayOnPersonalInformationPage")
	public void enterRemaningInformationOnPersonalInformatoinPage()
	{		
		 Reporter.log(Utilities.logOutputFile(" ########## Start Enter Remaning Information On Personal Informatoin Page STARTS ###########"));
		 DOBmonth = test.getYamlVal("CanadaURLReceiveInformation.StudentInformation.DOBmonth");
		 DOBday = test.getYamlVal("CanadaURLReceiveInformation.StudentInformation.DOBday");
		 DOByear = test.getYamlVal("CanadaURLReceiveInformation.StudentInformation.DOByear");
		test.enterInformationOnPersonalInformationPage(preFix, Fname, Lname, Mail, EmailExt, Phone, Address, City, State, Zip, DOBmonth, DOBday, DOByear);	
		Reporter.log(Utilities.logOutputFile(" ########## Start Enter Remaning Information On Personal Informatoin Page ENDS ###########"));

	}
	
	
	@Test(dependsOnMethods = "enterRemaningInformationOnPersonalInformatoinPage")
	public void verifyredirectToPaymentInformationPage()
	{		
		Reporter.log(Utilities.logOutputFile(" ########## Start Enter Remaning Information On Personal Informatoin Page STARTS ###########"));
		test.redirectToPaymentInformationPage();	
		Reporter.log(Utilities.logOutputFile(" ########## Start Enter Remaning Information On Personal Informatoin Page ENDS ###########"));

	}
	
	
	@Test(dependsOnMethods = "verifyredirectToPaymentInformationPage")
	public void verifyElementsDisplayOnPaymentInformation()
	{		
		Reporter.log(Utilities.logOutputFile(" ########## Start Verify Redirect To Payment Information Page STARTS ###########"));
		test.verifyElemetsDisplayOnPaymentInformationPage();	
		Reporter.log(Utilities.logOutputFile(" ########## Start Verify Redirect To Payment Information Page ENDS ###########"));

	}
	
	
	@Test(dependsOnMethods = "verifyElementsDisplayOnPaymentInformation")
	public void selectModeOfPaymentandProvideInformation()
	{		
		Reporter.log(Utilities.logOutputFile(" ########## Start Verify Elements Display On Payment Information STARTS ###########"));
		test.selectPaymentModeAndEnterCardInformation();	
		Reporter.log(Utilities.logOutputFile(" ########## Start Verify Elements Display On Payment Information ENDS ###########"));

	}
	
	
	@Test(dependsOnMethods = "selectModeOfPaymentandProvideInformation")
	public void verifyElementsDisplayAfterSelectModeOfPayment()
	{		
		Reporter.log(Utilities.logOutputFile(" ########## Start Select Mode Of Payment and Provide Information STARTS ###########"));
		test.verifyElementDisplayAfterCreditCardSelection();	
		Reporter.log(Utilities.logOutputFile(" ########## Start Select Mode Of Payment and Provide Information ENDS ###########"));

	}
	
	
	@Test(dependsOnMethods = "verifyElementsDisplayAfterSelectModeOfPayment")
	public void enterCreditCardInformation()
	{		
		Reporter.log(Utilities.logOutputFile(" ########## Start Verify Elements Display After Select Mode Of Payment STARTS ###########"));

		CreditCardNumber = test.getYamlVal("CanadaURLReceiveInformation.StudentInformation.CreditCardNumber");
		CVV = test.getYamlVal("CanadaURLReceiveInformation.StudentInformation.CVV");
		test.enterCreditCardInformationAfterCreditCardSelection(CreditCardNumber, CVV);	
		Reporter.log(Utilities.logOutputFile(" ########## Start Verify Elements Display After Select Mode Of Payment ENDS ###########"));

	}
	
	
	@Test(dependsOnMethods = "enterCreditCardInformation")
	public void verifyElementsDisplayOnReviewAndSubmitPage()
	{
		Reporter.log(Utilities.logOutputFile(" ########## Start Enter CreditCard Information STARTS ###########"));
		test.verifyInformationFieldDisplayOnReviewandSubmitPage(preFix, Fname, Lname, Mail, EmailExt, Phone, Address, City, State, Zip , DOBmonth, DOBday, DOByear);	
		Reporter.log(Utilities.logOutputFile(" ########## Start Enter CreditCard Information ENDS ###########"));
	}
        
        
        @Test(dependsOnMethods = "verifyElementsDisplayOnReviewAndSubmitPage")
	public void verifyEditButtonOnReviewAndSubmit()
	{
            if (Utilities.getYamlValue("CanadaURLReceiveInformation.RunType").equalsIgnoreCase("AllCources")) {
                Reporter.log(Utilities.logOutputFile(" ########## Start Verify Edit botton On Review and Submit Page STARTS ###########"));
                Reporter.log(Utilities.logOutputFile(" ########## Start Verify Edit botton On Review and Submit Page ENDS ###########"));
            }else{
		Reporter.log(Utilities.logOutputFile(" ########## Start Verify Edit botton On Review and Submit Page STARTS ###########"));
                test.clickPersonalInfoEditButtonOnReviewAndSubmit();
                test.enterInformationAfterEditOnPersonalInformationPage(preFix, Fname, Lname, Mail, EmailExt, Phone, Address, City, State, Zip, DOBmonth, DOBday, DOByear);
                verifyredirectToPaymentInformationPage();
                verifyElementsDisplayOnPaymentInformation();
                selectModeOfPaymentandProvideInformation();
                verifyElementsDisplayAfterSelectModeOfPayment();
                enterCreditCardInformation();
                test.clickProgramInfoEditButtonOnReviewAndSubmit();
                verifyredirectToPaymentInformationPage();
                verifyElementsDisplayOnPaymentInformation();
                selectModeOfPaymentandProvideInformation();
                verifyElementsDisplayAfterSelectModeOfPayment();
                enterCreditCardInformation();
                test.clickPaymentInfoEditButtonOnReviewAndSubmit();
                verifyredirectToPaymentInformationPage();
                verifyElementsDisplayOnPaymentInformation();
                selectModeOfPaymentandProvideInformation();
                verifyElementsDisplayAfterSelectModeOfPayment();
                enterCreditCardInformation();
		Reporter.log(Utilities.logOutputFile(" ########## Start Verify Edit botton On Review and Submit Page ENDS ###########"));
            }
	}
	
		
	@Test(dependsOnMethods = "verifyEditButtonOnReviewAndSubmit")
	public void verifyandClickOnTermAndConditionsDisplayOnReviewandSubmitPage()
	{		
		Reporter.log(Utilities.logOutputFile(" ########## Start Verify Elements Display On Review and Submit Page STARTS ###########"));
		test.clickonTermAndConditionsonReviewandSubmitPage();	
		Reporter.log(Utilities.logOutputFile(" ########## Start Verify Elements Display On Review and Submit Page ENDS ###########"));

	}

	
	@AfterClass
    public void tearDown() 
     {
		Reporter.log(Utilities.logOutputFile(" ########## Stop Browser Session ###########"));
//		test.stopBrowserSession();
     }	
	
}