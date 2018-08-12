/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package OSAlgos;

import java.util.ArrayList;
import java.util.Arrays;
import javax.swing.JFrame;
/**
 *
 * @author Dan
 * First-Come-First-Served Algorithm
 */
public class FCFS extends Algo{ 
    ArrayList<Animatable> animateMe = new ArrayList<>();        //arraylist to handle animations (same with others)
    
    FCFS(ArrayList<Process> arr){
        super(arr);
    }
    
    public void go() throws InterruptedException{
        sortByArrivalTime();                                    //sorts the list by arrival time
        ArrayList<Process> pList = super.getList();             //gets the sorted list
        
        int time = 0;                                           //contains amount of used cycle time
        int cycles;                                             //var to contain individual cycles (for animations and adding to total time)
        String name;                                            //var to contain individual name (for animations and debugging)

        
        for(Process p : pList){
            name = p.getName();
            cycles = p.getCycles();
            
            System.out.println("Allocating process: " + name + "...");
            System.out.println("Will take " + cycles + " cycles");

            time = time + cycles;
            
            //create a new Animatable object for animation in the animateMe list
            animateMe.add(new Animatable(name,cycles,time));
            
        }
        
        //DISPLAY
        DisplayTimeline_FCFS d = new DisplayTimeline_FCFS(animateMe);
        
        JFrame jf = new JFrame();
                
        jf.setTitle("DisplayTimeline");
        jf.setSize(1280,720);
        jf.add(d);
        jf.setVisible(true);
    }
}
