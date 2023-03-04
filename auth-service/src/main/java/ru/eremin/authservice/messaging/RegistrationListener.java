package ru.eremin.authservice.messaging;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.log4j.Log4j2;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;
import ru.eremin.authservice.messaging.dto.RegistrationRequest;

@Log4j2
@Component
@RequiredArgsConstructor
public class RegistrationListener {

    private final ObjectMapper mapper;

    @SneakyThrows
    @KafkaListener(topics = "${service.kafka.topics.registration}", containerFactory = "registrationRequestConcurrentKafkaListenerContainerFactory")
    public void handle(RegistrationRequest request){
        log.info("Receive message: {}", request);
    }
}
