package feeta;
import java.io.IOException;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

public class Earnedleave extends Base {

	public static void main(String[] args) throws IOException, InterruptedException {
		// TODO Auto-generated method stub

	}

	@SuppressWarnings("rawtypes")
	@Test
	public void earnedleave() throws InterruptedException, IOException {
		
			
		
		Base.login();

		WebElement leave = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()=' Leave ']")));
		leave.click();
		WebElement menu = wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.cssSelector("mat-icon[data-mat-icon-type='font']")));
		menu.click();
		WebElement headingElement = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.mat-headline")));
		headingElement.getText();
		System.out.println(headingElement);
		if (headingElement.getText().equals(" Leave ")) {
			System.out.println(" Heading name is Leave");
		} else {
			System.out.println("Incorrect Heading name");
		}
		WebElement searchElement = wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.cssSelector("[formcontrolname='searchFilterControl']")));
		boolean isClickable = wait.until(ExpectedConditions.elementToBeClickable(searchElement)) != null;

		if (isClickable) {

			System.out.println("Search field is clickable");
		} else {

			System.out.println("Search field is not clickable");
		}
		searchElement.sendKeys("Sushant");
		WebElement searchresult = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("mat-cell")));
		String search = searchresult.getText();
		System.out.println(searchresult);
		if (searchElement.equals(search)) {

			System.out.println("Search result found");
		} else {
			System.out.println("No record found");
		}
		searchElement.clear();
		Thread.sleep(1000);
		WebElement earnedLeaveCount = wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//app-leaves/app-employee-view/div/div[1]/div[1]/div[2]")));
		String El = earnedLeaveCount.getText();
		String count = extractNumber(El);
		System.out.println(count);
		Base.applyforleave();
		Base.selectManager();
		WebElement Earnedleave = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='Earned leave']")));
		Earnedleave.click();
		Thread.sleep(2000);
		Base.dateselector();
		WebElement nextMonth = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[aria-label=\"Next month\"]")));
		nextMonth.click();
		WebElement selectDate = wait.until(ExpectedConditions.visibilityOfElementLocated(
				(By.xpath("//div[contains(@class, 'mat-calendar-body-cell-content') and contains(text(), '17')]"))));
		selectDate.click();
		WebElement selectAnotherDate = wait.until(ExpectedConditions.visibilityOfElementLocated(
				(By.xpath("//div[contains(@class, 'mat-calendar-body-cell-content') and contains(text(), '18')]"))));
		selectAnotherDate.click();
		WebElement workingDays = wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("//app-add-leave//div[2]/div/div[3]/div")));
		String leavetext = workingDays.getText();

		// Extract the number from the text
		String number = extractNumber(leavetext);

		// Print the extracted number
		System.out.println(number);

		WebElement notes = wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[formcontrolname='notesFormControl']")));
		notes.sendKeys("Not well");
//		 WebElement Uploadfile =
//		 wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='
//		 UPLOAD FILE ']")));
//		 Uploadfile.click();
//		
//		
//		 Process process=
//		 Runtime.getRuntime().exec("\"C:\\Users\\Sushsant\\Desktop\\upload.exe\"");
		
//		
//		 try {
//		  process.wait(2000);
//		
//		 } catch (Exception e) {
//		 TODO: handle exception
//		 }
		Base.submitbutton();
		int calculate = Integer.parseInt(count) - Integer.parseInt(number);
		Thread.sleep(1000);
		WebElement earnedLeaveAfterUpdate = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='leave-data'][1]")));
		String afterUpdateCount = earnedLeaveAfterUpdate.getText();
		String afterUpdate = extractNumber(afterUpdateCount);
		System.out.println(afterUpdate);
		if (calculate == Integer.parseInt(afterUpdate)) {
			System.out.println("Earned Leave count is" + "calculate");
		} else {
			System.out.println("earned leave count is incorrect");
		}
		List<WebElement> elements = driver
				.findElements(By.xpath("//mat-icon[contains(@class, 'mat-icon-no-color') and text()='edit']"));

		// Check if the desired index is within the bounds of the list
		int desiredIndex = 2;
		if (desiredIndex >= 2 && desiredIndex < elements.size()) {
			// Access the desired element by index
			WebElement desiredElement = elements.get(desiredIndex);
			// Perform actions on the selected element
			// For example, click on it
			desiredElement.click();
		} else {
			System.out.println("Desired index is out of bounds.");
		}
		WebElement withdrawLeave = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='WITHDRAW LEAVE']")));
		Thread.sleep(1000);
		withdrawLeave.click();
		Thread.sleep(1000);
		WebElement confirmwithdrawLeave = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='WITHDRAW LEAVE']")));
		Thread.sleep(1000);
		confirmwithdrawLeave.click();
		
			
		}
		
	
	private String extractNumber(WebElement afterLeave) {
		// TODO Auto-generated method stub
		return null;
	}

	private static String extractNumber(String text) {
		String number = text.replaceAll("[^0-9]", "");
		return number;
	}

}
