package com.hwmo.test.roma.mqs;

import com.huawei.it.eip.ump.client.consumer.ConsumeStatus;
import com.huawei.it.eip.ump.client.consumer.Consumer;
import com.huawei.it.eip.ump.client.listener.MessageListener;
import com.huawei.it.eip.ump.common.exception.UmpException;
import com.huawei.it.eip.ump.common.message.Message;
import java.io.UnsupportedEncodingException;

public class ConsumerTest {
    public static void main(String[] args) throws UmpException {
        Consumer consumer = new Consumer();
        consumer.setUmpNamesrvUrls("49.4.92.78:9776;117.78.27.54:9776"); // 设置统一消息平台的服务器地址(TOPIC中获取)
        consumer.setAppId("gzcss_mhw_test");        // 设置客户端账号
        consumer.setAppSecret("SIoLVDuaexVrbCH7N6VtTw==");     // 设置客户端密钥
        consumer.setTopic("T_mhw20919");// 设置Topic Name
        consumer.setConsumeOrderly(true);//当需要顺序消费时将此标识设置为true，默认为false
        consumer.setMaxReconsumeTimes(5);//当需要顺序消可修费改此最大重试次数，默认为16次
        consumer.setTags("*");                  // 设置订阅消息的标签，可以指定消费某一类型的消息，默认*表示消费所有类型的消息
        consumer.setEncryptTransport(true);// 设置是否需要加密传输。false（不加密）模式存在安全风险，建议使用true。
        consumer.subscribe(new MessageListener() {
            public ConsumeStatus consume(Message message) throws UnsupportedEncodingException {
// 消费消息的业务逻辑
                System.out.println("Receive: " + new String(message.getBody(), "UTF-8"));
// 正常接收到消息后，请务必返回CONSUME_SUCCESS，只有在业务处理失败才返回RECONSUME_LATER
                return ConsumeStatus.CONSUME_SUCCESS;
            }
        });
        consumer.start();                   // 启动消费者，建议在应用程序关闭时执行consumer.shutdown()关闭此消费者。
    }
}
