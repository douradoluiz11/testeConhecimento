package br.com.inmetrics.teste.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import br.com.inmetrics.teste.environment.EnvironmentResolver;
import br.com.inmetrics.teste.exceptions.NoSuchEnvironmentException;
import br.com.inmetrics.teste.support.Hooks;
import br.com.inmetrics.teste.utils.PageFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class BasePage {

	public void waitForLoad(WebDriver driver) {
		ExpectedCondition<Boolean> expectation = new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver driver) {
				return ((JavascriptExecutor) driver).executeScript("return document.readyState").toString()
						.equals("complete");
			}
		};
	}

	@SuppressWarnings("unchecked")
	private static <T> T getPage(Class<?> clazz) {
		T page = null;
		try {
			page = (T) clazz.newInstance();
		} catch (InstantiationException | IllegalAccessException e) {
			e.printStackTrace();
		}
		PageFactory.initElements(Hooks.getDriver(), page);
		return page;
	}

	public static TesteWebPage testeWebPage() {

		return getPage(TesteWebPage.class);

	}

}
