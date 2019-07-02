package Util;

import java.util.concurrent.TimeUnit;

public class Tempo {

    public static void aguardar(Integer segundos) {
        try {
            TimeUnit.SECONDS.sleep(segundos.intValue());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
