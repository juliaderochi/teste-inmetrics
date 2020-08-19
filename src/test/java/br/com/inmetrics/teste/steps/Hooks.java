package br.com.inmetrics.teste.steps;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import static br.com.inmetrics.teste.support.Utils.acessarSistema;
import static br.com.inmetrics.teste.support.Utils.driver;

import br.com.inmetrics.teste.pageObjects.GenericoPO;

public class Hooks extends GenericoPO{
	
	@Before(order = 0)
    public void before(Scenario cenario) {
		acessarSistema();
        setCenario(cenario);
    }
	  
	 @After
	 public void fechar() throws InterruptedException {
		 gerarEvidencia();
		 if(driver != null) {
			 driver.close();
			 driver.quit();
	        }
	  }

}
