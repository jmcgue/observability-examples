package dev.jhordycycg.examples.microservices.observability.first.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class FirstService {
    private static final String API_URI = "https://quoters.apps.pcfone.io/api/random";
    private final RestTemplate template;

    public FirstService(RestTemplate template) {
        this.template = template;
    }

    public Object getQuote() {
        return template.getForObject(API_URI, Object.class);
    }
}
