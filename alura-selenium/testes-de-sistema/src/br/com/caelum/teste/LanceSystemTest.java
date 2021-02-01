package br.com.caelum.teste;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class LanceSystemTest {
	
	private WebDriver driver;
    private LeiloesPage leiloes;

    @Before
    public void inicializa() {
        System.setProperty("webdriver.gecko.driver", "C:\\dev\\tools\\drivers_selenium\\geckodriver.exe");
        System.setProperty("webdriver.chrome.driver", "C:\\dev\\tools\\drivers_selenium\\chromedriver.exe");
    	this.driver = new FirefoxDriver();
        leiloes = new LeiloesPage(driver);
        
        driver.get("http://localhost:8080/apenas-teste/limpa");
        
        UsuariosPage usuarios = new UsuariosPage(driver);
        usuarios.visita();
        usuarios.novo().cadastra("José Alberto", "email");
        usuarios.novo().cadastra("João", "email2");
        
        LeiloesPage leiloes = new LeiloesPage(driver);
        leiloes.visita();
        leiloes.novo().preenche("obj", 10, "José Alberto", false);
    }

    @Test
    public void deveFazerUmLance() {

        DetalhesDoLeilaoPage lances = leiloes.detalhes(1);

        lances.lance("José Alberto", 150);

        assertTrue(lances.existeLance("José Alberto", 150));
    }
}
