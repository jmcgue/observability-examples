package dev.jhordycycg.examples.microservices.observability.first.controller;

import dev.jhordycycg.examples.microservices.observability.first.service.FirstService;
import io.opentracing.util.GlobalTracer;
import org.fluentd.logger.FluentLogger;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("first")
public class FirstController {

    private static final FluentLogger logger = FluentLogger.getLogger("firstController");

    private final FirstService service;

    public FirstController(FirstService service) {
        this.service = service;
    }

    @GetMapping
    public Object getQuote() {
        Map<String, Object> data = new HashMap<>();
        String traceId = GlobalTracer.get().activeSpan().context().toTraceId();
        data.put("message", "Consuming an external API");
        data.put("traceId", traceId);
        logger.log("getQuote", data);

        return service.getQuote();
    }
}
