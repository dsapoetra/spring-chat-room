package edu.udacity.java.nano.chat;

import com.alibaba.fastjson.JSON;
import edu.udacity.java.nano.model.Message;
import org.springframework.stereotype.Component;

import javax.websocket.*;
import javax.websocket.server.ServerEndpoint;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * WebSocket Server
 *
 * @see ServerEndpoint WebSocket Client
 * @see Session   WebSocket Session
 */

@Component
@ServerEndpoint("/chat/")
public class WebSocketChatServer {

    /**
     * All chat sessions.
     */
    private static Map<String, Session> onlineSessions = new ConcurrentHashMap<>();

        private static void sendMessageToAll(String msg) {
        //TODO: add send message method.
        onlineSessions.forEach((id, session) -> {
            try{
                session.getBasicRemote().sendText(msg);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    /**
     * Open connection, 1) add session, 2) add user.
     */
    @OnOpen
    public void onOpen(Session session) {
        //TODO: add on open connection.
        onlineSessions.put(session.getId(), session);
        sendMessageToAll(JSON.toJSONString(new Message("ENTER", "", "ENTER", Integer.toString(onlineSessions.size()))));
    }

    /**
     * Send message, 1) get username and session, 2) send message to all.
     */
    @OnMessage
    public void onMessage(Session session, String jsonStr) {
        //TODO: add send message.
        Message message = JSON.parseObject(jsonStr, Message.class);
        sendMessageToAll(JSON.toJSONString(new Message(message.getMessage(), message.getUsername(), "SPEAK", Integer.toString(onlineSessions.size()))));
    }

    /**
     * Close connection, 1) remove session, 2) update user.
     */
    @OnClose
    public void onClose(Session session) {
        //TODO: add close connection.
        onlineSessions.remove(session.getId());
        sendMessageToAll(JSON.toJSONString(new Message("LEAVE", "", "LEAVE", Integer.toString(onlineSessions.size()))));
    }

    /**
     * Print exception.
     */
    @OnError
    public void onError(Session session, Throwable error) {
        error.printStackTrace();
    }

}
