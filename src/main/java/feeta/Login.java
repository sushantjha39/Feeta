package feeta;

import java.io.IOException;

import javax.xml.transform.Result;

import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;

public class Login extends Extentreport {

	public static void main(String[] args) {
		 
	}
	
	@Test
	private static void Loginfeeta() throws IOException, InterruptedException {
		// TODO Auto-generated method stub
		
		
		Base.login();
		
	
		//Desktop.getDesktop().browse(new File("C:\\Users\\Sushsant\\eclipse-workspace\\Feeta\\Report\\report.html").toURI());
		return;
		
	}
	
}

