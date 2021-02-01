package br.com.caelum.teste;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class UsuariosPage {

    private WebDriver driver;

    public UsuariosPage(WebDriver driver) {
        this.driver = driver;
    }

    public void visita() {
        driver.get("localhost:8080/usuarios");
    }

    public NovoUsuarioPage novo() {
        // clica no link de novo usuario
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.findElement(By.cssSelector("a[href=\"/usuarios/new\"]")).click();
        // retorna a classe que representa a nova pagina
        return new NovoUsuarioPage(driver);
    }

    public AlteraUsuarioPage altera(int posicao) {
        driver.findElements(By.linkText("editar")).get(posicao-1).click();
        return new AlteraUsuarioPage(driver);
    }

    public boolean existeNaListagem(String nome, String email) {
        // verifica se ambos existem na listagem
        return driver.getPageSource().contains(nome) &&
                driver.getPageSource().contains(email);
    }

    public void deletaUsuarioNaPosicao(int posicao) {
        driver.findElements(By.tagName("button")).get(posicao-1).click();
        // pega o alert que está aberto
        Alert alert = driver.switchTo().alert();
        // confirma
        alert.accept();
    }


}