/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.example.netty.game;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;

/**
 *
 * @author alpalpalapalallapala
 */
public class GameScreen extends JFrame implements ActionListener {

        JFrame jf = new JFrame();
        

    GameScreen(int width, int height, Contents x){
       

        jf.setTitle("Game");
        jf.setSize(width,height);
        jf.setLocation(500,250);
        jf.setResizable(false);
        //adding contents of the game to the screen
        jf.add(x);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.setVisible(true);
        
    }


    @Override
    public void actionPerformed(ActionEvent e) {
       //click operation comes here
    }
    
    
   
}
