package com.hwmo.test.socket.reconnect;

import java.io.IOException;

public interface SocketClientResponseInterface<T> {
    /**
     * 客户端连接回调
     */
    void onSocketConnect();

    /**
     * 客户端收到服务端消息回调
     *
     * @param socketResult
     * @param code
     */
    void onSocketReceive(T socketResult, int code) throws IOException;

    /**
     * 客户端关闭回调
     *
     * @param msg
     * @param code
     */
    void onSocketDisable(String msg, int code);
}
