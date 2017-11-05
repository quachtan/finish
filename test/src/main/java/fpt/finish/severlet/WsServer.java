package fpt.finish.severlet;

import java.io.IOException;
import java.io.StringWriter;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonWriter;
import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

import javafx.animation.Interpolator;

@ServerEndpoint("/websocketendpoint")
public class WsServer {
	static Set<Session> chat = Collections.synchronizedSet(new HashSet<Session>());
	
	@OnOpen
	public void onOpen(Session userSession){
		chat.add(userSession);
		System.out.println("Open Connection ...");
	}
	
	@OnClose
	public void onClose(Session userSession){
		chat.remove(userSession);
		System.out.println("Close Connection ...");
	}
	
	@OnMessage
	public void onMessage(String message,Session userSession) throws IOException{
		/*String username=(String) userSession.getUserProperties().get("username");*/
		/*if(username == null){
			userSession.getUserProperties().put("username", message);
			userSession.getBasicRemote().sendText(buildJsonData("System","you are now connected as "+message));
		}
		else{*/
			Iterator<Session> iterator=chat.iterator();
			while (iterator.hasNext()) iterator.next().getBasicRemote().sendText(buildJsonData(message));
		}
	

	
	
	private String buildJsonData(String message){
		JsonObject jsonObject = Json.createObjectBuilder().add("message",""+message).build();
		StringWriter stringWriter=new StringWriter();
		
		try(JsonWriter jsonwriter = Json.createWriter(stringWriter))
		{
			jsonwriter.write(jsonObject);
			
		}
		return stringWriter.toString();
	}
}
