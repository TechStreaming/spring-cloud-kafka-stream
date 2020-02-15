package com.techstreams.springcloudkafkastream.model;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
@Builder
public class BaseResponse {

    private String status;

    private String message;

}
