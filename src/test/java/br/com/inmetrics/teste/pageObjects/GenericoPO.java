package br.com.inmetrics.teste.pageObjects;

import static br.com.inmetrics.teste.support.Utils.driver;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import cucumber.api.Scenario;

public class GenericoPO {
	
    public static WebDriverWait wait;
    private Scenario cenario = null;
	
    public GenericoPO(){
		PageFactory.initElements(driver, this);
    }

    public void fecharBrowser() throws InterruptedException {
        if(driver != null) {
        	driver.close();
        	driver.quit();
        }
    }

    public void gerarImagemCenario(Scenario cenarioEvidencia, WebDriver driver) {
        cenario.write("Imagem da tela");
        byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
        cenarioEvidencia.embed(screenshot, "image/png");
    }

    public void gerarEvidencia() {
        gerarImagemCenario(cenario, driver);
    }

    public Scenario getCenario() {
        return cenario;
    }

    public void setCenario(Scenario cenario) {
        this.cenario = cenario;
    }
      
    
}
