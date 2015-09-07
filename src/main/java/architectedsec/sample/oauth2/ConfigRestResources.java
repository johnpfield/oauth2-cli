/*
 * Copyright 2012-2015 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package architectedsec.sample.oauth2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.hateoas.hal.Jackson2HalModule;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.security.oauth2.client.DefaultOAuth2ClientContext;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.security.oauth2.client.token.DefaultAccessTokenRequest;
import org.springframework.security.oauth2.client.token.grant.client.ClientCredentialsAccessTokenProvider;
import org.springframework.security.oauth2.client.token.grant.client.ClientCredentialsResourceDetails;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 *  
 * @Author jfield@pivotal.io
 */

// Cf:  http://stackoverflow.com/questions/23264044/spring-data-rest-disable-hypertext-application-language-hal-in-json-applica
// Cf:  http://stackoverflow.com/questions/23239052/why-does-resttemplate-not-bind-response-representation-to-pagedresources

@Configuration
public class ConfigRestResources {

	@Bean
	public ObjectMapper ConfigObjectMapper() { 
		
	    ObjectMapper mapper = new ObjectMapper();
	    mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
	    mapper.registerModule(new Jackson2HalModule());
	    return mapper;
	}
	
	@Bean
	public MappingJackson2HttpMessageConverter ConfigConverter(ObjectMapper mapper) {
		
    MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();
    converter.setSupportedMediaTypes(MediaType.parseMediaTypes("application/hal+json"));
    converter.setObjectMapper(mapper);
	
    return converter;
	
	}
	
	@Bean
	public List<HttpMessageConverter<?>> ConfigConverterList (MappingJackson2HttpMessageConverter aConverter) {
		
		List<HttpMessageConverter<?>> converters = new ArrayList<HttpMessageConverter<?>>();
		converters.add(aConverter);
		return converters;

	}

	
	@Bean
	public ClientCredentialsResourceDetails ConfigClientCredentialsResourceDetails() {
		
		ClientCredentialsResourceDetails resource = new ClientCredentialsResourceDetails();
		resource.setAccessTokenUri("http://localhost:8080/uaa/oauth/token");
		resource.setClientId("fortressdemo2");
		resource.setClientSecret("hard2guess!");
		resource.setId("fortressdemo2");
		resource.setGrantType("client_credentials");
		resource.setScope(Arrays.asList("fortressdemo2.read", "fortressdemo2.write"));

		return resource;
		
	};


	@Bean 
	public ClientCredentialsAccessTokenProvider ConfigClientCredentialsAccessTokenProvider() {
		
		ClientCredentialsAccessTokenProvider provider = new ClientCredentialsAccessTokenProvider();
		return provider;
		
	};
	
	@Bean
	public OAuth2AccessToken ConfigOAuth2AccessToken(ClientCredentialsAccessTokenProvider provider, ClientCredentialsResourceDetails resource) {

		OAuth2AccessToken accessToken = provider.obtainAccessToken(resource, new DefaultAccessTokenRequest());
		return accessToken;
	}
	
	@Bean 
	public RestTemplate ConfigRestTemplate(List<HttpMessageConverter<?>> messageConverters) {
		
		RestTemplate template = new RestTemplate(messageConverters);
		return template;
	}

	@Bean
	public OAuth2RestTemplate ConfigOAuth2RestTemplate(ClientCredentialsResourceDetails resource, OAuth2AccessToken accessToken, List<HttpMessageConverter<?>> messageConverters) {

		OAuth2RestTemplate template = new OAuth2RestTemplate(resource, new DefaultOAuth2ClientContext(accessToken));
		template.setMessageConverters(messageConverters);
		return template;
	}
	

}
