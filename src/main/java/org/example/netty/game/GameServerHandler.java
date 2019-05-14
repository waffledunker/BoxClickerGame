/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.example.netty.game;

import io.netty.channel.Channel;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundMessageHandlerAdapter;
import io.netty.channel.group.ChannelGroup;
import io.netty.channel.group.DefaultChannelGroup;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author alpalpalapalallapala
 */
public class GameServerHandler extends ChannelInboundMessageHandlerAdapter<String> implements ActionListener  {

    private static final ChannelGroup channels = new DefaultChannelGroup();
    
   
    public GameServerHandler(MainScreen obj){
     this.x = obj;   
    }
    
    MainScreen x = MainScreen.getInstance();
    String message = x.message;
    String nickname = x.nickname;
    
    @Override 
    public void handlerAdded(ChannelHandlerContext ctx) throws Exception {
        Channel incoming = ctx.channel();
         System.out.println("Client : " + incoming.remoteAddress() + " has connected!"+ "\n" );
         x.txtarea.append("Client : " + incoming.remoteAddress() + " has connected!"+ "\n");
             
         
        for (Channel channel : channels){
            
            channel.write("[Server] : " + incoming.remoteAddress() + " has joined! \n");
            x.txtarea.append("[Server] : " + incoming.remoteAddress() + " has joined! \n");
             
        }
        channels.add(ctx.channel());
    }
    
    @Override
    public void handlerRemoved (ChannelHandlerContext ctx) throws Exception {
        
        Channel incoming = ctx.channel();
        for (Channel channel : channels){
            channel.write("[Server] : " + incoming.remoteAddress() + " has left! \n");
            x.txtarea.append("[Server] : " + incoming.remoteAddress() + " has left! \n");
             
        }
        channels.remove(ctx.channel());
    }
    
    
    
    @Override
    public void messageReceived(ChannelHandlerContext arg0, String message) throws Exception{
        Channel incoming = arg0.channel();
        
        GameCommands gs = GameCommands.getInstance();
        gs.parseMessage(message);  // parse message coming from clients
        
        for (Channel channel : channels){  // server - client communication
            
                
            
                if(channel != incoming){
                        x.txtarea.append("[ " + incoming.remoteAddress() + "]:" + "["+ message +"]"+ "\n");
                        channel.write("[ " + incoming.remoteAddress() + "]:" + "["+ message +"]"+ "\n" );  // print message to client screen except sender's
                        System.out.println("[" + incoming.remoteAddress() + "]:" + "["+ message +"]"+ "\n" );
                }
                
            
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (x.message != null && x.btnsend.isSelected()){
            System.out.println("btnsend clicked");
            message = x.message;
        }
        if(x.btnpickname.isSelected() && x.nickname != null){
            System.out.println("btnpickname clicked");
            nickname = x.nickname;
        }
    }
    
}
