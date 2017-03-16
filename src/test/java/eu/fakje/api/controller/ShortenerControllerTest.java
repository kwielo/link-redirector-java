package eu.fakje.api.controller;

import static org.hamcrest.Matchers.equalTo;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class ShortenerControllerTest
{
    @Autowired
    private MockMvc mvc;

    private static final String URL_TO_SHORT = "http://wp.pl";

    @Test
    public void getShortenedLink() throws Exception
    {
        mvc.perform(MockMvcRequestBuilders
            .get("/cut")
            .param("url", URL_TO_SHORT)
        )
        .andExpect(status().isOk());
    }

    public void redirect() throws Exception
    {
        mvc.perform(MockMvcRequestBuilders
            .get("/H4LV7b")
        )
        .andExpect(status().isOk());
    }

}