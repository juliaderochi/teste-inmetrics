package br.com.inmetrics.teste.steps;

import java.util.UUID;

import br.com.inmetrics.teste.pageObjects.CadastrarUsuarioPO;
import br.com.inmetrics.teste.pageObjects.GenericoPO;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class CadastroUsuarioSteps extends GenericoPO{

	
	  CadastrarUsuarioPO cadastrarUsuarioPO = new CadastrarUsuarioPO();
	
	  @And("clico na opção Cadastre-se para acessar a tela de cadastro$")
	  public void acessarTelaCadastrese() {
		  cadastrarUsuarioPO.acessarTelaCadastrase();
		  
	  }
	  @When("informo o campo para o \"([^\"]*)\"$")
	  public void inserirUsuario(String usuario) {
		  UUID uuid = UUID.randomUUID();
		  String myRandom = uuid.toString();
		  String user = usuario + myRandom.substring(0,5);
		  cadastrarUsuarioPO.cadastroInformaCampoUsuario(user);
		  
	  }
	  @And("informo o campo para a \"([^\"]*)\"$")
	  public void inserirSenha(String senha) {
		  cadastrarUsuarioPO.cadastroInformaCampoSenha(senha);
		  
	  }
	  @And("informo o campo \"([^\"]*)\" a senha$")
	  public void inserirConfirmaSenha(String senhaConfirma) {
		  cadastrarUsuarioPO.cadastroInformaCampoConfirmaSenha(senhaConfirma);
		  
	  }
	  @And("clico no botão cadastrar$")
	  public void confirmaCadastro() {
		  cadastrarUsuarioPO.cadastroClicarBotaoCadastrar();
		  
	  }
	  @Then("o usuario é criado com sucesso$")
	  public void usuarioCriadoComSucesso() throws InterruptedException {
		  Thread.sleep(5000);
		  cadastrarUsuarioPO.validaTituloLogin();
		  
	  }
	
	
}