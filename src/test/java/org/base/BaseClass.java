package org.base;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {

	public static WebDriver driver;

	public static WebDriver getDriver() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		return driver;
	}

	public static WebDriver getFirefoxDriver() {
		WebDriverManager.firefoxdriver().setup();
		driver = new FirefoxDriver();
		return driver;
	}

	public static WebDriver getEdgeDriver() {
		WebDriverManager.edgedriver().setup();
		driver = new EdgeDriver();
		return driver;
	}
	
	public static WebDriver getIEDriver() {
		WebDriverManager.iedriver().setup();
		driver = new InternetExplorerDriver();
		return driver;
	}

	public static void launchUrl(String url) {
		driver.get(url);
		driver.manage().window().maximize();
	}

	public static WebElement locatorById(String data) {
		WebElement element = driver.findElement(By.id(data));
		return element;
	}

	public static WebElement locatorByName(String data) {
		WebElement element = driver.findElement(By.name(data));
		return element;
	}

	public static WebElement locatorByClassName(String data) {
		WebElement element = driver.findElement(By.className(data));
		return element;
	}

	public static WebElement locatorByXpath(String data) {
		WebElement element = driver.findElement(By.xpath(data));
		return element;
	}

	public static WebElement locatorByTagName(String data) {
		WebElement element = driver.findElement(By.tagName(data));
		return element;
	}

	public static void countUsingFrameTagName() {
		List<WebElement> findElements = driver.findElements(By.tagName("frame"));
		int size = findElements.size();
		System.out.println(size);
	}

	public static void countUsingTableTagName() {
		List<WebElement> findElements = driver.findElements(By.tagName("table"));
		int size = findElements.size();
		System.out.println(size);
	}

	public static void title() {
		String title = driver.getTitle();
		System.out.println(title);
	}

	public static void currentUrl() {
		String currentUrl = driver.getCurrentUrl();
		System.out.println(currentUrl);
	}

	public static void text(WebElement element) {
		String text = element.getText();
		System.out.println(text);
	}

	public static String getValue(WebElement element) {
		String data = element.getAttribute("value");
		return data;
	}

	public static void insertValues(WebElement element, String data) {
		element.sendKeys(data);
	}

	public static void click(WebElement element) {
		element.click();
	}

	public static void quit() {
		driver.quit();
	}

	public static void moveToElement(WebElement element) {
		new Actions(driver).moveToElement(element).perform();
	}

	public static void contextClick(WebElement element) {
		new Actions(driver).contextClick(element).perform();
	}

	public static void doubleClick(WebElement element) {
		new Actions(driver).doubleClick(element).perform();
	}

	public static void dragAndDrop(WebElement element) {
		new Actions(driver).dragAndDrop(element, element).perform();
	}

	public static void clickHoldAndRelease(WebElement element) {
		new Actions(driver).clickAndHold(element).moveToElement(element).release().perform();
	}

	public static void keyDown(WebElement element, CharSequence keys) {
		new Actions(driver).keyDown(element, keys).perform();
	}

	public static void sendKeys(WebElement element, String data) {
		new Actions(driver).sendKeys(element, data).perform();
	}

	public static void keyUp(WebElement element, CharSequence keys) {
		new Actions(driver).keyUp(element, keys).perform();
	}
	
	public static void searchEnter() throws AWTException {
		new Robot().keyPress(KeyEvent.VK_ENTER);
		new Robot().keyRelease(KeyEvent.VK_ENTER);
	}

	public static void copyValues(WebElement element) throws AWTException {
		new Robot().keyPress(KeyEvent.VK_CONTROL);
		new Robot().keyPress(KeyEvent.VK_A);
		new Robot().keyRelease(KeyEvent.VK_A);
		new Robot().keyPress(KeyEvent.VK_C);
		new Robot().keyRelease(KeyEvent.VK_C);
		new Robot().keyRelease(KeyEvent.VK_CONTROL);

	}

	public static void pasteValues(WebElement element) throws AWTException {
		new Robot().keyPress(KeyEvent.VK_CONTROL);
		new Robot().keyPress(KeyEvent.VK_V);
		new Robot().keyRelease(KeyEvent.VK_V);
		new Robot().keyRelease(KeyEvent.VK_CONTROL);
	}

	public static void simpleAlert() {
		Alert alert = driver.switchTo().alert();
		alert.accept();
	}

	public static void confirmAlertIfOk() {
		Alert alert = driver.switchTo().alert();
		alert.accept();
	}

	public static void confirmAlertIfNotOk() {
		Alert alert = driver.switchTo().alert();
		alert.dismiss();
	}

	public static void promptAlertInsertValues(String data) {
		Alert alert = driver.switchTo().alert();
		alert.sendKeys(data);
		alert.accept();
	}

	public static void promptAlertGetValues() {
		Alert alert = driver.switchTo().alert();
		String text = alert.getText();
		System.out.println(text);
		alert.accept();
	}

	public static void screenShot(String name) throws IOException {
		TakesScreenshot screenshot = (TakesScreenshot) driver;
		File source = screenshot.getScreenshotAs(OutputType.FILE);
		File destination = new File(System.getProperty("user.dir") + "\\target\\" + name + ".png");
		FileHandler.copy(source, destination);
	}
	
	public static void screenshotCopy(String name) throws IOException {
		TakesScreenshot screenshot = (TakesScreenshot) driver;
		File source = screenshot.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(source, new File(name));
	}

	public static void javaSriptInsertValues(String data, WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].setAttribute('value','" + data + "')", element);
	}

	public static String javaSriptGetValues(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		String executeScript = (String) js.executeScript("return arguments[0].getAttribute('value')", element);
		return executeScript;
	}

	public static void javaScriptClick(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click()", element);
	}

	public static void scrollUp(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(false)", element);
	}

	public static void scrollDown(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true)", element);
	}

	public static void selectByIndex(WebElement element, int i) {
		new Select(element).selectByIndex(i);
	}

	public static void selectByValue(WebElement element, String data) {
		new Select(element).selectByValue(data);
	}

	public static void selectByVisibleText(WebElement element, String data) {
		new Select(element).selectByVisibleText(data);
	}

	public static void getAllOptions(WebElement element) {
		new Select(element).getOptions();
	}

	public static void getAllSelectedOptionsSelectedByIndex(WebElement element) {
		List<WebElement> allSelectedOptions = new Select(element).getAllSelectedOptions();
		for (WebElement all : allSelectedOptions) {
			String name = all.getText();
			System.out.println(name);
		}
	}

	public static void getAllSelectedOptionsSelectedByValue(WebElement element) {
		List<WebElement> allSelectedOptions = new Select(element).getAllSelectedOptions();
		for (WebElement all : allSelectedOptions) {
			String name = all.getText();
			System.out.println(name);
		}
	}

	public static void getAllSelectedOptionsSelectedByVisibleText(WebElement element) {
		List<WebElement> allSelectedOptions = new Select(element).getAllSelectedOptions();
		for (WebElement all : allSelectedOptions) {
			String name = all.getText();
			System.out.println(name);
		}
	}

	public static void getFirstSelectedOption(WebElement element) {
		WebElement firstSelectedOption = new Select(element).getFirstSelectedOption();
		String name = firstSelectedOption.getText();
		System.out.println(name);
	}

	public static void deselectByIndex(WebElement element, int i) {
		new Select(element).deselectByIndex(i);
	}

	public static void deselectByValue(WebElement element, String data) {
		new Select(element).deselectByValue(data);
	}

	public static void deselectByVisibleText(WebElement element, String data) {
		new Select(element).deselectByVisibleText(data);
	}

	public static void deselectAll(WebElement element) {
		new Select(element).deselectAll();
	}

	public static void isOptionsMultiple(WebElement element) {
		boolean multiple = new Select(element).isMultiple();
		System.out.println(multiple);
	}

	public static String fileDataReading(String path, String sheetName, int rowNo, int cellNo) throws IOException {
		File file = new File(path);
		FileInputStream stream = new FileInputStream(file);
		Workbook workbook = new XSSFWorkbook(stream);
		Sheet sheet = workbook.getSheet(sheetName);
		Row row = sheet.getRow(rowNo);
		Cell cell = row.getCell(cellNo);
		int cellType = cell.getCellType();
		String value = "";

		if (cellType == 1) {
			value = cell.getStringCellValue();
		} else if (DateUtil.isCellDateFormatted(cell)) {
			SimpleDateFormat dateFormat = new SimpleDateFormat("dd/mmm/yy");
			value = dateFormat.format(cell.getDateCellValue());
		} else {
			double numericCellValue = cell.getNumericCellValue();
			long l = (long) numericCellValue;
			value = String.valueOf(l);
		}

		return value;
	}

	public static void fileValueAddition(String filePath, String sheetName, int rowNo, int cellNo, String value)
			throws IOException {
		File file = new File(filePath);
		FileInputStream stream = new FileInputStream(file);
		Workbook workbook = new XSSFWorkbook(stream);
		Sheet sheet = workbook.getSheet(sheetName);
		Row row = sheet.getRow(rowNo);
		Cell cell = row.createCell(cellNo);
		cell.setCellValue(value);
		FileOutputStream output = new FileOutputStream(file);
		workbook.write(output);
	}

	public static void fileCreation(String filePath, String sheetName, int rowNo, int cellNo, String value)
			throws IOException {
		File file = new File(filePath);
		Workbook workbook = new XSSFWorkbook();
		Sheet sheet = workbook.createSheet(sheetName);
		Row row = sheet.createRow(rowNo);
		Cell cell = row.createCell(cellNo);
		cell.setCellValue(value);
		FileOutputStream output = new FileOutputStream(file);
		workbook.write(output);
	}

	public static void implicitlyWait(int seconds) {
		driver.manage().timeouts().implicitlyWait(seconds, TimeUnit.SECONDS);
	}

	public static WebElement webdriverWaitUntilVisibilityOfElement(int seconds, String data) {
		WebDriverWait wait = new WebDriverWait(driver, seconds);
		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(data)));
		return element;
	}

}