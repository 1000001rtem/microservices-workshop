package ru.eremin.uiservice.controller;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.eremin.uiservice.business.dto.DocumentDto;
import ru.eremin.uiservice.business.service.DocumentService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/document")
public class DocumentController {

    private final DocumentService documentService;

    @GetMapping("/list")
    public List<DocumentDto> getAllDocuments(@RequestHeader("Authorization") String token){
        return documentService.getAllDocuments(token);
    }
}
