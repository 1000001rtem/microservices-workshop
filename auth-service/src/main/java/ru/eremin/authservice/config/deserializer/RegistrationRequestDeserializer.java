package ru.eremin.authservice.config.deserializer;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;
import org.apache.kafka.common.serialization.Deserializer;
import ru.eremin.authservice.messaging.dto.RegistrationRequest;

public class RegistrationRequestDeserializer implements Deserializer<RegistrationRequest> {

    private ObjectMapper mapper;

    public RegistrationRequestDeserializer(final ObjectMapper mapper) {
        this.mapper = mapper;
    }

    @Override
    @SneakyThrows
    public RegistrationRequest deserialize(final String s, final byte[] bytes) {
        return mapper.readValue(bytes, RegistrationRequest.class);
    }
}
