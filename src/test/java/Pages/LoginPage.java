package Pages;

import DSL.Botao;
import DSL.CampoTexto;
import DSL.Label;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;

import static Core.DriverFactory.getDriver;

public class LoginPage {

    @FindBy(id="identifierId") private WebElement campoEmail;
    @FindBy(xpath = "//span[text()=\"Próxima\"]") private WebElement comandoProximo;
    @FindBy(name = "password") private WebElement campoSenha;
    @FindBy(xpath = "//h1[contains(text(),\"Bem-vindo, Teste de Software Teste\")]") private WebElement mensagemValidacao;
    @FindBy(xpath = "//span[@class=\"gb_xa gbii\"]") private WebElement iconeEmailPerfil;
    @FindBy(xpath = "//a[text()=\"Sair\"]") private WebElement comandoSair;


    public LoginPage(){
        PageFactory.initElements(getDriver(), this);
    }

    public void euPreenchoCampoDeEmail(String email) throws IOException {
        CampoTexto.preencher(campoEmail, email);
    }

    public void euPreenchoCampoDeSenha(String senha) throws IOException {
        CampoTexto.preencher(campoSenha, senha);
    }

    public void euAcionoComandoProximo() throws IOException {
        Botao.clicar(comandoProximo);
    }

    public String mensagemValidacao(){
        return Label.recuperaTexto(mensagemValidacao);
    }


}
