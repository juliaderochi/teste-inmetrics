package br.com.inmetrics.teste.steps;

import cucumber.api.java.After;
import cucumber.api.java.en.Given;
import static br.com.inmetrics.teste.support.Utils.acessarSistema;
import static br.com.inmetrics.teste.support.Utils.driver;

public class Hooks {
	  
	  @Given("Eu acesso o site inmrobo$")
	  public void acessar() {
		  acessarSistema();
		  
	  }	  
	  
	  @After
	  public void fechar() throws InterruptedException {
	        if(driver != null) {
	        	driver.close();
	        	driver.quit();
	        }
	  }

}
