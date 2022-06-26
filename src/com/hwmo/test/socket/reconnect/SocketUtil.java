package com.hwmo.test.socket.reconnect;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.*;
import java.util.Enumeration;

public class SocketUtil {

    public static String ADDRESS = "172.16.3.75";
    public static int PORT = 10086;

    public static int SUCCESS = 200;
    public static int FAILED = 201;
   // public static int PORT = 10086;


    /**
     * 读数据
     *
     * @param bufferedReader
     */
    public static String readFromStream(BufferedReader bufferedReader) {
        try {
            String s;
            if ((s = bufferedReader.readLine()) != null) {
                return s;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 写数据
     *
     * @param data
     * @param printWriter
     */
    public static void write2Stream(String data, PrintWriter printWriter) {
        if (data == null) {
            return;
        }
        if (printWriter != null) {
            printWriter.println(data);
        }
    }


    /**
     * 关闭输入流
     *
     * @param socket
     */
    public static void inputStreamShutdown(Socket socket) {
        try {
            if (!socket.isClosed() && !socket.isInputShutdown()) {
                socket.shutdownInput();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 关闭BufferedReader
     *
     * @param br
     */
    public static void closeBufferedReader(BufferedReader br) {
        try {
            if (br != null) {
                br.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 关闭输出流
     *
     * @param socket
     */
    public static void outputStreamShutdown(Socket socket) {
        try {
            if (!socket.isClosed() && !socket.isOutputShutdown()) {
                socket.shutdownOutput();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 关闭PrintWriter
     *
     * @param pw
     */
    public static void closePrintWriter(PrintWriter pw) {
        if (pw != null) {
            pw.close();
        }
    }

    /**
     * 获取本机IP地址
     */
    public static String getIP() throws SocketException {
        String hostIP = null;
        try {
            Enumeration nis = NetworkInterface.getNetworkInterfaces();
            InetAddress ia = null;
            while (nis.hasMoreElements()) {
                NetworkInterface ni = (NetworkInterface) nis.nextElement();
                Enumeration<InetAddress> ias = ni.getInetAddresses();
                while (ias.hasMoreElements()) {
                    ia = ias.nextElement();
                    if (ia instanceof Inet6Address) {
                        continue;// skip ipv6
                    }
                    String ip = ia.getHostAddress();
                    if (!"127.0.0.1".equals(ip)) {
                        hostIP = ia.getHostAddress();
                        break;
                    }
                }
            }
        } catch (SocketException e) {
            e.printStackTrace();
        }
        return hostIP;

    }


    /**
     * notify()调用后，并不是马上就释放对象锁的，而是在相应的synchronized(){}语句块执行结束，自动释放锁后
     */
    public static void toNotifyAll(Object obj) {
        synchronized (obj) {
            obj.notifyAll();
        }
    }
    /**
     * 阻塞线程,millis为0则永久阻塞,知道调用notify()
     */
    public static void toWait(Object o, long timeout) {
        synchronized (o) {
            try {
                o.wait(timeout);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
