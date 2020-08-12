package br.com.inmetrics.teste.support;

import java.nio.file.Paths;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;

public class Utils {
	
	public static ChromeDriver driver;
	private static String URL = "http://www.inmrobo.tk/accounts/login/";
	
	public static void acessarSistema() {
		  String path = System.getProperty("user.dir");
		  System.setProperty("webdriver.chrome.driver", Paths.get(path, "/driver/chromedriver.exe").toString());
		  driver = new ChromeDriver();
		  driver.manage().window().maximize();
		  driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		  driver.get(URL);
		
	}
}
