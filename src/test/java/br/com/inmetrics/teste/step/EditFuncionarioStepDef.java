package br.com.inmetrics.teste.step;

import static org.junit.Assert.assertEquals;

import org.junit.Assert;

import br.com.inmetrics.teste.actions.TesteWebActions;
import br.com.inmetrics.teste.model.Model;
import br.com.inmetrics.teste.pages.BasePage;
import io.cucumber.java8.En;

public class EditFuncionarioStepDef extends BasePage implements En {

	TesteWebActions actions = new TesteWebActions();

	public EditFuncionarioStepDef() {

		Given("pesquiso por nome do funcionario", () -> {

			testeWebPage().getTBL_FILTER().click();
			testeWebPage().getTBL_FILTER().sendKeys(Model.funcionario);

		});

		Given("valido meu funcionario", () -> {

			String rowNameFunc = testeWebPage().getROW_NAME_FUNC().getText();
			assertEquals(rowNameFunc, Model.funcionario);

		});

		Given("clico no botão editar", () -> {

			testeWebPage().getBTN_EDIT().click();
			actions.espera(5);

		});

		Given("Edito nome funcionario", () -> {

			testeWebPage().getNAME_EMPLOYEE().click();
			testeWebPage().getNAME_EMPLOYEE().clear();

			Model.funcionario = "InMetrics" + Model.geraNumero8Digitos();

			testeWebPage().getNAME_EMPLOYEE().sendKeys(Model.funcionario);
			actions.espera(5);

		});

		Given("envio alteracao", () -> {

			testeWebPage().getBTN_ENVIAR().click();
			actions.espera(10);

		});

		Given("valido edicao de cadastro com sucesso", () -> {

			String text = testeWebPage().getTXT_SUCESSO().getText();
			System.out.println(text);
			Assert.assertTrue(text.contains("SUCESSO! Informações atualizadas com sucesso"));

		});
	}

}
