package com.fm.mingwsserver.frame.server;

import java.util.HashMap;
import java.util.Map;

import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

public class ClientRegister {

	private ClientRegister() {
		
	}
	
	private static ClientRegister INSTANCE = new ClientRegister();
	private ApplicationContext applicationContext;
	
	public void setApplicationContext(ApplicationContext applicationContext) {
		this.applicationContext = applicationContext;
	}
	public static ClientRegister getInstance() {
		return INSTANCE;
	}
	
	//TODO 替换成redis
	private Map<String,ClientRegisterInfo> redisClientMap = new HashMap<String,ClientRegisterInfo>();
	
	
	public void deleteClient(String clientId) {
		redisClientMap.remove(clientId);
	}
	
	public void registerClient(String clientId) {
		//TODO 存储到redis里面
		ClientRegisterInfo client = new ClientRegisterInfo();
		client.setClientId(clientId);
		client.setServerIp(getLocalIp());
		client.setServerPort(getLocalPort());
		redisClientMap.put(clientId, client);
	}
	
	public ClientRegisterInfo getClientInfo(String clientId) {
		return redisClientMap.get(clientId);
	}
	
	public boolean isNativeServer(ClientRegisterInfo info) {
		String localIp = getLocalIp();
		if (info.getServerIp().equals(localIp)) {
			return true;
		}
		return false;
	}
	
	private String getLocalIp() {
		return "0.0.0.0";
	}
	
	private String getLocalPort() {
		return "8080";
	}
}
