/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package OSAlgos;

import java.util.ArrayList;

/**
 *
 * @author Dan
 */
public class RoundRobin extends Algo{
    int qTime = 0;
    RoundRobin(ArrayList<Process> arr, javax.swing.JTextArea ta, int qTime){
        super(arr,ta);
        this.qTime = qTime;
    }
    
    public void go() throws InterruptedException{
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
                    Thread.sleep(500);
                    
                    System.out.println("Starting process " + name + "...");
                    int remCycles = cycles - qTime;
                    p.setCycles(remCycles);
                    
                    if(qTime > 50){
                        Thread.sleep(qTime * 30);
                    }else if(qTime < 40){
                        Thread.sleep(qTime * 61);
                    }else if(qTime < 30){
                        Thread.sleep(qTime * 125);
                    }else if(qTime < 20){
                        Thread.sleep(qTime * 250);
                    }else if(qTime < 10){
                        Thread.sleep(qTime * 500);
                    }
                    if(remCycles > 0){
                        time = time + qTime;
                        System.out.println("Put on hold for next process.");
                        System.out.println("Cycles Remaining: " + cycles);
                    }else{
                        int timeDiff = Math.abs(remCycles);
                        int timeUsed = qTime - timeDiff;
                        time = time + timeUsed;
                        System.out.println("Process done.");
                    }
                }
            }
            totalCycles = getTotalCycles();            
            if(totalCycles <= 0)
                break;
        }
        
        System.out.println("RoundRobin done!\n" 
                + "Cycles elapsed: " + time);
    }
}

