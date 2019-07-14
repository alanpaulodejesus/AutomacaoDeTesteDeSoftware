package Pages;

import DSL.Comando;
import DSL.CampoTexto;
import DSL.Label;
import Utils.Generetor;
import Utils.RegistrarEvidencia;
import Utils.Tempo;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.File;

import static Core.DriverFactory.getDriver;

public class LoginPage {

    @FindBy(name = "username") private WebElement campoUserName;
    @FindBy(name = "password") private WebElement campoPassword;
    @FindBy(xpath = "//input[@value=\"Login\"]") private WebElement comandoLogin;
   // @FindBy(xpath = "//*[text()=\""+Propriedades.USUARIO+"\"]") private WebElement validaAcessoUsuario;
    @FindBy(xpath = "//td[@class=\"login-info-left\"]") private WebElement validaAcessoDeUsuario;
    @FindBy(xpath = "//font[text()=\"Your account may be disabled or blocked or the username/password you entered is incorrect.\"]")private WebElement validaAcessoNegado;
    @FindBy(linkText = "Logout") private WebElement comandoLogout;

    public LoginPage() {
        PageFactory.initElements(getDriver(), this);
    }

    public void euPreenchoCampoUsername(String username)  {
        CampoTexto.preencher(campoUserName,username);
    }

    public void euPreenchoCampoPassword(String password)  {
        CampoTexto.preencher(campoPassword, password);
    }

    public void euAcionoComandoLogin()  {
        Comando.clicar(comandoLogin);
    }

    public void euAcionoComandoLogout(){
        Comando.clicar(comandoLogout);
    }

    public Boolean euValidoAcessoLogin(){
        return Label.textoPresente(validaAcessoDeUsuario);
    }

    public String euValidoAcessoNegado(){
        return Label.recuperaTexto(validaAcessoNegado);
    }

    public Boolean euValidoLogoutComSucesso(){
        Tempo.aguardar(5, comandoLogin);
        return Label.textoPresente(comandoLogin);
    }

    public void euRegistroLoginInvalido(){
        RegistrarEvidencia.registrar(
                System.getProperty("user.dir") + File.separator +
                        "src" + File.separator + "test" + File.separator +"ArquivoLoginInvalido"+ File.separator +"Login Inválido"+ Generetor.dataHora()+".png");
    }

    public void euRegistroLoginValido(){
        RegistrarEvidencia.registrar(
                System.getProperty("user.dir") + File.separator +
                        "src" + File.separator + "test" + File.separator +"ArquivoLoginValido"+ File.separator +"Login valido"+ Generetor.dataHora()+".png");
    }
}
