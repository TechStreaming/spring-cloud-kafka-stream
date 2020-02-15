package com.techstreams.springcloudkafkastream.config;

import com.techstreams.springcloudkafkastream.stream.GreetingsStreams;
import org.springframework.cloud.stream.annotation.EnableBinding;

@EnableBinding(GreetingsStreams.class)
public class StreamsConfig {
}
