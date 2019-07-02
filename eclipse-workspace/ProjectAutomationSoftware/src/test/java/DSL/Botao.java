package DSL;

import Util.Tempo;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

import java.io.IOException;

public class Botao {

    public static void clicar(WebElement botao) throws IOException {

        try {
            botao.click();
            Tempo.aguardar(1);
        } catch (NoSuchElementException e) {
            System.out.println("ERRO: Não foi possível localizar o componente.");
        }
    }
}
