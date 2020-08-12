package br.com.inmetrics.teste.steps;

import br.com.inmetrics.teste.pageObjects.LoginPO;
import br.com.inmetrics.teste.pageObjects.GenericoPO;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static org.junit.Assert.assertTrue;

public class LoginSteps extends GenericoPO{

	
	  LoginPO loginPO = new LoginPO();

	  @When("informo o \"([^\"]*)\"$")
	  public void informaUsuario(String usuario) throws Exception {
		  loginPO.loginCampoUsuario(usuario);
		  
	  }
	  @And("tenha um usuario já cadastrado$")
	  public void usuarioJaCadastrado() {
			System.out.println("juliadr");
	  }
		  
	  @And("informo a \"([^\"]*)\"$")
	  public void informaSenha(String senha) throws Exception {
		  loginPO.loginCampoSenha(senha);
		  
	  }
	
	  @And("clico no botao Entre$")
	  public void clicaEntre() throws Exception {
		  loginPO.loginBotaoEntre();
		  
	  }
	
	  @Then("o usuario logou no sistema corretamente$")
	  public void validaEntrou() throws Exception {
		  Thread.sleep(5000);
		  assertTrue(LoginPO.validaEntrouNoSistema());
		  
	  }

}
