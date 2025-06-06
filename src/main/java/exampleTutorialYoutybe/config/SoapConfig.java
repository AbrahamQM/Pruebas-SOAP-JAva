package exampleTutorialYoutybe.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

//*clase de configuración que devuelve un marshaller
/* Explicación marshaller:
* componente que convierte objetos en una representación que puede ser almacenada o transmitida, como XML o JSON.
* En el contexto de JAXB (Java Architecture for XML Binding), un marshaller se usa para convertir objetos Java en XML.
* */

@Configuration
public class SoapConfig {

    @Bean
    public Jaxb2Marshaller marshaller(){
        Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
        //seteamos el contexto añadiendo EXACTAMENTE el mismo paquete que pusimos en nuestro pom->plugin->generatePackage
         marshaller.setContextPath("com.example.wsdlUPN");
         return marshaller;
    }

}
