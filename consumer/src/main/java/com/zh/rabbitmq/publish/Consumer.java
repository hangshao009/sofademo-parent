package com.zh.rabbitmq.publish;

import com.rabbitmq.client.*;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class Consumer {
    //static  final String Queue_Name="simple_queue";分组消费服务
    static  final String publish_queue1="publish_queue1";
    static  final String publish_queue2="publish_queue2";
    static  final String exchange_name="FANOUT";

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
        //2.1创建channel
        Connection connection = connectionFactory.newConnection();
        Channel channel= connection.createChannel();
        //防止运维人员先启动消费端报错。
        //4.监听某个队列
        channel.basicConsume(publish_queue1,true,new com.rabbitmq.client.DefaultConsumer(channel){
            //consumerTag消费者标签
            //envelope信封，保存很多信息
            //properties消息的属性
            //body消息的字节数组
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                //业务逻辑部分
                System.out.println("consumerTag:"+consumerTag);
                System.out.println("exchange:"+envelope.getExchange());
                System.out.println("RoutingKey:"+envelope.getRoutingKey());
                System.out.println("DeliveryTag:"+envelope.getDeliveryTag());
                System.out.println(new String(body));
            }
        });

        //消费者这端不要关闭连接，否则消息无法监听。
    }
}
