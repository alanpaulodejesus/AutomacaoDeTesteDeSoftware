package Test;

import Core.Propriedades;
import Pages.AlterarAtividadePage;
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
public class AlterarAtividadeTest {

    AlterarAtividadePage alterarAtividade = new AlterarAtividadePage();
    LoginPage login = new LoginPage();

    @Before
    public void setUp(){
        getDriver().get(Propriedades.URL);
    }

    @Test
    public void realizarAlteracaoEmAtividade(@Param(name="usuario")String usuario,
                                             @Param(name="senha")String senha,
                                             @Param(name="numeroAtividade")String numeroAtividade,
                                             @Param(name="projeto") String projeto,
                                             @Param(name="descricao") String descricao
                                             ){

        new PesquisaAtividadeComSucessoTest().realizarPesquisaAtividadeComSucesso(usuario,senha, projeto, numeroAtividade);
        alterarAtividade.euAcionoComandoEdit();
        alterarAtividade.euRegistroAlteracaoComSucesso();
        Assert.assertTrue(alterarAtividade.euValidoComandoEdit());
        alterarAtividade.euPreenchoCampoDescricao(descricao);
        alterarAtividade.euRegistroAlteracaoComSucesso();
        alterarAtividade.euAcionoComandoUpdateInformation();
        alterarAtividade.euRegistroAlteracaoComSucesso();
        Assert.assertEquals(descricao, alterarAtividade.euValidoDescricaoAlterada());

    }

    @After
    public void tearDown(){
        login.euAcionoComandoLogout();
        Assert.assertTrue(login.euValidoLogoutComSucesso());
    }
}
