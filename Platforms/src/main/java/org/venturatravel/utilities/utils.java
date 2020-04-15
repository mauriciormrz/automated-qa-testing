package org.venturatravel.utilities;

import static java.lang.Thread.sleep;

public class utils {

    public static void wait(int millis){

        try {
            sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
