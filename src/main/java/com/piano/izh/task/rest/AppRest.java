package com.piano.izh.task.rest;

import com.piano.izh.task.entities.Questions;
import com.piano.izh.task.service.StackExchangeService;
import org.springframework.web.bind.annotation.*;

import java.io.UnsupportedEncodingException;

@RestController
public class AppRest {

    private final StackExchangeService client;

    public AppRest(StackExchangeService client) {
        this.client = client;
    }

    @RequestMapping(value = "/search/questions/{headline}",
            method = RequestMethod.GET)
    public Questions getQuestions(@PathVariable String headline) throws UnsupportedEncodingException {
        return client.getQuestions(headline);
    }
}
