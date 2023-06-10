package com.surajraut.customer;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class CustomerRegistrationRequest {
    private String email;
    private String firstName;
    private String lastName;
}
