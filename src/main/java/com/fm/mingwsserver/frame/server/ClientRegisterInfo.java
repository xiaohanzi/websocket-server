package com.fm.mingwsserver.frame.server;

import java.io.Serializable;

public class ClientRegisterInfo implements Serializable{

	private static final long serialVersionUID = -8366172526582887567L;

	private String clientId;
	private String serverIp;
	private String serverPort;
	public String getClientId() {
		return clientId;
	}
	public void setClientId(String clientId) {
		this.clientId = clientId;
	}
	public String getServerIp() {
		return serverIp;
	}
	public void setServerIp(String serverIp) {
		this.serverIp = serverIp;
	}
	public String getServerPort() {
		return serverPort;
	}
	public void setServerPort(String serverPort) {
		this.serverPort = serverPort;
	}
}
