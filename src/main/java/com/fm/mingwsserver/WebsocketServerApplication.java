package com.fm.mingwsserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.fm.mingwsserver.frame.server.ClientRegister;

@SpringBootApplication
public class WebsocketServerApplication {

	public static void main(String[] args) {
		SpringApplication springApplication = new SpringApplication(WebsocketServerApplication.class);
		ConfigurableApplicationContext configurableApplicationContext = springApplication.run(args);
	    //解决WebSocket不能注入的问题
		ClientRegister.getInstance().setApplicationContext(configurableApplicationContext);
	}
}
