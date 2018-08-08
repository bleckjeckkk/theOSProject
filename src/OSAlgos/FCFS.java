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
/**
 *
 * @author Dan
 */
public class FCFS extends Algo{
    int[] timeArr = new int[20];
    ArrayList<Animatable> animateMe = new ArrayList<>();
    int total = 0;
    
    FCFS(ArrayList<Process> arr){
        super(arr);
    }
    
    public void go() throws InterruptedException{
        sortByArrivalTime();
        ArrayList<Process> pList = super.getList();
        System.out.println("FCFS Algorithm");
        
        int time = 0;
        int cycles;
        String name;
        int j=0;
        for(Process p : pList){
            name = p.getName();
            cycles = p.getCycles();
            
            System.out.println("Allocating process: " + name + "...");
            System.out.println("Will take " + cycles + " cycles");

           
            time = time + cycles;
            int i=0;
            while(i!=time){
                System.out.print("|");
                i++;
            }
            timeArr[j] = cycles;
            System.out.println("Done!\n");
            j++;
            animateMe.add(new Animatable(name,cycles,time));
        }
        System.out.println("FCFS done!\n" 
                + "Cycles elapsed: " + time);
        
        //DISPLAY
        total = time;
        System.out.print("proc:" + Arrays.toString(timeArr));
        //DisplayTimeline_FCFS d = new DisplayTimeline_FCFS(timeArr,time);));
        DisplayTimeline_FCFS d = new DisplayTimeline_FCFS(animateMe);
        
        JFrame jf = new JFrame();
        
        
        jf.setTitle("DisplayTimeline");
        jf.setSize(1280,720);
        jf.add(d);
        jf.setVisible(true);
    }
}
