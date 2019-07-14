package SuiteTest;

import Test.*;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({

        LoginValidoTest.class,
        PesquisaAtividadeComSucessoTest.class,
        PesquisaAtividadeInvalidaTest.class,
        AlterarAtividadeTest.class,
        LoginInvalidoTest.class
})
public class SuiteTest {

}
