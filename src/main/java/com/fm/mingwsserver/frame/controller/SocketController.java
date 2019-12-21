package com.fm.mingwsserver.frame.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fm.mingwsserver.frame.server.ServerExcutor;

@RestController
public class SocketController {

	@Autowired
	ServerExcutor serverExcutor;
	
    /**
                  * 给指定用户推送消息
     * @param userName 用户名
     * @param message 消息
     * @throws IOException
     */
    @RequestMapping(value = "/socket", method = RequestMethod.GET)
    public void sendClientMsg(@RequestParam String bussinessId,@RequestParam String clientId, @RequestParam String message){
    	serverExcutor.sendInfo(bussinessId,clientId, message);
    }
    
    /**
                  * 给所有用户推送消息
     * @param message 消息
     * @throws IOException
     */
    @RequestMapping(value = "/socket/all", method = RequestMethod.GET)
    public void testSocket2(@RequestParam String message){
//        try {
//            //webSocketServer.onMessage(message);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
    }
    
}
