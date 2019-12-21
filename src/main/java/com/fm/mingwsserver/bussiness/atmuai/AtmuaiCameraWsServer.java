package com.fm.mingwsserver.bussiness.atmuai;

import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

import org.springframework.stereotype.Component;

import com.fm.mingwsserver.frame.server.AbsWebSocketServer;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
@ServerEndpoint(value = "/socket/atmuai/camera/{clientId}")
public class AtmuaiCameraWsServer extends AbsWebSocketServer{

	
	@Override
	protected void connectOpen(Session session, String clientId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void receiveClientMessage(Session session,String msg,  String clientId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void connectClose(String clientId) {
		// TODO Auto-generated method stub
		
	}

}
