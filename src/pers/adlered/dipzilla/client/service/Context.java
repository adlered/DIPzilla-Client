package pers.adlered.dipzilla.client.service;

import pers.adlered.dipzilla.client.log.Logger;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;

/**
 * <h3>DIPzilla-Client</h3>
 * <p>运行时静态变量</p>
 *
 * @author : https://github.com/AdlerED
 * @date : 2020-01-11 18:18
 **/
public class Context {
    public static String VERSION = "1.0";

    public static String syncKey;
    public static String serverHost;
    public static int serverPort;
    public static String clientAlias;

    public static Socket dipClient;
    public static BufferedWriter bufferedWriter;
    public static BufferedReader bufferedReader;

    public static void init() {
        try {
            Context.dipClient = new Socket(Context.serverHost, Context.serverPort);
            Context.bufferedWriter = new BufferedWriter(new OutputStreamWriter(dipClient.getOutputStream(), "UTF-8"));
            Context.bufferedReader = new BufferedReader(new InputStreamReader(dipClient.getInputStream(), "UTF-8"));
        } catch (Exception e) {
            Logger.err("Startup failed! " + e.getCause());
            System.exit(0);
        }
    }
}
