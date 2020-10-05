package br.com.inmetrics.teste.step;

import org.junit.Assert;

import br.com.inmetrics.teste.actions.TesteWebActions;
import br.com.inmetrics.teste.pages.BasePage;
import io.cucumber.java8.En;

public class ExcluiFuncionarioStepDef extends BasePage implements En {
	
	TesteWebActions actions = new TesteWebActions();
	
	public ExcluiFuncionarioStepDef() {
		
		
		Given("clico no botão excluir", () -> {
			
			testeWebPage().getBTN_DELETE().click();
			actions.espera(5);
			
		    
		});

		Given("valido exclusao de cadastro com sucesso", () -> {
			
			String text = testeWebPage().getTXT_SUCESSO().getText();
			System.out.println(text);
			Assert.assertTrue(text.contains("SUCESSO! Funcionário removido com sucesso"));
		    
		});

		
		
	}

}
