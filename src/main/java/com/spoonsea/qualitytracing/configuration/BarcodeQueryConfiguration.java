package com.spoonsea.qualitytracing.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.ws.client.core.WebServiceTemplate;

@Configuration
public class BarcodeQueryConfiguration {

	@Value("${barcode-query.default-uri}")
	private String defaultUri;

	@Bean
	public Jaxb2Marshaller marshaller() {
		Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
		// this package must match the package in the <generatePackage> specified in
		// pom.xml
		marshaller.setContextPath("org.tempuri");
		return marshaller;
	}

	@Bean
	public WebServiceTemplate webServiceTemplate() {
	    WebServiceTemplate webServiceTemplate = new WebServiceTemplate();
	    webServiceTemplate.setMarshaller(marshaller());
	    webServiceTemplate.setUnmarshaller(marshaller());
	    webServiceTemplate.setDefaultUri(defaultUri);
	    return webServiceTemplate;
	}

}