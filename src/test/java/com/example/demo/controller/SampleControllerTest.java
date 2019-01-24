package com.example.demo.controller;

import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlHeading1;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.CoreMatchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@RunWith(SpringRunner.class)
@WebMvcTest(SampleController.class)
public class SampleControllerTest {


    @Autowired
    WebClient webClient;

    @Autowired
    MockMvc mockMvc;

    @Test
    public void hello() throws Exception{
        HtmlPage page = webClient.getPage("/hello");
        HtmlHeading1 h1 = page.getFirstByXPath("//h1"); //제일 앞에 있는 것 하나 가지고옴.
        assertThat(h1.getTextContent()).isEqualToIgnoringCase("주경");

//        mockMvc.perform(get("/hello"))
//                .andExpect(status().isOk())
//                .andDo(print())
//                .andExpect(view().name("hello"))
//                .andExpect(model().attribute("name","jukyung"))
//                .andExpect(content().string(containsString("jukyung")));

    }

}