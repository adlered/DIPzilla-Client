package pers.adlered.dipzilla.client;

import pers.adlered.dipzilla.client.cron.Daemon;
import pers.adlered.dipzilla.client.log.Logger;
import pers.adlered.dipzilla.client.service.ArgsAnalyze;
import pers.adlered.dipzilla.client.service.Context;

import java.io.IOException;

/**
 * <h3>DIPzilla-Client</h3>
 * <p>主方法</p>
 *
 * @author : https://github.com/AdlerED
 * @date : 2020-01-11 14:34
 **/
public class Main {
    public static void main(String[] args) throws IOException {
        Logger.info("DIPzilla Client v" + Context.VERSION);
        ArgsAnalyze.toMemory(args);
        Logger.info("Initializing...");
        Context.init();
        Logger.info("Sync started.");
        Thread thread = new Thread(new Daemon());
        thread.start();
    }
}
