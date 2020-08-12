package br.com.inmetrics.teste.pageObjects;

import static org.junit.Assert.assertTrue;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.Select;
import static br.com.inmetrics.teste.support.Utils.driver;

public class FuncionarioPO extends GenericoPO{
	
	@FindBy(id = "inputNome")
	private WebElement campoNome;
	
	@FindBy(id = "inputCargo")
	private WebElement campoCargo;

	@FindBy(id = "cpf")
	private WebElement campoCPF;

	@FindBy(id = "dinheiro")
	private WebElement campoSalario;	

	@FindBy(id = "slctSexo")
	private WebElement campoSexo;
	
	@FindBy(id = "clt")
	private WebElement campoCLT;
	
	@FindBy(id = "pj")
	private WebElement campoPJ;	
	
	@FindBy(id = "inputAdmissao")
	private WebElement campoDataAdmissao;		
	
	@FindBy(id = "delete-btn")
	private WebElement botaoDeletar;	

    @FindBy(how = How.XPATH, using = "//button[@class='btn btn-warning']")	
	private WebElement botaoEditar;	

    @FindBy(how = How.XPATH, using = "//input[@class='cadastrar-form-btn']")	
	private WebElement botaoEnviar;	
    
    @FindBy(how = How.XPATH, using = "//a[contains(text(),'Novo Funcionário')]")
	private WebElement linkNovoFuncionario;	

    @FindBy(how = How.XPATH, using = "//div[@class='alert alert-success alert-dismissible fade show']")
	private WebElement mensagemSucesso;	

    @FindBy(how = How.XPATH, using = "//input[@aria-controls='tabela']")
	private WebElement campoPesquisar;	

    @FindBy(how = How.XPATH, using = "//td[@class='text-center sorting_1']")
	private WebElement campoNomeListagem;	
    
	public void validaListagemFuncionario(String valor) throws InterruptedException {
		assertTrue(valor.equals(campoNomeListagem.getText()));
	}	
    
	public void digitaParaPesquisar(String valor) throws InterruptedException {
		Actions action = new Actions(driver);
		action.moveToElement(campoPesquisar).perform();
		Thread.sleep(1000);
		campoPesquisar.sendKeys(valor);
	}
    
	public void clicaNovoFuncionario() {
		linkNovoFuncionario.click();
	}
	      
	public void clicaBotaoEditar() {
		botaoEditar.click();
    }
    
	public void clicaBotaoDeletar() {
		botaoDeletar.click();
	}
	      
	public void informaNome(String valor) {
		campoNome.clear();
		campoNome.sendKeys(valor);
	}	  
    
	public void informaCargo(String cargo) {
		campoCargo.sendKeys(cargo);
	}
	      
	public void informaCPF(String CPF) {
		campoCPF.sendKeys(CPF);
	}	  
    
	public void informaSalario(String salario) {
		campoSalario.sendKeys(salario);
	}	  
    
	public void informaSexo(String sexo) {
		Select combo = new Select(campoSexo);
		combo.selectByVisibleText(sexo);
	}	  
    
	public void informaTipoContratacao(String tipoContratacao) {		
		if (tipoContratacao == "CLT") {
			campoCLT.click();
		}else {
			campoCLT.click();
		}
	}
	  
	public void informaDataAdimissao(String dataAdimissao) {
		campoDataAdmissao.sendKeys(dataAdimissao);
	}	  
    
	public void clicaEnviar() {
		botaoEnviar.click();
	}
 
	public void validarMensagem(String mensagem) {
		assertTrue(mensagem.trim().toUpperCase().toString().equals(mensagemSucesso.getText().substring(0, mensagemSucesso.getText().length() - 1).trim().toUpperCase().toString()));
	}
}
