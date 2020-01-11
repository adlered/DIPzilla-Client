package pers.adlered.dipzilla.client.log;

/**
 * <h3>DIPzilla-Server</h3>
 * <p>日志</p>
 *
 * @author : https://github.com/AdlerED
 * @date : 2020-01-11 13:50
 **/
public class Logger {
    private static boolean debug = false;

    public static void log(String log) {
        System.out.println(log);
    }

    public static void info(String log) {
        System.out.println("[INFO] " + log);
    }

    public static void warn(String log) {
        System.out.println("[WARN] " + log);
    }

    public static void err(String log) {
        System.out.println("[ERR] " + log);
    }

    public static void conf(String log) {
        System.out.println("[CONF] " + log);
    }

    public static void debug(String log) {
        if (debug) {
            System.out.println("[DEBUG] " + log);
        }
    }
}
