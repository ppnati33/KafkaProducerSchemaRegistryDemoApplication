package org.kafka.producer.controller.v2;

import org.kafka.producer.VideoCallbackEventProducer;
import org.kafka.producer.controller.v2.dto.VideoCallbackV2;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/v2/videoCallbacks")
@RestController
public class VideoCallbackEventControllerV2 {

    private final VideoCallbackEventProducer videoCallbackEventProducer;

    public VideoCallbackEventControllerV2(VideoCallbackEventProducer videoCallbackEventProducer) {
        this.videoCallbackEventProducer = videoCallbackEventProducer;
    }

    @PostMapping
    public String create(@RequestBody VideoCallbackV2 event) {
        videoCallbackEventProducer.send(event);
        return "OK";
    }
}
