package com.ficagna.TestesIntegrados;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

public class HelloControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testHello() throws Exception {
        ResultActions resultado = mockMvc
                .perform(MockMvcRequestBuilders.get("/hello"))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk());

        String contentAsString = resultado.andReturn().getResponse().getContentAsString();

        Assertions.assertEquals("tchau!", contentAsString);
    }

    @Test
    public void testSaudar() throws Exception {
        String json = "{\n" +
                "   \"nome\": \"Karla\"\n" +
                "}";

        ResultActions resultActions = mockMvc
                .perform(
                        MockMvcRequestBuilders.post("/saudacao")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(json))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk());

        String contentAsString = resultActions.andReturn().getResponse().getContentAsString();
        Assertions.assertEquals("oi, Karla, tudo bem?", contentAsString);

    }

    @Test
    public void testBye() throws Exception {
        String json = "{\n" +
                "   \"nome\": \"Karla\"\n" +
                "}";

        ResultActions resultActions = mockMvc
                .perform(
                        MockMvcRequestBuilders.post("/bye")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(json))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk());

        String contentAsString = resultActions.andReturn().getResponse().getContentAsString();
        Assertions.assertEquals("tchau, Karla!", contentAsString);

    }
}

