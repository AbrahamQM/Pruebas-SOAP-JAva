package com.example.demo.service;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.ws.client.core.WebServiceTemplate;
import org.springframework.ws.soap.client.core.SoapActionCallback;
import org.springframework.stereotype.Service;

@Service
public class SoapClient {
    private final WebServiceTemplate webServiceTemplate;

    public SoapClient() {
        this.webServiceTemplate = new WebServiceTemplate();
        Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
        marshaller.setContextPath("com.example.soap.client"); // Ajusta el paquete generado por wsimport
        webServiceTemplate.setMarshaller(marshaller);
        webServiceTemplate.setUnmarshaller(marshaller);
    }

    public Object sendRequest(String url, Object requestPayload) {
        return webServiceTemplate.marshalSendAndReceive(url, requestPayload, new SoapActionCallback("SOAP_ACTION"));
    }
}
