package corp.cbs.app.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.ResultActions;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;



@SpringBootTest
@AutoConfigureMockMvc
class EmployeeControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void createEmployee() throws Exception {
        // Arrange
        String userJson = "{\n"+"\"firstName\":\"John\",\n"+"\"lastName\": \"Doe\",\n"+"\"email\":\"john.doe@example.com\"\n"+"}";

        // Act
        ResultActions result = mockMvc.perform(post("/api/employees")
                .contentType(MediaType.APPLICATION_JSON)
                .content(userJson));

        // Assert
        result.andExpect(status().is2xxSuccessful());
    }


    @Test
    public void getAllEmployees() throws Exception {

        long userId = 1L;

        // Act
        ResultActions result = mockMvc.perform(get("/api/employees"));

        // Assert
        result.andExpect(status().is2xxSuccessful());
    }

    @Test
    void getEmployeeById() throws Exception {
        // Act
        // Arrange
        long userId = 1L;

        // Act
        ResultActions result = mockMvc.perform(get("/api/users/{id}", userId));

        // Assert
        result.andExpect(status().is4xxClientError());
    }
}