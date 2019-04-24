/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.example.netty.game;

import java.util.Random;
import java.util.Scanner;
import javax.swing.JFrame;

/**
 *
 * @author alpalpalapalallapala
 */
public class GameScreen extends JFrame {

    


    public  GameScreen(int width, int height ){
        super.setTitle("GameScreen");
        super.setSize(width,height);
        super.setLocation(100,100);
        super.setResizable(false);
        super.add(new Contents());
        super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        super.setVisible(true);
        
    }
 
    
    public static void main (String[] args){
        GameCommands gs = new GameCommands();
        
        Scanner x = new Scanner(System.in);
        System.out.println("Enter width then height of gamescreen: ");
        int width = x.nextInt();
        int height = x.nextInt();
        new GameScreen(width,height);
    }
   
}
