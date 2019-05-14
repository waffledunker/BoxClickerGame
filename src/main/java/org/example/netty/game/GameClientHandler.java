/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.example.netty.game;

import io.netty.channel.ChannelInboundMessageHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;
/**
 *
 * @author alpalpalapalallapala
 */

public class GameClientHandler extends ChannelInboundMessageHandlerAdapter<String> {
    
    MainScreen y;
    
    public GameClientHandler(MainScreen y){
        this.y = y;
    }

    @Override
    public void messageReceived(ChannelHandlerContext arg0, String arg1) throws Exception{  
        
        y.txtarea.append(arg1 + "\n");
        System.out.println(arg1 + "\n");  // incoming message print to screen
    }
    
}
