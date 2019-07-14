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

import java.io.IOException;

import static Core.DriverFactory.getDriver;

@RunWith(DataDrivenTestRunner.class)
@DataLoader(filePaths ="ArquivoDados.csv")

public class LoginValidoTest {

    LoginPage login = new LoginPage();

    @Before
    public void setUp(){

        getDriver().get(Propriedades.URL);
    }

    @Test
    public void realizarLoginValido(@Param(name="usuario") String usuario, @Param(name="senha") String senha)  {

        login.euPreenchoCampoUsername(usuario);
        login.euRegistroLoginValido();
        login.euPreenchoCampoPassword(senha);
        login.euRegistroLoginValido();
        login.euAcionoComandoLogin();
        login.euRegistroLoginValido();
        Assert.assertTrue(login.euValidoAcessoLogin());
    }

    @After
    public void tearDown(){
        login.euAcionoComandoLogout();
        Assert.assertTrue(login.euValidoLogoutComSucesso());
    }
}
