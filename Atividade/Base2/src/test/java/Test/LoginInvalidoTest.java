package Test;

import Core.Propriedades;
import Pages.LoginPage;
import org.easetech.easytest.annotation.DataLoader;
import org.easetech.easytest.annotation.Param;
import org.easetech.easytest.runner.DataDrivenTestRunner;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import static Core.DriverFactory.getDriver;

@RunWith(DataDrivenTestRunner.class)
@DataLoader(filePaths="ArquivoDados.csv")

public class LoginInvalidoTest {

    LoginPage login = new LoginPage();

    @Before
    public void setUp(){
        getDriver().get(Propriedades.URL);
    }

    @Test
    public void realizarLoginInvalido(@Param(name="usuario") String usuario,
                                      @Param(name="senha") String senha,
                                      @Param(name="mensagem")String mensagem)  {

        login.euPreenchoCampoUsername(usuario);
        login.euRegistroLoginInvalido();
        login.euPreenchoCampoPassword(senha);
        login.euRegistroLoginInvalido();
        login.euAcionoComandoLogin();
        login.euRegistroLoginInvalido();
        Assert.assertEquals(mensagem,login.euValidoAcessoNegado());
    }

    @After
    public void tearDown(){
    }

}
