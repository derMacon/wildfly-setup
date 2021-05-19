package dps.hoffmann.jmsproducer.controller;

import dps.hoffmann.jmsproducer.service.JmsQueueService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class DefaultController {

    @Autowired
    private JmsQueueService jmsQueueService;


    @RequestMapping("/")
    public String health() {
        return "component up and running";
    }

    @RequestMapping("/send")
    public void sendMessage(@RequestParam String message) {
        log.info("send message: {}", message);
        jmsQueueService.sendMessage(message);
    }

}
