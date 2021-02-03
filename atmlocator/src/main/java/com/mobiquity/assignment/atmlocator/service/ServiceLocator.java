package com.mobiquity.assignment.atmlocator.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mobiquity.assignment.atmlocator.beans.AtmDetails;

import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.ssl.TrustStrategy;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import java.security.cert.CertificateException;
import javax.net.ssl.SSLContext;

/**
 * 
 * @author cnu4u
 *
 */

@Service
public class ServiceLocator {
	
	  	//@Autowired
	    //private DataPopulator dataPopulator;  	
	   
	    /**
	     * Service call for ATMList
	     * @return The method  should return a well formed JSON response
	     * @throws Exception
	     */
	    @Autowired
	    public List<AtmDetails> getATMListfromService() throws Exception {
	        return getDataFromService();
	    }

	    /**
	     * Service to filter the atms by city
	     * @return The method  should returns list of locations as a well formed JSON response
	     * @throws Exception
	     */
	    public List<AtmDetails> getLocationsByCity(String city) throws Exception {

	        List<AtmDetails> locations = new ArrayList<>();
	        List<AtmDetails> atmLocationsfromING = getATMListfromService();
	        for (AtmDetails location : atmLocationsfromING) {
	            if (city.equalsIgnoreCase(location.getAddress().getCity())) {
	                locations.add(location);
	            }
	        }
	        return locations;
	    }
	    
	    /**
	     * invoke an external service to gather a list of atms
	     */
	    @Autowired
		 private RestTemplate restTemplate = null;
		 public List<AtmDetails> getDataFromService() throws Exception {
		        String response = restTemplate.getForObject("https://www.ing.nl/api/locator/atms/", String.class);
		    	String parseThisString = response.substring(6, response.length());
		        ObjectMapper objectMapper = new ObjectMapper();
		        AtmDetails[] locations = objectMapper.readValue(parseThisString, AtmDetails[].class);	    
		        return Arrays.asList(locations);
		    }
		 
		 /**
		  * Expose API over underlying HTTP client libraries  
		  * @return
		  * @throws Exception
		  */
		 @Bean
		    public RestTemplate getRestTemplate() throws Exception {
		        TrustStrategy acceptingTrustStrategy;
		        acceptingTrustStrategy = new TrustStrategy() {
		            @Override
		            public boolean isTrusted(java.security.cert.X509Certificate[] chain, String authType) throws CertificateException {
		                return true;
		            }
		        };

		        SSLContext sslContext = org.apache.http.ssl.SSLContexts.custom()
		                .loadTrustMaterial(null, acceptingTrustStrategy)
		                .build();

		        SSLConnectionSocketFactory csf = new SSLConnectionSocketFactory(sslContext);
		        //httpClient
		        CloseableHttpClient httpClient = HttpClients.custom()
		                .setSSLSocketFactory(csf)
		                .build();

		        HttpComponentsClientHttpRequestFactory requestFactory =
		                new HttpComponentsClientHttpRequestFactory();

		        requestFactory.setHttpClient(httpClient);

		        RestTemplate restTemplate = new RestTemplate(requestFactory);

		        return restTemplate;
		    }
}
