package br.com.inmetrics.teste.pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class CadastrarUsuarioPO extends GenericoPO{

    @FindBy(how = How.NAME, using = "username")
    private WebElement campoUsuario;

    @FindBy(how = How.NAME, using = "pass")
    private WebElement campoSenha;

    @FindBy(how = How.NAME, using = "confirmpass")
    private WebElement campoConfirmaSenha;

    @FindBy(how = How.XPATH, using = "//button[@class='login100-form-btn']")
    private WebElement botaoCadastrar;
    
    @FindBy(how = How.XPATH, using = "//span[@class='login100-form-title p-b-1']")
    private WebElement campoTituloLogin;

	@FindBy(xpath = "//a[contains(text(),'Cadastre-se')][1]")
	private WebElement linkCadastrese;
    
	public void validaTituloLogin() {
		campoTituloLogin.getText().equals("Login");
    }
    
	public void validalinkCadastrese() {
		linkCadastrese.getText().equals("Cadastre-se");
    }
    
    public void acessarTelaCadastrase() {
    	linkCadastrese.click();
    	validalinkCadastrese();
    }

    public void cadastroInformaCampoUsuario(String valor){
    	campoUsuario.sendKeys(valor);
    }

    public void cadastroInformaCampoSenha(String valor){
    	campoSenha.sendKeys(valor);
    }

    public void cadastroInformaCampoConfirmaSenha(String valor){
    	campoConfirmaSenha.sendKeys(valor);
    }

    public void cadastroClicarBotaoCadastrar(){
    	botaoCadastrar.click();
    }
    
}
