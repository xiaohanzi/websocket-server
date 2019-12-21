package com.fm.mingwsserver.bussiness;

import com.fm.mingwsserver.bussiness.atmuai.AtmuaiCameraWsServer;
import com.fm.mingwsserver.frame.server.AbsWebSocketServer;

public enum ClientInfoEnum {

	ATMUAICAMERA("1","格林深瞳-摄像头推送用户信息业务",AtmuaiCameraWsServer.class);
	
	ClientInfoEnum(String bussinessId,String name,Class clazz) {
		this.bussinessId = bussinessId;
		this.name = name;
		this.clazz = clazz;
	}
	
	private String bussinessId;
	private String name;
	private Class<AbsWebSocketServer> clazz;
	public String getBussinessId() {
		return bussinessId;
	}
	public void setBussinessId(String bussinessId) {
		this.bussinessId = bussinessId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Class<AbsWebSocketServer> getClazz() {
		return clazz;
	}
	public void setClazz(Class<AbsWebSocketServer> clazz) {
		this.clazz = clazz;
	}
	
	public static Class<AbsWebSocketServer> getServerClass(String type) {
		for (ClientInfoEnum c:ClientInfoEnum.values()) {
			if (c.getBussinessId().equals(type)) {
				return c.getClazz();
			}
		}
		return null;
	}
}
