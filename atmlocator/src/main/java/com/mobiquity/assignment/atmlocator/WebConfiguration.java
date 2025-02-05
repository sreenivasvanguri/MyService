package com.mobiquity.assignment.atmlocator;

import org.springframework.boot.autoconfigure.jackson.Jackson2ObjectMapperBuilderCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;

@Configuration
public class WebConfiguration implements WebMvcConfigurer {

    /**
     * VIEW Configuration : LIST OF ATM LOCATIONS
     */
	public void addViewControllers(ViewControllerRegistry registry) {
    	 registry.addRedirectViewController("/", "locations"); 
    }
    

   /**
    * JSON Object Formatting 
    * @return
    */
    
  public ObjectMapper configureJson() {
      return new Jackson2ObjectMapperBuilder()
              .indentOutput(true)
              .propertyNamingStrategy(PropertyNamingStrategy.UPPER_CAMEL_CASE)
              .build();
  }

  @Bean
  public Jackson2ObjectMapperBuilderCustomizer customizeJson()
  {
      return builder -> {

          builder.indentOutput(true);
          builder.propertyNamingStrategy(PropertyNamingStrategy.UPPER_CAMEL_CASE);
      };
  }

}
