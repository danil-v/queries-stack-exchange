package com.piano.izh.task.client;

import com.piano.izh.task.entities.BadRequestException;
import com.piano.izh.task.entities.Questions;
import org.apache.http.client.HttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

@Component
public class StackExchangeClient {
    private final static Logger log = LoggerFactory.getLogger(StackExchangeClient.class);
    HttpClient httpClient = HttpClientBuilder.create().build();
    ClientHttpRequestFactory requestFactory = new HttpComponentsClientHttpRequestFactory(httpClient);
    private RestTemplate restTemplate = new RestTemplate(requestFactory);
    private final String urlStackExchange;

    public StackExchangeClient(@Value("${stack.exchange.url}") String urlStackExchange) {
        this.urlStackExchange = urlStackExchange;
    }

    public Questions getQuestions(String headline) throws UnsupportedEncodingException {
        HttpEntity<Questions> response;
        UriComponentsBuilder builder = UriComponentsBuilder
                .fromUriString(urlStackExchange)
                .queryParam("intitle", headline);
        try {
            response = restTemplate.exchange(URLDecoder.decode(builder.toUriString(), "UTF-8"), HttpMethod.GET, null, Questions.class);
        } catch (HttpClientErrorException e) {
            log.error("При запросе на api.stackexchange.com произошла ошибка: "+ e.getMessage());
            throw new BadRequestException();
        }
        return response.getBody();
    }
}
