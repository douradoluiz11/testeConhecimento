package br.com.inmetrics.teste.step;

import static org.junit.Assert.assertEquals;

import org.openqa.selenium.WebDriver;

import br.com.inmetrics.teste.actions.TesteWebActions;
import br.com.inmetrics.teste.environment.EnvironmentResolver;
import br.com.inmetrics.teste.pages.BasePage;
import br.com.inmetrics.teste.pages.TesteWebPage;
import br.com.inmetrics.teste.support.Hooks;
import io.cucumber.java8.En;

public class LoginStepDef extends BasePage implements En {
 
	TesteWebActions actions = new TesteWebActions();
	
	public LoginStepDef() {

		Given("Que estou na pagina de login", () -> {

			waitForLoad(Hooks.getDriver());
			Hooks.getUrl("url");

		});

		Given("insiro o meu user", () -> {
			
			testeWebPage().getUSUARIO().sendKeys(EnvironmentResolver.getNamedEnvValue("user"));	
			
		});

		Given("insiro o meu password", () -> {
			
			testeWebPage().getPASS().sendKeys(EnvironmentResolver.getNamedEnvValue("pass"));

		});

		When("clico no botao entre", () -> {
			
			testeWebPage().getBTN_ENTRE().click();

		});

		Then("sou redirecionado a pagina de entrada", () -> {
			
			actions.esperaExplicita(TesteWebPage.TBL_NOME,10);
			
			assertEquals(Hooks.getDriver().findElement(TesteWebPage.TBL_NOME).getText(), "Nome");

		});

	}

}
