package com.github.gateway.api;


import com.github.gateway.model.Response;
import com.github.gateway.model.User;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class UserController {

    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    @Autowired
    public RestTemplate restTemplate;


    @GetMapping("users/{id}")
    @HystrixCommand(fallbackMethod = "fallbackMethod")
    public ResponseEntity<User> getUser(@PathVariable(value = "id") Long userId) {
        User response = restTemplate.exchange("http://user-service/api/v1/users/{id}",
                HttpMethod.GET, null, new ParameterizedTypeReference<User>() {
                }, userId).getBody();

        System.out.println("Response Body " + response);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }


    public ResponseEntity<User> fallbackMethod(Long id) {

        return new ResponseEntity<>(null, HttpStatus.OK);
    }


    @Bean
    @LoadBalanced
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
