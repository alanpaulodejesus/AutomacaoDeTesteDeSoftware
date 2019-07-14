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
@DataLoader(filePaths = "ArquivoDados.csv")


public class PesquisaAtividadeComSucessoTest {

    PesquisaAtividadePage pesquisaAtividadeComSucesso = new PesquisaAtividadePage();
    LoginPage login = new LoginPage();

    @Before
    public void setUp(){
        getDriver().get(Propriedades.URL);
    }

    @Test
    public void realizarPesquisaAtividadeComSucesso(@Param(name="usuario") String usuario,
                                                    @Param(name="senha") String senha,
                                                    @Param(name="projeto") String projeto,
                                                    @Param(name="numeroAtividade") String numeroAtividade){

        new LoginValidoTest().realizarLoginValido(usuario,senha);
        pesquisaAtividadeComSucesso.euSelecionoProjeto(projeto);
        pesquisaAtividadeComSucesso.euPreenchoAtividadeParaPesquisa(numeroAtividade);
        pesquisaAtividadeComSucesso.euRegistroPesquisaAtividadeComSucesso();
        pesquisaAtividadeComSucesso.euAcionoComandoDePesquisa();
        pesquisaAtividadeComSucesso.euRegistroPesquisaAtividadeComSucesso();
        Assert.assertTrue(pesquisaAtividadeComSucesso.euValidoPesquisaComSucesso());

     }


    @After
    public void tearDown(){
        login.euAcionoComandoLogout();
        Assert.assertTrue(login.euValidoLogoutComSucesso());
    }
}
