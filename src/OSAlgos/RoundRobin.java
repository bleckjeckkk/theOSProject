/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package OSAlgos;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 *
 * @author Dan
 */
public class RoundRobin extends Algo{
    int qTime = 0;
    int total = 0;
    
    RoundRobin(ArrayList<Process> arr,int qTime){
        super(arr);
        this.qTime = qTime;
    }
    
    ArrayList<Animatable> animateMe = new ArrayList<>();
    
    public void go() throws InterruptedException{
        sortByArrivalTime();
        ArrayList<Process> pList =  super.getList();
        
        System.out.println("RoundRobin Algorithm");
        System.out.println("Quantum Time: " + qTime + " cycles./n");
        
        int time = 0;
        int cycles;
        String name;
        int totalCycles;
        while(true){
            for(Process p : pList){
                name = p.getName();
                cycles = p.getCycles();
                if(cycles > 0){
                    System.out.println("----------------------------------------");
                    System.out.print("Allocating for process " + name);
                    System.out.println(" with " + cycles + " cycles Remaining: ");
                    //Thread.sleep(500);
                    
                    System.out.println("Starting process " + name + "...");
                    int remCycles = cycles - qTime;
                    p.setCycles(remCycles);
                    
                    if(remCycles > 0){
                        time = time + qTime;
                        System.out.println("Put on hold for next process.");
                        System.out.println("Cycles Remaining: " + cycles);
                        animateMe.add(new Animatable(p.getName(),qTime,false));
                    }else{
                        int timeDiff = Math.abs(remCycles);
                        int timeUsed = qTime - timeDiff;
                        time = time + timeUsed;
                        System.out.println("Process done.");
                        animateMe.add(new Animatable(p.getName(),timeUsed, true));
                    }
                }
            }
            totalCycles = getTotalCycles();            
            if(totalCycles <= 0)
                break;
        }
        
        System.out.println("RoundRobin done!\n" 
                + "Cycles elapsed: " + time);
        
        //DISPLAY
        DisplayTimeline_RR d = new DisplayTimeline_RR(animateMe,qTime);
        
        JFrame jf = new JFrame();
        
        jf.setTitle("DisplayTimeline");
        jf.setSize(1280,720);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.add(d);
        jf.setVisible(true);
    }
}
