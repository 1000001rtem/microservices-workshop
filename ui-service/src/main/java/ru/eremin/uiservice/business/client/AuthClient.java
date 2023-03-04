package ru.eremin.uiservice.business.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "authClient", url = "${service.auth.url}")
public interface AuthClient {

    @PostMapping("api/v1/auth/check")
    Boolean isAuth(@RequestBody String token);
}
