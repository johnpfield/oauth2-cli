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

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.security.oauth2.client.token.grant.client.ClientCredentialsAccessTokenProvider;
import org.springframework.security.oauth2.client.token.grant.client.ClientCredentialsResourceDetails;
import org.springframework.security.oauth2.common.OAuth2AccessToken;

/**
 *  
 * @Author jfield@pivotal.io
 */

@Configuration
public class ConfigDingusResources {
	
	@Bean
	public Dingus ConfigDingus(ClientCredentialsResourceDetails resource, 
								ClientCredentialsAccessTokenProvider provider, 
								OAuth2AccessToken accessToken, 
								OAuth2RestTemplate template) {
		
		Dingus dingus = new Dingus();
		dingus.resource = resource;
		dingus.provider = provider;
		dingus.accessToken = accessToken;
		dingus.template = template;
		return dingus;
	}
	

}
