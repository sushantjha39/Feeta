package feeta;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

public class Sickleave extends Base {
	@Test
	public static void sickLeave() throws InterruptedException, IOException {
		login();
		// TODO Auto-generated method stub
		WebElement leave = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()=' Leave ']")));
		leave.click();
		WebElement menu = wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.cssSelector("mat-icon[data-mat-icon-type='font']")));
		menu.click();
		WebElement sickLeaveCount = wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//app-employee-view/div/div[1]/div[2]/div[2]")));
		String Sl = sickLeaveCount.getText();
		System.out.println(Sl);
		String count = extractNumber(Sl);
		System.out.println(count);

		Base.applyforleave();
		Base.selectManager();
		
		WebElement sickleave = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='Sick leave']")));
		sickleave.click();
		Thread.sleep(1000);
		Base.dateselector();
		WebElement sickleavedate = wait.until(ExpectedConditions.visibilityOfElementLocated(
				(By.xpath("//div[contains(@class, 'mat-calendar-body-cell-content') and contains(text(), '3')]"))));
		sickleavedate.click();
		sickleavedate.click();
		WebElement workingDays = wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("//app-add-leave//div[2]/div/div[3]/div")));
		String leavetext = workingDays.getText();

		// Extract the number from the text
		String number = extractNumber(leavetext);

		// Print the extracted number
		System.out.println(number);
		Thread.sleep(1000);
		
		Base.submitbutton();
		driver.navigate().refresh();
		Thread.sleep(1000);
		
		int calculate = Integer.parseInt(count) - Integer.parseInt(number);
		System.out.println(calculate);
		Thread.sleep(1000);
		WebElement sickLeaveAfterUpdate = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//app-leaves/app-employee-view/div/div[1]/div[2]/div[2]")));
		String afterUpdateCount = sickLeaveAfterUpdate.getText();
		System.out.println(afterUpdateCount);
		String afterUpdate = extractNumber(afterUpdateCount);
		System.out.println(afterUpdate);
		if (calculate == Integer.parseInt(afterUpdate)) {
			System.out.println("Sick Leave count is" + "calculate");
		} else {
			System.out.println("Sick leave count is incorrect");
		}
	}

	private static String extractNumber(String text) {
		String number = text.replaceAll("[^0-9]", "");
		return number;
	}

	

}
