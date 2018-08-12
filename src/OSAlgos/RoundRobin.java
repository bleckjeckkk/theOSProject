/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package OSAlgos;

import java.util.ArrayList;
import javax.swing.JFrame;

/**
 *
 * @author Dan
 * Round Robin Algorithm
 */
public class RoundRobin extends Algo {
    int qTime = 0;  //contain quantum time
    
    RoundRobin(ArrayList<Process> arr,int qTime){
        super(arr);
        this.qTime = qTime;
    }
    
    ArrayList<Animatable> animateMe = new ArrayList<>();
    
    public void go() throws InterruptedException{
        sortByArrivalTime();                                //sorts by arrival time
        ArrayList<Process> pList =  super.getList();        //gets the sorted list
        
        
        int time = 0;           //contain total time (for animation)
        int cycles;             //will contain individual cycles for adding to total and animations
        String name;            //will contain individual name and animations
        int totalCycles;        //the Index Control Expression
        
        totalCycles = getTotalCycles();  
        while(totalCycles <= 0){
            for(Process p : pList){
                //getting info
                name = p.getName();
                cycles = p.getCycles();
                
                if(cycles > 0){                                 //if not yet done
                    int remCycles = cycles - qTime;             //subtract cycles by quantum time
                    p.setCycles(remCycles);
                    
                    if(remCycles > 0){                          //if not yet done after subtracting
                        time = time + qTime;
                        animateMe.add(new Animatable(p.getName(),qTime,false,time,qTime));
                    }else{                                      //if done after subtracting
                        int timeDiff = Math.abs(remCycles);     //time difference for the animation and info
                        int timeUsed = qTime - timeDiff;        //time difference for the animation and info
                        time = time + timeUsed;                 //increments the total time
                        animateMe.add(new Animatable(p.getName(),timeUsed, true,time,timeUsed));
                    }
                }
            }
            totalCycles = getTotalCycles();
        }
                
        //DISPLAY
        DisplayTimeline_RR d = new DisplayTimeline_RR(animateMe,qTime);
        
        JFrame jf = new JFrame();
        
        jf.setTitle("DisplayTimeline");
        jf.setSize(1280,720);
        jf.add(d);
        jf.setVisible(true);
    }
}
