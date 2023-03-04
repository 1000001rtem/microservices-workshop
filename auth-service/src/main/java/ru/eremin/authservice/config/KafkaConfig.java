package ru.eremin.authservice.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.HashMap;
import java.util.Map;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.support.serializer.JsonDeserializer;
import ru.eremin.authservice.config.deserializer.RegistrationRequestDeserializer;
import ru.eremin.authservice.messaging.dto.RegistrationRequest;

@Configuration
public class KafkaConfig {
    @Bean
    public ConsumerFactory<String, RegistrationRequest> registrationRequestConsumerFactory(
        ObjectMapper objectMapper
    ) {
        Map<String, Object> props = new HashMap<>();
        props.put(
            ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG,
            "localhost:9092");
        props.put(
            ConsumerConfig.GROUP_ID_CONFIG,
            "auth-service");
        props.put(
            ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG,
            StringDeserializer.class);
        props.put(
            ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG,
            RegistrationRequestDeserializer.class);
        props.put(
            JsonDeserializer.TRUSTED_PACKAGES,
            "*");
        return new DefaultKafkaConsumerFactory<>(
            props,
            new StringDeserializer(),
            new RegistrationRequestDeserializer(objectMapper));
    }

    @Bean
    public ConcurrentKafkaListenerContainerFactory<String, RegistrationRequest>
    registrationRequestConcurrentKafkaListenerContainerFactory(ObjectMapper objectMapper) {
        ConcurrentKafkaListenerContainerFactory<String, RegistrationRequest> factory =
            new ConcurrentKafkaListenerContainerFactory<>();
        factory.setConsumerFactory(registrationRequestConsumerFactory(objectMapper));
        return factory;
    }
}
