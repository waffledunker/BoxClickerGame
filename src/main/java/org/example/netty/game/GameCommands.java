/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.example.netty.game;

import io.netty.channel.Channel;

/**
 *
 * @author alpalpalapalallapala
 */
public class GameCommands  {
    
    
    
    public GameCommands(){
           
        
    }
    
   public String parseMessage(String s ){  // parse messages and do things.
       
       String delims = "[[]]+"; // regex
       String [] tokens = s.split(delims);
       String command = " ";
       
       
       for (int i = 0; i < tokens.length; i++){
           
           switch(tokens[i]){
           case "START-GAME":
               command = tokens[i];
               break;
           case "END-GAME" :
               command = tokens[i];
               break;
           case "POINTS":
               command = tokens[i];
               break;
           default:
               command = " ";
               break;
       }
           
       }
       
       return command;
       
   }
    
    
    
}
