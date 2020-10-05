package br.com.inmetrics.teste.support;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import br.com.inmetrics.teste.environment.EnvironmentResolver;
import br.com.inmetrics.teste.exceptions.NoSuchEnvironmentException;
import br.com.inmetrics.teste.pages.BasePage;
import io.cucumber.core.api.Scenario;
import io.cucumber.java8.En;

public class Hooks extends BasePage implements En {

	public static WebDriver driver;

	@io.cucumber.java.Before
	public static WebDriver getDriver() {
		if (driver == null) {
			System.setProperty("webdriver.chrome.driver",
					"src\\main\\java\\br\\com\\inmetrics\\teste\\driver\\chromedriver.exe");
			driver = new ChromeDriver();
			driver.manage().window().maximize();

		}
		return driver;
	}

	@io.cucumber.java.After
	public static void killDrivers() {
		if (driver != null) {
			driver.quit();
			driver = null;
		}
	}

	public static String getUrl(String url) throws NoSuchEnvironmentException {

		getDriver().get(EnvironmentResolver.getNamedEnvValue(url));

		return url;
	}
	
	@io.cucumber.java.AfterStep
	public void screenshot(Scenario scenario) {

		String namePrint = scenario.getName();
		String nameFeature = extractFeature(scenario);
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyy-HHmmss");
		Date date = new Date();
		byte[] scrFile = ((TakesScreenshot) Hooks.getDriver()).getScreenshotAs(OutputType.BYTES);
		try {
		   FileUtils.writeByteArrayToFile(new File("target"+"/"+"Relatorios" +"/"+"screenshot"+ "/" + nameFeature + "/"+ namePrint +"/" + namePrint + "_"
				 + dateFormat.format(date) + ".png"),scrFile);
		} catch (IOException e) {
		   e.printStackTrace();
		}
		scenario.embed(scrFile,"image/png");
	}
	
	public static String extractFeature(Scenario scenario) {
		Pattern pattern = Pattern.compile("^(([A-Z]:)?[\\.]?[\\\\{1,2}/]?.*[\\\\{1,2}/])*(.+)\\.(.+)");
		Matcher matcher = pattern.matcher(scenario.getUri());
		if(matcher.find()) {
			return matcher.group(matcher.groupCount()-1);
		}
		return "";
	}

}