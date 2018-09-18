package com.voicecyber.handler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import java.io.IOException;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/**
 * Created by Sean on 2018/7/26
 *
 * @author Sean
 */
public class TestWebSocketHandler extends TextWebSocketHandler {
    private Thread thread;
    private volatile boolean flag = true;
    private static ConcurrentMap<String, WebSocketSession> concurrentMap = new ConcurrentHashMap<>();
    private static final Logger LOGGER = LoggerFactory.getLogger(TextWebSocketHandler.class);

    /**
     * 连接成功时触发
     *
     * @param session
     * @throws Exception
     */
    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        //这里的map 的 key  在实际开发中 可以使用userName
        concurrentMap.put(session.getId(), session);
        LOGGER.info("client connect web socket success current num is " + concurrentMap.size());
        session.sendMessage(new TextMessage("hello this is server"));

//        thread = new Thread(() -> {
//            while (flag) {
//                try {
//                    session.sendMessage(new TextMessage("hello this is server"));
//                    Thread.sleep(1000*2);
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }
//        });
//        thread.start();

    }

    /**
     * 关闭连接时触发
     *
     * @param session
     * @param status
     * @throws Exception
     */
    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
        LOGGER.info("client close web socket ");
        flag = false;
        concurrentMap.remove(session.getId());
        LOGGER.info("current release user num is" + concurrentMap.size());
    }

    /**
     * 前端调用webSocket.send 时，调用该方法
     *
     * @param session
     * @param message
     * @throws Exception
     */
    @Override
    public void handleMessage(WebSocketSession session, WebSocketMessage<?> message) throws Exception {
        LOGGER.info("get client message " + message.toString() + session.getId());
        session.sendMessage(new TextMessage("server get Client Msg  " +  message.toString()));
    }

    /**
     * 异常时调用该方法
     *
     * @param session
     * @param exception
     * @throws Exception
     */
    @Override
    public void handleTransportError(WebSocketSession session, Throwable exception) throws Exception {
        LOGGER.error(session.getId() + "happen error" + exception.getMessage());
    }
}
