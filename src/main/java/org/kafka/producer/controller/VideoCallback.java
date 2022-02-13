package org.kafka.producer.controller;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
abstract public class VideoCallback {

    @JsonProperty("status")
    public String status;

    public VideoCallback(String status) {
        this.status = status;
    }
}
