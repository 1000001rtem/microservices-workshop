package ru.eremin.uiservice;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@Data
@NoArgsConstructor
@AllArgsConstructor
class UserDto{
    private String name;
    private Integer age;
}

@SpringBootTest
class UiServiceApplicationTests {

    @Autowired
    private ObjectMapper mapper;

    @Test
    void contextLoads() throws JsonProcessingException {
        System.out.println(mapper);
        var objectMapper = new ObjectMapper();
        var user = new UserDto("Rick", 42);
        String json = objectMapper.writeValueAsString(user);
        System.out.println(json);
        UserDto userDto = objectMapper.readValue(json, UserDto.class);
        System.out.println(userDto);
    }

}
