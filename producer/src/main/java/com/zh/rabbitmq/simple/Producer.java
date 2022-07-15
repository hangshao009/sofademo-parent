package com.zh.rabbitmq.simple;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.TimeoutException;
public class Producer {
    //static  final String Queue_Name="simple_queue";顺序消费
    static  final String Queue_Name="simple_queue";
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
        channel.queueDeclare(Queue_Name,true,false,false,null);
        //4.发消息
            String msg = "hello rabbitmq!!!";
            System.out.println("推送消息...");
            channel.basicPublish("",Queue_Name,null,msg.getBytes());
        //5.关闭连接
        System.out.println("准备关闭连接...");
        channel.close();
        connection.close();
        System.out.println("关闭连接完成");

    }
}
