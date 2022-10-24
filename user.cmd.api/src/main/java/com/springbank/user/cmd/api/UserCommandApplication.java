package com.springbank.user.cmd.api;

import com.netflix.discovery.EurekaClient;
import com.springbank.user.core.configuration.AxonConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;

@EnableResourceServer
@EnableGlobalMethodSecurity(prePostEnabled = true)
@EnableDiscoveryClient
@SpringBootApplication
@Import({ AxonConfig.class })
public class UserCommandApplication {


	public static void main(String[] args) {
		SpringApplication.run(UserCommandApplication.class, args);
	}

}
