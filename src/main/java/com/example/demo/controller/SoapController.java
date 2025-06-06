package com.example.demo.controller;

import com.example.demo.service.SoapClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SoapController {
    private final SoapClient soapClient;

    public SoapController(SoapClient soapClient) {
        this.soapClient = soapClient;
    }

    @GetMapping("/test-soap")
    public Object testSoap(@RequestParam String requestData) {
        return soapClient.sendRequest("http://www.dneonline.com/calculator.asmx", requestData);
    }
}
