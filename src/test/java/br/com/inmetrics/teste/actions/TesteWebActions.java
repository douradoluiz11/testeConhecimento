package br.com.inmetrics.teste.actions;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import br.com.inmetrics.teste.model.WaitsElement;
import br.com.inmetrics.teste.support.Hooks;

public class TesteWebActions {
	
	Log logger = LogFactory.getLog(TesteWebActions.class);

	public void esperaExplicita(By element, int segundos) throws InterruptedException {
		
		WebDriverWait wait = new WebDriverWait(Hooks.getDriver(), segundos);
		WaitsElement we = new WaitsElement();
		we.aguardarElementoVisivel(element, segundos);
		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(element));
	}
	
	public void buscarElemento(String sexo, By lista) throws InterruptedException {
		
		 Thread.sleep(2000);
		
		java.util.List<WebElement> relacaoSexo  =  Hooks.getDriver().findElements(lista);
		
		for (int i=0; i < relacaoSexo.size(); i++) {
			 Thread.sleep(2000);
			
			String sexoInformado = relacaoSexo.get(i).getText();
			if(relacaoSexo.get(i).getText().equalsIgnoreCase(sexo)) {
				
			System.out.println("Sexo:" + sexoInformado );
			
			relacaoSexo.get(i).click();
			break;
			
			} else {
				
				System.out.println("sexo INCORRETO: " + sexoInformado);
			}
			
			
		}

}
	
	public void selecionarPorTextoVisivel(By elemento, String textoVisivel) {

		WebDriverWait wait = new WebDriverWait(Hooks.getDriver(), 30);
		WebElement selectElement = Hooks.getDriver().findElement(elemento);
		Select select = new Select(selectElement);
		select.selectByVisibleText(textoVisivel);
		
	}
	
	
	 public void espera(int segundos) {
			logger.info(" -- Realizar a acao de esperar por: " + segundos + " segundos");
			try {
				Thread.sleep(segundos * 1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		 }
	
}
