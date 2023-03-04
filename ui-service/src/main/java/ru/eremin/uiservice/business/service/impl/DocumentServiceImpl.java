package ru.eremin.uiservice.business.service.impl;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;
import ru.eremin.uiservice.business.client.AuthClient;
import ru.eremin.uiservice.business.dto.DocumentDto;
import ru.eremin.uiservice.business.service.DocumentService;

@Service
@RequiredArgsConstructor
public class DocumentServiceImpl implements DocumentService {

    private final AuthClient authClient;
    private final ApplicationContext context;


    @Override
    public List<DocumentDto> getAllDocuments(final String token) {
        if(!authClient.isAuth(token)){
            throw new RuntimeException("HACCCCKKKKEEERRSSSSSS");
        }
        return List.of(new DocumentDto("1"), new DocumentDto("2"));
    }
}
