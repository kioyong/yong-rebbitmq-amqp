package com.yong.amqp;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
/**
 * Created by yong.a.liang on 7/31/2017.
 */

@RabbitListener(queues = "hello")
public class Tut1Receiver {

    private static final Logger log = LoggerFactory.getLogger(Tut1Receiver.class);


    @RabbitHandler
    public void receive(String in) {
        System.out.println(" [x] Received '" + in + "'");
        log.debug(" [x] Received '{}",in);
    }



}
