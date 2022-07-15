package com.zh.rabbitmq.tpoic;

import com.rabbitmq.client.BuiltinExchangeType;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.TimeoutException;
public class Producer {
    static  final String Queue_Name1="topic_queue1";
    static  final String Queue_Name2="topic_queue2";
    static final  String exchange="exchange";
    public static void main(String[] args) throws IOException, TimeoutException {
        //1.创建连接工厂
        ConnectionFactory connectionFactory = new ConnectionFactory();
        connectionFactory.setHost("172.16.31.220");
        connectionFactory.setPort(30944);
        //1.1设置虚拟主机目录
        connectionFactory.setVirtualHost("/");
        connectionFactory.setUsername("admin");
        connectionFactory.setPassword("password");
        //2.创建长链接
        System.out.println("创建连接...");
        //2.1创建channel
        Connection connection = connectionFactory.newConnection();
        Channel channel=connection.createChannel();
        //声明队列
        channel.queueDeclare(Queue_Name1,true,false,false,null);
        channel.queueDeclare(Queue_Name2,true,false,false,null);
        //声明交换机
        channel.exchangeDeclare(exchange, BuiltinExchangeType.TOPIC,true,false,null);
        channel.queueBind(Queue_Name1,exchange,"com.yunnan.*.*");
        channel.queueBind(Queue_Name2,exchange,"com.*.java.*");
        //4.发消息
        String msg1 = "tpoic 111";
        System.out.println("推送消息...");
        channel.basicPublish(exchange,"com.yunnan.qianduan.info",null,msg1.getBytes());
        String msg2 = "tpoic 222";
        System.out.println("推送消息...");
        channel.basicPublish(exchange,"com.beijing.java.error",null,msg2.getBytes());
        String msg3 = "tpoic 333";
        System.out.println("推送消息...");
        channel.basicPublish(exchange,"com.yunnan.qianduan.error",null,msg3.getBytes());
        //5.关闭连接
        System.out.println("准备关闭连接...");
        channel.close();
        connection.close();
        System.out.println("关闭连接完成");

    }
}
