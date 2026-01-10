package base;

import org.testng.annotations.BeforeMethod;

import pages.LoginPage;

public class common extends BaseTest {

	    @BeforeMethod
	    public void login() throws InterruptedException {

	        LoginPage lp = new LoginPage(driver);
	        lp.email("kiran@gmail.com");
	        lp.password("123456");
	        lp.signin();

	        Thread.sleep(500);
	  
	    }
	}
	
	


