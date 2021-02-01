package br.com.caelum.teste;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import static org.junit.Assert.assertTrue;

public class LeiloesSystemTest {

    private WebDriver driver;
    private LeiloesPage leiloes;

    @Before
    public void inicializa() {
        System.setProperty("webdriver.gecko.driver", "C:\\dev\\tools\\drivers_selenium\\geckodriver.exe");
        System.setProperty("webdriver.chrome.driver", "C:\\dev\\tools\\drivers_selenium\\chromedriver.exe");
        this.driver = new FirefoxDriver();
        driver.get("http://localhost:8080/apenas-teste/limpa");
        leiloes = new LeiloesPage(driver);

        UsuariosPage usuarios = new UsuariosPage(driver);
        usuarios.visita();
        usuarios.novo().cadastra("Paulo Henrique", "paulo@henrique.com");
    }

    @Test
    public void deveCadastrarUmLeilao() {
        leiloes.visita();
        NovoLeilaoPage novoLeilao = leiloes.novo();
        novoLeilao.preenche("Geladeira", 123, "Paulo Henrique", true);

        assertTrue(leiloes.existe("Geladeira", 123, "Paulo Henrique", true));

    }
}
