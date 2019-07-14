package DSL;

import org.openqa.selenium.WebElement;

import java.io.IOException;

public class CampoTexto {

    public static void preencher(WebElement elemento, String valor) {

        elemento.sendKeys(valor);
    }

    public static void limpar(WebElement elemento) {

        elemento.clear();
    }


}
