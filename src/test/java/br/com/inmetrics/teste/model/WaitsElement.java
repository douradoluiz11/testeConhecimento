package br.com.inmetrics.teste.model;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import br.com.inmetrics.teste.support.Hooks;

public class WaitsElement {
	
	public static int escape = 0;
    public static int contador = 0;
    public static int tentativas = 0;

    public static Boolean aguardarElementoVisivel(By e, int interacoes) throws InterruptedException {
        if (escape == 0) {
            contador = interacoes;
            escape = 1;
        }

        try {
            if (Hooks.getDriver().findElement(e).isDisplayed()) {
                return true;
            }
        } catch (Exception exception) {

            Thread.sleep(2000);
            System.out.println("Elemento nao encontrado, tentando " + tentativas + " vez(es)");

            if (tentativas < contador) {
                tentativas++;
                By temp = e;
                aguardarElementoVisivel(temp, contador);
            } else {
                return false;
            }
        }
        return null;
    }

    public static Boolean aguardarElementoClickavel(By e, int interacoes) throws InterruptedException {
        if (escape == 0) {
            contador = interacoes;
            escape = 1;
        }
        WebDriverWait wait = new WebDriverWait(Hooks.getDriver(),30);
        try {
            if (wait.until(ExpectedConditions.elementToBeClickable(e)).isEnabled()) {
                return true;
            }
        } catch (Exception exception) {

            Thread.sleep(2000);
            System.out.println("Elemento nao encontrado, tentando " + tentativas + " vez(es)");

            if (tentativas < contador) {
                tentativas++;
                By temp = e;
                aguardarElementoVisivel(temp, contador);
            } else {
                return false;
            }
        }
        return null;
    }

}
