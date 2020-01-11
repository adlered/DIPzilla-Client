package pers.adlered.dipzilla.client.cron;

import pers.adlered.dipzilla.client.service.Context;

import java.io.IOException;

/**
 * <h3>DIPzilla-Client</h3>
 * <p>服务端操作</p>
 *
 * @author : https://github.com/AdlerED
 * @date : 2020-01-11 18:58
 **/
public class ServerHandler {
    public static void action() throws IOException {
        String act = Context.syncKey + "\\" + Context.clientAlias + "\n";
        Context.bufferedWriter.write(act);
        Context.bufferedWriter.flush();
        Context.bufferedReader.readLine();
        String result = Context.bufferedReader.readLine();
        if (result.indexOf("Wrong") != -1) {
            throw new IOException();
        }
    }
}
