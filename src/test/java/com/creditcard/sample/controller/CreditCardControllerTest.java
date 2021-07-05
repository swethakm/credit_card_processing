package com.creditcard.sample.controller;

import com.creditcard.sample.model.CreditCard;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
@AutoConfigureMockMvc
class CreditCardControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper mapper;

    @Test
    @DisplayName("When get creditCards is requested then list of creditcards returned")
    void getAllCreditCards() throws Exception {
        String result = mockMvc
                .perform(get("/creditcards/list"))
                .andExpect(status().is2xxSuccessful())
                .andReturn()
                .getResponse()
                .getContentAsString();
        assertEquals("[{\"cardNumber\":\"1111 2222 3333 4444\",\"name\":\"Alice\",\"balance\":-1045.0,\"limit\":2000.0}" +
                ",{\"cardNumber\":\"4444 3333 2222 1111\",\"name\":\"Bob\",\"balance\":10.24,\"limit\":5000.0}]", result);
    }

    @Test
    @DisplayName("When a creditCard creation is requested then it is persisted")
    void addCreditCard() throws Exception {
        CreditCard creditCard = new CreditCard("4929 3890 8814 2556", "Test User", 3000);
        CreditCard newCard =
                mapper.readValue(
                        mockMvc
                                .perform(
                                        post("/creditcards/add")
                                                .contentType(MediaType.APPLICATION_JSON)
                                                .content(mapper.writeValueAsString(creditCard)))
                                .andExpect(status().isCreated())
                                .andReturn()
                                .getResponse()
                                .getContentAsString(),
                        CreditCard.class);

        assertThat(creditCard, equalTo(newCard));
        assertEquals(0, newCard.getBalance());

    }

    @Test
    @DisplayName("When a creditCard creation is requested then it is persisted")
    void addCreditCard_InvalidCard() throws Exception {
        CreditCard creditCard = new CreditCard("4444 3333 2222 1221", "Test User", 3000);

        String error = mockMvc
                .perform(
                        post("/creditcards/add")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(mapper.writeValueAsString(creditCard)))
                .andExpect(status().is4xxClientError())
                .andReturn()
                .getResponse()
                .getContentAsString();

        assertTrue(error.contains("Credit card Number is not valid."));

    }

    @Test
    @DisplayName("When a creditCard creation is requested then it is persisted")
    void addCreditCard_CardNumber_InvalidChar() throws Exception {
        CreditCard creditCard = new CreditCard("4444 $" +
                "333 1ad2 1221", "Test User", 3000);

        String error = mockMvc
                .perform(
                        post("/creditcards/add")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(mapper.writeValueAsString(creditCard)))
                .andExpect(status().is4xxClientError())
                .andReturn()
                .getResponse()
                .getContentAsString();

        assertTrue(error.contains("Credit card Number is not valid."));

    }
}