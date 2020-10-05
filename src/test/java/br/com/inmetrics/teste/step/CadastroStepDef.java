package br.com.inmetrics.teste.step;

import static org.junit.Assert.assertEquals;

import br.com.inmetrics.teste.actions.TesteWebActions;
import br.com.inmetrics.teste.environment.EnvironmentResolver;
import br.com.inmetrics.teste.model.Model;
import br.com.inmetrics.teste.pages.BasePage;
import br.com.inmetrics.teste.pages.TesteWebPage;
import br.com.inmetrics.teste.support.Hooks;
import cucumber.runtime.Env;
import io.cucumber.java8.En;

public class CadastroStepDef extends BasePage implements En{
	
	TesteWebActions actions = new TesteWebActions();
	
	public CadastroStepDef() {
		
		Given("Acesso o site de cadastro", () -> {
			
			waitForLoad(Hooks.getDriver());
			Hooks.getUrl("url");
		   
		});

		When("Clico no botão de cadasto", () -> {
			
			testeWebPage().getBTN_CADASTRAR().click();
			actions.esperaExplicita(TesteWebPage.TXT_CADASTRE_SE,5);
			
		    
		});

		When("preencho dados do cadastro", () -> {
			
			Model.user = "InMetrics" + Model.geraNumero8Digitos();
			
			testeWebPage().getUSUARIO().sendKeys(Model.user);
			
			System.out.println(Model.user);
			
			testeWebPage().getPASS().sendKeys(EnvironmentResolver.getNamedEnvValue("pass"));
			testeWebPage().getCONFPASS().sendKeys(EnvironmentResolver.getNamedEnvValue("confPass"));
		  
		});

		When("clico no botao cadastrar", () -> {
			
			testeWebPage().getBTN_CADASTRAR().click();
		   
		});

		Then("realizo cadastro com sucesso", () -> {
			
			
			assertEquals(testeWebPage().getTXT_LOGIN().getText(), "Login");
		    
		});

	}

}
