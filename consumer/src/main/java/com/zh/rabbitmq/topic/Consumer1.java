package com.zh.rabbitmq.topic;

import com.rabbitmq.client.*;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class Consumer1 {
    //static  final String Queue_Name="simple_queue";
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
        //2.1创建channel
        Connection connection = connectionFactory.newConnection();
        Channel channel= connection.createChannel();
        channel.queueDeclare(Queue_Name1,true,false,false,null);
        channel.queueDeclare(Queue_Name2,true,false,false,null);
        //声明交换机
        channel.exchangeDeclare(exchange, BuiltinExchangeType.TOPIC,true,false,null);
        channel.queueBind(Queue_Name1,exchange,"com.yunnan.*.*");
        channel.queueBind(Queue_Name2,exchange,"com.*.java.*");
        //防止运维人员先启动消费端报错。
        //4.监听某个队列
        channel.basicConsume(Queue_Name2,true,new DefaultConsumer(channel){
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
