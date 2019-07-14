package Pages;

import DSL.CampoTexto;
import DSL.Comando;
import DSL.Combo;
import DSL.Label;
import Utils.Generetor;
import Utils.RegistrarEvidencia;
import Utils.Tempo;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.File;

import static Core.DriverFactory.getDriver;

public class AlterarAtividadePage {

    @FindBy(xpath = "//*[@class][@value=\"Edit\"]")private WebElement comandoEdit;
    @FindBy(xpath = "//td[contains(text(), 'Updating Issue Information')]")private WebElement validaHabilitacaoEdicao;
    @FindBy(name = "description")private WebElement campoDescrição;
    @FindBy(xpath = "//input[@value=\"Update Information\"]") private WebElement comandoUpdateInformation;
    @FindBy(xpath = "//td[contains(text(), 'teste de software')]") private WebElement validaDescricaoAlterada;

    public AlterarAtividadePage() {
        PageFactory.initElements(getDriver(), this);
    }

    public void euAcionoComandoEdit(){
        Tempo.aguardar(15, comandoEdit);
        Comando.clicar(comandoEdit);

    }

    public Boolean euValidoComandoEdit(){
       return Label.textoPresente(validaHabilitacaoEdicao);
    }

    public void euPreenchoCampoDescricao(String texto){
        CampoTexto.limpar(campoDescrição);
        CampoTexto.preencher(campoDescrição, texto);
    }

    public void euAcionoComandoUpdateInformation(){

        Comando.clicar(comandoUpdateInformation);
    }

    public String euValidoDescricaoAlterada(){
        return Label.recuperaTexto(validaDescricaoAlterada);
    }

    public void euRegistroAlteracaoComSucesso(){
        RegistrarEvidencia.registrar(
                System.getProperty("user.dir") + File.separator +
                        "src" + File.separator + "test" + File.separator +"ArquivoAlterarComSucesso"+ File.separator +"Alteracao Com Sucesso"+ Generetor.dataHora()+".png");
    }
}
