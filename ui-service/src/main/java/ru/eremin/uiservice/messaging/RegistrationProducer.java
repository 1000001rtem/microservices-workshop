package ru.eremin.uiservice.messaging;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;
import ru.eremin.common.request.RegistrationRequest;

@Log4j2
@Component
@RequiredArgsConstructor
public class RegistrationProducer {

    private final KafkaTemplate<String, RegistrationRequest> kafkaTemplate;

    @Value("${service.kafka.topics.registration}")
    private String topic;

    public void sendRegistrationMessage(RegistrationRequest request){
        log.info("Send message: {} to {}", request, topic);
        kafkaTemplate.send(topic, request);
    }
}
