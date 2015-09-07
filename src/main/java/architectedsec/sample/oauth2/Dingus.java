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

import java.util.Iterator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.Links;
import org.springframework.hateoas.PagedResources;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.security.oauth2.client.token.grant.client.ClientCredentialsAccessTokenProvider;
import org.springframework.security.oauth2.client.token.grant.client.ClientCredentialsResourceDetails;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.stereotype.Component;

import architectedsec.sample.oauth2.Order;

/**
 *  
 * @author jfield@pivotal.io
 */

/**
 * 
 * With apologies to Dr. Seuss.
 *
 */
@Component
public class Dingus {
	
	@Autowired
	ClientCredentialsResourceDetails resource;
	
	@Autowired
	ClientCredentialsAccessTokenProvider provider;
	
	@Autowired
	OAuth2AccessToken accessToken;
	
	@Autowired
	OAuth2RestTemplate template;
	
	
	public Dingus() {
		// do nothing
	}
	
	public void doFetch() {
	   	
	System.out.println("MAKING THE OAUTH2 REST REQUEST\n");
	
	ParameterizedTypeReference<PagedResources<Order>> responseType = new ParameterizedTypeReference<PagedResources<Order>>() {};	
	ResponseEntity<PagedResources<Order>> result = template.exchange("http://localhost:8181/orders/search/findByCustomerName?name=123", HttpMethod.GET, null, responseType);	
	 
	System.out.println("HTTP STATUS CODE=" + result.getStatusCode().toString() + "\n");
	System.out.println("RESPONSE DATA SIZE=" + result.getBody().getContent().size() + "\n");
		
	Iterator<Order> itr = 	result.getBody().getContent().iterator();

	 while(itr.hasNext()) {

		 Order element = itr.next();
		 
        // Note that exposing the id property of the record is not supported by default.
		// This makes sense since it could be a security vulnerability.  However, you can expose if needed...
        // Cf. http://stackoverflow.com/questions/24936636/while-using-spring-data-rest-after-migrating-an-app-to-spring-boot-i-have-obser
        // N.B. The additional comment about the difference in configuration when using Spring-Boot.
        
        // System.out.println("Id=" + element.getId());
		
        System.out.println("Order-No=" + element.getOrderNumber());
		System.out.println("Order-Date=" + element.getOrderDate().toString());
        System.out.println("Customer=" + element.getCustomerName());
        System.out.println("Description=" + element.getDescription());
        System.out.println("Attr_j=" + element.getAttrJ());
        System.out.println("Attr_k=" + element.getAttrK());
        System.out.println("Attr_l=" + element.getAttrL() + "\n");
        
     }	 
	 
	System.out.println("DONE MAKING THE REST REQUEST\n");
 	
	return;
			
	}
	
}