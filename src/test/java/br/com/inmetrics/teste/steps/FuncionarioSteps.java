package br.com.inmetrics.teste.steps;

import br.com.inmetrics.teste.pageObjects.GenericoPO;
import br.com.inmetrics.teste.pageObjects.FuncionarioPO;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class FuncionarioSteps extends GenericoPO{
	
	  FuncionarioPO funcionarioPO = new FuncionarioPO();
	  
	  @Given("que o usuario clique em Novo Funcionario$")
	  public void clicaNovoFuncionario() {
		  funcionarioPO.clicaNovoFuncionario();
	  }

	  @When("informar o nome \"([^\"]*)\"$")
	  public void informaNome(String nome) throws Exception {
		  funcionarioPO.informaNome(nome);
		  
	  }

	  @And("informar o cargo \"([^\"]*)\"$")
	  public void informaCargo(String cargo) throws Exception {
		  funcionarioPO.informaCargo(cargo);
		  
	  }

	  @And("informar o CPF \"([^\"]*)\"$")
	  public void informaCPF(String CPF) throws Exception {
		  Thread.sleep(1000);
		  funcionarioPO.informaCPF(CPF);
		  Thread.sleep(1000);
		  
	  }

	  @And("informar o salario \"([^\"]*)\"$")
	  public void informaSalario(String salario) throws Exception {
		  funcionarioPO.informaSalario(salario);
		  
	  }

	  @And("informar o sexo \"([^\"]*)\"$")
	  public void informaSexo(String sexo) throws Exception {
		  funcionarioPO.informaSexo(sexo);
		  
	  }

	  @And("informar o Tipo de Contratacao \"([^\"]*)\"$")
	  public void informaTipoContratacao(String tipoContratacao) throws Exception {
		  funcionarioPO.informaTipoContratacao(tipoContratacao);
		  
	  }

	  @And("informar a Data Adimissão \"([^\"]*)\"$")
	  public void informaDataAdimissao(String dataAdimissao) throws Exception {
		  Thread.sleep(1000);
		  funcionarioPO.informaDataAdimissao(dataAdimissao);
		  
	  }
	  
	  @And("clica em enviar$")
	  public void clicaEnviar() throws InterruptedException {
		  funcionarioPO.clicaEnviar();
		  Thread.sleep(6000);
	  }

	  //Geral
	  @Then("demostra a mensagem \"([^\"]*)\"$")
	  public void demonstraMensagem(String mensagem) {
		  funcionarioPO.validarMensagem(mensagem);
	  }
	  
	  //Editar
	  
	  @Given("o usuario digite o nome do funcionario \"([^\"]*)\" na pesquisa$")
	  public void digitaParaPesquisar(String nome) throws InterruptedException {
		  funcionarioPO.digitaParaPesquisar(nome);
	  }
	  
	  @When("aparece na listagem o funcionario \"([^\"]*)\"$")
	  public void validaListagemFuncionario(String nome) throws InterruptedException {
		  funcionarioPO.validaListagemFuncionario(nome);
	  }
	  
	  @Then("clica no botao para editar$")
	  public void clicaBotaoEditar() throws InterruptedException {
		  funcionarioPO.clicaBotaoEditar();
	  }
	  
	  @And("clica no botao para deletar$")
	  public void clicaBotaoDeletar() throws InterruptedException {
		  funcionarioPO.clicaBotaoDeletar();
	  }
	  
	  
}
