package com.surajraut.notification.rabbitmq;


import com.surajraut.clients.notification.NotificationRequest;
import com.surajraut.notification.NotificationService;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
@Log4j2
public class NotificationConsumer {
    private final NotificationService notificationService;


    @RabbitListener(queues = "${rabbitmq.queues.notification}")
    public void consumer(NotificationRequest notificationRequest)
    {
        log.info("Consuming {} from queue", notificationRequest);

        notificationService.send(notificationRequest);

    }
}
