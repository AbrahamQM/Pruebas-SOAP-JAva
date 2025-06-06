package com.example.demo.config;

import com.example.demo.client.SoapClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

//*clase de configuración que devuelve un marshaller
/*
* Explicación marshaller:
* componente que convierte objetos en una representación que puede ser almacenada o transmitida, como XML o JSON.
* En el contexto de JAXB (Java Architecture for XML Binding), un marshaller se usa para convertir objetos Java en XML.
*
* */

@Configuration
public class SoapConfig {

    //El marshaller se encarga de convertir en los dos sentidos Java y XML
    @Bean
    public Jaxb2Marshaller marshaller(){
        Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
        //seteamos el contexto añadiendo EXACTAMENTE el mismo paquete que pusimos en nuestro pom->plugin->generatePackage
        marshaller.setContextPath("com.example.wsdlUPN");
        return marshaller;
    }

    // Configuramos el cliente Soap
    @Bean
    public SoapClient getSoapClient(Jaxb2Marshaller marshaller){
        SoapClient soapClient = new SoapClient();
        soapClient.setDefaultUri("http://www.dneonline.com/calculator.asmx"); //dirección de donde vamos a consumir el servicio,  la sacamos del campo location del wsdl
        //*Serializa convierte de Java a XML
        soapClient.setMarshaller(marshaller);
        //*Convierte de XML a Java
        soapClient.setUnmarshaller(marshaller);

        return soapClient;
    }

}
