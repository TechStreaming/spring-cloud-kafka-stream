package com.techstreams.springcloudkafkastream.model;


import lombok.Builder;
import lombok.Data;
import lombok.ToString;

import java.util.List;

@Data
@ToString
@Builder
public class Greetings {

    private String message;

    private List<Long> phomneNumbers;

    private Long timeStamp;

}
