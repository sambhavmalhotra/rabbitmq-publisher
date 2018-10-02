package com.rabbitmq.publisher.rabbitmqpublisher.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@EnableBinding(Source.class)
@RestController
public class RabbitMqPublisherController {

    @Autowired private Source source;

    @RequestMapping(path = "/startRabbit", method = RequestMethod.POST)
    public String startRabbit(@RequestBody @Valid String name) {
        source.output().send(MessageBuilder.withPayload(name).build());
        return "success";
    }
}
