package com.techstreams.springcloudkafkastream.service;

import com.techstreams.springcloudkafkastream.model.BaseResponse;
import com.techstreams.springcloudkafkastream.model.Greetings;
import com.techstreams.springcloudkafkastream.stream.GreetingsStreams;
import lombok.extern.slf4j.Slf4j;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;
import org.springframework.util.MimeTypeUtils;

@Service
@Slf4j
public class GreetingsService {

    private final GreetingsStreams greetingsStreams;


    public GreetingsService(GreetingsStreams greetingsStreams) {
        this.greetingsStreams = greetingsStreams;
    }

    public BaseResponse sendGreeting(final Greetings greetings) {
        log.info("Sending greetings {}", greetings);
        try {
            MessageChannel messageChannel = greetingsStreams.outboundGreetings();
            messageChannel.send(MessageBuilder
                    .withPayload(greetings)
                    .setHeader(MessageHeaders.CONTENT_TYPE, MimeTypeUtils.APPLICATION_JSON)
                    .build());
            return BaseResponse.builder()
                    .status("OK")
                    .message("Message Successfully Sent to Kafka")
                    .build();
        } catch (Exception e) {
            return BaseResponse.builder()
                    .status("ERROR")
                    .message("Error While Sending Message to Kafka")
                    .build();
        }

    }
}
