package com.example.fz_user.socket;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.stereotype.Component;

import javax.websocket.*;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.concurrent.ConcurrentHashMap;

@Component
@ServerEndpoint("/im/{userId}")
public class UserWebSocketServer {
    public static int totalOnlineCount;
    public static ConcurrentHashMap<String,UserWebSocketServer> sockets=new ConcurrentHashMap();
    private Session session;
    private String userId;


    @OnOpen
    public void onOpen(Session session, @PathParam("userId") String userId){
        this.session=session;
        this.userId=userId;
        String msg="欢迎用户"+userId+"进入";
        changeOnlineCount(true);
        log(msg);
        if(!sockets.contains(userId)){
            sockets.put(userId,this);
        }
        sendMessage(msg);
    }

    @OnMessage
    public void onMessage(String message,Session session){
        try {
            JSONObject object=new JSONObject(message);
            String toUserId=object.optString("toUserId");
            String msg=object.optString("contentText");
            if(sockets.containsKey(toUserId)){
                msg=userId+":"+msg;
                sockets.get(toUserId).sendMessage(msg);
                sendMessage(msg);
            }else{
                sendMessage("目标用户不存在");
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    @OnClose
    public void onClose(){
        log("用户"+userId+"退出");
        changeOnlineCount(false);
        if(sockets.contains(userId)){
            sockets.remove(userId);
        }
    }
    @OnError
    public void onError(Session session, Throwable error){
        log("连接出错");
        error.printStackTrace();
    }


    private void changeOnlineCount(boolean enter) {
        if(enter){
            totalOnlineCount+=1;
        }else{
            if(totalOnlineCount>0){
                totalOnlineCount-=1;
            }
        }
        log("当前在线人数："+totalOnlineCount);
    }

    private void sendMessage(String message){
        try {
            this.session.getBasicRemote().sendText(message);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void log(String msg){
        System.out.println(msg);
    }




}
