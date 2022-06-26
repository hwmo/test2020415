package com.hwmo.test.socket.heartbeat;


import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.logging.Logger;

public class SocketReadThread extends Thread {

    private static final String TAG = "SocketThread";
    private volatile boolean mStopThread = false;
    private Socket mSocket;
    private DataOutputStream mDataOutputStream;
    private String SOCKET_HOST = "127.0.0.1";
    private Integer SOCKET_PORT = 8888;

    public void release() {
        mStopThread = true;
        releaseLastSocket();
    }

    @Override
    public void run() {
        DataInputStream mInputStream = null;
        try {
            mInputStream = new DataInputStream(mSocket.getInputStream());
//            Logger.d(TAG, "SocketThread running!");
            System.out.println("SocketThread running!");
            while (!mStopThread) {
                String resultStr = mInputStream.readUTF();
                //handleStringMsg(resultStr);
            }
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                mSocket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            if (mInputStream != null) {
                try {
                    mInputStream.close();
                    mInputStream = null;
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private void releaseLastSocket() {
        try {
            if (null != mSocket) {
                if (!mSocket.isClosed()) {
                    mSocket.close();
                }
            }
            mSocket = null;
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    /**
     * 连接服务端
     */
    private void connectToServer() {
        Thread connectThread = new Thread(new Runnable() {
            public void run() {
                try {
                    mSocket = new Socket();
                    mSocket.connect(
                            new InetSocketAddress(SOCKET_HOST, SOCKET_PORT));

//                    Log.e(TAG, "连接成功  " + SOCKET_HOST);
                    System.out.println("连接成功");
                    mDataOutputStream = new DataOutputStream(
                            mSocket.getOutputStream());

                    // 开启线程负责读取服务端数据
                    mReadThread = new SocketReadThread();
                    mReadThread.start();

                    // 心跳检测，检测socket是否连接
                   // mHandler.postDelayed(mHeartBeatRunnable, HEART_BEAT_RATE);
                } catch (UnknownHostException e) {
//                    Log.e(TAG, "连接失败  ");
                    e.printStackTrace();
                } catch (IOException e) {
//                    Log.e(TAG, "连接失败  ");
                    e.printStackTrace();
                }
            }
        });
        connectThread.start();
    }

    private SocketReadThread mReadThread;
    private static final long HEART_BEAT_RATE = 4 * 1000;
    private long sendTime = 0L;
    private Runnable mHeartBeatRunnable = new Runnable() {

        @Override
        public void run() {
            if (System.currentTimeMillis() - sendTime >= HEART_BEAT_RATE) {//每隔4秒检测一次
                boolean isSuccess = sendHeartBeatMsg("");
                if (!isSuccess) {
//                    Log.i(TAG, "连接已断开，正在重连……");
                    System.out.println("连接已断开，正在重连……");
                   // mHandler.removeCallbacks(mHeartBeatRunnable);// 移除线程，重连时保证该线程已停止上次调用时的工作
                    mReadThread.release();//释放SocketReadThread线程资源
                    releaseLastSocket();
                    connectToServer();// 再次调用connectToServer方法，连接服务端
                }
            }
            //mHandler.postDelayed(this, HEART_BEAT_RATE);
        }
    };
    /**
     * 发送心跳包
     *
     * @param msg
     * @return
     */
    public boolean sendHeartBeatMsg(String msg) {
        if (null == mSocket) {
            return false;
        }
        try {
            if (!mSocket.isClosed() && !mSocket.isOutputShutdown()) {
                String message = msg + "\r\n";
                mDataOutputStream.write(message.getBytes());
                mDataOutputStream.flush();
                sendTime = System.currentTimeMillis();
            } else {
                return false;
            }
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

}