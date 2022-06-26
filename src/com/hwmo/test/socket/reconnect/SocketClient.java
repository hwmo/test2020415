package com.hwmo.test.socket.reconnect;


//import com.gzcss.modules.znrc.service.IRcWarnInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.io.IOException;

//@Component
public class SocketClient implements SocketClientResponseInterface, ApplicationRunner {

    @Value("${corerain.tcp.host}")
    private String tcpHost;
    @Value("${corerain.tcp.port}")
    private Integer tcpPort;


    private SocketClientThread socketClientThread;
    //private static final Logger log = Logger.getLogger(SocketClient.class);

    public SocketClient() {
        socketClientThread = new SocketClientThread("socketClientThread", this);
        new Thread(socketClientThread).start();
    }

    @Override
    public void onSocketConnect() {
        System.out.println("onSocketConnect: -----------连接到告警服务器成功！");
    }

    @Override
    public void onSocketReceive(Object socketResult, int code) throws IOException {
        System.out.println("onSocketReceive: 收到告警消息 ,  data: " + socketResult + " , code: " + code);

        //iRcWarnInfoService.processWarnInfo(socketResult.toString());
    }

    @Override
    public void onSocketDisable(String msg, int code) {
        System.out.println("onSocketDisable: 连接断开 , msg: " + msg + " , code: " + code);
    }

    public static void main(String[] args) {
        new SocketClient();
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        //new SocketClient();

    }

//    public <T> void sendData(T data) {
//        //convert to string or serialize object
//        String s = (String) data;
//        if (TextUtils.isEmpty(s)) {
//            System.out.println("sendData: 消息不能为空");
//            return;
//        }
//        if (socketClientThread != null) {
//            socketClientThread.addRequest(s);
//        }
//    }
//
//    public void stopSocket() {
//        //一定要在子线程内执行关闭socket等IO操作
//        new Thread(() -> {
//            socketClientThread.setReConnect(false);
//            socketClientThread.stopThread();
//        }).start();
//    }


}
