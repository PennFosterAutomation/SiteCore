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

public class EOLCanadaReceiveInfo_nocourse_Test {
	
	WebDriver driverTest;
	
	 EOLCanadaReceiveInfo_nocourse_Fixture test = new EOLCanadaReceiveInfo_nocourse_Fixture();
	 
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
	 
 	 EOLCanadaReceiveInfo_nocourse_Test()
	 {
		 DateFormat dateFormat = new SimpleDateFormat("ddmmssSSS");
		 Date date = new Date();		 
		 preFix = dateFormat.format(date);
	 }
	
	@BeforeClass
    public void initialsettings() 
    {
        test.setUpDataFile("testData/integration_testData_Canada.yml");
        if (Utilities.getYamlValue("CanadaURLReceiveInformationnocourse.RunType").equalsIgnoreCase("OneIteration")){
        	Utilities.createExcel();
        }
        
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
	public void getNumberOfCourseAvailable()
	{		
		Reporter.log(Utilities.logOutputFile(" ########## Start Get Number Of Course Available STARTS ###########"));
		test.getCourseCount();		
		Reporter.log(Utilities.logOutputFile(" ########## Start Get Number Of Course Available ENDS ###########"));


	}
	
	@Test(dependsOnMethods = "getNumberOfCourseAvailable")
	public void selectCourseFromAvailableCourses()
	{		
		if (Utilities.getYamlValue("CanadaURLReceiveInformationnocourse.RunType").equalsIgnoreCase("Selected")){
			Reporter.log(Utilities.logOutputFile(" ########## Start Select Course From Available Courses STARTS ###########"));
			test.selectCourse(Utilities.getYamlValue("CanadaURLReceiveInformationnocourse.SelectCourse.Cource"+AllCourse_EOLCanadaReceiveInfo_nocourse_Tests.initialCounter));				
			Reporter.log(Utilities.logOutputFile(" ########## Start Select Course From Available Courses ENDS ###########"));			
		}else{
			if (Utilities.getYamlValue("CanadaURLReceiveInformationnocourse.RunType").equalsIgnoreCase("AllCources")){
				Reporter.log(Utilities.logOutputFile(" ########## Start Select Course From Available Courses STARTS ###########"));			
				test.selectCourse("");				
				Reporter.log(Utilities.logOutputFile(" ########## Start Select Course From Available Courses ENDS ###########"));
		}else{
			Reporter.log(Utilities.logOutputFile(" ########## Start Select Course From Available Courses STARTS ###########"));			
//			test.selectCourse("A.S. DEGREE INTERIOR DESIGN");	
			test.selectCourse("ADMINISTRATIVE ASSISTANT");				

			Reporter.log(Utilities.logOutputFile(" ########## Start Select Course From Available Courses ENDS ###########"));
			
		}
						
		}
		

	}
	
	@Test(dependsOnMethods = "selectCourseFromAvailableCourses")
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

		  Fname = test.getYamlVal("CanadaURLReceiveInformationnocourse.StudentInformation.FirstName");
		  Lname = Utilities.getFname();
		  Mail = test.getYamlVal("CanadaURLReceiveInformationnocourse.StudentInformation.Email");
		  EmailExt = test.getYamlVal("CanadaURLReceiveInformationnocourse.StudentInformation.EmailExt");
		  Phone = test.getYamlVal("CanadaURLReceiveInformationnocourse.StudentInformation.PrimaryPhone");
		  Address = test.getYamlVal("CanadaURLReceiveInformationnocourse.StudentInformation.Address");
		  City = test.getYamlVal("CanadaURLReceiveInformationnocourse.StudentInformation.City");
		  State = test.getYamlVal("CanadaURLReceiveInformationnocourse.StudentInformation.State");
		  Zip = test.getYamlVal("CanadaURLReceiveInformationnocourse.StudentInformation.ZIP");
		

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
		String DOBmonth = test.getYamlVal("CanadaURLReceiveInformationnocourse.StudentInformation.DOBmonth");
		 String DOBday = test.getYamlVal("CanadaURLReceiveInformationnocourse.StudentInformation.DOBday");
		 String DOByear = test.getYamlVal("CanadaURLReceiveInformationnocourse.StudentInformation.DOByear");
		test.enterInformationOnPersonalInformationPage(DOBmonth, DOBday, DOByear);	
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

		CreditCardNumber = test.getYamlVal("CanadaURLReceiveInformationnocourse.StudentInformation.CreditCardNumber");
		CVV = test.getYamlVal("CanadaURLReceiveInformationnocourse.StudentInformation.CVV");
		test.enterCreditCardInformationAfterCreditCardSelection(CreditCardNumber, CVV);	
		Reporter.log(Utilities.logOutputFile(" ########## Start Verify Elements Display After Select Mode Of Payment ENDS ###########"));

	}
	


		@Test(dependsOnMethods = "enterCreditCardInformation")
		public void verifyElementsDisplayOnReviewAndSubmitPage()
		{		
			Reporter.log(Utilities.logOutputFile(" ########## Start Enter CreditCard Information STARTS ###########"));
			test.verifyInformationFieldDisplayOnReviewandSubmitPage();	
			Reporter.log(Utilities.logOutputFile(" ########## Start Enter CreditCard Information ENDS ###########"));

		}
		
		@Test(dependsOnMethods = "verifyElementsDisplayOnReviewAndSubmitPage")
		public void verifyandClickOnTermAndComtitionsDisplayOnReviewandSubmitPage()
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
