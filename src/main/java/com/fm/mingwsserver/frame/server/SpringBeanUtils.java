package com.fm.mingwsserver.frame.server;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class SpringBeanUtils {

	@Autowired
	private static ApplicationContext context;
	
	public static <T> T getObject(Class<T> clazz) {
		return context.getBean(clazz);
	}
	
}
