package org.kafka.producer.controller.v1;

import org.kafka.producer.VideoCallbackEventProducer;
import org.kafka.producer.controller.v1.dto.VideoCallbackV1;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/v1/videoCallbacks")
@RestController
public class VideoCallbackEventControllerV1 {

    private final VideoCallbackEventProducer videoCallbackEventProducer;

    public VideoCallbackEventControllerV1(VideoCallbackEventProducer videoCallbackEventProducer) {
        this.videoCallbackEventProducer = videoCallbackEventProducer;
    }

    @PostMapping
    public String create(@RequestBody VideoCallbackV1 event) {
        videoCallbackEventProducer.send(event);
        return "OK";
    }
}
