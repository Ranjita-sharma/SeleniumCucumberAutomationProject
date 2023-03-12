package Helper;

import org.joda.time.DateTime;

public class CommonHelper {
    public static void println(String msg)
    {
        msg = DateTime.now() + " | " + msg;
        System.out.println(msg);
    }

}
