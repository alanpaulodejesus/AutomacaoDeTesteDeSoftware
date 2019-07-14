package Test;

import Core.Propriedades;
import Pages.LoginPage;
import Pages.PesquisaAtividadePage;
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

public class PesquisaAtividadeInvalidaTest {

    PesquisaAtividadePage pesquisaAtividadeInvalida = new PesquisaAtividadePage();
    LoginPage login = new LoginPage();

    @Before
    public void setUp(){
        getDriver().get(Propriedades.URL);
    }

    @Test
    public void realizarPesquisaNaoCadastrada(@Param(name="usuario") String usuario,
                                              @Param(name="senha")String senha,
                                              @Param(name="numeroAtividadeInvalido") String numeroAtividadeInvalido){

        new LoginValidoTest().realizarLoginValido(usuario,senha);
        pesquisaAtividadeInvalida.euPreenchoAtividadeParaPesquisa(numeroAtividadeInvalido);
        pesquisaAtividadeInvalida.euRegistroPesquisaAtividadeInvalida();
        pesquisaAtividadeInvalida.euAcionoComandoDePesquisa();
        pesquisaAtividadeInvalida.euRegistroPesquisaAtividadeInvalida();
        Assert.assertTrue(pesquisaAtividadeInvalida.euValidoPesquisaInvalida());
    }

    @After
    public void tearDown(){
        login.euAcionoComandoLogout();
        Assert.assertTrue(login.euValidoLogoutComSucesso());
    }

}
