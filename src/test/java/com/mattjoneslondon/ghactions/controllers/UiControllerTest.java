package com.mattjoneslondon.ghactions.controllers;

import com.mattjoneslondon.ghactions.services.TimeDiscoveryService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.time.ZoneId;
import java.time.ZonedDateTime;

import static org.hamcrest.Matchers.containsString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(UiController.class)
@AutoConfigureMockMvc
public class UiControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private TimeDiscoveryService timeDiscoveryService;

    @Test
    void showHomePageReturnsExpectedViewName() throws Exception {
        var currentTime = ZonedDateTime.of(2024, 2, 15, 8, 30, 0, 0, ZoneId.of("UTC"));
        when(timeDiscoveryService.getCurrentDateTime()).thenReturn(currentTime);
        mockMvc.perform(get("/"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(model().attribute("currentDateTime", currentTime))
                .andExpect(content().string(containsString("2024-02-15T08:30Z[UTC]")));
    }
}