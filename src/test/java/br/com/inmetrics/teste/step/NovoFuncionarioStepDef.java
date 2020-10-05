package br.com.inmetrics.teste.step;

import static org.junit.Assert.assertEquals;

import org.junit.Assert;

import br.com.inmetrics.teste.actions.TesteWebActions;
import br.com.inmetrics.teste.environment.EnvironmentResolver;
import br.com.inmetrics.teste.model.Model;
import br.com.inmetrics.teste.pages.BasePage;
import br.com.inmetrics.teste.pages.TesteWebPage;
import br.com.inmetrics.teste.support.Hooks;
import io.cucumber.java8.En;

public class NovoFuncionarioStepDef extends BasePage implements En {

	TesteWebActions actions = new TesteWebActions();

	public NovoFuncionarioStepDef() {
		
		Given("Acesso o site de cadastro new empregado", () -> {

			waitForLoad(Hooks.getDriver());
			Hooks.getUrl("url");
			testeWebPage().getUSUARIO().sendKeys(EnvironmentResolver.getNamedEnvValue("user"));
			testeWebPage().getPASS().sendKeys(EnvironmentResolver.getNamedEnvValue("pass"));
			testeWebPage().getBTN_ENTRE().click();
			
			

		});

		When("Clico no botão de novo funcionario", () -> {

			actions.esperaExplicita(TesteWebPage.BTN_NEW_EMPLOYEE, 10);

			Hooks.getDriver().findElement(TesteWebPage.BTN_NEW_EMPLOYEE).click();

		});

		When("preencho dados do novo funcionario", () -> {
			
			Model.funcionario = "InMetrics" + Model.geraNumero8Digitos();

			testeWebPage().getNAME_EMPLOYEE().sendKeys(Model.funcionario);
			actions.espera(5);
			testeWebPage().getCARGO().sendKeys("QA");
			actions.espera(5);
			testeWebPage().getCPF().click();
			testeWebPage().getCPF().sendKeys("089.403.814-16");
			actions.espera(5);
			testeWebPage().getSALARIO().sendKeys("1000,00");
			actions.espera(5);
			actions.selecionarPorTextoVisivel(TesteWebPage.LISTA_SEXO, "Masculino");
			actions.espera(5);
			testeWebPage().getCLT().click();
			actions.espera(5);
			testeWebPage().getADMISSAO().sendKeys("04/10/2020");
			actions.espera(5);
			
			

		});

		When("clico no botao enviar", () -> {
			
			testeWebPage().getBTN_ENVIAR().click();
			actions.espera(5);

		});

		Then("valido cadastro com sucesso", () -> {
			
		String text = testeWebPage().getTXT_SUCESSO().getText();
		System.out.println(text);
		Assert.assertTrue(text.contains("SUCESSO! Usuário cadastrado com sucesso"));
			

		});

	}

}
