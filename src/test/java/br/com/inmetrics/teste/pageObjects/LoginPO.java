package br.com.inmetrics.teste.pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import static br.com.inmetrics.teste.support.Utils.driver;

public class LoginPO extends GenericoPO{

    @FindBy(how = How.NAME, using = "username")
    private WebElement campoUsuario;

    @FindBy(how = How.NAME, using = "pass")
    private WebElement campoSenha;
    
    @FindBy(how = How.XPATH, using = "//span[@class='login100-form-title p-b-1']")
    private WebElement campoTituloLogin;

    @FindBy(how = How.XPATH, using = "//button[@class='login100-form-btn']")
    private WebElement botaoEntre;

    @FindBy(how = How.XPATH, using = "//a[contains(text(),'Funcionários')]")
    private WebElement linkFuncionario;
    
    
	public void validaTituloLogin() {
		campoTituloLogin.getText().equals("Login");
    }

    public void loginCampoUsuario(String valor){
    	campoUsuario.sendKeys(valor);
    }

    public void loginCampoSenha(String valor){
    	campoSenha.sendKeys(valor);
    }

    public void loginBotaoEntre(){
    	botaoEntre.click();
    }
    
    public static boolean validaEntrouNoSistema() throws InterruptedException {
		boolean entrou = driver.getPageSource().contains("Funcionários");
		System.out.println("Encontrou corretamente o Funcionários " + entrou);
		return entrou;
    }
}
