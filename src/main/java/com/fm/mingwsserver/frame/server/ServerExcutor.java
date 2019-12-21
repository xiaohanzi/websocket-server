package com.fm.mingwsserver.frame.server;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import com.fm.mingwsserver.bussiness.ClientInfoEnum;
import com.fm.mingwsserver.frame.exception.WebsocketException;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class ServerExcutor {

	@Autowired
    private ApplicationContext context;
	
	public void sendInfo(String bussinessId,String clientId,String msg) {
		ClientRegister clientRegister = ClientRegister.getInstance();
		//从redis里面取出clientId在哪台服务器上，如果是本机，则执行webSocketServer，如果是别的服务器，则用http调用该服务器的请求
		ClientRegisterInfo clientInfo = clientRegister.getClientInfo(clientId);
		if ( null == clientInfo) {
			throw new WebsocketException("clientId "+clientId+" has no client in clientRegister.");
		}
		boolean isNative = clientRegister.isNativeServer(clientInfo);
		Class<AbsWebSocketServer> clazz = ClientInfoEnum.getServerClass(bussinessId);
		if (null == clazz) {
			throw new WebsocketException("bussinessId "+bussinessId+" no config in ClientInfoEnum.");
		}
		AbsWebSocketServer server=context.getBean(clazz);
		if (null == server ) {
			throw new WebsocketException("bussinessId "+bussinessId+" no serverbean in spring.");
		}
		if (isNative) {
			server.sendInfo(clientId, msg);
		}else {
			
		}
		
	}
}
