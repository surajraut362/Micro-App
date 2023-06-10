package com.surajraut.fraud;

import com.surajraut.clients.fraud.FraudCheckResponse;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@Log4j2
@RequestMapping("api/v1/fraudcheck")
public class FraudCheckController {
    private final FraudCheckService fraudCheckService;

    @GetMapping(path = "{customerId}")
    public FraudCheckResponse isFraudUser(@PathVariable("customerId") Integer customerId) {
        log.info("Chhecking fraud");
        return new FraudCheckResponse(fraudCheckService.isFraudlentUser(customerId));
    }
}
