package dev.jhordycycg.examples.microservices.observability.second.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class SecondService {
    private static final String API_URI = "http://localhost:8080/first";
    private final RestTemplate template;

    public SecondService(RestTemplate template) {
        this.template = template;
    }

    public Object getQuote() {
        return template.getForObject(API_URI, Object.class);
    }
}
