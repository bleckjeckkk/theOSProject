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
 */
public class PSched extends Algo{
    PSched(ArrayList<Process> arr){
        super(arr);
    }
    
    public void go() throws InterruptedException{
        sortByArrivalTime();                                        //sorts the arrayList in the Algo superclass
        ArrayList<Process> pList = super.getList();                 //gets the sorted arrayList from the Algo superclass
        ArrayList<Animatable> animateMe = new ArrayList<>();             
         
        int time = 0;
        int cycles;
        String name;
  
        for(Process p : pList){
            if (p.getArrivalTime() == 0){
                name = p.getName();
                cycles = p.getCycles();

                System.out.println("Allocating process: " + name + "...");
                System.out.println("Arrival Time is " + p.getArrivalTime() +" with priority # " + p.getPriority());
                System.out.println("Will take " + cycles + " cycles");
                
                time = time + cycles;
                
                System.out.println("Done!\n");
                
                animateMe.add(new Animatable(name,cycles,true,p.getPriority(),time));
            }
            else{
                break;
            }
        }
        sortByArrivalTimePrio();
        ArrayList<Process> priorityTime = super.getList();             

        for(Process p : priorityTime){
            if(p.getArrivalTime() != 0){
                name = p.getName();
                cycles = p.getCycles();

                System.out.println("Allocating process: " + name + "...");
                System.out.println("Arrival Time is " + p.getArrivalTime() +" with priority: " + p.getPriority());
                System.out.println("Will take " + cycles + " cycles");
                
                time = time + cycles;
                System.out.println("Done!\n");
                System.out.println(time);
                animateMe.add(new Animatable(name,cycles,true,p.getPriority(),time));
            }
        }
        System.out.println("Priority Scheduling done!\n" 
                + "Cycles elapsed: " + time);
        
        //DISPLAY
        DisplayTimeline_PSched d = new DisplayTimeline_PSched(animateMe);
        
        JFrame jf = new JFrame();
        
        jf.setTitle("DisplayTimeline");
        jf.setSize(1280,720);
        jf.add(d);
        jf.setVisible(true);
    }
    
}