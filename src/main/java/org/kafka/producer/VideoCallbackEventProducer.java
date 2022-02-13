package org.kafka.producer;

import org.apache.kafka.clients.producer.ProducerRecord;
import org.kafka.producer.controller.VideoCallback;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Component;
import org.springframework.util.concurrent.ListenableFutureCallback;

import java.util.UUID;

@Component
public class VideoCallbackEventProducer {

    private static final Logger logger = LoggerFactory.getLogger(VideoCallbackEventProducer.class);

    private final KafkaTemplate<String, VideoCallback> kafkaTemplate;

    @Value("${kafka.poc-events.topic-name}")
    private String topicName;

    public VideoCallbackEventProducer(KafkaTemplate<String, VideoCallback> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void send(VideoCallback event) {
        logger.info(String.format("Producing event -> %s", event));

        kafkaTemplate
            .send(new ProducerRecord<>(topicName, UUID.randomUUID().toString(), event))
            .addCallback(new ListenableFutureCallback<>() {

                @Override
                public void onSuccess(SendResult<String, VideoCallback> result) {
                    logger.info(
                        String.format("Sent event=[%s] with offset=[%s]", event, result.getRecordMetadata().offset())
                    );
                }

                @Override
                public void onFailure(Throwable ex) {
                    logger.error(
                        String.format("Unable to send event=[%s] due to : %s", event, ex.getMessage())
                    );
                }
            });
    }
}
