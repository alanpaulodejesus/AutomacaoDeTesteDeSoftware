package Test;

import Core.Propriedades;
import Pages.LoginPage;
import Util.Tempo;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;

import static Core.DriverFactory.getDriver;
import java.io.IOException;
import java.sql.SQLException;

public class LoginTest {

    LoginPage login = new LoginPage();

    @Given("^que eu como usuário acesso página do e-mail$")
    public void acessarNavegador() throws SQLException {
        getDriver().get(Propriedades.URL);
    }

    @When("^eu preencho a página de login$")
    public void preencherPaginaLogin() throws IOException {

        login.euPreenchoCampoDeEmail(Propriedades.EMAIL);
        login.euAcionoComandoProximo();
        login.euPreenchoCampoDeSenha(Propriedades.SENHA);
        login.euAcionoComandoProximo();
    }

    @Then("^eu valido acesso no e-mail$")
    public void validarAcessoDeEmail(){

        Assert.assertEquals(Propriedades.mensagemValidacao,login.mensagemValidacao());
    }

}
