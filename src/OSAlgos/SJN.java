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
public class SJN extends Algo{

    SJN(ArrayList<Process> arr){
        super(arr);
    }
        
    public void go() throws InterruptedException{
        sortByArrivalTime();
        ArrayList<Process> pList = super.getList();
        ArrayList<Process> container = new ArrayList<>();
        ArrayList<Animatable> animateMe = new ArrayList<>();
        
        System.out.println("SJN/SJF Algorithm");
        
        int time = 0, lastTime = 0;
        int cycles;
        String name;
        
        Process p = pList.get(0);
        
        name = p.getName();
        cycles = p.getCycles();
        
        System.out.println("Allocating Process : " + name + "...");
        System.out.println("Will take " + cycles + " cycles");
        lastTime = time;
        time += cycles;
        System.out.println("Done!");
        
        animateMe.add(new Animatable(name,cycles,false,0,time));
        pList.remove(0);
        
        while(true){
            if(pList.size() > 0){
                for(Process temp : pList){
                    if(temp.getArrivalTime() <= time && temp.getArrivalTime() >= lastTime){
                        container.add(temp);
                    }
                }
                p = getMin(container);

                name = p.getName();
                cycles = p.getCycles();

                System.out.println("Allocating Process : " + name + "...");
                System.out.println("Will take " + cycles + " cycles");
                lastTime = time;
                time += cycles;
                System.out.println("Done!");
                animateMe.add(new Animatable(name,cycles,false,0,time));
        
                pList.remove(p);
                container.remove(p);
            }
            else
                break;
        }
        
        
        System.out.println("SJN/SJF done!\n" 
                + "Cycles elapsed: " + time);
        //DISPLAY
        DisplayTimeline_SJN d = new DisplayTimeline_SJN(animateMe);
        
        JFrame jf = new JFrame();
        
        jf.setTitle("DisplayTimeline");
        jf.setSize(1280,720);
        jf.add(d);
        jf.setVisible(true);
    }

    private Process getMin(ArrayList<Process> container) {
        Algo a = new Algo(container);
        a.sortByCycleTime();
        return a.getList().get(0);
    }
    
}
        