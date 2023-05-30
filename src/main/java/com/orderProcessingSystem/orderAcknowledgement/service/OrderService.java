package com.orderProcessingSystem.orderAcknowledgement.service;

import com.orderProcessingSystem.orderAcknowledgement.exception.ApplicationException;
import com.orderProcessingSystem.orderAcknowledgement.model.Order;
import com.orderProcessingSystem.orderAcknowledgement.model.OrderItem;
import jakarta.transaction.Transactional;
import org.apache.activemq.artemis.jms.client.ActiveMQConnectionFactory;
import org.apache.activemq.artemis.jndi.ActiveMQInitialContextFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.jms.JMSContext;
import javax.jms.ObjectMessage;
import javax.jms.Topic;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import java.util.List;

@Service
@Transactional
public class OrderService {

    public void processOrder(Order order) throws NamingException, ApplicationException {
        InitialContext context = new InitialContext();
        Topic topic = (Topic) context.lookup("Topic/orderTopic");
        try (ActiveMQConnectionFactory cf = new ActiveMQConnectionFactory();
             JMSContext jmsContext = cf.createContext()) {
            jmsContext.createProducer().send(topic,order);
            System.out.println("Message sent!");
        }
    }
}
