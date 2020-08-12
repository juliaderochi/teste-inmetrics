package br.com.inmetrics.teste.pageObjects;

import static br.com.inmetrics.teste.support.Utils.driver;

import org.openqa.selenium.support.PageFactory;

public class GenericoPO {
	
    public GenericoPO(){
		PageFactory.initElements(driver, this);
    }

    public void fecharBrowser() throws InterruptedException {
        if(driver != null) {
        	driver.close();
        	driver.quit();
        }
    }
      
    
}
