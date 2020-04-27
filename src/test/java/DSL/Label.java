package DSL;

import org.openqa.selenium.WebElement;

public class Label {

    public static String recuperaTexto(WebElement texto){

        return texto.getText();
    }

    public static boolean labelVazio(WebElement texto){

        try{
            texto.getText();
            return false;
        }catch (Exception e){
            return true;
        }
    }
}
