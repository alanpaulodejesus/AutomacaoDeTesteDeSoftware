package DSL;

import Util.Tempo;
import org.openqa.selenium.WebElement;

import java.io.IOException;

public class CampoTexto {

    public static void preencher(WebElement elemento, String valor) throws IOException {

        elemento.sendKeys(valor);
        Tempo.aguardar(Integer.valueOf(1));
    }

    public static void limpar(WebElement elemento) {

        elemento.clear();
    }

    public static boolean preencherHabilitado(WebElement elemento){

        try {
            elemento.isEnabled();
            return false;
        } catch (Exception e){
            return true;

        }
    }

}
