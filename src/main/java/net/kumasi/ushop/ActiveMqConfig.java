package net.kumasi.ushop;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.core.JmsTemplate;

import javax.jms.ConnectionFactory;


@Configuration
@EnableJms
public class ActiveMqConfig {

    @Value("${spring.activemq.broker-url}")
    String BROKER_URL;
    @Value("${spring.activemq.user}")
    String BROKER_USERNAME;
    @Value("${spring.activemq.password}")
    String BROKER_PASSWORD;

    @Bean
    public ConnectionFactory getConnectionFactory(){
        ActiveMQConnectionFactory activeMQConnectionFactory  = new ActiveMQConnectionFactory();
        activeMQConnectionFactory.setBrokerURL(BROKER_URL);
        activeMQConnectionFactory.setPassword(BROKER_PASSWORD);
        activeMQConnectionFactory.setUserName(BROKER_USERNAME);
        return  activeMQConnectionFactory;
    }

    @Bean
    public JmsTemplate getJmsTemplate(){
        JmsTemplate jmsTemplate = new JmsTemplate();
        jmsTemplate.setConnectionFactory(getConnectionFactory());

        return jmsTemplate;
    }

}
