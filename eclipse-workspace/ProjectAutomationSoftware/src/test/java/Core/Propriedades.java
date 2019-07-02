package Core;

public class Propriedades {

    public static final String URL = "https://accounts.google.com/ServiceLogin/identifier?hl=pt-BR&flowName=GlifWebSignIn&flowEntry=AddSession";
    public static final String EMAIL = "automacaodetestedesoftware@gmail.com";
    public static final String SENHA = "testedesoftware";
    public static final String mensagemValidacao= "Bem-vindo, Teste de Software Teste";

    public static final Browsers browser = Browsers.CHROME;

    public enum Browsers {
        CHROME,
        FIREFOX
    }
}
