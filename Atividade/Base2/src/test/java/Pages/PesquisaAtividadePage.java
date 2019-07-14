package Pages;

import DSL.Comando;
import DSL.CampoTexto;
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

public class PesquisaAtividadePage {

    @FindBy(name="bug_id")private WebElement campoPesquisa;
    @FindBy(xpath = "//input[@value=\"Jump\"]")private WebElement comandoPesquisa;
    @FindBy(xpath = "//td[contains(text(),'View Issue Details')]")private WebElement validaPesquisaComSucesso;
    @FindBy(xpath = "//p[contains(text(), 'not found')]")private WebElement validaPesquisaInvalida;
    @FindBy(name = "project_id")private WebElement comboProjeto;

    public PesquisaAtividadePage(){
        PageFactory.initElements(getDriver(), this);
    }

    public void euPreenchoAtividadeParaPesquisa(String atividade){
        CampoTexto.preencher(campoPesquisa, atividade);
    }

    public void euAcionoComandoDePesquisa(){
        Comando.clicar(comandoPesquisa);
    }

    public Boolean euValidoPesquisaComSucesso(){
       return Label.textoPresente(validaPesquisaComSucesso);
    }

    public Boolean euValidoPesquisaInvalida(){
        return Label.textoPresente(validaPesquisaInvalida);
    }

    public void euSelecionoProjeto(String projeto){
        Tempo.aguardar(10, comboProjeto);
        Combo.selecionarCombo(comboProjeto, projeto);
    }
    public void euRegistroPesquisaAtividadeComSucesso(){
        RegistrarEvidencia.registrar(
                System.getProperty("user.dir") + File.separator +
                        "src" + File.separator + "test" + File.separator +"ArquivoPesquisaComSucesso"+ File.separator +"Pesquisa com sucesso"+ Generetor.dataHora()+".png");
    }

    public void euRegistroPesquisaAtividadeInvalida(){
        RegistrarEvidencia.registrar(
                System.getProperty("user.dir") + File.separator +
                        "src" + File.separator + "test" + File.separator +"ArquivoPesquisaInvalida"+ File.separator +"Pesquisa Invalida"+ Generetor.dataHora()+".png");
    }
}
