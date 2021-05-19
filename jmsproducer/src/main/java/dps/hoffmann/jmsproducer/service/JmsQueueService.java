package dps.hoffmann.jmsproducer.service;

import dps.hoffmann.jmsproducer.model.MessageWrapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Slf4j
public class JmsQueueService {

    @Autowired
    JmsTemplate jmsTemplate;

    public void sendMessage(String message) {
        log.info("new message: {}", message);
        jmsTemplate.convertAndSend("jms/queue/ip-queue", new MessageWrapper(message));
        jmsTemplate.convertAndSend("jms.queue.ip-queue", new MessageWrapper(message));
    }

}