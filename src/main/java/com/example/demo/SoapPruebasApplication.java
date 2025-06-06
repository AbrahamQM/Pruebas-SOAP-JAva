package com.example.demo;

import com.example.demo.client.SoapClient;
import com.example.demo.wsdlUPN.AddResponse;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@SpringBootApplication
@ComponentScan(basePackages = "com.example.demo.client")
public class SoapPruebasApplication {

	private static final Logger LOGGER = LoggerFactory.getLogger(SoapPruebasApplication.class);


	public static void main(String[] args) {

		ApplicationContext context = SpringApplication.run(SoapPruebasApplication.class, args);
		SoapClient soapClient = context.getBean(SoapClient.class);

		AddResponse addResponse = soapClient.suma(5, 2);

		LOGGER.info("El resultado de la suma de los numeros {} y {} es: {}", 5, 2, addResponse.getAddResult());

	}

}
