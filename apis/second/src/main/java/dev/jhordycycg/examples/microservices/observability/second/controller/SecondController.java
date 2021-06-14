package dev.jhordycycg.examples.microservices.observability.second.controller;

import dev.jhordycycg.examples.microservices.observability.second.service.SecondService;
import io.opentracing.util.GlobalTracer;
import org.fluentd.logger.FluentLogger;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("second")
public class SecondController {
    private static final FluentLogger logger = FluentLogger.getLogger("secondController");
    private final SecondService service;

    public SecondController(SecondService service) {
        this.service = service;
    }

    @GetMapping
    public Object getQuote() {
        Map<String, Object> data = new HashMap<>();
        String traceId = GlobalTracer.get().activeSpan().context().toTraceId();
        data.put("message", "Consuming firstApplication API");
        data.put("traceId", traceId);
        logger.log("getQuote", data);
        return service.getQuote();
    }
}
