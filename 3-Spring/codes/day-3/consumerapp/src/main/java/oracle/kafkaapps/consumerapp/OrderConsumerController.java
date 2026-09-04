package oracle.kafkaapps.consumerapp;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestController;

@Service
public class OrderConsumerController {

    @KafkaListener(topics = "ORDERS", groupId = "order-consumer-group")
    public void consume(Order order) {
        if (order == null)
            System.out.println("called but no data");
        else
            System.out.println("Id: " + order.getId() + ", amount: " + order.getAmount());
    }
}
