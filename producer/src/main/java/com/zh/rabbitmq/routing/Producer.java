package com.zh.rabbitmq.routing;

import com.rabbitmq.client.BuiltinExchangeType;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class Producer {
    //static  final String Queue_Name="simple_queue";顺序消费
    static  final String Queue_Name1="DIRECT1";
    static  final String Queue_Name2="DIRECT2";
    static  final String ExangeName="DIRECT";
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
        channel.exchangeDeclare(ExangeName, BuiltinExchangeType.DIRECT,true,false,null);
        channel.queueBind(Queue_Name1,ExangeName,"error");
        channel.queueBind(Queue_Name2,ExangeName,"info");
        channel.queueBind(Queue_Name1,ExangeName,"warning");
        channel.queueBind(Queue_Name2,ExangeName,"error");
        //4.发消息
        String msg = "hello rabbitmq!!! error";
        System.out.println("推送消息...");
        channel.basicPublish(ExangeName,"error",null,msg.getBytes());
        String msg1 = "hello rabbitmq!!! info";
        channel.basicPublish(ExangeName,"info",null,msg1.getBytes());
        String msg2 = "hello rabbitmq!!! warning";
        channel.basicPublish(ExangeName,"warning",null,msg2.getBytes());
        //5.关闭连接
        System.out.println("准备关闭连接...");
        channel.close();
        connection.close();
        System.out.println("关闭连接完成");

    }
}
