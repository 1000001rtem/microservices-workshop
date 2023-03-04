package ru.eremin.uiservice.business.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import ru.eremin.common.request.RegistrationRequest;
import ru.eremin.uiservice.business.service.UserService;
import ru.eremin.uiservice.messaging.RegistrationProducer;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final RegistrationProducer producer;

    @Override
    public void registration(final RegistrationRequest request) {
        producer.sendRegistrationMessage(request);
    }
}
