package ru.eremin.uiservice.business.service;

import java.util.List;
import ru.eremin.uiservice.business.dto.DocumentDto;

public interface DocumentService {

    List<DocumentDto> getAllDocuments(String token);

}
