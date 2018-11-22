package com.piano.izh.task.service;

import com.piano.izh.task.client.StackExchangeClient;
import com.piano.izh.task.entities.Questions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.UnsupportedEncodingException;

@Service
public class StackExchangeService {

    @Autowired
    private StackExchangeClient stackExchangeClient;

    public Questions getQuestions(String headline) throws UnsupportedEncodingException {
        return stackExchangeClient.getQuestions(headline);
    }
}
