package com.hwmo.test.roma.mqs;

import com.huawei.it.eip.ump.client.producer.Producer;
import com.huawei.it.eip.ump.client.producer.SendResult;
import com.huawei.it.eip.ump.common.exception.UmpException;
import com.huawei.it.eip.ump.common.message.Message;
import java.io.UnsupportedEncodingException;

public class ProducerTest {
    public static void main(String[] args) throws UmpException, UnsupportedEncodingException {
        Producer producer = new Producer();
        producer.setUmpNamesrvUrls("49.4.92.78:9776;117.78.27.54:9776"); // 设置MQS的服务器地址(TOPIC中获取)
        producer.setAppId("test_fdi");             // 设置客户端账号
        producer.setAppSecret("lxBql97OJpxDEhbGyp+zog==");          // 设置客户端密钥
        producer.setTopic("T_mhw20919");     // 设置Topic Name
        producer.setEncryptTransport(true); // 设置是否需要加密传输。false（不加密）模式存在安全风险，建议使用true。
        producer.setTags("tag-xxx");        //发布tagA包含producer.tagB，tagB包含message.tagC，tagA、tagB不填即为所有(*)
        producer.start();                                // 启动消息生产者，建议在应用程序启动时调用（即执行此代码）
// 发送消息的业务逻辑
        Message message = new Message();
        message.setBusinessId("id-xxx");         // 设置消息业务标示，便于追踪消息轨迹
        message.setMessageGroupId("group1");    //当消息需要严格保证顺序消费时，将需要顺序消费的消息设置为相同的MessageGroupId
        message.setTags("tag-xxx");               // 设置消息标签
        message.setBody("body".getBytes("UTF-8")); // 消息体，推荐使用JSON.toJSONString(businessDo).getBytes("UTF-8") ，注：MQS不对二进制消息进行转换，Producer和Consumer需协商好序列化和反序列化方式
        try {
            SendResult sendResult = producer.send(message);
            if (sendResult.isSuccess()) {
// 发送成功的逻辑处理
            } else {
// 发送失败的逻辑处理
            }
        } catch (UmpException e) {
// 异常处理
        }
        producer.shutdown();        // 关闭消息生产者，建议在应用程序关闭的时候调用
    }
}