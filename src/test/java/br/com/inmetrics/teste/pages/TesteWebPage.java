package br.com.inmetrics.teste.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

import br.com.inmetrics.teste.model.Model;

public class TesteWebPage {

	@FindBy(xpath = "//input[@name='username']")
	@CacheLookup
	private WebElement USUARIO;

	@FindBy(xpath = "//input[@name='pass']")
	@CacheLookup
	private WebElement PASS;

	@FindBy(xpath = "//input[@name='confirmpass']")
	@CacheLookup
	private WebElement CONF_PASS;

	@FindBy(xpath = "//a[@class='txt2 bo1']")
	@CacheLookup
	private WebElement BTN_CADASTRAR;

	@FindBy(xpath = "//span[contains(text(),'Login')]")
	@CacheLookup
	private WebElement TXT_LOGIN;

	@FindBy(xpath = "//button[contains(text(),'Entre')]")
	@CacheLookup
	private WebElement BTN_ENTRE;

	@FindBy(id = "inputNome")
	@CacheLookup
	private WebElement NAME_EMPLOYEE;

	@FindBy(id = "inputCargo")
	@CacheLookup
	private WebElement CARGO;

	@FindBy(id = "cpf")
	@CacheLookup
	private WebElement CPF;

	@FindBy(id = "dinheiro")
	@CacheLookup
	private WebElement SALARIO;
	
	@FindBy(id = "clt")
	@CacheLookup
	private WebElement CLT;
	
	@FindBy(xpath = "//input[@class='cadastrar-form-btn']")
	@CacheLookup
	private WebElement BTN_ENVIAR;
	
	@FindBy(id = "inputAdmissao")
	@CacheLookup
	private WebElement ADMISSAO;
	
	@FindBy(xpath = "//div[@role='alert']")
	@CacheLookup
	private WebElement TXT_SUCESSO;
	
	@FindBy(xpath = "//input[@type='search']")
	@CacheLookup
	private WebElement TBL_FILTER;
	
	@FindBy(xpath = "//td[@class='text-center sorting_1']")
	@CacheLookup
	private WebElement ROW_NAME_FUNC;
	
	@FindBy(xpath = "//button[@class='btn btn-warning']")
	@CacheLookup
	private WebElement BTN_EDIT;
	
	@FindBy(id = "delete-btn")
	@CacheLookup
	private WebElement BTN_DELETE;
	


	public static By BTN_NEW_EMPLOYEE = By.xpath("//a[contains(text(),'Novo Funcionário')]");

	public static By LISTA_SEXO = By.id("slctSexo");

	public static By TBL_NOME = By.xpath("//th[contains(text(),'Nome')]");

	public static By TXT_CADASTRE_SE = By.xpath("//span[contains(text(),'Cadastre-se')]");

	public WebElement getUSUARIO() {
		return USUARIO;
	}

	public WebElement getPASS() {
		return PASS;
	}

	public WebElement getCONFPASS() {
		return CONF_PASS;
	}

	public WebElement getBTN_CADASTRAR() {
		return BTN_CADASTRAR;
	}

	public WebElement getTXT_LOGIN() {
		return TXT_LOGIN;
	}

	public WebElement getBTN_ENTRE() {
		return BTN_ENTRE;
	}

	public WebElement getNAME_EMPLOYEE() {
		return NAME_EMPLOYEE;
	}

	public WebElement getCARGO() {
		return CARGO;
	}

	public WebElement getCPF() {
		return CPF;
	}

	public WebElement getSALARIO() {
		return SALARIO;
	}
	
	public WebElement getCLT() {
		return CLT;
	}
	
	public WebElement getBTN_ENVIAR() {
		return BTN_ENVIAR;
	}
	
	public WebElement getADMISSAO() {
		return ADMISSAO;
	}
	
	public WebElement getTXT_SUCESSO() {
		return TXT_SUCESSO;
	}

	public WebElement getTBL_FILTER() {
		return TBL_FILTER;
	}
	
	public WebElement getBTN_EDIT() {
		return BTN_EDIT;
	}
	
	public WebElement getROW_NAME_FUNC() {
		return ROW_NAME_FUNC;
	}
	
	public WebElement getBTN_DELETE() {
		return BTN_DELETE;
	}

}
