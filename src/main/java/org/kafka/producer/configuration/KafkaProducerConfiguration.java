package org.kafka.producer.configuration;

import io.confluent.kafka.serializers.json.KafkaJsonSchemaSerializerConfig;
import org.kafka.producer.controller.VideoCallback;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;

@EnableKafka
@Configuration
public class KafkaProducerConfiguration {

    @Autowired
    private KafkaProperties properties;

    @Bean
    public ProducerFactory<String, VideoCallback> producerFactory() {
        var props = properties.buildProducerProperties();
        props.put(KafkaJsonSchemaSerializerConfig.SCHEMA_REGISTRY_URL_CONFIG, "http://localhost:8081");
        props.put(KafkaJsonSchemaSerializerConfig.AUTO_REGISTER_SCHEMAS, false);
        props.put(KafkaJsonSchemaSerializerConfig.USE_LATEST_VERSION, true);
        return new DefaultKafkaProducerFactory<>(props);
    }

    @Bean
    public KafkaTemplate<String, VideoCallback> kafkaTemplate() {
        return new KafkaTemplate<>(producerFactory());
    }
}
