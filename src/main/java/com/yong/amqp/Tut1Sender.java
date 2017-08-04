package com.yong.amqp;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * Created by yong.a.liang on 7/31/2017.
 */
@Component
public class Tut1Sender {


    private static final Logger log = LoggerFactory.getLogger(Tut1Sender.class);

    @Autowired
    private RabbitTemplate template;

    @Autowired
    private Queue queue;


    @Scheduled(fixedDelay = 1000, initialDelay =500)
    public void send(){
        String message = "hello World!";
        this.template.convertAndSend(queue.getName(),message);
        log.debug(" [x] Send '{}'",message);
        System.out.println(" [x] Sent '" + message + "'");
    }

}
