/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.example.netty.game;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author alpalpalapalallapala
 */
public class MainScreen extends JFrame implements ActionListener  {
    
    protected JButton btnstart ;
    protected  static JTextField txtname;
    protected JTextArea txtarea;
    protected static JFrame jf = new JFrame();
    protected String nickname = "nickname";
    protected String message = "message";
    protected JTextField txtfield;
    protected JButton btnsend;
    protected JButton btnpickname;
   
    //singleton
   private static final MainScreen x = new MainScreen();
   //Contents instance for all clients
   static Contents y = Contents.getInstance();
  
    
     MainScreen(){
        
        jf.setTitle("Main Screen");
        jf.setLayout(new GridLayout(3,3));
        jf.setSize(700,700);
        jf.setLocation(500, 250);
        jf.setResizable(false);
        
        btnstart = new JButton("Start Game!");
        btnstart.addActionListener(this);
        
        txtname = new JTextField("Enter Nickname here!");
        
        txtarea = new JTextArea();
        txtarea.setColumns(5);
        txtarea.setRows(5);
        txtarea.setEditable(true);
        txtarea.setVisible(true);
        
        txtfield = new JTextField("Message here!");
        
        btnsend = new JButton("Send Message");
        btnsend.addActionListener(this);
        
        btnpickname = new JButton("Pick Nickname");
        btnpickname.addActionListener(this);
        
        jf.add(txtname);
        jf.add(btnpickname);
        jf.add(txtarea);
        jf.add(txtfield);
        jf.add(btnsend);
        jf.add(btnstart);
        jf.setVisible(true);
        
    }
    
    

    @Override
    public void actionPerformed(ActionEvent e) {
        
          
          if(btnpickname.isSelected()){
              nickname = txtname.getText();
          }
          if(btnsend.isSelected()){
              message = txtfield.getText();
          }
          if(btnstart.isSelected()){
              new GameScreen(700,700,y);
              System.out.println("OYUN Basladi!!!!!!");
              jf.setVisible(false);
          }
          
    }
    
    //singleton
    public static MainScreen getInstance() {
        return x;
    }
    
    
    
}
