package com.surajraut.customer;

import com.surajraut.amqp.MQMessageProducer;
import com.surajraut.clients.fraud.FraudCheckResponse;
import com.surajraut.clients.fraud.FraudClient;
import com.surajraut.clients.notification.NotificationClient;
import com.surajraut.clients.notification.NotificationRequest;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@AllArgsConstructor
public class CustomerService {
    private final CustomerRepository customerRepository;
    private final FraudClient fraudClient;
    private final MQMessageProducer mqMessageProducer;

    public void register(CustomerRegistrationRequest customerRegistrationRequest) {
        Customer customer = Customer.builder()
                .firstName(customerRegistrationRequest.getFirstName())
                .lastName(customerRegistrationRequest.getLastName())
                .email(customerRegistrationRequest.getEmail())
                .build();
        customerRepository.saveAndFlush(customer);

         fraudClient.isFraudUser(customer.getId());
//         notificationClient.sendNotification(new NotificationRequest(customer.getId(),customer.getFirstName(),"In Customer Service"));
            mqMessageProducer.publish(new NotificationRequest(customer.getId(),customer.getFirstName(),"In Customer Service"),"internal.exchange","internal.notification.routing-key");


    }
}
