package dps.hoffmann.jmsproducer.config;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;
import org.springframework.jms.connection.CachingConnectionFactory;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.jms.annotation.EnableJms;

import javax.jms.ConnectionFactory;
import java.util.Arrays;

@Configuration
@EnableJms
@EnableTransactionManagement
public class ActiveMqConfiguration {

//    @Value("${activemq.broker-url}")
    private String brokerUrl = "tcp://localhost:61616";

    @Bean
    public ConnectionFactory senderActiveMQConnectionFactory() {
        ActiveMQConnectionFactory activeMQConnectionFactory =
                new ActiveMQConnectionFactory();
        activeMQConnectionFactory.setBrokerURL(brokerUrl);
        activeMQConnectionFactory.setTrustedPackages(Arrays.asList(
                "dps.hoffmann",
                "java.time",
                "java.sql",
                "java.lang"));

        return activeMQConnectionFactory;
    }

    @Bean
    @Primary
    public CachingConnectionFactory cachingConnectionFactory() {
        return new CachingConnectionFactory(
                senderActiveMQConnectionFactory());
    }

    @Bean
    public DefaultJmsListenerContainerFactory jmsListenerContainerFactory(
            ConnectionFactory connectionFactory) {
        DefaultJmsListenerContainerFactory factory = new DefaultJmsListenerContainerFactory();
        factory.setConnectionFactory(connectionFactory);
        return factory;
    }

    /**
     * Provides the jms template instance
     * IMPORTANT: to make the whole main producer method transactional,
     * the option from the template must be set to session transacted
     * @return jms template instance
     */
    @Bean
    public JmsTemplate jmsTemplate() {
        JmsTemplate jmsTemplate = new JmsTemplate();
        jmsTemplate.setConnectionFactory(cachingConnectionFactory());
//        jmsTemplate.setSessionTransacted(true);
        return jmsTemplate;
    }

}