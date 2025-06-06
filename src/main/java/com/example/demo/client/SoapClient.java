package com.example.demo.client;

import com.example.demo.wsdlUPN.Add;
import com.example.demo.wsdlUPN.AddResponse;
import org.springframework.stereotype.Service;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;

@Service
public class SoapClient extends WebServiceGatewaySupport {
//* ruta del servicio soap que vamos a usar de ejemplo: http://www.dneonline.com/calculator.asmx
//* ruta del wsdl de ejemplo para esta prueba: http://www.dneonline.com/calculator.asmx?WSDL
//* Ruta el repo del video https://github.com/UnProgramadorNaceOfficial/spring-boot-soap-maven/blob/main/src/main/java/com/soap/SpringBootSoapApplication.java

    public AddResponse suma(int numberA, int numberB){
        Add addRequest = new Add();
        addRequest.setIntA(numberA);
        addRequest.setIntB(numberB);

        // el param de SoapActionCallback sale del campo del soapAction del wsdl
        SoapActionCallback soapActionCallback = new SoapActionCallback("http://tempuri.org/Add");

        //param 1 requestCallback dirección de donde vamos a consumir el servicio,  la sacamos del campo location del wsdl
        //param 2 el petición/request que queremos hacer
        //param 3 el métod que va a utilizar
        AddResponse addResponse = (AddResponse) getWebServiceTemplate().marshalSendAndReceive("http://www.dneonline.com/calculator.asmx",
               addRequest,  soapActionCallback);

        return addResponse; //se podría devolver directamente el AddResponse sin declararlo, pero es para que se entienda mejor.
    }
}
