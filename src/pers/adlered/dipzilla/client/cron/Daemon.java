package pers.adlered.dipzilla.client.cron;

import pers.adlered.dipzilla.client.log.Logger;
import pers.adlered.dipzilla.client.service.Context;

import java.io.*;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Date;

import static pers.adlered.dipzilla.client.service.Context.dipClient;

/**
 * <h3>DIPzilla-Client</h3>
 * <p>守护任务</p>
 *
 * @author : https://github.com/AdlerED
 * @date : 2020-01-11 18:57
 **/
public class Daemon implements Runnable {
    @Override
    public void run() {
        while (true) {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm:ss:SS");
            String time = simpleDateFormat.format(new Date());
            try {
                ServerHandler.action();
                Logger.log(time + " Sync succeed.");
            } catch (IOException e) {
                Logger.err(time + " Wrong Sync Key or Server Connections refused!");
            }
            try {
                renewConn();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                Thread.sleep(15000);
            } catch (InterruptedException e) {
            }
        }
    }

    private void renewConn() throws IOException {
        Context.bufferedReader.close();
        Context.bufferedWriter.close();
        dipClient.close();

        dipClient = new Socket(Context.serverHost, Context.serverPort);
        Context.bufferedWriter = new BufferedWriter(new OutputStreamWriter(dipClient.getOutputStream(), "UTF-8"));
        Context.bufferedReader = new BufferedReader(new InputStreamReader(dipClient.getInputStream(), "UTF-8"));
    }
}
