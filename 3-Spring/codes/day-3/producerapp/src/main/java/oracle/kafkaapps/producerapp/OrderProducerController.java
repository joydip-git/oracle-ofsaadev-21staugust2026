package oracle.kafkaapps.producerapp;

import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping(path = "/api/orders")
public class OrderProducerController {

    private final KafkaTemplate<String, Order> kafkaTemplate;
    private static final String TOPIC = "orders";

    public OrderProducerController(KafkaTemplate<String, Order> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    @PostMapping
    public ResponseEntity<String> publishOrder(@RequestBody Order order) {
        kafkaTemplate.send(TOPIC, String.valueOf(order.getId()), order);
        return ResponseEntity.ok("published order");
    }
}
