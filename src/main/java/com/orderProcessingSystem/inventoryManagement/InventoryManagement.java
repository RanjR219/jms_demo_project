package com.orderProcessingSystem.inventoryManagement;

import com.orderProcessingSystem.orderAcknowledgement.model.Order;
import org.apache.activemq.artemis.jms.client.ActiveMQConnectionFactory;

import javax.jms.*;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class InventoryManagement {
    public static void main(String[] args) throws NamingException, JMSException, InterruptedException {
        InitialContext context = new InitialContext();
        Topic topic = (Topic) context.lookup("Topic/orderTopic");
        try (ActiveMQConnectionFactory cf = new ActiveMQConnectionFactory();
             JMSContext jmsContext = cf.createContext()) {
            JMSConsumer consumer = jmsContext.createConsumer(topic);
            Message message = consumer.receive();
            Order order = message.getBody(Order.class);
            System.out.println(order.getEmailId());
            System.out.println(order.getOrderItems());

        }

    }
}
