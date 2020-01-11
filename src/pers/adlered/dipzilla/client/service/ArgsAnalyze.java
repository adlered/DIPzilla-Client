package pers.adlered.dipzilla.client.service;

import pers.adlered.dipzilla.client.log.Logger;

/**
 * <h3>DIPzilla-Client</h3>
 * <p>分析传入的 args ，并写入至静态变量</p>
 *
 * @author : https://github.com/AdlerED
 * @date : 2020-01-11 18:18
 **/
public class ArgsAnalyze {
    public static void toMemory(String[] args) {
        try {
            String serverHost = args[0];
            Context.serverHost = serverHost;
            Logger.conf("Server Host = " + Context.serverHost);
            String serverPort = args[1];
            Context.serverPort = Integer.parseInt(serverPort);
            Logger.conf("Server Port = " + Context.serverPort);
            String syncKey = args[2];
            Context.syncKey = syncKey;
            Logger.conf("Sync Key = " + Context.syncKey);
            String clientAlias = args[3];
            Context.clientAlias = clientAlias;
            Logger.conf("Client Alias = " + Context.clientAlias);
        } catch (Exception e) {
            Logger.err("Usage:");
            Logger.log("java -jar dipzilla-client.jar [serverHost] [serverPort] [syncKey] [clientAlias]");
            Logger.log("java -jar dipzilla-client.jar [服务端 IP 地址] [服务端端口] [同步密钥] [客户端别名]");
            System.exit(0);
        }
    }
}
