/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.example.netty.game;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.Random;
import javax.swing.JPanel;

/**
 *
 * @author alpalpalapalallapala
 */
public  class Contents extends  JPanel{
    
    public Contents (){
        super.setDoubleBuffered(true);
        
    }
      public  int getRandomNumber(){  // random number generator via time
        Random rand = new Random(System.currentTimeMillis()*735);
        int x = rand.nextInt(500);
        return x;
    }
      
      
      public int initializeValue(int value){
          value = getRandomNumber();
          return value;
      }
      
      
      public Color randColor(int x){
          x = x % 4;
          Color red = Color.RED;
          Color blue = Color.BLUE;
          Color green = Color.GREEN;
          Color yellow = Color.YELLOW;
          
          switch (x){
              case 0:
                  return red;
                 
              case 1:
                  return blue;
                  
              case 2:
                  return green;
                  
              case 3:
                  return yellow;
                  
              default:
                  return Color.CYAN;
                  
          }
      }
      
      public void randShape(int x, Graphics g){
          x = x % 2;
          int y = getRandomNumber();
         Graphics2D g2d = (Graphics2D) g;
         

          switch(x){
              case 0:
                  g2d.fillRect(initializeValue(y),initializeValue(y),initializeValue(y),initializeValue(y));
                  
              case 1:
                  g2d.fillOval(initializeValue(y),initializeValue(y),initializeValue(y),initializeValue(y));
                  
              default:
                  break;
                  
          }
      }
    
    @Override
    public void paintComponent(Graphics g){
        
        Graphics2D g2d =  (Graphics2D) g;
        int i = 0;
        
        int randC = getRandomNumber(); // randomColorGenerator
       Color rrandC = randColor(randC);
         g2d.setColor(rrandC);
        
         while(i < 50){
         randShape(getRandomNumber(),g);
         i++;
    }
         
        
        
        
    }

   
}
