package com.sessionlistener;

import com.utils.ApplicationContextUtil;
import com.websocket.WebSocket;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Component
public class SessionListener implements HttpSessionListener {

    Map map =new HashMap<>();
    @Override
    public void sessionCreated(HttpSessionEvent httpSessionEvent) {
        System.out.println("session创建");
        map.put(httpSessionEvent.getSession().getId(),httpSessionEvent.getSession());
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent httpSessionEvent) {
        System.out.println(httpSessionEvent.getSession().getId());
        System.out.println("seession销毁了");
        try {
            new WebSocket().sendMessageTo("Session到期了","王帆");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
