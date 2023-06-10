package com.surajraut.customer;

import com.surajraut.clients.fraud.FraudCheckResponse;
import lombok.extern.log4j.Log4j2;
import org.springframework.cloud.client.loadbalancer.reactive.ReactorLoadBalancerExchangeFilterFunction;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@Log4j2
@RestController
@RequestMapping("api/v1/customers")
public record CustomerController(CustomerService customerService) {
    @PostMapping
    public void customerRegistration(@RequestBody CustomerRegistrationRequest customerRegistrationRequest) {
        log.info("New Customer Creation:", customerRegistrationRequest);
//               Customer customer=customerService.register(customerRegistrationRequest);
//        ResponseEntity<FraudCheckResponse> responseEntity = webClient.filter(lbFunction).build()
//                .method(HttpMethod.GET)
//                .uri("http://fraud/api/v1/fraudcheck/{customerId}",customer.getId())
//                .retrieve()
//                .toEntity(FraudCheckResponse.class)
//                .block();
         customerService.register(customerRegistrationRequest);

    }


}
