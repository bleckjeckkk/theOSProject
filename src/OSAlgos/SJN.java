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
 * Shortest Job Next/Shortest Job First
 */
public class SJN extends Algo{

    SJN(ArrayList<Process> arr){
        super(arr);
    }
        
    public void go() throws InterruptedException{
        sortByArrivalTime();                                    //sorts the list
        ArrayList<Process> pList = super.getList();             //gets the list
        ArrayList<Process> container = new ArrayList<>();       //to contain processes in the READY queue
        ArrayList<Animatable> animateMe = new ArrayList<>();    //to contain processes for animating
        
        int time = 0, lastTime = 0;                             //to be the range in which next processes will be added to the container
        
        int cycles;                                             //to contain the specific cycles (for increments and animations)
        String name;                                            //to contain the specific names (for animations)
        
        //gets the first process
        Process p = pList.get(0);
        
        //get info
        name = p.getName();
        cycles = p.getCycles();
        
        //sets the lastTime to 0
        lastTime = time;
        //adds the time with the number of cycles of the first-est process in the list
        time += cycles;
        
        //adds the animatable to the animateMe array
        animateMe.add(new Animatable(name,cycles,false,0,time));
        //removes the process
        pList.remove(0);
        
        while(pList.size() > 0){
            //getting the processes from the range lastTime(min) to time(max) (inclusive)
            for(Process temp : pList){
                if(temp.getArrivalTime() <= time && temp.getArrivalTime() >= lastTime){
                    container.add(temp);
                }
            }
            
            //gets the Process in the queue with the smallest cycle time
            p = getMin(container);

            //getting info
            name = p.getName();
            cycles = p.getCycles();

            //sets the last time as the time
            lastTime = time;
            
            //adds time by cycles
            time += cycles;
            
            //adds the animatable to the animateMe list
            animateMe.add(new Animatable(name,cycles,false,0,time));

            //removes the process from both the process list and the Ready Queue
            pList.remove(p);
            container.remove(p);
        }
        
        //DISPLAY
        DisplayTimeline_SJN d = new DisplayTimeline_SJN(animateMe);
        
        JFrame jf = new JFrame();
        
        jf.setTitle("DisplayTimeline");
        jf.setSize(1280,720);
        jf.add(d);
        jf.setVisible(true);
    }

    private Process getMin(ArrayList<Process> container) {
        /*
        creates an object of the Algo class to sort the list and return the process with the shortest cycle time
        */
        Algo a = new Algo(container);
        a.sortByCycleTime();
        return a.getList().get(0);
    }
    
}
        